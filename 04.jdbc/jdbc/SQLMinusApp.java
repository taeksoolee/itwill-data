package site.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//키보드로 SQL 명령(INSERT,UPDATE,DELETE,SELECT)을 입력받아 DBMS 서버에 
//전달하여 실행된 처리 결과를 출력하는 JDBC 프로그램
// => SQL 명령을 계속 입력받아 전달하여 처리 결과 출력
// => 입력된 명령이 EXIT인 경우 프로그램 종료 - 대소문자 미구분
// => 입력된 SQL 명령이 잘못된 경우 에러 메세지(SQLException 이용) 출력
// => SQLPLUS 프로그램을 참고하여 처리 결과 출력
public class SQLMinusApp {
	public static void main(String[] args) throws Exception {
		//SQL 명령을 입력받기 키보드 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=null;
		
		while(true) {
			//키보드로 SQL 명령을 입력받아 저장
			System.out.print("SQL> ");
			String sql=in.readLine().trim();
			
			//입력된 문자열이 [exit]인 경우 반복문 종료 >> 프로그램 종료
			if(sql.equalsIgnoreCase("exit")) break;
			
			//SQL 명령을 입력하지 않은 경우 반복문 재실행
			if(sql==null || sql.equals("")) continue;
		
			//SQL 명령을 전달하여 실행결과를 반환받아 출력
			try {
				if(stmt.execute(sql)) {//DQL
					rs=stmt.getResultSet();
					
					//검색결과에 대한 부가적인 정보를 반환받아 저장
					ResultSetMetaData rsmd=rs.getMetaData();
					
					//검색결과에 대한 컬럼 갯수를 반환받아 저장
					int columnCount=rsmd.getColumnCount();
					
					if(rs.next()) {//검색결과(행)가 있는 경우
						//검색결과에 대한 검색대상(컬럼명) 출력
						System.out.println("================================================================");
						for(int i=1;i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t");
						}
						System.out.println();
						System.out.println("================================================================");
						do {
							for(int i=1;i<=columnCount;i++) {
								String columnValue=rs.getString(i);
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									columnValue=columnValue.substring(0, 10);
								}
								if(columnValue==null) {
									columnValue="   ";
								}
								System.out.print(columnValue+"\t");
							}
							System.out.println();
						} while(rs.next());
					} else {//검색결과(행)가 없는 경우
						System.out.println("검색된 결과가 하나도 없습니다.");
					}
				} else {//DML
					int rows=stmt.getUpdateCount();
					System.out.println(rows+"개의 행을 "
						+sql.substring(0, 6).toUpperCase()+" 하였습니다.");
				}
			} catch (SQLException e) {
				//입력된 SQL 명령이 잘못된 경우 발생되는 예외처리
				System.out.println("SQL 오류 = "+e.getMessage());
			}
			System.out.println();
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("[메세지]SQLMinus 프로그램을 종료합니다.");
	}
}








