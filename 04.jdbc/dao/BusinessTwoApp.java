package site.itwill.dao;

public class BusinessTwoApp {
	public static void main(String[] args) {
		/*
		System.out.println("--- ������ ������ �����ϴ� ��� ---");
		System.out.println("@@@ ������ ������ �˻��ϴ� ��� @@@");
		*/
		
		/*
		FileDAO fileDAO=new FileDAO();
		fileDAO.modify();
		fileDAO.search();
		*/
		
		/*
		MysqlDAO mysqlDAO=new MysqlDAO();
		mysqlDAO.update();
		mysqlDAO.select();
		*/
		
		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		//DAO dao=new OracleDAO();
		
		DAO dao=DAOFactory.getDAO();
		
		dao.modify();
		dao.search();
	}
}




