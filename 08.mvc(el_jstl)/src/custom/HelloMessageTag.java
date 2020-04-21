package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성이 있으며 태그 내용이 없는 태그 클래스
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//태그 속성값을 저장하기 위한 필드 : 태그 속성명과 동일한 이름으로 작성
	private String name;
	
	//초기화 작업 - 필드에 필요한 값 저장
	public HelloMessageTag() {
		//태그 속성에 대한 기본 초기값을 설정할 경우 작성
		// => 태그 속성이 필수인 경우 초기값 설정 생략 
		//name="홍길동";
	}
	
	public String getName() {
		return name;
	}

	//태그의 속성값을 매개변수로 제공받아 필드값이 변경하도록 자동 호출 
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("홍길동")) {
				pageContext.getOut().println("<h3>관리자님, 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"님, 안녕하세요.</h3>");
			}
		} catch (IOException e) {
			//브라우저에 예외 메세지를 전달할 경우 인위적 예외 발생
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	/*
	//doEndTag() 메소드를 오버라이드 선언하지 않을 경우 종료태그 사용시
	//부모클래스의 메소드 호출
	// => 부모클래스의 메소드와 동일한 경우 오버라이드 선언하지 않고 사용 
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	*/
}







