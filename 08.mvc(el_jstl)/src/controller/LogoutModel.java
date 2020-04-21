package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//클라이언트가 "/logout.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
//=> 세션에 저장된 인증정보 제거 : 로그아웃 처리 
//=> "loginform.do" 주소로 리다이렉트 되도록 인스턴스 반환
public class LogoutModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//session.removeAttribute("loginUserinfo");
		session.invalidate();

		ActionForward actionForward=new ActionForward();
		actionForward.setForward(false);
		actionForward.setPath("loginform.do");
		return actionForward;
	}
}






