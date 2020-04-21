package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.PhonebookDTO;

//DAO(Data Access Object) : 정보(행)에 대한 데이타 저장소의 저장,변경,삭제
//,검색 기능을 제공하기 위한 클래스

//PHONEBOOK 테이블의 행정보 삽입,변경,삭제,검색 기능을 메소드로 제공하는 클래스
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장
public class PhonebookDAO extends JdbcDAO {
	private static PhonebookDAO _dao;
	
	private PhonebookDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new PhonebookDAO();		
	}
	
	public static PhonebookDAO getDAO() {
		return _dao;
	}
	
	//PHONEBOOK 테이블에 저장된 모든 행을 검색하여 반환하는 메소드
	public List<PhonebookDTO> getPhonebookList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<PhonebookDTO> phonebookList=new ArrayList<PhonebookDTO>();
		try {
			con=getConnection();
			
			String sql="select * from phonebook order by name";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			//다수의 검색행을 DTO 인스턴스로 생성하여 List 인스턴스 추가
			while(rs.next()) {
				PhonebookDTO phonebook=new PhonebookDTO();
				phonebook.setPhone(rs.getString("phone"));
				phonebook.setName(rs.getString("name"));
				phonebook.setAddress(rs.getString("address"));
				phonebookList.add(phonebook);
			}
		} catch (SQLException e) {
			System.out.println("[에러]getPhonebookList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return phonebookList;
	}
}








