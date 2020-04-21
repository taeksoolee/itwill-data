<%@page import="java.util.ArrayList"%>
<%@page import="site.itwill.el.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Student> studentList=new ArrayList<Student>();
	studentList.add(new Student(1000,"홍길동"));
	studentList.add(new Student(2000,"임꺽정"));
	studentList.add(new Student(3000,"전우치"));
	studentList.add(new Student(4000,"일지매"));
	studentList.add(new Student(5000,"장길산"));
	
	request.setAttribute("studentList", studentList);
	
	request.getRequestDispatcher("student_list_el.jsp").forward(request, response);
%>





