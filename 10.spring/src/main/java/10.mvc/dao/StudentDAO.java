package site.itwill10.dao;

import java.util.List;

import site.itwill10.dto.Student;

public interface StudentDAO {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}
