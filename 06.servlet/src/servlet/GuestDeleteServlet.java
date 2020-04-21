package site.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.GuestDAO;

//출력페이지(select.itwill)에서 전달한 글번호를 반환받아 GUEST 테이블에
//저장된 방명록 게시글을 삭제하고 출력페이지로 이동하는 서블릿 - 처리페이지(삭제)
@WebServlet("/delete.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비정상적인 요청에 대한 응답처리
		if(request.getParameter("no")==null) {//전달값이 없는 경우
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//전달된 글번호를 반환받아 저장 => 정수값으로 변환
		int no=Integer.parseInt(request.getParameter("no"));
		
		//GUEST 테이블에서 방명록 게시글을 삭제하는 DAO 클래스의 메소드 호출
		int rows=GuestDAO.getDAO().deleteGuest(no);
		
		if(rows>0) {//삭제행이 존재하는 경우
			//출력페이지로 리다이렉트 이동
			response.sendRedirect("select.itwill");
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}





