package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("========================================================================");
		Student student1=context.getBean("student1", Student.class);
		System.out.println(student1);
		System.out.println("========================================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2);
		System.out.println("========================================================================");
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3);
		System.out.println("========================================================================");
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("========================================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("========================================================================");
		/*
		StudentServiceImpl studentServiceImpl=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		//System.out.println(studentServiceImpl.getStudentJdbcDAO());
		
		studentServiceImpl.addStudent(null);
		studentServiceImpl.getStudent(0);
		studentServiceImpl.getStudentList();
		*/
		
		StudentService studentService=context.getBean("studentService", StudentService.class);
		
		studentService.addStudent(null);
		studentService.getStudent(0);
		studentService.getStudentList();
		System.out.println("========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
