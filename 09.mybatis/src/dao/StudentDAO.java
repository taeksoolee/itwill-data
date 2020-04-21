package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.itwill.dto.StudentDTO;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	//SqlSessionFactory : SqlSession �ν��Ͻ��� �����Ͽ� �����ϱ� ���� �ν��Ͻ�
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			//Mybatis ȯ�漳�� ������ �б� ���� �Է½�Ʈ�� �����Ͽ� ����
			//Resources.getResourceAsStream(String resource) : ������(XML)
			//������ �б� ���� �Է½�Ʈ���� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		//SqlSessionFactoryBuilder.build(InputStream inputStream) : ȯ�漳��
		//������ �����Ͽ� SqlSessionFactory �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => SqlSession �ν��Ͻ��� �̿��Ͽ� SQL ��� ���� ���� 
	public List<StudentDTO> selectAllStudent() {
		//SqlSessionFactory.openSession() : SqlSession �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//SqlSession : Mapper ���Ͽ� ��ϵ� SQL ����� ���� �����ϰ� ����� �ڵ����� �����Ͽ� ��ȯ�ϴ� �ν��Ͻ�
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.selectList(String elementId) : Mapper ���Ͽ��� SELECT ����� 
			//���� ���� �����ϰ� �˻������ �����Ͽ� List �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
			return sqlSession.selectList("site.itwill.mapper.StudentMapper.selectAllStudent");
		} finally {
			//sqlSession.close() : SqlSession �ν��Ͻ��� �����ϴ� �޼ҵ�
			sqlSession.close();
		}
	}
	
}






