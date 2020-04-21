package realization;

//Mysql DBMS�� �����Ͽ� CRUD ����� �����ϱ� ���� Ŭ����
public class JdbcMysql implements Jdbc {
	@Override
	public void insert() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void update() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void delete() {
		System.out.println("[Mysql]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void select() {
		System.out.println("[Mysql]�л������� �˻� �Ͽ����ϴ�.");
	}
}
