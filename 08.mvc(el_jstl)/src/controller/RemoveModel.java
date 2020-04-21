package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/remove.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 관리자만 접근 가능하도록 권한 처리
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제 처리
// => "list.do"로 리다이렉트 이동되도록 인스턴스 반환
public class RemoveModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			UserinfoService.getService().removeUserinfo(userid);
			
			actionForward.setForward(false);
			
			if(loginUserinfo.getUserid().equals(userid)) {
				actionForward.setPath("logout.do");
			} else {	
				actionForward.setPath("list.do");
			}
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
