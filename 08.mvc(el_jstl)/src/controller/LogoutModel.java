package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Ŭ���̾�Ʈ�� "/logout.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
//=> ���ǿ� ����� �������� ���� : �α׾ƿ� ó�� 
//=> "loginform.do" �ּҷ� �����̷�Ʈ �ǵ��� �ν��Ͻ� ��ȯ
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






