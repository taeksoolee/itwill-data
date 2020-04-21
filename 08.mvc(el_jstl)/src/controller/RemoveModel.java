package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/remove.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => �����ڸ� ���� �����ϵ��� ���� ó��
// => ���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���� ó��
// => "list.do"�� �����̷�Ʈ �̵��ǵ��� �ν��Ͻ� ��ȯ
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
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}
}
