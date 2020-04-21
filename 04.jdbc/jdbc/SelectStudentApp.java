package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷�
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
			//Statement.executeQuery(String sql) : SELECT ����� �����Ͽ� �����ϴ� �޼ҵ�
			// => SELECT ��ɿ� ���� �˻��� ���� ResultSet �ν��Ͻ��� �����Ͽ� ��ȯ
			rs=stmt.executeQuery(sql);
			
			//ResultSet �ν��Ͻ��� ����� �˻����� ������� ó���ϱ� ���� Ŀ��(Cursor) ����
			// => �ʱ⿡�� ResultSet Ŀ���� BOF(Before Of File)�� ��ġ 
			//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ� - boolean ��ȯ
			// => false ��ȯ : Ŀ�� ��ġ�� ���� �������� �ʴ� ��� - EOF : End Of File 
			// => true ��ȯ : Ŀ�� ��ġ�� ���� �����ϴ� ���
			if(rs.next()) {
				//System.out.println("[�޼���]�˻��� �л������� �ֽ��ϴ�.");

				do {
					//ResultSet Ŀ�� ��ġ�� �࿡ �÷����� ��ȯ�޾� ����
					//ResultSet.getXXX(int columnIndex) �Ǵ� ResultSet.getXXX(String columnName)
					// => XXX�� �÷����� ��ȯ�ޱ� ���� Java �ڷ������� ǥ��
					// => columnIndex : �˻���� ���� ��ġ��(1���� 1�� �����Ǵ� ������)
					// => columnName : �˻������ �÷���(��Ī) 
					//int no=rs.getInt(1);
					int no=rs.getInt("no");
					String name=rs.getString("name");
					String phone=rs.getString("phone");
					String address=rs.getString("address");
					//��� �÷����� ���ڿ�(String)�� ��ȯ�޾� ���� ����
					//Date birthday=rs.getDate("birthday");
					String birthday=rs.getString("birthday");
					
					System.out.println("�й� = "+no);
					System.out.println("�̸� = "+name);
					System.out.println("��ȭ��ȣ = "+phone);
					System.out.println("�ּ� = "+address);
					//System.out.println("������� = "+birthday.toString());
					System.out.println("������� = "+birthday.substring(0, 10));
					System.out.println("================================");
				} while(rs.next());
			} else {
				System.out.println("[�޼���]�˻��� �л������� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
	}
}








