package site.itwill09.mvc;

//뷰페이지를 제공하는 기능의 클래스
public class ViewResolver {
	//문자열을 전달받아 응답할 뷰페이지(JSP 문서)로 변환하여 반환하는 메소드 
	// => "/WEB-INF" 디렉토리에 JSP 문서를 작성하여 클라이언트의 요청 거부
	public String getViewPage(String view) {
		return "/WEB-INF/mvc/"+view+".jsp";
	}
}
