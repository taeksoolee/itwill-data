package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//WAS�� ��ϵ� �ڿ��� �̿��Ͽ� DataSource �ν��Ͻ��� ��ȯ�޾� Connection
//�ν��Ͻ� ������ �����ϴ� ����  
@WebServlet("/jndi.itwill")
public class JNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			//InitialContext �ν��Ͻ��� �����Ͽ� ����
			//InitialContext : WAS�� ��ϵ� �ڿ��� �̿��Ͽ� �ν��Ͻ��� ����
			//�Ͽ� ��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�  
			InitialContext ic=new InitialContext();
			
			//InitialContext.lookup(String name) : �ڿ��̸��� �����Ͽ� WAS��
			//��ϵ� �ڿ������� �̿��Ͽ� �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			// => Object Ÿ���� �ν��Ͻ��� ��ȯ�ϹǷ� ��ü ����ȯ �� ���
			DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracle");
			
			Connection con=ds.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Apache DBCP(JNDI)</h1>");
			out.println("<hr>");
			out.println("<p>Connection = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");
			
			con.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
