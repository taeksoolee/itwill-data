package site.itwill05.di;

import java.util.List;

//Service 클래스 : 프로그램 작성에 필요한 기능을 제공하기 위한 클래스 - 모듈
// => DAO 클래스의 메소드를 호출하여 필요한 기능을 제공하는 메소드 작성
// => Service 클래스가 변경되어도 프로그램에 영향을 최소화 하기 위해 인터페이스 상속받아 작성
public class StudentServiceImpl implements StudentService {
	//필드값으로 StudentJdbcDAO 인스턴스를 저장하여 포함관계 설정
	// => 생성자 또는 Setter 메소드를 이용하여 인스턴스 저장
	//private StudentJdbcDAO studentJdbcDAO;
	//private StudentMybatisDAO studentMybatisDAO;

	/*
	//필드의 클래스가 변경될 경우 생성자와 모든 메소드 변경
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO studentJdbcDAO) {
		super();
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentJdbcDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) 메소드 호출 ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentJdbcDAO.insertStudent(student);
	}



	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentJdbcDAO.selectStudentList();
	}
    */

	//부모 인터페이스를 이용하여 참조필드 선언하면 모든 자식 인스턴스 저장
	// => 자식 인스턴스가 변경될 경우 클래스에 미치는 영향 최소화
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) 메소드 호출 ***");
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}
