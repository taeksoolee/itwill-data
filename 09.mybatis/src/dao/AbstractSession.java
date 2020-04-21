package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory 인스턴스를 생성하여 반환하는 기능을 구현한 클래스
// => Mapper 파일을 사용하는 DAO 클래스가 상속받아 사용하는 클래스
// => 상속을 목적으로 하는 클래스이므로 추상클래스로 선언하는 것을 권장
public abstract class AbstractSession {
	//SqlSessionFactory 인스턴스를 저장하기 위한 필드
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
	
	//필드에 저장된 SqlSessionFactory 인스턴스를 반환하는 메소드
	protected SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}








