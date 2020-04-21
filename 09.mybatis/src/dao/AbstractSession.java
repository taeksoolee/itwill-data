package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� ����� ������ Ŭ����
// => Mapper ������ ����ϴ� DAO Ŭ������ ��ӹ޾� ����ϴ� Ŭ����
// => ����� �������� �ϴ� Ŭ�����̹Ƿ� �߻�Ŭ������ �����ϴ� ���� ����
public abstract class AbstractSession {
	//SqlSessionFactory �ν��Ͻ��� �����ϱ� ���� �ʵ�
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//�ʵ忡 ����� SqlSessionFactory �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	protected SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}








