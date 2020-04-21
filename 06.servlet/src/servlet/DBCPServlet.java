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

//Apache DBCP 기능을 이용하여 ConnectionPool를 생성하여 Connection 인스턴스
//정보를 클라이언트에게 전달하는 서블릿
//DBCP(DataBase Connection Pool) : 여러 개의 Connection 인스턴스를 미리
//생성하여 저장 후 JDBC 프로그램에 제공하는 기능 - 가독성과 유지보수 효율성 증가
@WebServlet("/dbcp.itwill")
public class DBCPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//BasicDataSource 인스턴스 생성
		BasicDataSource ds=new BasicDataSource();
		
		//Connection 인스턴스 생성을 위해 BasicDataSource 인스턴스의 필드값 변경
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(10);//최초 생성되는 Connection 인스턴스 갯수 변경
		ds.setMaxIdle(10);//대기상태의 Connection 인스턴스 갯수 변경
		ds.setMaxTotal(20);//최대 생성 가능한 Connection 인스턴스 갯수 변경
		
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
			out.println("<h3>Connection 인스턴스 제공 후</h3>");
			out.println("<p>Connection Active Number = "+ds.getNumActive()+"</p>");
			out.println("<p>Connection Idle Number = "+ds.getNumIdle()+"</p>");
			
			con.close();
			out.println("<hr>");
			out.println("<h3>Connection 인스턴스 제거 후</h3>");
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







