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

//ApplicationContextAware 인터페이스를 상속받아 클래스가 Spring Bean으로 등록될 때 
//setApplicationContext() 메소드를 호출하여 매개변수의 전달값으로 필드 초기화 작업
// => ApplicationContext 인스턴스를 매개변수에 저장하여 필드값 변경
@Controller
public class FileController implements ApplicationContextAware {
	@Autowired
	private FileBoardService fileBoardService;
	
	//WebApplicationContext : SpringMVC의 Front Controller에서 사용하기 위한
	//Spring Bean를 관리하는 Spring Container 관련 인스턴스
	private WebApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//ApplicationContext 인스턴스는 WebApplicationContext 인스턴스의 
		//부모 인스턴스이므로 객체 형변환을 해야만 필드에 저장 가능
		context=(WebApplicationContext)applicationContext;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}

	/*
	//MultipartHttpServletRequest : "multipart/form-data"로 전달받은 
	//입력파일과 입력값을 처리하는 인스턴스
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
		
		//MultipartHttpServletRequest.getFile(String name) : 입력파일을 
		//전달받아 MultipartFile 인스턴스로 반환하는 메소드
		//MultipartFile : 입력파일 정보를 저장하기 위는 인스턴스
		MultipartFile uploadFile=request.getFile("uploadFile");
		
		//MultipartFile.getContentType() : 입력파일의 형식(MimeType)을 반환하는 메소드 
		//System.out.println(uploadFile.getContentType());
		//MultipartFile.getBytes() : 입력파일을 byte 배열로 변환하여 반환하는 메소드 
		//System.out.println(uploadFile.getBytes().length);
		
		//MultipartFile.isEmpty() : 입력파일 정보가 존재하지 않을 경우 true를 반환하는 메소드
		// => 입력파일에 대한 유효성 검사 가능 : 파일형식, 파일 크기 등 
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//입력파일을 저장하기 위한 업로드 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirPath=request.getServletContext().getRealPath("/resources/upload");
		
		//입력파일을 서버 디렉토리에 저장하기 위한 File 인스턴스 생성
		//MultipartFile.getOriginalFilename() : 입력파일의 이름을 반환하는 메소드
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
				
		//MultipartFile.transferTo(File file) : 입력파일을 서버에 전송하여 저장하는 메소드
		// => 서버에 동일한 이름의 파일이 이미 존재할 경우 덮어씌우기 
		uploadFile.transferTo(file);//업로드 처리
		
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
		
		//WebApplicationContext 인스턴스를 이용하여 서버의 업로드 디렉토리의  
		//시스템 경로를 반환받아 저장 
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		
		//서버에 입력파일과 동일한 이름의 파일이 존재할 경우 입력파일명을
		//변경하여 서버에 저장되도록 설정
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);
		
		//실제 서버에 저장하기 위한 파일명을 저장하기 위한 변수 선언
		// => 초기값으로 입력파일명 저장
		String uploadFilename=originalFilename;
		
		//서버에 입력파일명과 같은 이름에 파일이 존재할 경우 입력파일명 변경 -  반복처리
		int i=0;
		while(file.exists()) {
			i++;
			int index=originalFilename.lastIndexOf(".");
			//입력파일명 뒤에 "_숫자"를 추가하여 변경
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
		
		//입력파일을 서버에 업로드 처리하여 저장
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
		//업로드 처리된 이미지 파일을 이용하여 썸네일 파일 생성
		//1.이미지 파일을 읽어 이미지를 메모리에 저장
		//BufferedImage : 이미지 파일의 정보를 저정하는 클래스
		//ImageIO.read(File file) : 이미지 파일 정보를 읽어 BufferedImage 인스턴스로 반환하는 메소드
		BufferedImage sourceImage=ImageIO.read(file);
		
		//2.메모리에 저장된 이미지의 크기를 변경하여 썸네일 이미지 생성
		//Scalr.resize(BufferedImage src, Method scalingMethod, Mode resizeMode
		//, int targetSize) : 메모리에 저장된 이미지의 크기를 변경하는 메소드
		// => Scalr.Method.AUTOMATIC : 이미지의 폭 또는 높이를 자동으로 변경
		// => FIT_TO_WIDTH : 이미지의 폭 변경
		BufferedImage thumbnailImage=Scalr.resize(sourceImage
			, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH, 400);
		
		//3.메모리에 저장된 썸네일 이미지를 이용하여 파일 생성
		// => 썸네일 파일의 이름 설정
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)
				+"_s"+imageFilename.substring(index);
		index=thumbnailFilename.lastIndexOf(".");
		//ImageIO.write(RenderedImage im, String formatName, File output) : 메모리에
		//저장된 이미지 정보를 읽어 이미지 파일로 생성하는 메소드 
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
		//입력파일에 대한 유효성 검사
		if(fileBoard.getFile().isEmpty()) {
			return "file/file_upload";
		}
		
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		
		//입력 파일명을 반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
		//업로드 파일명을 TimeStamp를 이용하여 생성
		// => 업로드 파일명이 중복되지 않도록 설정
		String upload=System.currentTimeMillis()+"";
		
		//파일 업로드 처리
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
		//필드값 변경
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);

		//FILE_BOARD 테이블에 파일 게시글 관련 정보 저장
		fileBoardService.addFileBoard(fileBoard);
		
		//리다이렉트 이동
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		//서버에 저장된 파일 삭제
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDirPath=context.getServletContext().getRealPath("/WEB-INF/upload");
		//서버에 저장된 파일을 이용하여 File 인스턴스 생성 후 delete() 메소드 호출 - 파일 삭제
		new File(uploadDirPath, fileBoard.getUpload()).delete();
		
		//FILE_BOARD 테이블에 저장된 게시글 삭제
		fileBoardService.removeFileBoard(num);
		
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_download/{num}")
	public String fileDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//다운로드 파일정보를 저장하기 위한 Map 인스턴스 생성
		Map<String, String> fileInfo=new HashMap<String, String>();
		fileInfo.put("uploadDirPath", context.getServletContext().getRealPath("/WEB-INF/upload"));
		fileInfo.put("uploadFilename", fileBoard.getUpload());
		fileInfo.put("originFilename", fileBoard.getOrigin());
		
		model.addAttribute("downloadFile", fileInfo);
		
		return "fileDownload";
	}
}








