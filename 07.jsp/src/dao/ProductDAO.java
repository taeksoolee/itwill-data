package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.ProductDTO;

public class ProductDAO extends JdbcDAO {
	private static ProductDAO _dao;
	
	private ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ProductDAO();		
	}
	
	public static ProductDAO getDAO() {
		return _dao;
	}
	
	//제품정보를 전달받아 PRODUCT 테이블에 저장하고 저장행의 갯수를 반환하는 메소드
	public int insertProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into product values(product_seq.nextval,?,?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getMainImage());
			pstmt.setString(4, product.getProductDetail());
			pstmt.setInt(5, product.getProductQty());
			pstmt.setInt(6, product.getProductPrice());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//제품정보를 전달받아 PRODUCT 테이블에 저장된 제품정보를 변경하고 
	//변경행의 갯수를 반환하는 메소드
	public int updateProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update product set product_code=?,product_name=?"
					+ ",main_image=?,product_detail=?,product_qty=?"
					+ ",product_price=? where product_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getMainImage());
			pstmt.setString(4, product.getProductDetail());
			pstmt.setInt(5, product.getProductQty());
			pstmt.setInt(6, product.getProductPrice());
			pstmt.setInt(7, product.getProductNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//제품번호를 전달받아 PRODUCT 테이블에 저장된 제품정보를 삭제하고 
	//삭제행의 갯수를 반환하는 메소드
	public int deleteProduct(int productNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from product where product_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, productNum);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//제품코드를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 검색하여 반환하는 메소드
	public ProductDTO selectCodeProduct(String productCode) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductDTO product=null;
		try {
			con=getConnection();
			
			String sql="select * from product where product_code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, productCode);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				product=new ProductDTO();
				product.setProductNum(rs.getInt("product_num"));
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setMainImage(rs.getString("main_image"));
				product.setProductDetail(rs.getString("product_detail"));
				product.setProductQty(rs.getInt("product_qty"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setAddDate(rs.getString("add_date"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectCodeProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return product;
	}
	
	//제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 검색하여 반환하는 메소드
	public ProductDTO selectNumProduct(int productNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductDTO product=null;
		try {
			con=getConnection();
			
			String sql="select * from product where product_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, productNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				product=new ProductDTO();
				product.setProductNum(rs.getInt("product_num"));
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setMainImage(rs.getString("main_image"));
				product.setProductDetail(rs.getString("product_detail"));
				product.setProductQty(rs.getInt("product_qty"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setAddDate(rs.getString("add_date"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNumProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return product;
	}
	
	//카테고리를 전달받아 PRODUCT 테이블에 저장된 해당 카테고리의 제품목록을 검색하여 반환하는 메소드
	public List<ProductDTO> selectCategoryProduct(String category) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductDTO> productList=new ArrayList<ProductDTO>();
		try {
			con=getConnection();
			
			if(category.equals("ALL")) {
				String sql="select * from product order by product_code";
				pstmt=con.prepareStatement(sql);
			} else {
				String sql="select * from product where product_code like ?||'%' order by product_code";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, category);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product=new ProductDTO();
				product.setProductNum(rs.getInt("product_num"));
				product.setProductCode(rs.getString("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setMainImage(rs.getString("main_image"));
				product.setProductDetail(rs.getString("product_detail"));
				product.setProductQty(rs.getInt("product_qty"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setAddDate(rs.getString("add_date"));
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectCategoryProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return productList;
	}
}











