package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� "/loginForm.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => "user_login.jsp"�� ������ �̵��ǵ��� �ν��Ͻ� ��ȯ
public class LoginFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_login.jsp");
		return actionForward;
	}
}







