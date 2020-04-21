package site.itwill.dto;

/*
�̸�             ��?       ����            
-------------- -------- ------------- 
PRODUCT_NUM    NOT NULL NUMBER(4)       - ��ǰ��ȣ(PK)
PRODUCT_CODE            VARCHAR2(20)    - ��ǰ�ڵ�
PRODUCT_NAME            VARCHAR2(50)    - ��ǰ�̸�
MAIN_IMAGE              VARCHAR2(30)    - �����̹���(���ϸ�)
PRODUCT_DETAIL          VARCHAR2(300)   - ������
PRODUCT_QTY             NUMBER(8)       - ��� 
PRODUCT_PRICE           NUMBER(8)       - ����
ADD_DATE                DATE            - ��ϳ�¥
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










