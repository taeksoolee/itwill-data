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

//WAS에 등록된 자원을 이용하여 DataSource 인스턴스를 반환받아 Connection
//인스턴스 정보를 전달하는 서블릿  
@WebServlet("/jndi.itwill")
public class JNDIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			//InitialContext 인스턴스를 생성하여 저장
			//InitialContext : WAS에 등록된 자원을 이용하여 인스턴스를 생성
			//하여 반환하는 기능을 제공하는 인스턴스  
			InitialContext ic=new InitialContext();
			
			//InitialContext.lookup(String name) : 자원이름을 전달하여 WAS에
			//등록된 자원정보를 이용하여 인스턴스를 생성하여 반환하는 메소드
			// => Object 타입의 인스턴스를 반환하므로 객체 형변환 후 사용
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
