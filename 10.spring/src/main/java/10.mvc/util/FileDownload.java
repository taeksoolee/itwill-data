package site.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//���� �ٿ�ε� ����� �����ϴ� Ŭ����
// => Bean Configuration File �Ǵ� ������̼��� �̿��Ͽ� Spring Bean���� ���
//BeanNameViewResolver�� ���� ����Ǵ� Spring Bean�� Ŭ������ �ݵ�� AbstractView Ŭ������ ��ӹ޾� �ۼ�
// => renderMergedOutputModel() �޼ҵ带 �������̵� ����
public class FileDownload extends AbstractView {
	//Ŭ���̾�Ʈ�� ������ ���� ����(MimeType) ���� - ���� �ٿ�ε� ��� 
	public FileDownload() {
		//AbstractView.setContentType(String mimeType) : ���� ������ �����ϴ� �޼ҵ�
		setContentType("application/download;utf-8");
	}
	
	//BeanNameViewResolver�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => model �Ű������� ��ûó�� �޼ҵ忡�� ��ȯ�Ǵ� ModelAndView �ν��Ͻ��� Model ������ ���޵Ǿ� ����
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��ûó�� �޼ҵ忡�� �����Ǵ� �ٿ�ε� ���������� ��ȯ�޾� ����
		@SuppressWarnings("unchecked")
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
		//�ٿ�ε� ���������� ��ȯ�޾� ����
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFilename=fileInfo.get("uploadFilename");
		String originFilename=fileInfo.get("originFilename");
		
		//�ٿ�ε� ���������� �̿��Ͽ� File �ν��Ͻ� ����
		File downloadFile=new File(uploadDirPath, uploadFilename);
		
		//Ŭ���̾�Ʈ���� ������ �����ϱ� ���� �������� ����
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		//Ŭ���̾�Ʈ���� �ٿ�ε� ���ϸ�� ���۹���� �����Ͽ� Ŭ���̾�Ʈ���� ����
		response.setHeader("Content-Disposition"
				, "attachment;filename=\""+originFilename+"\";");
		
		//Ŭ���̾�Ʈ���� ���õ���Ÿ�� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		try {
			//�ٿ�ε� ������ ���õ���Ÿ�� �б� ���� �Է½�Ʈ�� ����
			in=new FileInputStream(downloadFile);
			
			//�Է½�Ʈ������ ���õ���Ÿ�� �о� ��½�Ʈ������ ���� - �ٿ�ε�
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			
			//Spring���� �����ϴ� FileCopyUtils Ŭ������ copy() �޼ҵ带 ȣ���Ͽ� ���� ����
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {	}
		}
	}

}




