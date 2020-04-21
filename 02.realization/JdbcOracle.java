package realization;

//Oralce DBMS�� �����Ͽ� CRUD ����� �����ϱ� ���� Ŭ����
public class JdbcOracle implements Jdbc {
	/*
	public void add() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	public void modify() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	public void erase() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	public void search() {
		System.out.println("[Oracle]�л������� �˻� �Ͽ����ϴ�.");
	}
	*/

	@Override
	public void insert() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void update() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void delete() {
		System.out.println("[Oracle]�л������� ���� �Ͽ����ϴ�.");
	}
	
	@Override
	public void select() {
		System.out.println("[Oracle]�л������� �˻� �Ͽ����ϴ�.");
	}
}
