package site.itwill.dao;

public class BusinessTwoApp {
	public static void main(String[] args) {
		/*
		System.out.println("--- 파일의 정보를 변경하는 기능 ---");
		System.out.println("@@@ 파일의 정보를 검색하는 기능 @@@");
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




