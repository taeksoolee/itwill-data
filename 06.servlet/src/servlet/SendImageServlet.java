package site.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에게 이미지 파일(JPEG 파일) 전달
		// => 이미지 파일을 전달하므로 캐릭터셋 미설정
		response.setContentType("image/jpeg");
		
		//클라이언트에게 원시데이타를 전달할 수 있는 출력스트림을 반환받아 저장
		ServletOutputStream out=response.getOutputStream();
		
		//서버에 저장된 이미지 파일의 경로를 반환받아 저장
		//HttpServletRequest.getServletContext() : 클라이언트가 요청한
		//컨텍스트의 정보(ServletContext 인스턴스)를 반환하는 메소드
		//ServletContext.getRealPath(String contextFilePath) : 컨텍스트에
		//존재하는 파일의 실제 절대경로를 반환하는 메소드
		String filePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		//System.out.println("filePath = "+filePath);
		
		//서버에 저장된 이미지 파일을 읽기 위한 입력스트림을 생성하여 저장
		FileInputStream in=new FileInputStream(filePath);
		
		//입력스트림(파일)에서 원시데이타를 읽어 출력스트림(클라이언트)으로 전달
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		//파일 입력스트림 제거
		in.close();		
	}
}







