package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentAopApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-1_aop.xml");
		System.out.println("===============================================================================");
		StudentService service=context.getBean("studentService", StudentService.class);
		service.addStudent(null);
		System.out.println("===============================================================================");
		service.getStudent(0);
		System.out.println("===============================================================================");
		service.getStudentList();
		System.out.println("===============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
