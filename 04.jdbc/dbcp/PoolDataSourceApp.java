package site.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//javax.sql.DataSource : DBCP 클래스를 작성하기 위해 상속받아야 되는 인터페이스
// => DBCP 클래스에 동일한 형태의 메소드가 선언하도록 메소드 작성 규칙 제공

//UCP(Universal Connection Pool) 라이브러리의 PoolDataSource 인스턴스를 이용한 프로그램
public class PoolDataSourceApp {
	public static void main(String[] args) throws SQLException {
		//PoolDataSourceFactory.getPoolDataSource() : PoolDataSource 인스턴스를 반환하는 메소드
		PoolDataSource pds=PoolDataSourceFactory.getPoolDataSource();
		
		//Connection 인스턴스를 생성하기 위해 PoolDataSource 인스턴스의 정보 변경
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		pds.setUser("scott");
		pds.setPassword("tiger");
		
		//Connection 인스턴스의 갯수를 제한하기 위해 PoolDataSource 인스턴스의 정보 변경
		// => Connection 인스턴스의 갯수를 제한하지 않을 경우 기본값 사용
		pds.setInitialPoolSize(2);
		pds.setMaxPoolSize(3);
		
		//PoolDataSource.getConnection() : Connection 인스턴스를 반환하는 메소드
		// => PoolDataSource 인스턴스에 Connection 인스턴스가 없는 경우 생성
		Connection con1=pds.getConnection();
		System.out.println("con1 = "+con1);
		System.out.println("사용 가능한 Connection 갯수 = "+pds.getAvailableConnectionsCount());
		//Connection 인스턴스를 제거하면 PoolDataSource 인스턴스에서 새로운
		//Connection 생성하여 추가 - 동일한 Connection 인스턴스 갯수 유지
		//con1.close();
		System.out.println("============================================");
		Connection con2=pds.getConnection();
		System.out.println("con2 = "+con2);
		System.out.println("사용 가능한 Connection 갯수 = "+pds.getAvailableConnectionsCount());
		//con2.close();
		System.out.println("============================================");
		Connection con3=pds.getConnection();
		System.out.println("con3 = "+con3);
		System.out.println("사용 가능한 Connection 갯수 = "+pds.getAvailableConnectionsCount());
		//con3.close();
		System.out.println("============================================");
		Connection con4=pds.getConnection();
		System.out.println("con4 = "+con4);
		System.out.println("사용 가능한 Connection 갯수 = "+pds.getAvailableConnectionsCount());
		con4.close();
		System.out.println("============================================");
	}
}