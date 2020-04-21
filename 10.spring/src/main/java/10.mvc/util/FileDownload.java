package site.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하는 클래스
// => Bean Configuration File 또는 어노테이션을 이용하여 Spring Bean으로 등록
//BeanNameViewResolver에 의해 실행되는 Spring Bean의 클래스는 반드시 AbstractView 클래스를 상속받아 작성
// => renderMergedOutputModel() 메소드를 오버라이드 선언
public class FileDownload extends AbstractView {
	//클라이언트에 응답할 파일 형식(MimeType) 변경 - 파일 다운로드 기능 
	public FileDownload() {
		//AbstractView.setContentType(String mimeType) : 파일 형식을 변경하는 메소드
		setContentType("application/download;utf-8");
	}
	
	//BeanNameViewResolver에 의해 자동 호출되는 메소드
	// => model 매개변수에 요청처리 메소드에서 반환되는 ModelAndView 인스턴스의 Model 정보가 전달되어 저장
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//요청처리 메소드에서 제공되는 다운로드 파일정보를 반환받아 저장
		@SuppressWarnings("unchecked")
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
		//다운로드 파일정보를 반환받아 저장
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFilename=fileInfo.get("uploadFilename");
		String originFilename=fileInfo.get("originFilename");
		
		//다운로드 파일정보를 이용하여 File 인스턴스 생성
		File downloadFile=new File(uploadDirPath, uploadFilename);
		
		//클라이언트에게 파일을 전달하기 위한 응답정보 변경
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		//클라이언트에게 다운로드 파일명과 전송방식을 변경하여 클라이언트에게 전달
		response.setHeader("Content-Disposition"
				, "attachment;filename=\""+originFilename+"\";");
		
		//클라이언트에게 원시데이타를 전달하기 위한 출력스트림을 반환받아 저장
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		try {
			//다운로드 파일을 원시데이타로 읽기 위한 입력스트림 생성
			in=new FileInputStream(downloadFile);
			
			//입력스트림에서 원시데이타를 읽어 출력스트림으로 전달 - 다운로드
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			
			//Spring에서 제공하는 FileCopyUtils 클래스의 copy() 메소드를 호출하여 파일 복사
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




