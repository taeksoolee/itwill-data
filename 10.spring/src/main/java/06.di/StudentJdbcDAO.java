package site.itwill05.di;

import java.util.List;

//DAO 클래스 : 저장매체(DataSource - DBMS)에 정보의 삽입,변경,삭제,검색 기능을 제공하는 클래스
// => 저장매체의 종류 또는 방법에 따라 여러 개의 DAO 클래스 존재
// => DAO 클래스가 변경되어도 Service 클래스의 영향을 최소화 하기 위해 인터페이스 상속받아 작성
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 insertStudent(Student student) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudent(int num) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudentList() 메소드 호출 ***");
		return null;
	}
	
}
