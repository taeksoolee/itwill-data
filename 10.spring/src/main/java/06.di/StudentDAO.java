package site.itwill05.di;

import java.util.List;

//�л������� ���� DAO Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => �ν��Ͻ�(��ü)���� ���յ��� ���� ���������� ȿ������ �����ϱ� ���� ���� 
public interface StudentDAO {
	int insertStudent(Student student);
	Student selectStudent(int num);
	List<Student> selectStudentList();
}
