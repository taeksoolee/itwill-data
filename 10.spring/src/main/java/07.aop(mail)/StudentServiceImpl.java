package site.itwill07.aop;

import java.util.List;

//핵심관심모듈 : 핵심관심코드로 작성된 메소드가 선언된 클래스
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출");
		studentDAO.insertStudent(student);
		//throw new RuntimeException();//인위적 예외 발생
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출");
		return studentDAO.selectStudentList();
	}

}
