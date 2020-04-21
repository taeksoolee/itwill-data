<%@page import="java.io.File"%>
<%@page import="site.itwill.dao.ProductDAO"%>
<%@page import="site.itwill.dto.ProductDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품정보를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 변경하고
제품상세 출력페이지(product_datail.jsp)로 이동하는 JSP 문서 --%>    
<%
	//비정상적인 요청에 대한 응답처리
	if(request.getMethod().equals("GET")) {
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=error&work=error400';");
		out.println("</script>");
		return;
	}

	//입력파일이 저장되기 위한 디렉토리의 실제 경로를 반환받아 저장
	String saveDirectory=request.getServletContext().getRealPath("/site/product_images");
	
	//MultiPartRequest 인스턴스 생성
	// => 입력파일이 서버 디렉토리에 자동 업로드 처리
	MultipartRequest mr=new MultipartRequest(request, saveDirectory
		, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//입력값을 반환받아 저장
	int productNum=Integer.parseInt(mr.getParameter("productNum"));
	String currentMainImage=mr.getParameter("currentMainImage");

	String productCode=mr.getParameter("category")+"_"+mr.getParameter("productCode");
	String productName=mr.getParameter("productName");
	String mainImage=mr.getFilesystemName("mainImage");
	String productDetail=mr.getParameter("productDetail");
	int productQty=Integer.parseInt(mr.getParameter("productQty"));
	int productPrice=Integer.parseInt(mr.getParameter("productPrice"));
	
	//DTO 인스턴스 생성 후 입력값으로 필드값 변경
	ProductDTO product=new ProductDTO();
	product.setProductNum(productNum);
	product.setProductCode(productCode);
	product.setProductName(productName);
	if(mainImage!=null) {//제품이미지를 변경한 경우
		product.setMainImage(mainImage);
		//기존 제품이미지 파일 삭제
		new File(saveDirectory,currentMainImage).delete();
	} else {//제품이미지를 변경하지 않은 경우
		product.setMainImage(currentMainImage);
	}
	product.setProductDetail(productDetail);
	product.setProductQty(productQty);
	product.setProductPrice(productPrice);
	
	//제품정보를 전달하여 PRODUCT 테이블에 저장된 해당 제품정보를 변경하는
	//DAO 클래스의 메소드 호출
	ProductDAO.getDAO().updateProduct(product);
	
	//제품상세 출력페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=product_detail&productNum="+productNum+"';");
	out.println("</script>");
%>