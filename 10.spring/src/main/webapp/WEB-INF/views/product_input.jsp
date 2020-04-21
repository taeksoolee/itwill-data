<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>제품등록</h1>
	<hr>
	<%-- 
	<form action="product" method="post">
	<table>
		<tr>
			<td>제품코드</td>
			<td><input type="text" name="code"></td>
		</tr>
		<tr>
			<td>제품이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td><input type="text" name="qty"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
	</form>
	--%>
	
	<form action="product" method="post">
	<table>
		<tr>
			<td colspan="2">제품정보-1</td>
		</tr>
		<tr>
			<td>제품코드</td>
			<td><input type="text" name="productList[0].code"></td>
		</tr>
		<tr>
			<td>제품이름</td>
			<td><input type="text" name="productList[0].name"></td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td><input type="text" name="productList[0].qty"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2">제품정보-2</td>
		</tr>
		<tr>
			<td>제품코드</td>
			<td><input type="text" name="productList[1].code"></td>
		</tr>
		<tr>
			<td>제품이름</td>
			<td><input type="text" name="productList[1].name"></td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td><input type="text" name="productList[1].qty"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2">제품정보-3</td>
		</tr>
		<tr>
			<td>제품코드</td>
			<td><input type="text" name="productList[2].code"></td>
		</tr>
		<tr>
			<td>제품이름</td>
			<td><input type="text" name="productList[2].name"></td>
		</tr>
		<tr>
			<td>제품수량</td>
			<td><input type="text" name="productList[2].qty"></td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
		
		<tr>
			<td colspan="2">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>	
	</form>
</body>
</html>










