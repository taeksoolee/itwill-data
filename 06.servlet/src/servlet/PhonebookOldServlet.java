package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//PHONEBOOK ���̺� ����� ��� ���� �˻��Ͽ� Ŭ���̾�Ʈ���� �����ϴ� ����
// => JDBC ��� �̿�
@WebServlet("/old.itwill")
public class PhonebookOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1.OracleDriver Ŭ������ �о� �޸𸮿� ���� - Ŭ���� �ε� �۾�
			// => OracleDriver �ν��Ͻ��� �����Ǿ� JDBC Driver�� ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DBMS ������ �����Ͽ� Connection �ν��Ͻ��� ��ȯ�޾� ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			//3.SQL ����� ������ PreparedStatement �ν��Ͻ��� ��ȯ�޾� ����
			String sql="select * from phonebook order by name";
			pstmt=con.prepareStatement(sql);
			
			//4.SQL ����� �����Ͽ� ���� �� ����� ��ȯ�޾� ����
			rs=pstmt.executeQuery();
			
			//5.��ȯ���� ����� �̿��� ó�� �۾� - Ŭ���̾�Ʈ���� ��� ����
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
			
			//�˻����� �÷����� ��ȯ�޾� Ŭ���̾�Ʈ���� ���� - �ݺ� ó��
			while(rs.next()) {
				out.println("<tr align='center'>");
				out.println("<td>"+rs.getString("phone")+"</td>");
				out.println("<td>"+rs.getString("name")+"</td>");
				out.println("<td>"+rs.getString("address")+"</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]SQL ���� = "+e.getMessage());
		} finally {
			//6.JDBC �ڿ� ����
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		
	}

}








