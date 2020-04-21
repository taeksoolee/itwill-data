package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/modifyform.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => ���� ����ڰ� �α��� ������̰ų� �����ڸ� ���� �����ϵ��� ���� ó��
// => ���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��µǵ��� ���� 
// => "user_modify.jsp"�� ������ �̵��ǵ��� �ν��Ͻ� ��ȯ
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
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
