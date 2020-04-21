package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection 인스턴스를 생성하여 반환하거나 제거하는 기능을 제공하는 클래스
// => JDBC 프로그램 작성에 필요한 공통적인 명령들을 메소드로 제공
// => 프로그램의 생산성 향상 및 유지보수 효율성 증가
public class ConnectionFactory {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("[에러]Connection 인스턴스를 생성할 수 없습니다.");
			System.exit(0);
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con,Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}









