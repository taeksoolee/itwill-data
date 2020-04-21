package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT ���̺� : �й�(������-PRIMARY KEY),�̸�(������)
//,��ȭ��ȣ(������),�ּ�(������),�������(��¥��)
//CREATE TABLE STUDENT(NO NUMBER(4) PRIMARY KEY, NAME VARCHAR2(20) 
//,PHONE VARCHAR2(15),ADDRESS VARCHAR2(50), BIRTHDAY DATE)

//STUDENT ���̺� �л������� �����ϴ� JDBC ���α׷�
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC ���� �ν��Ͻ��� �����ϴ� ���������� try ���� �ܺο��� ����
		// => finally �������� ���������� ����Ͽ� �޼ҵ� ȣ�� ����
		Connection con=null;
		Statement stmt=null;
		
		try {
			/*
			//������ OracleDriver Ŭ������ �ٸ� �ν��Ͻ��� JDBC Driver�� ��� ���� - ����� 
		
			//OracleDriver Ŭ������ �ν��Ͻ��� �����Ͽ� ����
			OracleDriver driver=new OracleDriver();
		
			//OracleDriver �ν��Ͻ��� �����Ͽ� JDBC ����̹��� ���
			DriverManager.registerDriver(driver);
			*/
			
			//1.OracleDriver Ŭ������ �о� �޸𸮿� ����
			// => OracleDriver Ŭ������ �ν��Ͻ��� �����Ͽ� JDBC ����̹��� ���
			//JDBC ����̹� : DriverManager Ŭ������ ��ϵ� Driver �ν��Ͻ���
			//DBMS ������ URL �ּҸ� �̿��Ͽ� ������ ������ �� �ִ� �ν��Ͻ� 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2.JDBC ����̹��� �̿��Ͽ� DBMS ������ ����
			//DriverManager.getConnection(String url,String user,String password)
			// => DBMS ������ �����ϴ� �޼ҵ� - Connection �ν��Ͻ� ��ȯ
			// => ���޵� URL ������ ���� �ٸ� DBMS ������ ����
			// => SQLException �߻� : JDBC ���õ� �ν��Ͻ��� �޼ҵ忡�� �߻��ϴ� ����
			//URL : ���ͳݿ� �����ϴ� �ڿ��� ǥ���ϴ� ��� 
			// => Protocol:ServerName:Port:Resource
			//Oracel DBMS Server JDBC URL
			//����) jdbc:oracle:thin:@ServerName:Port:SID
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott"; 
			String password="tiger"; 
			//Connection : Connection �ν��Ͻ��� �����ϱ� ���� Ŭ������ �θ� �������̽�
			// => Connection �ν��Ͻ��� ������ �� �ִ� �������� ����
			// => DBMS ������ ���������� �����ϱ� ���� �ν��Ͻ�
			con=DriverManager.getConnection(url, user, password);
			
			//3.SQL ����� �����ϱ� ���� �ν��Ͻ��� ��ȯ�޾� ����
			//Connection.createStatement() : Statement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			//Statement : Statement �ν��Ͻ��� �����ϱ� ���� Ŭ������ �θ� �������̽�
			// => Statement �ν��Ͻ��� ������ �� �ִ� �������� ����
			// => SQL ����� ���ӵ� ������ �����ϱ� ���� ����� �����ϴ� �ν��Ͻ�
			stmt=con.createStatement();
			
			//4.Statement �ν��Ͻ��� SQL ����� ���ӵ� ������ �����Ͽ� �������� ��ȯ�޾� ����
			//Statement.executeUpdate(String sql) : SQL ���(INSERT,UPDATE,DELETE)�� ���ӵ� ������ �����ϴ� �޼ҵ�
			// => ���۵� ���� ����(int) ��ȯ
			//Statement.executeQuery(String sql) : SQL ���(SELECT)�� ���ӵ� ������ �����ϴ� �޼ҵ�
			// => �˻��� ��(ResultSet �ν��Ͻ�) ��ȯ
			//String sql="insert into student values(1000,'ȫ�浿','010-1111-1111','����� ������','1999-12-31')";
			//String sql="insert into student values(2000,'�Ӳ���','010-2222-2222','������ �ȴޱ�','2000-01-01')";
			String sql="insert into student values(3000,'����ġ','010-3333-3333','��õ�� ���̱�','1997-04-22')";
			int rows=stmt.executeUpdate(sql);
			
			//5.����� SQL ����� �������� ���(��ȯ)
			System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} finally {
			//6.JDBC ���� �ν��Ͻ� ���� - close() �޼ҵ� ȣ��
			// => �ν��Ͻ� ���� ���� �ݴ�� ���� 
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();//��������
			} catch (SQLException e) { }
		}
		
	}
}










