package site.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement 인스턴스 : 접속된 DBMS 서버에 SQL 명령을 전달하여 실행
//결과를 반환하는 기능을 제공하는 인스턴스
//장점 : SQL 명령에 InParameter를 사용하여 값을 전달받아 사용 - 동적 SQL 명령
// => 미리 저장된 SQL 명령을 전달하므로 가독성이 좋으며 InParameter를 사용하여 유지보수의 효율성이 높음
// => InSQL 해킹 공격 무효화 - 전달값이 SQL 명령으로 미포함
//단점 : PreparedStatement 인스턴스에는 하나의 SQL 명령만 저장되어 전달 가능
public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		/*
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 저장하고 STUDENT
		//테이블에 저장된 모든 학생정보를 검색하여 출력하는 프로그램
		
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 저장
		System.out.println("<<학생정보 입력>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.print("전화번호 입력 >> ");
		String phone=in.readLine();
		System.out.print("주소 입력 >> ");
		String address=in.readLine();
		System.out.print("생년월일 입력 >> ");
		String birthday=in.readLine();
		System.out.println("============================================");
		//키보드로 입력받은 학생정보를 STUDENT 테이블에 저장 - JDBC
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : SQL 명령을 저장하고 있는
		//PreparedStatement 인스턴스를 반환하는 메소드
		// => PreparedStatement 인스턴스에 저장된 SQL 명령에는 ?(InParameter) 사용
		//InParameter : Java 변수값을 제공받아 Oracle 상수로 표현하기 위한 기호
		// => 모든 InParameter에 Java 변수값이 전달 되어야만 SQL 명령 완성
		//PreparedStatement.setXXX(int parameterIndex,XXX value) : InParameter에 값을 전달하기 위한 메소드
		// => XXX는 Java 자료형이며 메소드는 InParameter 갯수만큼 호출
		String sql1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement 인스턴스에
		//저장된 SQL 명령(DML)을 전달하여 실행하는 메소드 - 조작행의 갯수 반환
		int rows=pstmt.executeUpdate();
		
		System.out.println("[결과]"+rows+"명의 학생정보를 저장 하였습니다.");
		System.out.println("============================================");
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================");
		*/
		
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보를 
		//입력된 이름으로 검색하여 출력하는 프로그램
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("<<학생정보 검색>>");
		System.out.print("이름 입력 >> ");
		String name=in.readLine();
		System.out.println("============================================");
		Connection con=ConnectionFactory.getConnection();
		
		String sql="select * from student where name=? order by no";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<검색결과>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
			}while(rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================");
	}
}




