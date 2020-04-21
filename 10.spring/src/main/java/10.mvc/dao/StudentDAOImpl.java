package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAO Ŭ���� : DBMS ������ SQL ����� �����Ͽ� �����ϰ� ����� ����� 
//��ȯ�ϴ� ����� �޼ҵ尡 �����ϴ� Ŭ����
//@Repository : DAO ���� Ŭ������ Spring Bean���� ����ϴ� ������̼�
@Repository
public class StudentDAOImpl implements StudentDAO {
	//SqlSession ���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ����
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
	
}
