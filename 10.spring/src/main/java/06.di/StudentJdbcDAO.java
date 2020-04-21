package site.itwill05.di;

import java.util.List;

//DAO Ŭ���� : �����ü(DataSource - DBMS)�� ������ ����,����,����,�˻� ����� �����ϴ� Ŭ����
// => �����ü�� ���� �Ǵ� ����� ���� ���� ���� DAO Ŭ���� ����
// => DAO Ŭ������ ����Ǿ Service Ŭ������ ������ �ּ�ȭ �ϱ� ���� �������̽� ��ӹ޾� �ۼ�
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
	
}
