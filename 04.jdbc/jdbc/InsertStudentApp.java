package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블 : 학번(숫자형-PRIMARY KEY),이름(문자형)
//,전화번호(문자형),주소(문자형),생년월일(날짜형)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY, NAME VARCHAR2(20) 
//,PHONE VARCHAR2(15),ADDRESS VARCHAR2(50), BIRTHDAY DATE)

//STUDENT 테이블에 학생정보를 저장하는 JDBC 프로그램
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 인스턴스를 저장하는 참조변수는 try 영역 외부에서 선언
		// => finally 영역에서 참조변수를 사용하여 메소드 호출 가능
		Connection con=null;
		Statement stmt=null;
		
		try {
			/*
			//동일한 OracleDriver 클래스의 다른 인스턴스가 JDBC Driver로 등록 가능 - 비권장 
		
			//OracleDriver 클래스를 인스턴스로 생성하여 저장
			OracleDriver driver=new OracleDriver();
		
			//OracleDriver 인스턴스를 전달하여 JDBC 드라이버로 등록
			DriverManager.registerDriver(driver);
			*/
			
			//1.OracleDriver 클래스를 읽어 메모리에 저장
			// => OracleDriver 클래스로 인스턴스를 생성하여 JDBC 드라이버로 등록
			//JDBC 드라이버 : DriverManager 클래스에 등록된 Driver 인스턴스로
			//DBMS 서버의 URL 주소를 이용하여 서버에 접속할 수 있는 인스턴스 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2.JDBC 드라이버를 이용하여 DBMS 서버에 접속
			//DriverManager.getConnection(String url,String user,String password)
			// => DBMS 서버에 접속하는 메소드 - Connection 인스턴스 반환
			// => 전달된 URL 정보에 따라 다른 DBMS 서버에 접속
			// => SQLException 발생 : JDBC 관련된 인스턴스의 메소드에서 발생하는 예외
			//URL : 인터넷에 존재하는 자원을 표현하는 방법 
			// => Protocol:ServerName:Port:Resource
			//Oracel DBMS Server JDBC URL
			//형식) jdbc:oracle:thin:@ServerName:Port:SID
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott"; 
			String password="tiger"; 
			//Connection : Connection 인스턴스를 생성하기 위한 클래스의 부모 인터페이스
			// => Connection 인스턴스를 저장할 수 있는 참조변수 생성
			// => DBMS 서버의 접속정보를 저장하기 위한 인스턴스
			con=DriverManager.getConnection(url, user, password);
			
			//3.SQL 명령을 저장하기 위한 인스턴스를 반환받아 저장
			//Connection.createStatement() : Statement 인스턴스를 반환하는 메소드
			//Statement : Statement 인스턴스를 생성하기 위한 클래스의 부모 인터페이스
			// => Statement 인스턴스를 저장할 수 있는 참조변수 생성
			// => SQL 명령을 접속된 서버에 전달하기 위한 기능을 제공하는 인스턴스
			stmt=con.createStatement();
			
			//4.Statement 인스턴스에 SQL 명령을 접속된 서버에 전달하여 실행결과를 반환받아 저장
			//Statement.executeUpdate(String sql) : SQL 명령(INSERT,UPDATE,DELETE)을 접속된 서버에 전달하는 메소드
			// => 조작된 행의 갯수(int) 반환
			//Statement.executeQuery(String sql) : SQL 명령(SELECT)을 접속된 서버에 전달하는 메소드
			// => 검색된 행(ResultSet 인스턴스) 반환
			//String sql="insert into student values(1000,'홍길동','010-1111-1111','서울시 강남구','1999-12-31')";
			//String sql="insert into student values(2000,'임꺽정','010-2222-2222','수원시 팔달구','2000-01-01')";
			String sql="insert into student values(3000,'전우치','010-3333-3333','인천시 월미구','1997-04-22')";
			int rows=stmt.executeUpdate(sql);
			
			//5.저장된 SQL 명령의 실행결과를 출력(반환)
			System.out.println("[메세지]"+rows+"명의 학생정보를 저장 하였습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 문제 = "+e.getMessage());
		} finally {
			//6.JDBC 관련 인스턴스 제거 - close() 메소드 호출
			// => 인스턴스 생성 순서 반대로 제거 
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();//접속종료
			} catch (SQLException e) { }
		}
		
	}
}










