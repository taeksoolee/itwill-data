package site.itwill.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(file_view.html)에서 전달된 입력값과 입력파일(내용)을 반환받아 클라이언트에게 전달하는 서블릿
@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//비정상적인 요청에 대한 응답처리
		if(request.getMethod().equalsIgnoreCase("get")) {
			response.sendRedirect("error.html");
			return;
		}
		
		//입력값에 대한 인코딩 변경
		request.setCharacterEncoding("utf-8");
		
		//입력값(올린이)을 반환받아 저장
		//form 태그의 enctype 속성값을 "multipart/form-data"로 설정한 경우
		//getParameter() 메소드로 입력값을 반환 불가능
		String name=request.getParameter("name");
		
		//클라이언트에게 입력값과 입력파일의 내용을 전달
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력값과 입력파일 내용 확인</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+name+"</p>");
		out.println("<hr>");
		
		//입력파일의 내용을 읽기 위한 입력스트림을 반환받아 저장
		//HttpServletRequest.getInputStream() : 리퀘스트 메세지의 폼데이타를
		//원시데이타를 제공받을 수 있는 입력스트림(ServletInputStream)을 반환하는 메소드
		//HttpServletRequest.getReader() : 리퀘스트 메세지의 폼데이타를
		//텍스타데이타를 제공받을 수 있는 입력스트림(BufferedReader)을 반환하는 메소드
		//ServletInputStream in=request.getInputStream();
		InputStreamReader in=new InputStreamReader(request.getInputStream(),"utf-8");
		
		//입력파일의 내용을 읽어 클라이언트에게 전달
		// => form 태그로 입력되어 전달된 값(폼데이타) 반환
		out.println("<p>[입력파일내용]</p>");
		out.println("<pre>");
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		out.println("</pre>");
		out.println("</body>");
		out.println("</html>");

	}
}





