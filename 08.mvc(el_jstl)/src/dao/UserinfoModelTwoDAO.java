package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.UserinfoDTO;

public class UserinfoModelTwoDAO extends JdbcDAO {
	private static UserinfoModelTwoDAO _dao;
	
	private UserinfoModelTwoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelTwoDAO();		
	}
	
	public static UserinfoModelTwoDAO getDAO() {
		return _dao;
	}
	
	public int insertUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into userinfo values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getUserid());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getEmail());
			pstmt.setInt(5, userinfo.getStatus());
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int updateUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update userinfo set password=?,name=?,email=? where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getPassword());
			pstmt.setString(2, userinfo.getName());
			pstmt.setString(3, userinfo.getEmail());
			pstmt.setString(4, userinfo.getUserid());
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int deleteUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public UserinfoDTO selectUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserinfoDTO userinfo=null;
		try {
			con=getConnection();
			
			String sql="select * from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
			}
		} finally {
			close(con, pstmt, rs);
		}
		return userinfo;
	}
	
	public List<UserinfoDTO> selectAllUserinfo() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserinfoDTO> userinfoList=new ArrayList<UserinfoDTO>();
		try {
			con=getConnection();
			
			String sql="select * from userinfo order by userid";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				UserinfoDTO userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setStatus(rs.getInt("status"));
				userinfoList.add(userinfo);
			}
		} finally {
			close(con, pstmt, rs);
		}
		return userinfoList;
	}
}
