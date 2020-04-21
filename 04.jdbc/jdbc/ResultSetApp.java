package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Statement �ν��Ͻ� ��������� ���� ResultSet �ν��Ͻ��� ���� ����
// => ResultSet Ŀ�� ��ġ ���� �� Ŀ�� ��ġ�� �˻����� ������ ����
public class ResultSetApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//Statement �ν��Ͻ� : SQL ����� �����ϱ� ���� ����� �����ϴ� �ν��Ͻ�
		//Statement.executeQuery(String sql) : SELECT ����� �����Ͽ� ResultSet �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ResultSet �ν��Ͻ� : SELECT ����� �˻������ �����ϱ� ���� �ν��Ͻ�
		// => ResultSet Ŀ���� �̵��Ͽ� ����� ó��
		// => ResultSet Ŀ���� ���������θ� �̵��ϸ� Ŀ�� ��ġ�� �࿡ ���� ���� �Ұ���
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		// => Ŀ����ġ�� ���� ���� ��� false ��ȯ, �ִ� true ��ȯ
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet �ν��Ͻ��� ����� �˻�����
			//���ȣ(RowIndex)�� ��ȯ�ϴ� �޼ҵ�
			System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("============================================");
		con=ConnectionFactory.getConnection();
		
		//con.createStatement(int resultSetType, int resultSetConcurrency)
		// => Statement �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => SELECT ����� �����Ͽ� ��ȯ�Ǵ� ResultSet �ν��Ͻ��� �Ӽ� ����
		//resultSetType : ResultSet Ŀ�� �̵� ���� �Ӽ� ����
		// => ResultSet.TYPE_FORWARD_ONLY : ResultSet Ŀ���� �Ʒ������θ� �̵�(�⺻)
		// => ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ �̹ݿ�
		// => ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet Ŀ���� ���ϴ� ������ �̵� - ������ �ݿ�
		//resultSetConcurrency : ResultSet Ŀ�� ��ġ�� ó���� ���� ���� �Ӽ� ����
		// => ResultSet.CONCUR_READ_ONLY : ó������ ���� �Ұ���(�⺻)
		// => ResultSet.CONCUR_UPDATABLE : ó������ ���� ����
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		sql="select * from student order by no";
		//ResultSet Ŀ���� ���� ��ġ : BOF
		rs=stmt.executeQuery(sql);
		
		//ResultSet.first() : ResultSet Ŀ���� ù��° �˻������� �̵��ϴ� �޼ҵ�
		rs.first();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//ResultSet.last() : ResultSet Ŀ���� ������ �˻������� �̵��ϴ� �޼ҵ�
		rs.last();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//ResultSet.absolute(int rowIndex) : ResultSet Ŀ���� Index ��ġ�� �˻������� �̵��ϴ� �޼ҵ�
		rs.absolute(2);
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		System.out.println("============================================");
		//ResultSet.beforeFirst() : ResultSet Ŀ���� BOF�� �̵��ϴ� �޼ҵ�
		rs.beforeFirst();
		//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		rs.next();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		
		//ResultSet.afterLast() : ResultSet Ŀ���� EOF�� �̵��ϴ� �޼ҵ�
		rs.afterLast();
		//ResultSet.previous() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ�
		rs.previous();
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("============================================");
		con=ConnectionFactory.getConnection();

		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		//Ŀ�� ��ġ�� ���� �����ϰ��� �� ��� SELECT ��ɿ��� �˻�������� * ��� �Ұ��� 
		sql="select no,name,phone,address,birthday from student order by no";
		rs=stmt.executeQuery(sql);
		
		/*
		//ResultSet �ν��Ͻ��� ����� �˻�������� 2��° ��ġ�� ���ο� 
		//���� �����Ͽ� ���̺� ���� >> INSERT
		rs.absolute(2);
		
		//ResultSet.moveToInsertRow() : Ŀ�� ��ġ�� ���ο� ���� �����ϴ� �޼ҵ�
		// => ���� ����� �ڵ����� �ڷ� �̵�
		rs.moveToInsertRow();
		
		//ResultSet.updateXXX(String columnName, XXX value) : Ŀ�� ��ġ�� 
		//�࿡ �÷����� �����ϴ� �޼ҵ� => XXX : Java �ڷ���
		rs.updateInt("no", 4000);
		rs.updateString("name", "������");
		rs.updateString("phone", "010-4444-4444");
		rs.updateString("address", "������ �ȴޱ�");
		//rs.updateDate("birthday", new Date(2000, 5, 10));
		rs.updateString("birthday", "2000-05-10 00:00:00.0");
		
		//ResultSet.insertRow() : Ŀ�� ��ġ�� ������ ���̺��� ���� �����ϴ� �޼ҵ�
		rs.insertRow();
		
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		*/
		
		/*
		//ResultSet �ν��Ͻ��� ����� �˻�������� 3��° ��ġ�� �˻��� 
		//�����Ͽ� ���̺� ���� >> DELETE
		rs.absolute(3);
		
		//ResultSet.deleteRow() : Ŀ�� ��ġ�� ������ ���̺��� ���� �����ϴ� �޼ҵ�
		rs.deleteRow();
		*/
		
		//ResultSet �ν��Ͻ��� ����� �˻�������� 2��° ��ġ�� �˻��࿡ 
		//�̸��� [�Ӳ���]���� �����Ͽ� ���̺� ���� >> UPDATE
		rs.absolute(2);
		rs.updateString("name", "�Ӳ���");
		
		//ResultSet.updateRow() : Ŀ�� ��ġ�� ������ ���̺��� ���� �����ϴ� �޼ҵ�
		rs.updateRow();
		
		System.out.println(rs.getRow()+"�� : �й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));

		ConnectionFactory.close(con, stmt, rs);
		System.out.println("============================================");
	}
}













