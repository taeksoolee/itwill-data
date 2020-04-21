package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		/*
		String sql1="update student set name='ȫ�浿' where no=1000";
		int rows=stmt.executeUpdate(sql1);
		
		System.out.println("[���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		System.out.println("==============================================");
		
		String sql2="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		*/
		
		int choice=1;
		
		String sql;
		if(choice==1) {
			sql="update student set name='��浿' where no=1000";
		} else {
			sql="select * from student order by no";
		}
		
		//���޵� SQL ����� Ȯ�������� ���� ��� execute() �޼ҵ� �̿�
		//Statement.execute(String sql) : ��� SQL ����� �����ϴ� �޼ҵ� - boolean ��ȯ
		// => false : DML ����� ���޵Ǿ� ����� ����� ��ȯ��
		// => true : DQL ����� ���޵Ǿ� ����� ����� ��ȯ��
		boolean result=stmt.execute(sql);
		
		if(result) {//DQL ����� ���޵� ���
			//Statement.getResultSet() : ���޵Ǿ� ����� SELECT ��ɿ� 
			//���� �˻����(ResultSet �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
			ResultSet rs=stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
			}
			
			ConnectionFactory.close(con, stmt, rs);
		} else {//DML ����� ���޵� ���
			//Statement.getUpdateCount() : ���޵Ǿ� ����� INSERT,UPDATE,
			//DELETE ��ɿ� ���� �������� ������ ��ȯ�ϴ� �޼ҵ�
			int rows=stmt.getUpdateCount();
			System.out.println("[���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");

			ConnectionFactory.close(con, stmt);
		}
	}
}























