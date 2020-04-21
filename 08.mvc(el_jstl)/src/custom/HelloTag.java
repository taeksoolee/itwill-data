package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//커스텀 태그(Custom Tag) : JSP 문서에서 사용하기 위해 개발자가 만든 태그 
// => 태그 사용시 실행될 명령이 선언된 메소드 필요 - 태그 클래스 작성
//태그 클래스 : JSP 문서에서 커스텀 태그 사용시 호출될 메소드를 선언한 클래스
// => TagSupport, BodyTagSupport, SimpleTagSupport 클래스 중 하나를 상속받아 작성
// => 상속받은 부모클래스의 메소드를 오버라이드 선언하여 실행될 명령 작성

//태그 속성과 태그 내용이 없는 태그 클래스
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP 문서에서 커스텀 태그를 사용할 경우 태그 클래스를 인스턴스로 자동 생성 
	public HelloTag() {
		//System.out.println("[정보]HelloTag 클래스의 기본 생성자 호출");
	}
	
	//JSP 문서에서 커스텀 태그의 시작태그 사용시 자동 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("[정보]HelloTag 클래스의 doStartTag() 메소드 호출");
		try {
			//부모클래스에서 제공되는 pageContext 인스턴스를 이용하여 실행에
			//필요한 인스턴스를 제공받아 작성
			pageContext.getOut().println("<div>안녕하세요.</div>");
		} catch (IOException e) {
			//개발자에서 콘솔 메세지를 이용하여 예외 메세지 출력
			e.printStackTrace();
		}
		//doStartTag() 메소드의 반환값 : SKIP_BODY, EVAL_BODY_INCLUDE 등
		// => SKIP_BODY : 태그 내용이 존재하지 않는 경우의 반환값
		// => EVAL_BODY_INCLUDE : 태그 내용이 존재할 경우의 반환값(태그 내용 포함) - 기본
		return SKIP_BODY;
	}
	
	//JSP 문서에서 커스텀 태그의 종료태그 사용시 자동 호출되는 메소드
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("[정보]HelloTag 클래스의 doEndTag() 메소드 호출");

		//doEndTag() 메소드의 반환값 : SKIP_PAGE, EVAL_PAGE 등
		// => SKIP_PAGE : 종료태그 사용 후 JSP 문서를 강제로 종료할 경우의 반환값
		// => EVAL_PAGE : 종료태그 사용 후 JSP 문서를 계속 실행할 경우 반환값 - 기본
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
}
