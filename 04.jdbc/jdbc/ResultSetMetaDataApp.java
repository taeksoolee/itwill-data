package site.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//ResultSetMetaData 인스턴스 : ResultSet 인스턴스에 저장된 검색결과에 대한
//부가적인 정보를 저장하는 인스턴스
public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		//String sql="select no,name,phone from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.getMetaData() : ResultSet 인스턴스에 저장된 검색결과에 대한 
		//부가적인 정보가 저장된 ResultSetMetaData 인스턴스를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCount() : 검색결과에 대한 컬럼 갯수를 반환하는 메소드
		int columnCount=rsmd.getColumnCount();
		System.out.println("검색결과에 대한 컬럼 갯수 = "+columnCount);
		System.out.println("==============================================");
		for(int i=1;i<=columnCount;i++) {
			//ResultSetMetaData.getColumnLabel(index columnIndex) : 
			//columnIndex 위치의 컬럼명을 반환하는 메소드
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ResultSetMetaData.isNullable(index columnIndex) : 
			//columnIndex 위치의 컬럼에 대한 NULL 허용 유무값(0 or 1)을 반환하는 메소드
			int isNull=rsmd.isNullable(i);
			String nullResult="NULL";
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			
			//ResultSetMetaData.getColumnTypeName(index columnIndex) : 
			//columnIndex 위치의 컬럼 자료형을 반환하는 메소드
			String columnTypeName=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(index columnIndex) : 
			//columnIndex 위치의 컬럼값에 출력크기를 반환하는 메소드
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼 라벨명 = "+columnLabel);
			System.out.println("NULL 허용 유무 = "+nullResult);
			System.out.println("컬럼 자료형 = "+columnTypeName);
			System.out.println("컬럼값 출력크기 = "+columnDisplaySize);
			System.out.println("==============================================");
		}
		
		ConnectionFactory.close(con, stmt, rs);
	}
}











