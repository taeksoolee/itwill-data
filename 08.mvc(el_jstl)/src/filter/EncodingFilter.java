package site.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터(Filter) 클래스 : 클라이언트의 특정 요청에 대한 처리 전 요청정보를
//변경하거나 응답 전 응답정보를 변경하기 위한 클래스
// => Filter 인터페이스를 상속받아 작성

//클라이언트의 모든 요청에 대한 요청정보의 캐릭터셋을 변경하는 필터 클래스
// => @WebFilter 어노테이션을 이용하거나 web.xml 파일을 변경하여 필터 클래스가 동작되도록 설정
public class EncodingFilter implements Filter  {
	//변경할 캐릭터셋의 인코딩 정보를 저장하기 위한 필드
	private String encoding;
	
	//필터 클래스가 인스턴스로 생성된 후 가장 먼저 한번만 호출되는 메소드 - 초기화 작업 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding="UTF-8";
		
		//FilterConfig.getInitParameter(String name) : web.xml 파일의 제공값을 반환하는 메소드
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//클라이언트 특정 요청에 의해 반복 호출되는 메소드 - 요청정보 또는 응답정보 변경
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청정보 변경 - 캐릭터셋의 인코딩 정보 변경
		if(request.getCharacterEncoding()==null 
				|| !request.getCharacterEncoding().equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//클라이언트의 요청을 처리하기 위한 웹어플리케이션(Servlet OR JSP) 실행
		//FilterChain.doFilter(request, response) : 클라이언트의 요청을 
		//처리하는 웹어플리케이션을 실행하기 위한 메소드
		chain.doFilter(request, response);
		
		//응답정보 변경
		//response.setCharacterEncoding("UTF-8");
	}
}





