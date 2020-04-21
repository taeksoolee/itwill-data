<%@page import="site.itwill.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품정보를 입력받기 위한 JSP 문서 --%>
<%-- => [제품등록]을 클릭한 경우 제품등록 처리페이지(product_add_action.jsp) 요청 --%>
<%@include file="/site/security/admin_check.jspf"%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
	
	ProductDTO product=(ProductDTO)session.getAttribute("product");
	if(product!=null) {
		session.removeAttribute("product");
	}
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
	<h2>제품등록</h2>
	<%-- 파일을 입력받아 전달하기 위해 method 속성과 enctype 속성 설정 --%>
	<form action="<%=request.getContextPath()%>/site/index.jsp?workgroup=admin&work=product_add_action"
		method="post" enctype="multipart/form-data" id="productForm">
	<table>
		<tr>
			<td>제품코드</td>
			<td>
				<select name="category">
					<option value="CPU" selected>중앙처리장치(CPU)</option>
					<option value="MAINBOARD">메인보드(MAINBOARD)</option>
					<option value="MEMORY">메모리(MEMORY)</option>
				</select>&nbsp;
				<input type="text" name="productCode" id="productCode">
			</td>
		</tr>	
		<tr>
			<td>제품이름</td>
			<td>
				<input type="text" name="productName" id="productName" <% if(product!=null) { %>value="<%=product.getProductName()%>" <% } %>>
			</td>
		</tr>
		<tr>
			<td>제품이미지</td>
			<td>
				<input type="file" name="mainImage" id="mainImage">
			</td>
		</tr>
		<tr>
			<td>제품상세설명</td>
			<td>
				<textarea rows="7" cols="50" name="productDetail" 
				id="productDetail"><% if(product!=null) { %><%=product.getProductDetail()%><% } %></textarea>
			</td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td>
				<input type="text" name="productQty" id="productQty"<% if(product!=null) { %>value="<%=product.getProductQty()%>" <% } %>>
			</td>
		</tr>
		<tr>
			<td>제품가격</td>
			<td>
				<input type="text" name="productPrice" id="productPrice"<% if(product!=null) { %>value="<%=product.getProductPrice()%>" <% } %>>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<button type="submit">제품등록</button>
			</td>
		</tr>
	</table>		
	</form>
	
	<div id="message" style="color: red;"><%=message %></div>
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
	
	if($("#mainImage").val()=="") {
		$("#message").text("제픔이미지를 입력해 주세요.");
		$("#mainImage").focus();
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













