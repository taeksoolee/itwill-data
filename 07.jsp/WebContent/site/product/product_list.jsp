<%@page import="java.text.DecimalFormat"%>
<%@page import="site.itwill.dao.ProductDAO"%>
<%@page import="site.itwill.dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- PRODUCT 테이블에 저장된 모든 제품정보를 검색하여 클라이언트에게 전달하는 JSP 문서 --%>
<%
	//PRODUCT 테이블에 저장된 모든 제품정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	List<ProductDTO> productList=ProductDAO.getDAO().selectCategoryProduct("ALL");
%>    
<style type="text/css">
#productList {
	width: 1000px;
	margin: 0 auto;
}

.product {
	padding: 10px 5px;
	border: 1px solid black;
	width: 300px;
	margin: 10px;
	text-align: center;
	float: left;
}
</style>

<div id="productList">
	<% for(ProductDTO product:productList) { %>
	<div class="product">
		<div><%=product.getProductName() %></div>
		<div>[<%=product.getProductCode() %>]</div>
		<div>
			<a href="#">
				<img src="<%=request.getContextPath()%>/site/product_images/<%=product.getMainImage()%>" width="250">
			</a>
		</div>
		<div>
			<%=DecimalFormat.getCurrencyInstance().format(product.getProductPrice()) %>
		</div>
	</div>
	<% } %>
</div>

<div style="clear: both;"></div>




