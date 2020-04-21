package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => �⺻������ Ŭ�������� beanName���� ���������� value �Ӽ��� �̿��Ͽ� beanName ���� ����
//@Component("studentDAO")

//@Repository : DAO Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Repository("studentJdbcDAO")
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}

}
