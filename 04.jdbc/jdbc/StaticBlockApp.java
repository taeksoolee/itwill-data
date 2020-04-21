package site.itwill.jdbc;

public class StaticBlockApp {
	public static void main(String[] args) {
		/*
		//1.Class Loader ���α׷��� ���� Ŭ����(Class ����)�� �о� �޸𸮿� ���� - �ڵ�
		//2.new �����ڷ� �޸𸮿� ����� Ŭ����(Clazz)�� �����ڸ� ȣ���Ͽ� �ν��Ͻ� ����
		// => ������ �ν��Ͻ��� ���������� ����
		StaticBlock sb=new StaticBlock();
				
		//3.���������� �̿��Ͽ� �ν��Ͻ��� �޼ҵ� ȣ�� - ��� ����
		sb.display();
		*/
		
		//Class.forName(String className) : ���ڿ��� ǥ���� ��Ű���� ������
		//Ŭ������ ���޹޾� ClassLoader ���α׷��� �̿��Ͽ� �޸𸮿� �����ϴ� �޼ҵ�
		// => �޸𸮿� ����� Ŭ���� ����(Class �ν��Ͻ� - Clazz) ��ȯ
		// => ClassNotFoundException �߻� - ����ó��
		//Class.newInstance() : �޸𸮿� ����� Ŭ����(Clazz)�� �����ڸ� 
		//�̿��Ͽ� �ν��Ͻ��� �����ϴ� �޼ҵ�
		// => Object Ÿ���� �ν��Ͻ� ��ȯ - ����� ��ü ����ȯ
		// => InstantiationException�� IllegalAccessException �߻� - ����ó��
		//���÷���(Reflection) : Ŭ������ ���� �޸𸮿� �����Ͽ� �ν��Ͻ��� �����ϴ� ���
		/*
		try {
			StaticBlock sb=(StaticBlock)Class.forName
					("site.itwill.jdbc.StaticBlock").newInstance();
			sb.display();
		} catch (ClassNotFoundException e) {
			System.out.println("[����]Ŭ������ �������� �ʽ��ϴ�.");
		} catch (Exception e) {
			System.out.println("[����]���� ���α׷��� ������ �߻� �Ͽ����ϴ�.");
		} 
		*/
		
		try {
			Class.forName("site.itwill.jdbc.StaticBlock");
		} catch (ClassNotFoundException e) {
			System.out.println("[����]Ŭ������ �������� �ʽ��ϴ�.");
		}
	}
}






