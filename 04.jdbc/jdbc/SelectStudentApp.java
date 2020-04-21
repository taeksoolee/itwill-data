package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 JDBC 프로그램
public class SelectStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하는 메소드
			// => SELECT 명령에 의해 검색된 행을 ResultSet 인스턴스에 저장하여 반환
			rs=stmt.executeQuery(sql);
			
			//ResultSet 인스턴스에 저장된 검색행을 행단위로 처리하기 위해 커서(Cursor) 제공
			// => 초기에는 ResultSet 커서가 BOF(Before Of File)에 위치 
			//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드 - boolean 반환
			// => false 반환 : 커서 위치에 행이 존재하지 않는 경우 - EOF : End Of File 
			// => true 반환 : 커서 위치에 행이 존재하는 경우
			if(rs.next()) {
				//System.out.println("[메세지]검색된 학생정보가 있습니다.");

				do {
					//ResultSet 커서 위치의 행에 컬럼값을 반환받아 저장
					//ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(String columnName)
					// => XXX는 컬럼값을 반환받기 위한 Java 자료형으로 표현
					// => columnIndex : 검색대상에 대한 위치값(1부터 1씩 증가되는 정수값)
					// => columnName : 검색대상의 컬럼명(별칭) 
					//int no=rs.getInt(1);
					int no=rs.getInt("no");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String address=rs.getString("address");
					//모든 컬럼값은 문자열(String)로 반환받아 저장 가능
					//Date birthday=rs.getDate("birthday");
					String birthday=rs.getString("birthday");
					
					System.out.println("학번 = "+no);
					System.out.println("이름 = "+name);
					System.out.println("전화번호 = "+phone);
					System.out.println("주소 = "+address);
					//System.out.println("생년월일 = "+birthday.toString());
					System.out.println("생년월일 = "+birthday.substring(0, 10));
					System.out.println("================================");
				} while(rs.next());
			} else {
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 예외 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}








