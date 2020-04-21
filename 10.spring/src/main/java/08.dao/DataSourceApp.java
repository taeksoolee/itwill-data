package site.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("===============================================================================");
		DataSource apacheDataSource=context.getBean("apacheDataSource", DataSource.class);
		Connection apacheConnection=apacheDataSource.getConnection();
		System.out.println("Apache Connection = "+apacheConnection);
		apacheConnection.close();
		System.out.println("===============================================================================");
		DataSource springDataSource=context.getBean("springDataSource", DataSource.class);
		Connection springConnection=springDataSource.getConnection();
		System.out.println("Spring Connection = "+springConnection);
		springConnection.close();
		System.out.println("===============================================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}





