package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.StudentDAO;
import site.itwill10.dto.Student;

//Service 클래스 : DAO 클래스의 메소드를 호출하여 어플리케이션에서 필요한
//기능을 제공하기 위한 메소드가 선언된 클래스
//@Service : Service 관련 클래스를 Spring Bean으로 등록하는 어노테이션
@Service
public class StudentServiceImple implements StudentService {
	//DAO 클래스 관련 Spring Bean을 인젝션 처리하여 필드에 저장
	// => 필드의 자료형을 인터페이스로 선언하여 모든 자식클래스의 인스턴스가 인젝션 되도록 설정
	//인터페이스를 상속받은 자식클래스의 Spring Bean이 여러 개인 경우 
	//@Qualifier 어노테이션을 사용하여 원하는 Spring Bean이 인젝션 되도록 설정
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
