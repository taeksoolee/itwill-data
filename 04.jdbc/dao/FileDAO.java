package site.itwill.dao;

public class FileDAO implements DAO {
	@Override
	public void add() {
		System.out.println("### ������ ������ �����ϴ� ��� ###");
	}
	
	@Override
	public void modify() {
		System.out.println("--- ������ ������ �����ϴ� ��� ---");
	}
	
	@Override
	public void remove() {
		System.out.println("+++ ������ ������ �����ϴ� ��� +++");
	}
	
	@Override
	public void search() {
		System.out.println("*** ������ ������ �˻��ϴ� ��� ***");
	}
}
