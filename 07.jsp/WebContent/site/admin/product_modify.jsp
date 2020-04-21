<%@page import="site.itwill.dao.ProductDAO"%>
<%@page import="site.itwill.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 검색하여
입력태그에 출력하여 클라이언트에게 전달하기 위한 JSP 문서 --%>
<%-- [제품변경]을 클릭한 경우 제품정보 변경 처리페이지(product_modify_action.jsp) 요청 --%>    
<%@include file="/site/security/admin_check.jspf"%>
<%
	//전달값(제품번호)을 반환받아 저장
	int	 productNum=Integer.parseInt(request.getParameter("productNum"));

	//제품번호를 전달하여 PRODUCT 테이블에 저장된 해당 제품정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	ProductDTO product=ProductDAO.getDAO().selectNumProduct(productNum);
%>
<style type="text/css">
#product {
	width: 800px;
	margin: 0 auto;
}

table {
	margin: 0 auto;
}

td {
	text-align: left;
}
</style>
    
<div id="product">
	<h2>제품변경</h2>
	<%-- 파일을 입력받아 전달하기 위해 method 속성과 enctype 속성 설정 --%>
	<form action="<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=product_modify_action"
		method="post" enctype="multipart/form-data" id="productForm">
	<input type="hidden" name="productNum" value="<%=product.getProductNum()%>">
	<%-- 제품이미지를 변경하지 않을 경우 기존 제품이미지 사용을 위해 전달하거나
	제품이미지를 변경할 경우 기존 제품이미지 파일을 제거하기 위해 전달 --%>	
	<input type="hidden" name="currentMainImage" value="<%=product.getMainImage()%>">	
	<table>
		<tr>
			<td>제품코드</td>
			<td>
				<select name="category">
					<option value="CPU" <% if(product.getProductCode().split("_")[0].equals("CPU")) { %> selected <% } %>>중앙처리장치(CPU)</option>
					<option value="MAINBOARD" <% if(product.getProductCode().split("_")[0].equals("MAINBOARD")) { %> selected <% } %>>메인보드(MAINBOARD)</option>
					<option value="MEMORY" <% if(product.getProductCode().split("_")[0].equals("MEMORY")) { %> selected <% } %>>메모리(MEMORY)</option>
				</select>&nbsp;
				<input type="text" name="productCode" id="productCode" value="<%=product.getProductCode().split("_")[1]%>">
			</td>
		</tr>	
		<tr>
			<td>제품이름</td>
			<td>
				<input type="text" name="productName" id="productName" value="<%=product.getProductName()%>">
			</td>
		</tr>
		<tr>
			<td>제품이미지</td>
			<td>
				<img src="<%=request.getContextPath()%>/site/product_images/<%=product.getMainImage()%>" width="200"><br>
				<input type="file" name="mainImage" id="mainImage">
			</td>
		</tr>
		<tr>
			<td>제품상세설명</td>
			<td>
				<textarea rows="7" cols="50" name="productDetail" 
				id="productDetail"><%=product.getProductDetail()%></textarea>
			</td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td>
				<input type="text" name="productQty" id="productQty" value="<%=product.getProductQty()%>">
			</td>
		</tr>
		<tr>
			<td>제품가격</td>
			<td>
				<input type="text" name="productPrice" id="productPrice" value="<%=product.getProductPrice()%>">
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button type="submit">제품변경</button>
			</td>
		</tr>
	</table>		
	</form>
	
	<div id="message" style="color: red;"></div>
</div>

<script type="text/javascript">
$("#productForm").submit(function() {
	if($("#productCode").val()=="") {
		$("#message").text("제품코드를 입력해 주세요.");
		$("#productCode").focus();
		return false;
	}
	
	if($("#productName").val()=="") {
		$("#message").text("제품이름을 입력해 주세요.");
		$("#productName").focus();
		return false;
	}
	
	if($("#productDetail").val()=="") {
		$("#message").text("제품상세설명을 입력해 주세요.");
		$("#productDetail").focus();
		return false;
	}
	
	if($("#productQty").val()=="") {
		$("#message").text("제품수량을 입력해 주세요.");
		$("#productQty").focus();
		return false;
	}
	
	if($("#productPrice").val()=="") {
		$("#message").text("제품가격을 입력해 주세요.");
		$("#productPrice").focus();
		return false;
	}
});
</script>