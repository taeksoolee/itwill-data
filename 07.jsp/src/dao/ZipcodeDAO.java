package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.ZipcodeDTO;

public class ZipcodeDAO extends JdbcDAO {
	private static ZipcodeDAO _dao;
	
	private ZipcodeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ZipcodeDAO();
	}
	
	public static ZipcodeDAO getDAO() {
		return _dao;
	}
	
	//동이름을 전달받아 ZIPCODE 테이블에 저장된 행을 검색하여 반환하는 메소드
	// => 전달받은 동이름으로 시작되는 컬럼값의 모든 행 검색
	public List<ZipcodeDTO> selectZipcode(String dong) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ZipcodeDTO> zipcodeList=new ArrayList<ZipcodeDTO>();
		try {
			con=getConnection();
			
			String sql="select * from zipcode where dong like ?||'%' order by zipcode";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dong);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeDTO zipcode=new ZipcodeDTO();
				zipcode.setZipcode(rs.getString("zipcode"));
				zipcode.setDong(rs.getString("dong"));
				zipcode.setAddress(rs.getString("address"));
				zipcodeList.add(zipcode);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectZipcode() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return zipcodeList;
	}
}










