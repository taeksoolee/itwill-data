package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;
import site.itwill.service.UserinfoService;

//클라이언트가 "/login.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 인증정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리 
// => "loginform.do" 주소로 리다이렉트 되도록 인스턴스 반환
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();//인위적 예외 발생
			}
		
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//모델클래스의 처리메소드는 서비스 클래스의 메소드를 호출하여 기능 구현
			// => 인증 실패시 예외 발생 
			UserinfoService.getService().login(userid, password);
			
			//인증 성공 => 세션에 인증정보 저장
			HttpSession session=request.getSession();//세션 바인딩
			session.setAttribute("loginUserinfo"
					, UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginform.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) { //JDK1.7 이상
			//Request Scope : 스레드가 이동된 JSP 문서에서 사용 가능하도록 인스턴스 저장
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		
		return actionForward;
	}

}
