package site.itwill.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith : 테스트 클래스를 실행하기 위한 클래스(Clazz)를 설정하는 어노테이션
//SpringJUnit4ClassRunner : JUnit  기능을 이용하여 테스트 클래스를 실행하는 Runner 클래스 
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 테스트 클래스에서 사용하기 위한 Spring Bean을 등록하는
//Bean Configuration File을 설정하는 어노테이션
// => ApplicationContext 객체(Spring Container)를 이용하여 Spring Bean 관리
//locations 속성 : Bean Configuration File 경로를 배열 형식의 속성값으로 설정
// => Bean Configuration File 경로는 file 접두사를 사용하여 설정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	private static final Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
	//DataSource 관련 클래스의 Spring Bean를 제공받아 필드에 인젝션 처리
	@Autowired
	private DataSource dataSource;
	
	//@Test : 테스트 메소드를 설정하는 어노테이션
	// => Runner 클래스에 의해 호출되어 실행되는 메소드 설정
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+dataSource);
		logger.info("Connection = "+dataSource.getConnection());
	}
}