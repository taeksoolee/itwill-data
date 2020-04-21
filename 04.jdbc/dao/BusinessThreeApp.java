package site.itwill.dao;

public class BusinessThreeApp {
	public static void main(String[] args) {
		/*
		System.out.println("+++ 파일의 정보를 삭제하는 기능 +++");
		System.out.println("@@@ 파일의 정보를 검색하는 기능 @@@");
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






