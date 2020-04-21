package site.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

//DBCP(DataBase Connection Pool) : Connection 인스턴스 미리 여러개 생성
//저장하여 제공하는 기능의 클래스
public class ConnectionPoolApp {
	public static void main(String[] args) throws SQLException {
		ConnectionPool cp=ConnectionPool.getInstance();
		
		Connection con1=cp.getConnection();
		System.out.println("con1 = "+con1);
		//cp.freeConnection(con1);
		
		Connection con2=cp.getConnection();
		System.out.println("con2 = "+con2);
		//cp.freeConnection(con2);
		
		Connection con3=cp.getConnection();
		System.out.println("con3 = "+con3);
		//cp.freeConnection(con3);
		
		Connection con4=cp.getConnection();
		System.out.println("con4 = "+con4);
		cp.freeConnection(con4);
	}
}
