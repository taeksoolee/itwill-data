package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.GuestDTO;

public class GuestDAO extends JdbcDAO {
	private static GuestDAO _dao;
	
	private GuestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new GuestDAO();
	}
	
	public static GuestDAO getDAO() {
		return _dao;
	}

	//���� ������ ���޹޾� GUEST ���̺� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertGuest(GuestDTO guest) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into guest values(guest_seq.nextval,?,sysdate,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getTitle());
			pstmt.setString(3, guest.getContent());
			
			rows=pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("[����]insertGuest() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//���� �۹�ȣ�� ���޹޾� GUEST ���̺� ����� �۹�ȣ�� ���� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int deleteGuest(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from guest where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("[����]deleteGuest() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
		
	//GUEST ���̺� ����� ��� ���� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<GuestDTO> selectAllGuest() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<GuestDTO> guestList=new ArrayList<GuestDTO>();
		try {
			con=getConnection();
			
			String sql="select * from guest order by no desc";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDTO guest=new GuestDTO();
				guest.setNo(rs.getInt("no"));
				guest.setName(rs.getString("name"));
				guest.setRegdate(rs.getString("regdate"));
				guest.setTitle(rs.getString("title"));
				guest.setContent(rs.getString("content"));
				guestList.add(guest);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectAllGuest() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guestList;
	}
}





