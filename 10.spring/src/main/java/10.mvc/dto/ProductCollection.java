package site.itwill10.dto;

import java.util.List;

public class ProductCollection {
	//다수의 제품정보를 저장하기 위한 콜렉션 필드	
	private List<Product> productList;
	
	public ProductCollection() {
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
