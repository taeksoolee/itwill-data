package site.itwill.dao;

public class BusinessOneApp {
	public static void main(String[] args) {
		/*
		System.out.println("### ������ ������ �����ϴ� ��� ###");
		System.out.println("@@@ ������ ������ �˻��ϴ� ��� @@@");
		*/
		
		/*
		FileDAO fileDAO=new FileDAO();
		fileDAO.add();
		fileDAO.search();
		*/
		
		/*
		MysqlDAO mysqlDAO=new MysqlDAO();
		mysqlDAO.insert();
		mysqlDAO.select();
		*/
		
		//FileDAO fileDAO=new FileDAO();
		
		//�������̽��� ���������� �����Ͽ� �ڽ� �ν��Ͻ� ����
		// => �ڽ� �ν��Ͻ��� ����� ��쿡�� ���� ����
		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		//DAO dao=new OracleDAO();
		
		DAO dao=DAOFactory.getDAO();
		
		//�������̽��� �̿��Ͽ� �ڽ� �ν��Ͻ��� �������̵� �޼ҵ� ȣ��
		// => �������̽��� �̿��Ͽ� ���յ��� ���ߴ� ��� - ���������� ȿ���� ����
		dao.add();
		dao.search();
	}
}








