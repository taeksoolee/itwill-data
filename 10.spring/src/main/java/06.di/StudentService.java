package site.itwill05.di;

import java.util.List;

//학생정보에 대한 Service 클래스가 반드시 상속받아야 되는 인터페이스
public interface StudentService {
	void addStudent(Student student);
	Student getStudent(int num);
	List<Student> getStudentList();
}
