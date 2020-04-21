package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//JDBC ����� �����ϱ� ���� DAO Ŭ�������� ��ӹ޾� ����ϱ� ���� Ŭ����
// => DBCP ���� �ν��Ͻ��� �����̳ʷ� ���� �޾� Connection �ν��Ͻ���
//    ��ȯ�ϰų� Connection �ν��Ͻ��� �����ϴ� ����� �޼ҵ� �ۼ�
// => ����� ������ Ŭ�����̹Ƿ� �߻�Ŭ������ �����ϴ� ���� ����
public abstract class JdbcDAO {
	private static DataSource ds;
	
	static {
		try {
			ds=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//Connection �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	//JDBC �ڿ��� �����ϴ� �޼ҵ�
	public void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}






