package site.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체를 대상으로 행정보의 저장,변경
//,삭제,검색 기능을 제공하기 위한 목적의 클래스 - CRUD 기능 제공
// => 저장매체 : 데이타를 행단위로 저장하기 위한 하드웨어 또는 소프트웨어
// => 인터페이스를 상속받아 작성하는 것을 권장
// => 싱글톤 클래스(프로그램이 인스턴스를 하나만 제공하는 클래스)로 작성하는 것을 권장

//STUDENT 테이블에 학생정보에 대한 저장,변경,삭제,검색 기능을 제공하기 위한 클래스
// => 메소드마다 Connection 인스턴스를 제공받기 위해 JdbcDAO 클래스를 상속받아 작성
public class StudentDAO extends JdbcDAO {
	//싱글톤 디자인 패턴이 적용된 클래스 작성 방법
	//1.클래스의 인스턴스를 저장하기 위한 참조필드 선언 - 시스템 필드
	private static StudentDAO _dao;
	
	//2.생성자 은닉화 선언 - 클래스 외부에서 생성자를 이용하여 인스턴스 생성 불가
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}

	//3.클래스가 로딩된 후 시스템 필드에 클래스의 인스턴스를 생성하여 저장
	static {
		_dao=new StudentDAO();
	}
	
	//4.시스템 필드에 저장된 클래스의 인스턴스를 반환하는 메소드 작성
	public static StudentDAO getStudentDAO() {
		/*
		//static 영역을 설정하지 않을 경우
		if(_dao==null) {
			_dao=new StudentDAO();
		}
		*/
		return _dao;
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 행을 저장하고 저장행의 갯수를 반환하는 메소드
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into student values(p,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학생정보를 전달받아 STUDENT 테이블의 저장행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번을 전달받아 STUDENT 테이블의 저장행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번을 전달받아 STUDENT 테이블의 저장행을 검색하여 학생정보로 반환하는 메소드
	// => 단일행 검색 : 검색된 행이 하나인 경우 - 값 또는 DTO 반환
	public StudentDTO selectNoStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		try {
			con=getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//검색행이 존재할 경우 DTO 인스턴스를 생성하고 컬럼값으로 필드값을 변경
			if(rs.next()) {
				student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNoStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return student;
	}
	
	//이름을 전달받아 STUDENT 테이블의 저장행을 검색하여 학생정보들로 반환하는 메소드
	// => 다중행 검색 : 검색된 행이 여러개인 경우 - List 반환
	public List<StudentDTO> selectNameStudent(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			//String sql="select * from student where name=? order by no";
			String sql="select * from student where name like '%'||?||'%' order by no";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 존재할 경우 반복 처리
			// => DTO 인스턴스를 생성하고 컬럼값으로 필드값을 변경
			// => DTO 인스턴스를 List 인스턴스의 요소로 추가
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
	
	//STUDENT 테이블의 모든 저장행을 검색하여 학생정보들로 반환하는 메소드
	public List<StudentDTO> selectAllStudent() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
}
