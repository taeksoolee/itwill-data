package site.itwill.dao;

//Factory Ŭ���� : �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ尡 ����� Ŭ����
public class DAOFactory {
	public static DAO getDAO() {
		//DAO dao=new FileDAO();
		//DAO dao=new MysqlDAO();
		DAO dao=new OracleDAO();
		
		return dao;
	}
}
