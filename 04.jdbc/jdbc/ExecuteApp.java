package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		/*
		String sql1="update student set name='홍길동' where no=1000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[결과]"+rows+"명의 학생정보를 변경 하였습니다.");
		System.out.println("==============================================");
		
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		*/
		
		int choice=1;
		
		String sql;
		if(choice==1) {
			sql="update student set name='고길동' where no=1000";
		} else {
			sql="select * from student order by no";
		}
		
		//전달될 SQL 명령이 확정적이지 않을 경우 execute() 메소드 이용
		//Statement.execute(String sql) : 모든 SQL 명령을 전달하는 메소드 - boolean 반환
		// => false : DML 명령이 전달되어 실행된 경우의 반환값
		// => true : DQL 명령이 전달되어 실행된 경우의 반환값
		boolean result=stmt.execute(sql);
		
		if(result) {//DQL 명령이 전달된 경우
			//Statement.getResultSet() : 전달되어 실행된 SELECT 명령에 
			//대한 검색결과(ResultSet 인스턴스)를 반환하는 메소드
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			}
			
			ConnectionFactory.close(con, stmt, rs);
		} else {//DML 명령이 전달된 경우
			//Statement.getUpdateCount() : 전달되어 실행된 INSERT,UPDATE,
			//DELETE 명령에 대한 조작행의 갯수를 반환하는 메소드
			int rows=stmt.getUpdateCount();
			System.out.println("[결과]"+rows+"명의 학생정보를 변경 하였습니다.");

			ConnectionFactory.close(con, stmt);
		}
	}
}























