package site.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.GuestDAO;
import site.itwill.dto.GuestDTO;

//�Է�������(insert.html)���� ���޵� �Է°��� ��ȯ�޾� GUEST ���̺� ������
//�� ���������(select.itwill)�� �̵��ϴ� ���� - ó��������(����)
@WebServlet("/insert.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���������� ��û�� ���� ���� ó��
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		//�Է°��� ����� ������Ʈ �޼����� ĳ���ͼ� ����
		request.setCharacterEncoding("utf-8");
		
		//�Է°��� ��ȯ�޾� ����
		// => �Է°��� ��ȯ�޾� �յ� ������ ����
		// => XSS ���ݿ� ���� ����� ��ũ��Ʈ ��ȣ�� ȸ��(Escape)���ڷ� ��ȯ
		//XSS : �Է��±׿� ��ũ��Ʈ�� �Է��Ͽ� ����Ʈ�� �����ϴ� ���
		String name=request.getParameter("name").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
		String title=request.getParameter("title").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
		String content=request.getParameter("content").trim()
				.replace("<", "&lt;").replace(">", "&gt;");
				
		//DTO �ν��Ͻ� ���� �� �Է°��� �̿��Ͽ� �ʵ尪 ����
		GuestDTO guest=new GuestDTO();
		guest.setName(name);
		guest.setTitle(title);
		guest.setContent(content);
		
		//GUEST ���̺� ���� �Խñ��� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		GuestDAO.getDAO().insertGuest(guest);
		
		//����������� �����̷�Ʈ �̵�
		// => Ŭ���̾�Ʈ���� 301 �ڵ�� URL �ּҸ� ����
		response.sendRedirect("select.itwill");
	}

}










