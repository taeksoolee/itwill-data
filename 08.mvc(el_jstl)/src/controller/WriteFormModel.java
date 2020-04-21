package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;

//클라이언트가 "/writeform.do"로 요청한 경우 컨트롤러에 의해 인스턴스로 생성되는 클래스
// =>  관리자만 접근 가능하도록 권한 처리
// => "user_write.jsp"로 포워드 이동되도록 인스턴스 반환
public class WriteFormModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo.getStatus()!=9) {
				throw new Exception();
			}
			
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



