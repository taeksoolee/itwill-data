package site.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ�� : �ٽɰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ����
public class StudentDAOImpl implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl Ŭ������ insertStudent(Student student) �޼ҵ� ȣ��");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudent(int num) �޼ҵ� ȣ��");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ��");
		return null;
	}

}
