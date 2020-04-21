package site.itwill07.aop;

import java.util.List;

public interface StudentDAO {
	int insertStudent(Student student);
	Student selectStudent(int num);
	List<Student> selectStudentList(); 
}
