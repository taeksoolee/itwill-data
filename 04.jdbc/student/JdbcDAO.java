package site.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//DBCP(DataBase Connection Pool) ���� �ν��Ͻ��� �����Ͽ� Connection �ν��Ͻ�
//��ȯ�ϰų� Connection �ν��Ͻ��� �����ϴ� ����� �����ϱ� ���� Ŭ����
// => �����ü�� DBMS�� DAO Ŭ�������� ��ӹ޾� ��� 
// => �߻�Ŭ������ �����ϴ� ���� ����
public abstract class JdbcDAO {
	private static PoolDataSource _pds;
	
	static {
		_pds=PoolDataSourceFactory.getPoolDataSource();
		
		try {
			_pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			_pds.setURL("jdbc:oracle:thin:@192.168.14.31:1521:xe");
			_pds.setUser("scott");
			_pds.setPassword("tiger");
			_pds.setInitialPoolSize(3);
			_pds.setMaxPoolSize(5);
			_pds.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=_pds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
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
