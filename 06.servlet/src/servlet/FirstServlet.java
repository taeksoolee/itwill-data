package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(String url) : ���� Ŭ������ �������� ����ϰ� URL �ּҷ�
//���� �����ϱ� ���� ������̼�(Annotation)
// => �⺻������ Ŭ�������� ���� �̸����� �ڵ� ����
// => name �Ӽ� : ���� ó���� URL �ּҸ� �Ӽ������� ���� - �ٸ� �Ӽ��� ���� ��� �Ӽ��� ���� ����
// => [web.xml]������ <servlet>�� <servlet-mapping> ������Ʈ�� ������ ��� ����
@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//�������� ���α׷��� �����Ͽ� Ŭ���̾�Ʈ���� ��� ����
		// => Ŭ���̾�Ʈ���� �ϰ��� �ִ� ������ �����ϴ� ���� ������ ����
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		String displayNow=sdf.format(now);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style type='text/css'>");
		out.println("p { width: 600px; margin: 0 auto; padding: 30px 0;"
			+ "font-size: 2em; font-weight: bold; text-align: center;"
			+ "border: 2px solid black; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� ������ �ð�</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script type='text/javascript'>");
		out.println("setInterval(function() { location.reload(); },1000);");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}
}
