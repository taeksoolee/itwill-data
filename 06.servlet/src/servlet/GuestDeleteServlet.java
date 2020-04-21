package site.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.GuestDAO;

//���������(select.itwill)���� ������ �۹�ȣ�� ��ȯ�޾� GUEST ���̺�
//����� ���� �Խñ��� �����ϰ� ����������� �̵��ϴ� ���� - ó��������(����)
@WebServlet("/delete.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������� ��û�� ���� ����ó��
		if(request.getParameter("no")==null) {//���ް��� ���� ���
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//���޵� �۹�ȣ�� ��ȯ�޾� ���� => ���������� ��ȯ
		int no=Integer.parseInt(request.getParameter("no"));
		
		//GUEST ���̺��� ���� �Խñ��� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		int rows=GuestDAO.getDAO().deleteGuest(no);
		
		if(rows>0) {//�������� �����ϴ� ���
			//����������� �����̷�Ʈ �̵�
			response.sendRedirect("select.itwill");
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}





