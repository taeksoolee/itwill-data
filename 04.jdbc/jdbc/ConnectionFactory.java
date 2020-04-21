package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection �ν��Ͻ��� �����Ͽ� ��ȯ�ϰų� �����ϴ� ����� �����ϴ� Ŭ����
// => JDBC ���α׷� �ۼ��� �ʿ��� �������� ��ɵ��� �޼ҵ�� ����
// => ���α׷��� ���꼺 ��� �� �������� ȿ���� ����
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
			System.out.println("[����]Connection �ν��Ͻ��� ������ �� �����ϴ�.");
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









