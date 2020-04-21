package site.itwill05.di;

import java.util.List;

//Service Ŭ���� : ���α׷� �ۼ��� �ʿ��� ����� �����ϱ� ���� Ŭ���� - ���
// => DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� �ʿ��� ����� �����ϴ� �޼ҵ� �ۼ�
// => Service Ŭ������ ����Ǿ ���α׷��� ������ �ּ�ȭ �ϱ� ���� �������̽� ��ӹ޾� �ۼ�
public class StudentServiceImpl implements StudentService {
	//�ʵ尪���� StudentJdbcDAO �ν��Ͻ��� �����Ͽ� ���԰��� ����
	// => ������ �Ǵ� Setter �޼ҵ带 �̿��Ͽ� �ν��Ͻ� ����
	//private StudentJdbcDAO studentJdbcDAO;
	//private StudentMybatisDAO studentMybatisDAO;

	/*
	//�ʵ��� Ŭ������ ����� ��� �����ڿ� ��� �޼ҵ� ����
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO studentJdbcDAO) {
		super();
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentJdbcDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) �޼ҵ� ȣ�� ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentJdbcDAO.insertStudent(student);
	}



	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentJdbcDAO.selectStudentList();
	}
    */

	//�θ� �������̽��� �̿��Ͽ� �����ʵ� �����ϸ� ��� �ڽ� �ν��Ͻ� ����
	// => �ڽ� �ν��Ͻ��� ����� ��� Ŭ������ ��ġ�� ���� �ּ�ȭ
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) �޼ҵ� ȣ�� ***");
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}
