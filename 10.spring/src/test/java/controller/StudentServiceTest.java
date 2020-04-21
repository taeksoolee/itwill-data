package site.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//�׽�Ʈ Ŭ���������� Service Ŭ������ �޼ҵ带 �˻��ϱ� ���� �������� �ۼ�
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebApplicationContext ��ü(Spring Container)�� 
//�̿��Ͽ� Spring Bean �����ϵ��� �����ϴ� ������̼�
@WebAppConfiguration 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentServiceTest.class);
	
	@Autowired
	private StudentService studentService;
	
	/*
	@Test
	public void testAddStudent() {
		Student student=new Student();
		student.setNo(8000);
		student.setName("ȫ�浿");
		student.setPhone("010-8888-8888");
		student.setAddress("��õ�� ���̱�");
		student.setBirthday("1999-04-09");
		studentService.addStudent(student);
		logger.info("�л����� �߰� ���� ��� ���� ����");
	}
	*/
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		for(Student student:studentList) {
			/*
			logger.info(student.getNo()+", "+student.getName()
				+", "+student.getPhone()+", "+student.getAddress()
				+", "+student.getBirthday().substring(0, 10));
			*/
			logger.info(student.toString());
		}
	}
}










