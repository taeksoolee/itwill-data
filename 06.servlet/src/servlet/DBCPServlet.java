package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//Apache DBCP ����� �̿��Ͽ� ConnectionPool�� �����Ͽ� Connection �ν��Ͻ�
//������ Ŭ���̾�Ʈ���� �����ϴ� ����
//DBCP(DataBase Connection Pool) : ���� ���� Connection �ν��Ͻ��� �̸�
//�����Ͽ� ���� �� JDBC ���α׷��� �����ϴ� ��� - �������� �������� ȿ���� ����
@WebServlet("/dbcp.itwill")
public class DBCPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//BasicDataSource �ν��Ͻ� ����
		BasicDataSource ds=new BasicDataSource();
		
		//Connection �ν��Ͻ� ������ ���� BasicDataSource �ν��Ͻ��� �ʵ尪 ����
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(10);//���� �����Ǵ� Connection �ν��Ͻ� ���� ����
		ds.setMaxIdle(10);//�������� Connection �ν��Ͻ� ���� ����
		ds.setMaxTotal(20);//�ִ� ���� ������ Connection �ν��Ͻ� ���� ����
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Apache DBCP</h1>");
		out.println("<hr>");
		
		try {
			Connection con=ds.getConnection();
			out.println("<p>Connection = "+con+"</p>");
			out.println("<hr>");
			out.println("<h3>Connection �ν��Ͻ� ���� ��</h3>");
			out.println("<p>Connection Active Number = "+ds.getNumActive()+"</p>");
			out.println("<p>Connection Idle Number = "+ds.getNumIdle()+"</p>");
			
			con.close();
			out.println("<hr>");
			out.println("<h3>Connection �ν��Ͻ� ���� ��</h3>");
			out.println("<p>Connection Active Number = "+ds.getNumActive()+"</p>");
			out.println("<p>Connection Idle Number = "+ds.getNumIdle()+"</p>");
			
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}







