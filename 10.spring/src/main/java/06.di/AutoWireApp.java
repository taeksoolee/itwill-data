package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("05-3_autowire.xml");
		System.out.println("========================================================================");
		StudentService service=context.getBean("studentService", StudentService.class);
		service.addStudent(null);
		System.out.println("========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
