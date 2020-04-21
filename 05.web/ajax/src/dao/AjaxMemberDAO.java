package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import site.itwill.dto.AjaxMemberDTO;

public class AjaxMemberDAO extends JdbcDAO {
	private static AjaxMemberDAO _dao;
	
	private AjaxMemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new AjaxMemberDAO();
	}
	
	public static AjaxMemberDAO getDAO() {
		return _dao;
	}
	
	//ȸ�������� ���޹޾� AJAX_MEMBER ���̺� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int insertAjaxMember(AjaxMemberDTO ajaxMember) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into ajax_member values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxMember.getId());
			pstmt.setString(2, ajaxMember.getPasswd());
			pstmt.setString(3, ajaxMember.getName());
			pstmt.setString(4, ajaxMember.getEmail());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]insertAjaxMember() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//���̵� ���޹޾� AJAX_MEMBER ���̺� ����� �ش� ���̵��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public AjaxMemberDTO selectAjaxMember(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AjaxMemberDTO ajaxMember=null;
		try {
			con=getConnection();
			
			String sql="select * from ajax_member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ajaxMember=new AjaxMemberDTO();
				ajaxMember.setId(rs.getString("id"));
				ajaxMember.setPasswd(rs.getString("passwd"));
				ajaxMember.setName(rs.getString("name"));
				ajaxMember.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			System.out.println("[����]selectAjaxMember() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return ajaxMember;
	}
	
	//�̸��� �̸����� ���޹޾� AJAX_MEMBER ���̺� ����� �ش� ȸ����
	//���̵� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	/*
	public String selectAjaxMemberId(String name, String email) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id=null;
		try {
			con=getConnection();
			
			String sql="select id from ajax_member where name=? and email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getString("id");
			}
		} catch (SQLException e) {
			System.out.println("[����]selectId() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return id;
	}
	*/
	
	public String selectAjaxMemberId(AjaxMemberDTO ajaxMember) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id=null;
		try {
			con=getConnection();
			
			String sql="select id from ajax_member where name=? and email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ajaxMember.getName());
			pstmt.setString(2, ajaxMember.getEmail());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id=rs.getString("id");
			}
		} catch (SQLException e) {
			System.out.println("[����]selectId() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return id;
	}
}










