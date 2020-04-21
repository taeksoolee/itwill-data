package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.service.UserinfoService;

//클라이언트가 "/write.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 회원정보를 전달받아 USERINFO 테이블에 회원정보 저장 처리
// => "loginform.do"로 리다이렉트 이동되도록 인스턴스 반환
public class WriteModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		UserinfoDTO userinfo=null;
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("UTF-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			userinfo.setPassword(password);
			userinfo.setName(name);
			userinfo.setEmail(email);
			userinfo.setStatus(1);
			
			//회원정보를 저장하는 서비스 클래스의 메소드 호출
			// => 회원정보를 저장시 예외 발생 가능
			UserinfoService.getService().addUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("loginform.do");
		} catch (ExistsUserinfoException e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userinfo", userinfo);
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_write.jsp");
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}		
		return actionForward;
	}
}





