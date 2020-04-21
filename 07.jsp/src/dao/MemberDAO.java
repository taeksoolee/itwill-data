package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.MemberDTO;

public class MemberDAO extends JdbcDAO {
	private static MemberDAO _dao;
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MemberDAO();		
	}
	
	public static MemberDAO getDAO() {
		return _dao;
	}
	
	//회원정보를 전달받아 MEMBER 테이블에 저장하고 저장행의 갯수를 반환하는 메소드
	// => 아이디,비밀번호,이름,이메일,전화번호,우편번호,기본주소,상세주소는 입력값을 이용하여 저장
	// => 회원가입날짜 : 현재, 마지막 로그인 날짜 : null, 회원상태 : 1(일반회원)
	public int insertMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into member values(?,?,?,?,?,?,?,?,sysdate,null,1)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getMobile());
			pstmt.setString(6, member.getZipcode());
			pstmt.setString(7, member.getAddress1());
			pstmt.setString(8, member.getAddress2());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//아이디를 전달받아 MEMBER 테이블에서 해당 아이디의 회원정보를 검색하여 반환하는 메소드 - 단일행 검색
	public MemberDTO selectIdMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO member=null;
		try {
			con=getConnection();
			
			String sql="select * from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member=new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectIdMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 해당 회원정보의 마지막
	//로그인 날짜를 현재로 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateLastLogin(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set last_login=sysdate where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateLastLogin() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//회원정보를 전달받아 MEMBER 테이블에 저장된 학생정보를 변경하고 
	//변경행의 갯수를 반환하는 메소드
	// => 비밀번호,이름,이메일,전화번호,우편번호,기본주소,상세주소 변경
	public int updateMember(MemberDTO member) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set passwd=?,name=?,email=?,mobile=?,zipcode=?,address1=?,address2=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getMobile());
			pstmt.setString(5, member.getZipcode());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getId());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 회원정보를 삭제하고 
	//삭제행의 갯수를 반환하는 메소드
	public int deleteMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//MEMBER 테이블에 저장된 회원목록을 검색하여 반환하는 메소드
	public List<MemberDTO> selectAllMember() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MemberDTO> memberList=new ArrayList<MemberDTO>();
		try {
			con=getConnection();
			
			String sql="select * from member order by id";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member=new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setJoinDate(rs.getString("join_date"));
				member.setLastLogin(rs.getString("last_login"));
				member.setStatus(rs.getInt("status"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllMember() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return memberList;
	}
	
	//아이디와 상태를 전달받아 MEMBER 테이블에 저장된 해당 회원의 상태를 
	//변경하고 변경행의 갯수를 반환하는 메소드
	public int updateStatus(String id, int status) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update member set status=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setString(2, id);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStatus() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
}












