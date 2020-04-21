package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.SuggestDTO;

public class SuggestDAO extends JdbcDAO {
	private static SuggestDAO _dao;
	
	private SuggestDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new SuggestDAO();
	}
	
	public static SuggestDAO getDAO() {
		return _dao;
	}
	
	//Ű���带 ���޹޾� SUGGEST ���̺��� Ű���尡 ���Ե� ���þ� ����  
	//������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<SuggestDTO> selectSuggestList(String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<SuggestDTO> suggestList=new ArrayList<SuggestDTO>();
		try {
			con=getConnection();
			
			String sql="select rownum, temp.* from (select * from suggest "
				+ "where upper(word) like '%'||upper(?)||'%' order by "
				+ "word) temp where rownum<=10";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SuggestDTO suggest=new SuggestDTO();
				suggest.setWord(rs.getString("word"));
				suggest.setAddress(rs.getString("address"));
				suggestList.add(suggest);
			}
		} catch (SQLException e) {
			System.out.println("[����]selectSuggestList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return suggestList;
	}
}
