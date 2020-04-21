package site.itwill10.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import site.itwill10.dto.FileBoard;
import site.itwill10.service.FileBoardService;

//ApplicationContextAware �������̽��� ��ӹ޾� Ŭ������ Spring Bean���� ��ϵ� �� 
//setApplicationContext() �޼ҵ带 ȣ���Ͽ� �Ű������� ���ް����� �ʵ� �ʱ�ȭ �۾�
// => ApplicationContext �ν��Ͻ��� �Ű������� �����Ͽ� �ʵ尪 ����
@Controller
public class FileController implements ApplicationContextAware {
	@Autowired
	private FileBoardService fileBoardService;
	
	//WebApplicationContext : SpringMVC�� Front Controller���� ����ϱ� ����
	//Spring Bean�� �����ϴ� Spring Container ���� �ν��Ͻ�
	private WebApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//ApplicationContext �ν��Ͻ��� WebApplicationContext �ν��Ͻ��� 
		//�θ� �ν��Ͻ��̹Ƿ� ��ü ����ȯ�� �ؾ߸� �ʵ忡 ���� ����
		context=(WebApplicationContext)applicationContext;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}

	/*
	//MultipartHttpServletRequest : "multipart/form-data"�� ���޹��� 
	//�Է����ϰ� �Է°��� ó���ϴ� �ν��Ͻ�
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
		
		//MultipartHttpServletRequest.getFile(String name) : �Է������� 
		//���޹޾� MultipartFile �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//MultipartFile : �Է����� ������ �����ϱ� ���� �ν��Ͻ�
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//MultipartFile.getContentType() : �Է������� ����(MimeType)�� ��ȯ�ϴ� �޼ҵ� 
		//System.out.println(uploadFile.getContentType());
		//MultipartFile.getBytes() : �Է������� byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� 
		//System.out.println(uploadFile.getBytes().length);
		
		//MultipartFile.isEmpty() : �Է����� ������ �������� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		// => �Է����Ͽ� ���� ��ȿ�� �˻� ���� : ��������, ���� ũ�� �� 
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//�Է������� �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirPath=request.getServletContext().getRealPath("/resources/upload");
		
		//�Է������� ���� ���丮�� �����ϱ� ���� File �ν��Ͻ� ����
		//MultipartFile.getOriginalFilename() : �Է������� �̸��� ��ȯ�ϴ� �޼ҵ�
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
				
		//MultipartFile.transferTo(File file) : �Է������� ������ �����Ͽ� �����ϴ� �޼ҵ�
		// => ������ ������ �̸��� ������ �̹� ������ ��� ������ 
		uploadFile.transferTo(file);//���ε� ó��
		
		request.setAttribute("uploader", uploader);
		request.setAttribute("originalFilename", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	*/
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam String uploader
			, @RequestParam MultipartFile uploadFile, Model model) throws IllegalStateException, IOException {
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//WebApplicationContext �ν��Ͻ��� �̿��Ͽ� ������ ���ε� ���丮��  
		//�ý��� ��θ� ��ȯ�޾� ���� 
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		
		//������ �Է����ϰ� ������ �̸��� ������ ������ ��� �Է����ϸ���
		//�����Ͽ� ������ ����ǵ��� ����
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);
		
		//���� ������ �����ϱ� ���� ���ϸ��� �����ϱ� ���� ���� ����
		// => �ʱⰪ���� �Է����ϸ� ����
		String uploadFilename=originalFilename;
		
		//������ �Է����ϸ�� ���� �̸��� ������ ������ ��� �Է����ϸ� ���� -  �ݺ�ó��
		int i=0;
		while(file.exists()) {
			i++;
			int index=originalFilename.lastIndexOf(".");
			//�Է����ϸ� �ڿ� "_����"�� �߰��Ͽ� ����
			uploadFilename=originalFilename.substring(0, index)
				+"_"+i+originalFilename.substring(index);
			file=new File(uploadDirPath, uploadFilename);
		}
		
		uploadFile.transferTo(file);

		model.addAttribute("uploader", uploader);
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_ok";
	}
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.GET)
	public String thumbnail() {
		return "file/thumbnail";
	}
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.POST)
	public String thumbnail(@RequestParam MultipartFile imageFile
			, Model model) throws IllegalStateException, IOException {
		if(!imageFile.getContentType().equals("image/jpeg")) {
			return "file/thumbnail_fail";
		}
		
		//�Է������� ������ ���ε� ó���Ͽ� ����
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
		//���ε� ó���� �̹��� ������ �̿��Ͽ� ����� ���� ����
		//1.�̹��� ������ �о� �̹����� �޸𸮿� ����
		//BufferedImage : �̹��� ������ ������ �����ϴ� Ŭ����
		//ImageIO.read(File file) : �̹��� ���� ������ �о� BufferedImage �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		BufferedImage sourceImage=ImageIO.read(file);
		
		//2.�޸𸮿� ����� �̹����� ũ�⸦ �����Ͽ� ����� �̹��� ����
		//Scalr.resize(BufferedImage src, Method scalingMethod, Mode resizeMode
		//, int targetSize) : �޸𸮿� ����� �̹����� ũ�⸦ �����ϴ� �޼ҵ�
		// => Scalr.Method.AUTOMATIC : �̹����� �� �Ǵ� ���̸� �ڵ����� ����
		// => FIT_TO_WIDTH : �̹����� �� ����
		BufferedImage thumbnailImage=Scalr.resize(sourceImage
			, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH, 400);
		
		//3.�޸𸮿� ����� ����� �̹����� �̿��Ͽ� ���� ����
		// => ����� ������ �̸� ����
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)
				+"_s"+imageFilename.substring(index);
		index=thumbnailFilename.lastIndexOf(".");
		//ImageIO.write(RenderedImage im, String formatName, File output) : �޸𸮿�
		//����� �̹��� ������ �о� �̹��� ���Ϸ� �����ϴ� �޼ҵ� 
		ImageIO.write(thumbnailImage, thumbnailFilename.substring(index+1)
				, new File(uploadDirPath, thumbnailFilename));
		
		model.addAttribute("imageFilename", imageFilename);
		model.addAttribute("thumbnailFilename", thumbnailFilename);
		
		return "file/thumbnail_ok";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		return "file/file_upload";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		//�Է����Ͽ� ���� ��ȿ�� �˻�
		if(fileBoard.getFile().isEmpty()) {
			return "file/file_upload";
		}
		
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		
		//�Է� ���ϸ��� ��ȯ�޾� ����
		String origin=fileBoard.getFile().getOriginalFilename();
		//���ε� ���ϸ��� TimeStamp�� �̿��Ͽ� ����
		// => ���ε� ���ϸ��� �ߺ����� �ʵ��� ����
		String upload=System.currentTimeMillis()+"";
		
		//���� ���ε� ó��
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
		//�ʵ尪 ����
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);

		//FILE_BOARD ���̺� ���� �Խñ� ���� ���� ����
		fileBoardService.addFileBoard(fileBoard);
		
		//�����̷�Ʈ �̵�
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		//������ ����� ���� ����
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		//������ ����� ������ �̿��Ͽ� File �ν��Ͻ� ���� �� delete() �޼ҵ� ȣ�� - ���� ����
		new File(uploadDirPath, fileBoard.getUpload()).delete();
		
		//FILE_BOARD ���̺� ����� �Խñ� ����
		fileBoardService.removeFileBoard(num);
		
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_download/{num}")
	public String fileDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//�ٿ�ε� ���������� �����ϱ� ���� Map �ν��Ͻ� ����
		Map<String, String> fileInfo=new HashMap<String, String>();
		fileInfo.put("uploadDirPath", context.getServletContext().getRealPath("/WEB-INF/upload"));
		fileInfo.put("uploadFilename", fileBoard.getUpload());
		fileInfo.put("originFilename", fileBoard.getOrigin());
		
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownload";
	}
}








