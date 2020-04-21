package site.itwill.dao;

//Factory 클래스 : 인스턴스를 생성하여 반환하는 메소드가 선언된 클래스
public class DAOFactory {
	public static DAO getDAO() {
		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		DAO dao=new OracleDAO();
		
		return dao;
	}
}
