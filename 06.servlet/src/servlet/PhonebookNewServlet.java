package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.PhonebookDAO;
import site.itwill.dto.PhonebookDTO;

//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ����
// => DAO Ŭ���� �̿�
@WebServlet("/new.itwill")
public class PhonebookNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		List<PhonebookDTO> phonebookList=PhonebookDAO.getDAO().getPhonebookList();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>��ȭ��ȣ��(JDBC)</h1>");
		out.println("<hr>");
		out.println("<table border='1' cellspacing='0' width='600'>");
		out.println("<tr>");
		out.println("<th>��ȭ��ȣ</th><th>�̸�</th><th>�ּ�</th>");
		out.println("</tr>");
		
		//��ȯ���� ����� Ŭ���̾�Ʈ���� ���� - �ݺ� ���
		for(PhonebookDTO phonebook:phonebookList) {
			out.println("<tr align='center'>");
			out.println("<td>"+phonebook.getPhone()+"</td>");
			out.println("<td>"+phonebook.getName()+"</td>");
			out.println("<td>"+phonebook.getAddress()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}









