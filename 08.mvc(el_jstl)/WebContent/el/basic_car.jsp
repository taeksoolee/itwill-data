<%@page import="site.itwill.el.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//객체속성으로 Car 인스턴스 저장
	pageContext.setAttribute("car", new Car("싼타페","하얀색"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//객체속성으로 저장된 Car 인스턴스를 반환받아 저장
		Car car=(Car)pageContext.getAttribute("car");
		
		//속성명으로 저장된 인스턴스가 없는 경우 null이 반환되어 저장
		// => 참조변수에 null이 저장된 경우 메소드 호출시 NullPointerExeption 발생 
		//Car car=(Car)pageContext.getAttribute("pageCar");
	
		//Car 인스턴스의 필드값을 반환받아 저장
		String name=car.getName();
		String color=car.getColor();
	%>
	<p>자동차 = <%=car %></p>
	<p>자동차 이름 = <%=name %></p>
	<p>자동차 색상 = <%=color %></p>
	<hr>
	<h2>EL 사용</h2>
	<p>자동차 = ${car}</p>
	<%-- ${속성명.필드명} 형식으로 저장 인스턴스의 필드값을 반환받아 출력 --%>
	<%-- => 필드명은 getter 메소드를 호출하기 위한 이름 --%>
	<%-- => 필드에 대한 getter 메소드가 없는 경우 에러 발생 --%>
	<p>자동차 이름 = ${car.name}</p>
	<p>자동차 색상 = ${car.color}</p>
	<%-- 속성명으로 저장된 인스턴스가 없는 경우 미출력 => NullPointerException 미발생 --%>
	<p>자동차 색상 = ${pageCar.color}</p>
</body>
</html>
