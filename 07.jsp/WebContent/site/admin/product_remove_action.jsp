<%@page import="java.io.File"%>
<%@page import="site.itwill.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 삭제하고
제품목록 출력페이지(product_manager.jsp)로 이동하는 JSP 문서 --%>
<%@include file="/site/security/admin_check.jspf"%>
<%
	//전달값(제품번호)을 반환받아 저장
	int	productNum=Integer.parseInt(request.getParameter("productNum"));

	//제품이미지 파일이 저장된 디렉토리의 실제 경로를 반환받아 저장	
	String saveDirectory=request.getServletContext().getRealPath("/site/product_images");
	//삭제하고자 하는 제품이미지 파일명을 반환받아 저장
	String mainImage=ProductDAO.getDAO().selectNumProduct(productNum).getMainImage();
	
	//제품번호를 전달하여 PRODUCT 테이블에 저장된 해당 제품정보를 삭제하는
	//DAO 클래스의 메소드 호출
	ProductDAO.getDAO().deleteProduct(productNum);
	
	//삭제할 제품의 이미지 파일 제거
	new File(saveDirectory, mainImage).delete();
	
	//제품목록 출력페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=product_manager';");
	out.println("</script>");
%>