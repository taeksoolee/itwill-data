package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.StudentDAO;
import site.itwill10.dto.Student;

//Service Ŭ���� : DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� ���ø����̼ǿ��� �ʿ���
//����� �����ϱ� ���� �޼ҵ尡 ����� Ŭ����
//@Service : Service ���� Ŭ������ Spring Bean���� ����ϴ� ������̼�
@Service
public class StudentServiceImple implements StudentService {
	//DAO Ŭ���� ���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ����
	// => �ʵ��� �ڷ����� �������̽��� �����Ͽ� ��� �ڽ�Ŭ������ �ν��Ͻ��� ������ �ǵ��� ����
	//�������̽��� ��ӹ��� �ڽ�Ŭ������ Spring Bean�� ���� ���� ��� 
	//@Qualifier ������̼��� ����Ͽ� ���ϴ� Spring Bean�� ������ �ǵ��� ����
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
