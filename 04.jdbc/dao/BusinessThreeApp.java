package site.itwill.dao;

public class BusinessThreeApp {
	public static void main(String[] args) {
		/*
		System.out.println("+++ ������ ������ �����ϴ� ��� +++");
		System.out.println("@@@ ������ ������ �˻��ϴ� ��� @@@");
		*/
		
		/*
		FileDAO fileDAO=new FileDAO();
		fileDAO.remove();
		fileDAO.search();
		*/

		/*
		MysqlDAO mysqlDAO=new MysqlDAO();
		mysqlDAO.delete();
		mysqlDAO.select();
		*/

		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		//DAO dao=new OracleDAO();
		
		DAO dao=DAOFactory.getDAO();

		dao.remove();
		dao.search();
	}
}






