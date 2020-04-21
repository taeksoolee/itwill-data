package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/view.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => �α��� ����ڸ� ���� �����ϵ��� ���� ó��
// => ���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��µǵ��� ���� 
// => "user_view.jsp"�� ������ �̵��ǵ��� �ν��Ͻ� ��ȯ
public class ViewModel implements Action {

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
			
			String userid=request.getParameter("userid");
			
			//�信�� ����� �� �ֵ��� USERINFO ���̺� ����� ȸ��������  
			//�˻��Ͽ� HttpServletRequest �ν��Ͻ��� ����(Request Scope) 
			request.setAttribute("userinfo"
					, UserinfoService.getService().getUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_view.jsp");
		} catch (Exception e) {
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}

}
