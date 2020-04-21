package site.itwill.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;

//Ŭ���̾�Ʈ�� "/writeform.do"�� ��û�� ��� ��Ʈ�ѷ��� ���� �ν��Ͻ��� �����Ǵ� Ŭ����
// =>  �����ڸ� ���� �����ϵ��� ���� ó��
// => "user_write.jsp"�� ������ �̵��ǵ��� �ν��Ͻ� ��ȯ
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
			System.out.println("[����]"+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		return actionForward;
	}

}



