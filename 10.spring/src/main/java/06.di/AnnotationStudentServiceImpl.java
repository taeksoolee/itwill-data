package site.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : Service Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Resource : Spring Bean�� �ڵ� Injection(DI) ����� �����ϱ� ���� ������̼�
	// => JDK ���̺귯������ �����Ǵ� ������̼� - Ư�� Framework ���ӵ��� �ʴ� ������̼�
	//@Resource
	
	//@Autowired : Spring Bean�� �ڵ� Injection(DI) ����� �����ϱ� ���� ������̼�
	// => Spring ���̺귯������ �����ϴ� ������̼�
	// => bean ������Ʈ�� autowire �Ӽ��� "byType" �Ӽ����� ���� ������� ������ ó��
	// => Setter �޼ҵ带 �������� �ʾƵ� Setter Injection ����
	//������)�ʵ��� �ڷ����� �������̽��� ��� �ڽ�Ŭ������ Spring Bean���� ������ ��ϵǸ� ���� �߻�
	//�ذ�-1)�ڽ�Ŭ������ Spring Bean���� ������ ��ϵ� ��� "byName" �Ӽ����� ���� ������� ������ ó��
	// => �ڽ�Ŭ���� �� �ϳ��� beanName�� �ʵ��� ������ �̸����� ����
	//�ذ�-2)@Qualifier ������̼��� �̿��Ͽ� ������ ó���� Spring Bean ����
	//@Qualifier : value �Ӽ��� beanName�� �����Ͽ� Spring Bean�� ������ ó���ϴ� ������̼�
	// => @Autowired ������̼��� ���ӵ� ������̼�
	@Autowired
	//@Qualifier("studentJdbcDAO")
	@Qualifier("studentMybatisDAO")
	private StudentDAO studentDAO;

	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}
