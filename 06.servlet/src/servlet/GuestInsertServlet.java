package site.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.GuestDAO;
import site.itwill.dto.GuestDTO;

//입력페이지(insert.html)에서 전달된 입력값을 반환받아 GUEST 테이블에 저장한
//후 출력페이지(select.itwill)로 이동하는 서블릿 - 처리페이지(저장)
@WebServlet("/insert.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비정상적인 요청에 대한 응답 처리
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		//입력값이 저장된 리퀘스트 메세지의 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		//입력값을 반환받아 저장
		// => 입력값을 반환받아 앞뒤 공백을 제거
		// => XSS 공격에 대한 방법로 스크립트 기호를 회피(Escape)문자로 변환
		//XSS : 입력태그에 스크립트를 입력하여 사이트를 공격하는 방법
		String name=request.getParameter("name").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
		String title=request.getParameter("title").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
		String content=request.getParameter("content").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
				
		//DTO 인스턴스 생성 후 입력값을 이용하여 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setName(name);
		guest.setTitle(title);
		guest.setContent(content);
		
		//GUEST 테이블에 방명록 게시글을 저장하는 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().insertGuest(guest);
		
		//출력페이지로 리다이렉트 이동
		// => 클라이언트에게 301 코드와 URL 주소를 전달
		response.sendRedirect("select.itwill");
	}

}










