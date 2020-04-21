package site.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : Service 클래스를 Spring Bean으로 등록하기 위한 어노테이션
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Resource : Spring Bean의 자동 Injection(DI) 기능을 제공하기 위한 어노테이션
	// => JDK 라이브러리에서 제공되는 어노테이션 - 특정 Framework 종속되지 않는 어노테이션
	//@Resource
	
	//@Autowired : Spring Bean의 자동 Injection(DI) 기능을 제공하기 위한 어노테이션
	// => Spring 라이브러리에서 제공하는 어노테이션
	// => bean 엘리먼트의 autowire 속성의 "byType" 속성값과 같은 방법으로 인젝션 처리
	// => Setter 메소드를 선언하지 않아도 Setter Injection 가능
	//문제점)필드의 자료형이 인터페이스인 경우 자식클래스가 Spring Bean으로 여러개 등록되면 예외 발생
	//해결-1)자식클래스가 Spring Bean으로 여러개 등록된 경우 "byName" 속성값과 같은 방법으로 인젝션 처리
	// => 자식클래스 중 하나의 beanName를 필드명과 동일한 이름으로 변경
	//해결-2)@Qualifier 어노테이션을 이용하여 인젝션 처리할 Spring Bean 설정
	//@Qualifier : value 속성에 beanName를 지정하여 Spring Bean를 인젝션 처리하는 어노테이션
	// => @Autowired 어노테이션의 종속된 어노테이션
	@Autowired
	//@Qualifier("studentJdbcDAO")
	@Qualifier("studentMybatisDAO")
	private StudentDAO studentDAO;

	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}
