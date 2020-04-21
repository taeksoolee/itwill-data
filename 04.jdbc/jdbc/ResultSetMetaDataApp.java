package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//ResultSetMetaData �ν��Ͻ� : ResultSet �ν��Ͻ��� ����� �˻������ ����
//�ΰ����� ������ �����ϴ� �ν��Ͻ�
public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		//String sql="select no,name,phone from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.getMetaData() : ResultSet �ν��Ͻ��� ����� �˻������ ���� 
		//�ΰ����� ������ ����� ResultSetMetaData �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCount() : �˻������ ���� �÷� ������ ��ȯ�ϴ� �޼ҵ�
		int columnCount=rsmd.getColumnCount();
		System.out.println("�˻������ ���� �÷� ���� = "+columnCount);
		System.out.println("==============================================");
		for(int i=1;i<=columnCount;i++) {
			//ResultSetMetaData.getColumnLabel(index columnIndex) : 
			//columnIndex ��ġ�� �÷����� ��ȯ�ϴ� �޼ҵ�
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ResultSetMetaData.isNullable(index columnIndex) : 
			//columnIndex ��ġ�� �÷��� ���� NULL ��� ������(0 or 1)�� ��ȯ�ϴ� �޼ҵ�
			int isNull=rsmd.isNullable(i);
			String nullResult="NULL";
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			
			//ResultSetMetaData.getColumnTypeName(index columnIndex) : 
			//columnIndex ��ġ�� �÷� �ڷ����� ��ȯ�ϴ� �޼ҵ�
			String columnTypeName=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(index columnIndex) : 
			//columnIndex ��ġ�� �÷����� ���ũ�⸦ ��ȯ�ϴ� �޼ҵ�
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("�÷� �󺧸� = "+columnLabel);
			System.out.println("NULL ��� ���� = "+nullResult);
			System.out.println("�÷� �ڷ��� = "+columnTypeName);
			System.out.println("�÷��� ���ũ�� = "+columnDisplaySize);
			System.out.println("==============================================");
		}
		
		ConnectionFactory.close(con, stmt, rs);
	}
}











