package realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
		
		/*
		//�ý��ۿ� ���� Ŭ���� ����� ���α׷� ��κ� ���� 
		// => Ŭ�������� ���յ� ���� ���������� ȿ���� ����. 
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.erase();
		oracle.search();
		*/
		
		//�������̽��� �̿��Ͽ� Ŭ������ �ۼ��� ��� �ý��� ���濡 ����
		//Ŭ���� ����� ���α׷��� ���� �ణ ����
		// => Ŭ�������� ���յ� ���� ���������� ȿ���� ���� 
		//�������̽��� ���������� �����Ͽ� �ڽ� �ν��Ͻ� ����
		// => ���������� ����� �ڽ� �ν��Ͻ� �����ϸ� �ٸ� Ŭ������ �޼ҵ� ȣ�� 
		//Jdbc jdbc=new JdbcMysql();
		Jdbc jdbc=new JdbcOracle();
		
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}



