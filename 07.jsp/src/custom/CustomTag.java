package site.itwill.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//JSP 문서에서 사용될 태그를 클래스로 구현 - 태그 클래스
// => TagSupport 클래스를 상속받아 작성
public class CustomTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println("<h3>커스텀 태그 사용</h3>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
