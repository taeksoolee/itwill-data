package site.itwill.dao;

public class MysqlDAO implements DAO {
	/*
	public void insert() {
		System.out.println("### Mysql 프로그램을 이용해 정보를 저장하는 기능 ###");
	}
	
	public void update() {
		System.out.println("--- Mysql 프로그램을 이용해 정보를 변경하는 기능 ---");
	}
	
	public void delete() {
		System.out.println("+++ Mysql 프로그램을 이용해 정보를 삭제하는 기능 +++");
	}
	
	public void select() {
		System.out.println("*** Mysql 프로그램을 이용해 정보를 검색하는 기능 ***");
	}
	*/
	
	@Override
	public void add() {
		System.out.println("### Mysql 프로그램을 이용해 정보를 저장하는 기능 ###");
	}

	@Override
	public void modify() {
		System.out.println("--- Mysql 프로그램을 이용해 정보를 변경하는 기능 ---");
	}

	@Override
	public void remove() {
		System.out.println("+++ Mysql 프로그램을 이용해 정보를 삭제하는 기능 +++");
	}

	@Override
	public void search() {
		System.out.println("*** Mysql 프로그램을 이용해 정보를 검색하는 기능 ***");
	}
}
