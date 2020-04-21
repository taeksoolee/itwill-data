package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/modify.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// => ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ������ ���� ó��
// => "view.do"�� �����̷�Ʈ �̵��ǵ��� �ν��Ͻ� ��ȯ
public class ModifyModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
			
			request.setCharacterEncoding("UTF-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			UserinfoDTO userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			if(password==null || password.equals("")) {
				userinfo.setPassword(UserinfoService.getService().getUserinfo(userid).getPassword());
			} else {
				userinfo.setPassword(password);
			}
			userinfo.setName(name);
			userinfo.setEmail(email);
			
			UserinfoService.getService().modifyUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);
		} catch (Exception e) {
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}		
		return actionForward;
	}
}
