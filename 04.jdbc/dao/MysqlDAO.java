package site.itwill.dao;

public class MysqlDAO implements DAO {
	/*
	public void insert() {
		System.out.println("### Mysql ���α׷��� �̿��� ������ �����ϴ� ��� ###");
	}
	
	public void update() {
		System.out.println("--- Mysql ���α׷��� �̿��� ������ �����ϴ� ��� ---");
	}
	
	public void delete() {
		System.out.println("+++ Mysql ���α׷��� �̿��� ������ �����ϴ� ��� +++");
	}
	
	public void select() {
		System.out.println("*** Mysql ���α׷��� �̿��� ������ �˻��ϴ� ��� ***");
	}
	*/
	
	@Override
	public void add() {
		System.out.println("### Mysql ���α׷��� �̿��� ������ �����ϴ� ��� ###");
	}

	@Override
	public void modify() {
		System.out.println("--- Mysql ���α׷��� �̿��� ������ �����ϴ� ��� ---");
	}

	@Override
	public void remove() {
		System.out.println("+++ Mysql ���α׷��� �̿��� ������ �����ϴ� ��� +++");
	}

	@Override
	public void search() {
		System.out.println("*** Mysql ���α׷��� �̿��� ������ �˻��ϴ� ��� ***");
	}
}
