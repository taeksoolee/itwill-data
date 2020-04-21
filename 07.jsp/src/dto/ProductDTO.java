package site.itwill.dto;

/*
이름             널?       유형            
-------------- -------- ------------- 
PRODUCT_NUM    NOT NULL NUMBER(4)       - 제품번호(PK)
PRODUCT_CODE            VARCHAR2(20)    - 제품코드
PRODUCT_NAME            VARCHAR2(50)    - 제품이름
MAIN_IMAGE              VARCHAR2(30)    - 메인이미지(파일명)
PRODUCT_DETAIL          VARCHAR2(300)   - 상세정보
PRODUCT_QTY             NUMBER(8)       - 재고량 
PRODUCT_PRICE           NUMBER(8)       - 가격
ADD_DATE                DATE            - 등록날짜
*/

public class ProductDTO {
	private int productNum;
	private String productCode;
	private String productName;
	private String mainImage;
	private String productDetail;
	private int productQty;
	private int productPrice;
	private String addDate;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
}










