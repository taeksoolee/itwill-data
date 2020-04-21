package site.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//Spring Framework에서 제공하는 spring-jdbc 라이브러리를 이용하여 DAO 클래스 작성
// => JdbcTemplate 클래스의 템플릿 메소드를 호출하여 DAO 클래스의 메소드 작성
public class StudentSpringDAO implements StudentDAO {
	//Bean Configuration File에서 JdbcTemplate 클래스의 Spring Bean을 인젝션 처리
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql, Object ... args) : SQL 명령(INSERT, UPDATE, DELETE)을 전달하여 실행하는 메소드
		// => 매개변수에 SQL 명령과 InParameter에 저장될 값을 차례대로 전달하여 메소드 호출 
		// => SQL 명령의 실행결과(조작행의 갯수)를 정수값으로 반환
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
			, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone()
			, student.getAddress(), student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			//JdbcTemplate.queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) : SQL 명령(SELECT)을 전달하여 실행하는 메소드
			// => 단일행을 검색하여 결과값을 반환할 경우 사용하는 메소드
			// => SQL 명령과 InParameter에 전달될 값, 매핑정보를 매개변수로 전달하여 메소드 호출
			// => RowMapper 인스턴스를 이용하여 검색결과를 매핑 처리하여 반환 - 제네릭으로 반환될 결과의 자료형 설정
			/*
			return jdbcTemplate.queryForObject(sql, new Object[] {no}, new RowMapper<Student>() {
				//검색행의 컬럼값을 인스턴스 필드값으로 매핑하여 반환하는 메소드
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student=new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}				
			});
			*/

			return jdbcTemplate.queryForObject(sql, new Object[] {no}, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : 검색결과가 존재하지 않을 경우 발생되는 예외
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		String sql="select * from student order by no";
		//JdbcTemplate.query(String sql, Object[] args, RowMapper<T> rowMapper) : SQL 명령(SELECT)을 전달하여 실행하는 메소드
		// => 다중행을 검색하여 결과값을 List 인스턴스로 반환할 경우 사용하는 메소드
		/*
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				return student;
			}
		});
		*/
		
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	//RowMapper 인터페이스를 상속받은 자식클래스 선언
	// => 검색행의 컬럼값을 반환 인스턴스의 필드값으로 매핑 처리
	public class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student=new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}
	}
}



