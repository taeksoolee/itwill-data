package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/login.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => ���������� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���Ͽ� ���� ó�� 
// => "loginform.do" �ּҷ� �����̷�Ʈ �ǵ��� �ν��Ͻ� ��ȯ
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();//������ ���� �߻�
			}
		
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//��Ŭ������ ó���޼ҵ�� ���� Ŭ������ �޼ҵ带 ȣ���Ͽ� ��� ����
			// => ���� ���н� ���� �߻� 
			UserinfoService.getService().login(userid, password);
			
			//���� ���� => ���ǿ� �������� ����
			HttpSession session=request.getSession();//���� ���ε�
			session.setAttribute("loginUserinfo"
					, UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginform.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) { //JDK1.7 �̻�
			//Request Scope : �����尡 �̵��� JSP �������� ��� �����ϵ��� �ν��Ͻ� ����
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) {
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		
		return actionForward;
	}

}
