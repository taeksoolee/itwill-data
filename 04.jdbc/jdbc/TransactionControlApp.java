package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 기능을 이용하여 SQL 명령(DML)을 전달하여 실행하면 기본적으로 자동 커밋되어 처리
// => 프로그램 실행시 예외가 발생될 경우 이전에 전달되어 실행된 SQL 명령은 롤백 처리하는 것을 권장
//자동 커밋 기능을 비활성화 설정하여 프로그램이 정상적으로 실행된 경우 커밋 
//처리하고 프로그램 실행시 예외가 발생된 경우 롤백 처리
public class TransactionControlApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			//Connection.setAutoCommit(boolean autoCommit) : 자동 커밋 기능의 사용 여부를 변경하는 메소드
			// => false : 자동 커밋 기능 비활성화, true : 자동 커밋 기능 활성화(기본)
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			String sql="update student set name='고길동' where no=1000";
			int rows=stmt.executeUpdate(sql);
			
			//throw new Exception("나도 알수 없는 예외입니다.");
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 변경 하였습니다.");
			
			//Connection.commit() : COMMIT 명령을 전달하는 메소드
			con.commit();
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} catch (Exception e) { //프로그램 실행시 발생된 예외를 처리
			try {
				//Connection.rollback() : ROLLBACK 명령을 전달하는 메소드
				con.rollback();
			} catch (SQLException e1) {}
			System.out.println("[에러]프로그램 오류 = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}





