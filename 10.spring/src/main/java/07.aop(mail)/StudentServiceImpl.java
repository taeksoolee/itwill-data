package site.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ�� : �ٽɰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ����
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
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ��");
		studentDAO.insertStudent(student);
		//throw new RuntimeException();//������ ���� �߻�
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ��");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ��");
		return studentDAO.selectStudentList();
	}

}
