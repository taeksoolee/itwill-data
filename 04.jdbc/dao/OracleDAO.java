package site.itwill.dao;

public class OracleDAO implements DAO {
	@Override
	public void add() {
		System.out.println("### Oracle ���α׷��� �̿��� ������ �����ϴ� ��� ###");
	}

	@Override
	public void modify() {
		System.out.println("--- Oracle ���α׷��� �̿��� ������ �����ϴ� ��� ---");
	}

	@Override
	public void remove() {
		System.out.println("+++ Oracle ���α׷��� �̿��� ������ �����ϴ� ��� +++");
	}

	@Override
	public void search() {
		System.out.println("*** Oracle ���α׷��� �̿��� ������ �˻��ϴ� ��� ***");
	}
}
