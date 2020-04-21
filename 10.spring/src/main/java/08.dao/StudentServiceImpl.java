package site.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	//Bean Configuration File���� StudentDAO ���� Spring Bean�� �ʵ忡 ������ ó�� - DI
	// => ������ ó���� StudentDAO �������̽��� �ڽ� Ŭ���� �޼ҵ� ȣ��
	// => �ʵ��� �ڷ����� �������̽��� �����ϸ� �����ǵ� DAO Ŭ������ Spring Bean�� ����Ǿ �ҽ� �̺���
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
