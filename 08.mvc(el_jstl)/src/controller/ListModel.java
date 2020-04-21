package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/list.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// => 로그인 사용자만 접근 가능하도록 권한 처리
// => USERINFO 테이블에 저장된 모든 회원정보를 검색하여 출력되도록 저장 
// => "user_list.jsp"로 포워드 이동되도록 인스턴스 반환
public class ListModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null) {
				throw new Exception();
			}
			
			//뷰에서 출력할 수 있도록 USERINFO 테이블에 저장된 모든 회원정보를  
			//검색하여 HttpServletRequest 인스턴스에 저장(Request Scope) 
			request.setAttribute("userinfoList"
					, UserinfoService.getService().getUserinfoList());
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_list.jsp");
		} catch (Exception e) {
			System.out.println("[예외]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}







