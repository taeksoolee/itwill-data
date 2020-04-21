package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC ����� �̿��Ͽ� SQL ���(DML)�� �����Ͽ� �����ϸ� �⺻������ �ڵ� Ŀ�ԵǾ� ó��
// => ���α׷� ����� ���ܰ� �߻��� ��� ������ ���޵Ǿ� ����� SQL ����� �ѹ� ó���ϴ� ���� ����
//�ڵ� Ŀ�� ����� ��Ȱ��ȭ �����Ͽ� ���α׷��� ���������� ����� ��� Ŀ�� 
//ó���ϰ� ���α׷� ����� ���ܰ� �߻��� ��� �ѹ� ó��
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
			
			//Connection.setAutoCommit(boolean autoCommit) : �ڵ� Ŀ�� ����� ��� ���θ� �����ϴ� �޼ҵ�
			// => false : �ڵ� Ŀ�� ��� ��Ȱ��ȭ, true : �ڵ� Ŀ�� ��� Ȱ��ȭ(�⺻)
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			String sql="update student set name='��浿' where no=1000";
			int rows=stmt.executeUpdate(sql);
			
			//throw new Exception("���� �˼� ���� �����Դϴ�.");
			
			System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
			
			//Connection.commit() : COMMIT ����� �����ϴ� �޼ҵ�
			con.commit();
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} catch (Exception e) { //���α׷� ����� �߻��� ���ܸ� ó��
			try {
				//Connection.rollback() : ROLLBACK ����� �����ϴ� �޼ҵ�
				con.rollback();
			} catch (SQLException e1) {}
			System.out.println("[����]���α׷� ���� = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}





