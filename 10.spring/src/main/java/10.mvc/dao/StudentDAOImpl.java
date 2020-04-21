package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAO 클래스 : DBMS 서버에 SQL 명령을 전달하여 실행하고 실행된 결과를 
//반환하는 기능의 메소드가 선언하는 클래스
//@Repository : DAO 관련 클래스를 Spring Bean으로 등록하는 어노테이션
@Repository
public class StudentDAOImpl implements StudentDAO {
	//SqlSession 관련 Spring Bean을 인젝션 처리하여 필드에 저장
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
