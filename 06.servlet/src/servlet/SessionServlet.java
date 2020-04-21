package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션 바인딩하여 클라이언트에게 세션정보를 전달하는 서블릿
//세션 바인딩(Session Binding) : 세션을 서블릿에서 사용할 수 있도록 연결하는 작업
// => 클라이언트에게 JSESSIONID 쿠키를 제공받지 않을 경우 세션 생성 후 바인딩
// => 클라이언트에게 JSESSIONID 쿠키를 제공받은 경우 세션 트렉킹 후 바인딩
//세션 트렉킹(Session Tracking) : 제공받은 JSESSIONID 쿠키값과 세션의 아이디를 비교하는 작업
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//HttpServletRequest.getSession() : 세션 바인딩 처리된 Session 인스턴스를 반환하는 메소드
		// => Session 인스턴스를 생성하거나 기존 Session 인스턴스를 바인딩하여 반환
		//HttpSession : 연결 지속성을 제공하기 위한 정보를 저장하기 위한 인스턴스
		HttpSession session=request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>세션(Session)</h1>");
		out.println("<hr>");
		//HttpSession.isNew() : 세션이 트렉킹되어 바인딩된 경우 false, 생성
		//되어 바인딩된 경우 true를 반환하는 메소드
		if(session.isNew()) {
			out.println("<p>세션을 생성하여 바인딩 되었습니다.</p>");
			
			Cookie cookie=new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*60);//1시간 유지
			response.addCookie(cookie);
		} else {
			out.println("<p>세션을 트렉킹하여 바인딩 되었습니다.</p>");
		}
		
		//HttpSession.getId() : 세션의 고유값을 반환하는 메소드
		out.println("<p>세션 아이디 = "+session.getId()+"</p>");
		//HttpSession.getCreationTime() : 세션이 생성된 시간(TimeStamp)을 반환하는 메소드
		out.println("<p>세션 생성시간 = "+session.getCreationTime()+"</p>");
		//HttpSession.getMaxInactiveInterval() : 세션 유지시간(초)을 반환하는 메소드
		out.println("<p>세션 유지시간 = "+session.getMaxInactiveInterval()+"</p>");

		//HttpSession.setAttribute(String name, Object value) : Session 
		//인스턴스를 이용하여 속성명과 인스턴스를 전달하여 저장
		// => 다른 웹어플리케이션에게 속성명으로 인스턴스를 공유하여 제공 
		session.setAttribute("now", new Date());
		
		//HttpSession.getAttribute(String name) : Session 인스턴스에 저장
		//되어 공유된 인스턴스를 속성명으로 반환하는 메소드
		// => 다른 웹어플리케이션에게 공유한 인스턴스를 반환받아 사용
		// => Object 타입으로 인스턴스를 반환하므로 객체 형변환 후 사용
		// => 속성명이 존재하기 않을 경우 null 반환
		Date now=(Date)session.getAttribute("now");
		
		out.println("<p>세션의 공유 인스턴스 = "+now+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}








