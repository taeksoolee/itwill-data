package site.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("===============================================================================");
		StudentService service=context.getBean("studentService",StudentService.class);
		/*
		Student student=new Student();
		student.setNo(6000);
		student.setName("∑Œ∫Û» ");
		student.setPhone("010-6666-6666");
		student.setAddress("º≠øÔΩ√ µø¿€±∏");
		student.setBirthday("2000-05-05");
		service.addStudent(student);
		*/
		
		/*
		Student student=service.getStudent(6000);
		student.setBirthday("1999-12-31");
		service.modifyStudent(student);
		*/
		
		//service.removeStudent(6000);
		
		List<Student> studentList=service.getStudentList();
		for(Student stu:studentList) {
			System.out.println(stu.getNo()+", "+stu.getName()+", "+stu.getPhone()
				+", "+stu.getAddress()+", "+stu.getBirthday().substring(0, 10));
		}
		System.out.println("===============================================================================");
		((ClassPathXmlApplicationContext)context).close();		
	}
}



