package site.itwill07.aop;

import java.util.List;

public interface StudentService {
	void addStudent(Student student);
	Student getStudent(int num);
	List<Student> getStudentList();
}
