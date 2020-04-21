package site.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;

//Ű����� �й��� �Է¹޾� STUDENT ���̺� ����� �й��� �л������� �����ϴ� ���α׷�
public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<�л����� ����>>");
		System.out.print("�й� �Է� >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("============================================");
		
		Connection con=ConnectionFactory.getConnection();
		
		//�й��� ���޹޾� STUDENT ���̺��� �л������� �����ϴ� ���� ���ν����� ȣ���Ͽ� ó��
		/*
		//DELETE_STUDENT ���� ���ν��� ����
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN NUMBER) IS
		BEGIN
		    DELETE FROM STUDENT WHERE NO=VNO;
		    COMMIT;
		END;
		/
		*/
		
		//CallableStatement �ν��Ͻ� : ���� ���ν��� �Ǵ� ���� �Լ��� 
		//ȣ���ϴ� ����� �����Ͽ� �����ϱ� ���� �ν��Ͻ�
		// => ���� ���ν����� ȣ���ϴ� SQL ��� : {call �������ν���(��,...)}
		// => �� ��� InParameter ��� ���� - InParameter�� ������ �Ǵ� ������ ����
		// => ���� ���ν��� ȣ�� ����� execute() �޼ҵ� ��� 
		String sql="{call DELETE_STUDENT(?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		cstmt.execute();
		
		System.out.println("[���]�л������� ���� �Ͽ����ϴ�.");
		
		ConnectionFactory.close(con, cstmt);
		System.out.println("============================================");
	}
}







