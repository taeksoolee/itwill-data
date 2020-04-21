package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesBeanApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context
			=new ClassPathXmlApplicationContext("04-4_beanProperties.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		PropertiesBean bean=(PropertiesBean)context.getBean("propertiesBean");
		System.out.println(bean);
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
