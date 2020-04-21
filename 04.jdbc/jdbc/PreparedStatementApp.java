package site.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//PreparedStatement �ν��Ͻ� : ���ӵ� DBMS ������ SQL ����� �����Ͽ� ����
//����� ��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�
//���� : SQL ��ɿ� InParameter�� ����Ͽ� ���� ���޹޾� ��� - ���� SQL ���
// => �̸� ����� SQL ����� �����ϹǷ� �������� ������ InParameter�� ����Ͽ� ���������� ȿ������ ����
// => InSQL ��ŷ ���� ��ȿȭ - ���ް��� SQL ������� ������
//���� : PreparedStatement �ν��Ͻ����� �ϳ��� SQL ��ɸ� ����Ǿ� ���� ����
public class PreparedStatementApp {
	public static void main(String[] args) throws Exception {
		/*
		//Ű����� �л������� �Է¹޾� STUDENT ���̺� �����ϰ� STUDENT
		//���̺� ����� ��� �л������� �˻��Ͽ� ����ϴ� ���α׷�
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է½�Ʈ�� ����
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �л������� �Է¹޾� ����
		System.out.println("<<�л����� �Է�>>");
		System.out.print("�й� �Է� >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.print("�̸� �Է� >> ");
		String name=in.readLine();
		System.out.print("��ȭ��ȣ �Է� >> ");
		String phone=in.readLine();
		System.out.print("�ּ� �Է� >> ");
		String address=in.readLine();
		System.out.print("������� �Է� >> ");
		String birthday=in.readLine();
		System.out.println("============================================");
		//Ű����� �Է¹��� �л������� STUDENT ���̺� ���� - JDBC
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareStatement(String sql) : SQL ����� �����ϰ� �ִ�
		//PreparedStatement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => PreparedStatement �ν��Ͻ��� ����� SQL ��ɿ��� ?(InParameter) ���
		//InParameter : Java �������� �����޾� Oracle ����� ǥ���ϱ� ���� ��ȣ
		// => ��� InParameter�� Java �������� ���� �Ǿ�߸� SQL ��� �ϼ�
		//PreparedStatement.setXXX(int parameterIndex,XXX value) : InParameter�� ���� �����ϱ� ���� �޼ҵ�
		// => XXX�� Java �ڷ����̸� �޼ҵ�� InParameter ������ŭ ȣ��
		String sql1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		//PreparedStatement.executeUpdate() : PreparedStatement �ν��Ͻ���
		//����� SQL ���(DML)�� �����Ͽ� �����ϴ� �޼ҵ� - �������� ���� ��ȯ
		int rows=pstmt.executeUpdate();
		
		System.out.println("[���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		System.out.println("============================================");
		String sql2="select * from student order by no";
		pstmt=con.prepareStatement(sql2);
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================");
		*/
		
		//Ű����� �̸��� �Է¹޾� STUDENT ���̺� ����� �л������� 
		//�Էµ� �̸����� �˻��Ͽ� ����ϴ� ���α׷�
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("<<�л����� �˻�>>");
		System.out.print("�̸� �Է� >> ");
		String name=in.readLine();
		System.out.println("============================================");
		Connection con=ConnectionFactory.getConnection();
		
		String sql="select * from student where name=? order by no";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("<<�˻����>>");
		if(rs.next()) {
			do {
				System.out.println("�й� = "+rs.getInt("no")+", �̸� = "+rs.getString("name"));
			}while(rs.next());
		} else {
			System.out.println("�˻��� �л������� �����ϴ�.");
		}
		
		ConnectionFactory.close(con, pstmt, rs);
		System.out.println("============================================");
	}
}




