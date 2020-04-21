package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ű�� �����Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ����
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie Ŭ������ �ν��Ͻ� ����
		// => Ŭ���̾�Ʈ���� ���� ���Ӽ��� �����ϱ� ���� ���� ������ �ν��Ͻ�
		//Cookie(String name, String value) ������
		// => ��Ű��(��Ű���� �����ϱ� ���� ������)�� ��Ű���� �����Ͽ� �ν��Ͻ� ����
		// => ��Ű��� ��Ű���� ������, ����, �Ϻ� Ư�����ڸ� ��� ����
		Cookie idCookie=new Cookie("id", "abc123");
		Cookie countCookie=new Cookie("count", "0");
		
		//Ŭ���̾�Ʈ�� ����� ��Ű�� �����ð� ����
		//Cookie.setMaxAge(int expiry) : ��Ű�� �����ð�(��)�� �����ϴ� �޼ҵ�
		//��Ű �����ð��� �������� ���� ��� �⺻���� -1�� ����
		// => �����ð��� -1�� ������ ��Ű�� �������� ����� ��� �Ҹ�
		countCookie.setMaxAge(24*60*60);//�����ð��� 1�Ϸ� ����
		
		//Cookie �ν��Ͻ��� Ŭ���̾�Ʈ���� ���� - Ŭ���̾�Ʈ�� ���޹��� ��Ű ����
		// => �����ð��� �������� ���� ��Ű�� ������ �޸𸮿� ����
		// => �����ð��� ������ ��Ű�� ��Ű���Ͽ� ����
		//HttpServletResponse.addCookie(Cookie cookie) : Ŭ���̾�Ʈ���� ��Ű�� �����ϴ� �޼ҵ�
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>��Ű ������ ����</h1>");
		out.println("<hr>");
		out.println("<p>�� �ȿ� ��Ű �ִ�.</p>");
		out.println("<hr>");
		out.println("<p><a href='read.itwill'>��Ű �б�</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
