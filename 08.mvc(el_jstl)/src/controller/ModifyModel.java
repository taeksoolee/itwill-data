package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/modify.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보 변경 처리
// => "view.do"로 리다이렉트 이동되도록 인스턴스 반환
public class ModifyModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("UTF-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			UserinfoDTO userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			if(password==null || password.equals("")) {
				userinfo.setPassword(UserinfoService.getService().getUserinfo(userid).getPassword());
			} else {
				userinfo.setPassword(password);
			}
			userinfo.setName(name);
			userinfo.setEmail(email);
			
			UserinfoService.getService().modifyUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}		
		return actionForward;
	}
}
