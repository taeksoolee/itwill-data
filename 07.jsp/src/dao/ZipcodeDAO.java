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
	
	//���̸��� ���޹޾� ZIPCODE ���̺� ����� ���� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޹��� ���̸����� ���۵Ǵ� �÷����� ��� �� �˻�
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
			System.out.println("[����]selectZipcode() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return zipcodeList;
	}
}










