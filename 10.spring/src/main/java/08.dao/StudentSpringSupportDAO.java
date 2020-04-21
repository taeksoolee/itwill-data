package site.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//JdbcDaoSupport Ŭ������ ��ӹ޾� DAO Ŭ���� �ۼ�
// => JdbcTemplate �ν��Ͻ��� �����ϴ� �ʵ尡 ����� Ŭ����
// => getJdbcTemplate() �޼ҵ带 ȣ���Ͽ� JdbcTemplate �ν��Ͻ��� ��ȯ�޾� ���ø� �޼ҵ� ȣ��
public class StudentSpringSupportDAO extends JdbcDaoSupport implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?,?,?,?,?)";
		return getJdbcTemplate().update(sql, student.getNo(), student.getName()
			, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		return getJdbcTemplate().update(sql, student.getName(), student.getPhone()
			, student.getAddress(), student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return getJdbcTemplate().update("delete from student where no=?", no);
	}

	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			return getJdbcTemplate().queryForObject(sql, new Object[] {no}, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		String sql="select * from student order by no";
		return getJdbcTemplate().query(sql, new StudentRowMapper());
	}
	
	//RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ���� ����
	// => �˻����� �÷����� ��ȯ �ν��Ͻ��� �ʵ尪���� ���� ó��
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
