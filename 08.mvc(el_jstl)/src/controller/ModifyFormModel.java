package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/modifyform.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 변경 사용자가 로그인 사용자이거나 관리자만 접근 가능하도록 권한 처리
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 출력되도록 저장 
// => "user_modify.jsp"로 포워드 이동되도록 인스턴스 반환
public class ModifyFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			
			String userid=request.getParameter("userid");
			
			if(loginUserinfo==null || !(loginUserinfo.getStatus()==9  
					|| loginUserinfo.getUserid().equals(userid))) {
				throw new Exception();
			}
			
			request.setAttribute("userinfo"
					, UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_modify.jsp");
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
