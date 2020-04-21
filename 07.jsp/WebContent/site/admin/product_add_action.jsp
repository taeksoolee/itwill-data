<%@page import="java.io.File"%>
<%@page import="site.itwill.dao.ProductDAO"%>
<%@page import="site.itwill.dto.ProductDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 제품정보를 전달받아 PRODUCT 테이블에 저장하고 제품목록 출력페이지(product_manager.jsp) 요청 --%>
<%-- => 전달된 제품정보 중 제품이미지파일는 서버 디렉토리에 업로드 처리 --%>
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
	String productCode=mr.getParameter("category")+"_"+mr.getParameter("productCode");
	String productName=mr.getParameter("productName");
	String mainImage=mr.getFilesystemName("mainImage");
	String productDetail=mr.getParameter("productDetail");
	int productQty=Integer.parseInt(mr.getParameter("productQty"));
	int productPrice=Integer.parseInt(mr.getParameter("productPrice"));
	
	//DTO 인스턴스 생성 후 입력값으로 필드값 변경
	ProductDTO product=new ProductDTO();
	product.setProductCode(productCode);
	product.setProductName(productName);
	product.setMainImage(mainImage);
	product.setProductDetail(productDetail);
	product.setProductQty(productQty);
	product.setProductPrice(productPrice);

	//제품코드를 전달하여 PRODUCT 테이블에 저장된 해당 제품정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
	// => PRODUCT 테이블에 동일한 제품코드가 저장되는 것을 방지
	//입력된 제품코드가 이미 저장된 경우 제품등록 입력페이지로 이동
	if(ProductDAO.getDAO().selectCodeProduct(productCode)!=null) {
		//이미 업로드 처리된 파일 제거
		new File(saveDirectory,mainImage).delete();
		session.setAttribute("message", "이미 등록된 제품코드를 입력 하였습니다.");
		session.setAttribute("product", product);
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=product_add';");
		out.println("</script>");
		return;
	}
	
	//제품정보를 전달하여 PRODUCT 테이블에 저장하는 DAO 클래스의 메소드 호출
	ProductDAO.getDAO().insertProduct(product);
	
	//제품목록 출력페이지 이동
	out.println("<script type='text/javascript'>");
	out.println("location.href='"+request.getContextPath()+"/site/index.jsp?workgroup=admin&work=product_manager';");
	out.println("</script>");
%>
