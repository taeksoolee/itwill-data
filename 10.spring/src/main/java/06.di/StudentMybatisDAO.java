package site.itwill05.di;

import java.util.List;

public class StudentMybatisDAO implements StudentDAO {
	public StudentMybatisDAO() {
		System.out.println("### StudentMybatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentMybatisDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentMybatisDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentMybatisDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}

}
