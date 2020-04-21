package site.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학번의 학생정보를 삭제하는 프로그램
public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("============================================");
		
		Connection con=ConnectionFactory.getConnection();
		
		//학번을 전달받아 STUDENT 테이블의 학생정보를 삭제하는 저장 프로시저를 호출하여 처리
		/*
		//DELETE_STUDENT 저장 프로시저 생성
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN NUMBER) IS
		BEGIN
		    DELETE FROM STUDENT WHERE NO=VNO;
		    COMMIT;
		END;
		/
		*/
		
		//CallableStatement 인스턴스 : 저장 프로시저 또는 저장 함수를 
		//호출하는 명령을 저장하여 전달하기 위한 인스턴스
		// => 저장 프로시저를 호출하는 SQL 명령 : {call 저장프로시저(값,...)}
		// => 값 대신 InParameter 사용 가능 - InParameter에 변수값 또는 변수를 전달
		// => 저장 프로시저 호출 명령은 execute() 메소드 사용 
		String sql="{call DELETE_STUDENT(?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		cstmt.execute();
		
		System.out.println("[결과]학생정보를 삭제 하였습니다.");
		
		ConnectionFactory.close(con, cstmt);
		System.out.println("============================================");
	}
}







