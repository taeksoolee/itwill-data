package site.itwill10.mapper;

import java.util.List;

import site.itwill10.dto.Student;

public interface StudentMapper {
	int insertStudent(Student student);
	List<Student> selectStudentList();
}
