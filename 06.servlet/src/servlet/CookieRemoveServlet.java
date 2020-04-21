package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에 저장된 쿠키를 제거하는 서블릿
@WebServlet("/remove.itwill")
public class CookieRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//클라이언트가 보내온 쿠키들을 반환받아 저장
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null) {
			//클라이언트에 저장된 모든 쿠키 제거
			// => 클라이언트에 저장된 쿠키의 유지시간 변경
			// => 유지시간이 지난 쿠키는 클라이언트에서 자동 소멸 
			for(Cookie cookie:cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 제거</h1>");
		out.println("<hr>");
		out.println("<p>이제 네 안에 쿠키 없다.</p>");
		out.println("<hr>");
		out.println("<p><a href='read.itwill'>쿠키 읽기</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}








