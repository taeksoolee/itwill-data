package site.itwill.dao;

public class BusinessOneApp {
	public static void main(String[] args) {
		/*
		System.out.println("### 파일의 정보를 저장하는 기능 ###");
		System.out.println("@@@ 파일의 정보를 검색하는 기능 @@@");
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
		
		//인터페이스로 참조변수를 생성하여 자식 인스턴스 저장
		// => 자식 인스턴스가 변경될 경우에도 저장 가능
		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		//DAO dao=new OracleDAO();
		
		DAO dao=DAOFactory.getDAO();
		
		//인터페이스를 이용하여 자식 인스턴스의 오버라이드 메소드 호출
		// => 인터페이스를 이용하여 결합도는 낮추는 방법 - 유지보수의 효율성 증가
		dao.add();
		dao.search();
	}
}








