package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿(웹에서 실행되는 프로그램) 작성 방법
//1.HttpServlet 클래스를 상속받아 작성 - 서블릿 클래스
// => HttpServlet 클래스를 상속받은 자식클래스는 객체직렬화 클래스로 
//    serialVersionUID 필드를 선언하는 것을 권장
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//2.doGet() 또는 doPost() 메소드를 오버라이드 선언
	// => 클라이언트 요청에 대한 처리와 응답을 위해 자동 호출되는 메소드
	// => doGet() : 클라이언트가 GET 방식으로 요청한 경우 호출
	// => doPost() : 클라이언트가 POST 방식으로 요청한 경우 호출
	// => doGet() 또는 doPost() 메소드 대신 service() 메소드 오버라이드 선언
	// => service() 메소드가 doGet() 또는 doPost() 메소드보다 호출 우선순위가 높다.
	//WAS(Web Application Server)에 의해 메소드가 호출될 때 HttpServletRequest 인스턴스와
	//HttpServletResponse 인스턴스를 매개변수에 자동으로 전달하여 저장
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest 인스턴스 : 리퀘스트 메세지(요청정보)를 저장하는 인스턴스
		//HttpServletResponse 인스턴스 : 리스폰즈 메세지(응답정보)를 저장하는 인스턴스
		
		//3.클라이언트에게 응답할 문서(파일) 형식(MimeType) 변경
		// => 문서 형식으로 응답할 경우 문서의 캐릭터셋(Character Encoding) 설정
		// => 기본 응답 문서 형식 : text/html, 캐릭터셋 : ISO-8859-1(서유럽어)
		//형식)HttpServletResponse.setContentType(String MimeType[;charset=Encoding])
		// => 응답 문서 형식을 변경하는 메소드
		response.setContentType("text/html;charset=UTF-8");
		
		//4.클라이언트에게 요청에 대한 실행 결과를 전달(응답)하기 위한
		//출력스트림을 반환받아 저장
		//형식)HttpServletResponse.getOutputStream() : 원시데이타(1Byte)를
		//전달할 수 있는 출력스트림(ServletOutputStream)을 반환하는 메소드
		// => 그림,음악,동영상 파일등을 클라이언트에게 전달하기 위해 사용하는 출력스트림
		//형식)HttpServletResponse.getWriter() : 텍스트데이타(2Byte)를 
		//전달할 수 있는 출력스트림(PrintWriter)을 반환하는 메소드
		// => HTML,XML,Text 파일등을 클라이언트에게 전달하기 위해 사용하는 출력스트림
		PrintWriter out=response.getWriter();
		
		//5.입력값을 전달받아 처리(JDBC) 후 결과를 클라이언트에게 전달(응답)
		// => 출력스트림의 메소드를 호출하여 결과를 클라이언트에게 전달
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿(Servlet)</h1>");
		out.println("<hr>");
		out.println("<p>Hello, Servlet!!!</p>");
		out.println("</body>");
		out.println("</html>");
		
		//6.[web.xml]파일에서 서블릿 클래스를 서블릿으로 등록하고 URL 주소로
		//매핑 설정해야만 클라이언트의 요청을 받아 실행하여 응답 가능
	}
}



