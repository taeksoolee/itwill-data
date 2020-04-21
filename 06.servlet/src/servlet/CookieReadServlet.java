package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에서 보내온 쿠키을 읽어 클라이언트에게 전달하는 서블릿
// => 클라이언트는 서버에 요청할 때 서버에세 제공한 쿠키를 무조건 제공 
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
	
		//클라이언트가 보내온 쿠키들을 반환받아 저장
		//HttpServletRequest.getCookies() : 클라이언트가 보내온 쿠키들을 반환하는 메소드
		// => Cookie 인스턴스 배열 반환
		Cookie[] cookies=request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 읽기와 사용</h1>");
		out.println("<hr>");
		if(cookies==null) {
			out.println("<p>네 안에 쿠키 없다.</p>");
		} else {
			String id="";
			String count="";
			
			//원하는 쿠키값을 반환받아 저장
			for(Cookie cookie:cookies) {
				//Cookie.getName() : Cookie 인스턴스의 쿠키명을 반환하는 메소드
				if(cookie.getName().equals("id")) {
					//Cookie.getValue() : Cookie 인스턴스의 쿠키값을 반환하는 메소드
					id=cookie.getValue();
				} else if(cookie.getName().equals("count")) {
					count=cookie.getValue();
				}
			}
			
			//클라이언트에게 쿠키값 전달(출력)
			if(!id.equals("")) {
				out.println("<p>아이디 = "+id+"</p>");
			}
			
			if(!count.equals("")) {
				int cnt=Integer.parseInt(count)+1;
				out.println("<p>요청횟수 = "+cnt+"</p>");
				
				//클라이언트에게 Cookie 인스턴스 전달
				// => 쿠키명이 같은 경우 기존 쿠키 덮어씌우기
				Cookie cookie=new Cookie("count", cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
		}
		
		out.println("<hr>");
		out.println("<p><a href='create.itwill'>쿠키 생성</a></p>");
		out.println("<p><a href='remove.itwill'>쿠키 삭제</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}







