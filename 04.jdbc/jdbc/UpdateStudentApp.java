package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT ���̺� ����� �л����� �� �й��� 2000�� �л��� �̸��� [�Ӱ���]����
//�����ϰ� �ּҸ� [��õ�� ���̱�]�� �����ϴ� JDBC ���α׷�
public class UpdateStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="update student set name='�Ӱ���',address='��õ�� ���̱�' where no=2000";
			int rows=stmt.executeUpdate(sql);
			
			if(rows>0) {
				System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
			} else {
				System.out.println("[�޼���]�й��� �л������� ã�� �� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}

