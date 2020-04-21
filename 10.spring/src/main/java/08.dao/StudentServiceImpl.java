package site.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	//Bean Configuration File에서 StudentDAO 관련 Spring Bean을 필드에 인젝션 처리 - DI
	// => 인젝션 처리된 StudentDAO 인터페이스의 자식 클래스 메소드 호출
	// => 필드의 자료형을 인터페이스로 선언하면 인젝션된 DAO 클래스의 Spring Bean이 변경되어도 소스 미변경
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}
}
