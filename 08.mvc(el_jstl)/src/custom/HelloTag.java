package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//Ŀ���� �±�(Custom Tag) : JSP �������� ����ϱ� ���� �����ڰ� ���� �±� 
// => �±� ���� ����� ����� ����� �޼ҵ� �ʿ� - �±� Ŭ���� �ۼ�
//�±� Ŭ���� : JSP �������� Ŀ���� �±� ���� ȣ��� �޼ҵ带 ������ Ŭ����
// => TagSupport, BodyTagSupport, SimpleTagSupport Ŭ���� �� �ϳ��� ��ӹ޾� �ۼ�
// => ��ӹ��� �θ�Ŭ������ �޼ҵ带 �������̵� �����Ͽ� ����� ��� �ۼ�

//�±� �Ӽ��� �±� ������ ���� �±� Ŭ����
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP �������� Ŀ���� �±׸� ����� ��� �±� Ŭ������ �ν��Ͻ��� �ڵ� ���� 
	public HelloTag() {
		//System.out.println("[����]HelloTag Ŭ������ �⺻ ������ ȣ��");
	}
	
	//JSP �������� Ŀ���� �±��� �����±� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doStartTag() �޼ҵ� ȣ��");
		try {
			//�θ�Ŭ�������� �����Ǵ� pageContext �ν��Ͻ��� �̿��Ͽ� ���࿡
			//�ʿ��� �ν��Ͻ��� �����޾� �ۼ�
			pageContext.getOut().println("<div>�ȳ��ϼ���.</div>");
		} catch (IOException e) {
			//�����ڿ��� �ܼ� �޼����� �̿��Ͽ� ���� �޼��� ���
			e.printStackTrace();
		}
		//doStartTag() �޼ҵ��� ��ȯ�� : SKIP_BODY, EVAL_BODY_INCLUDE ��
		// => SKIP_BODY : �±� ������ �������� �ʴ� ����� ��ȯ��
		// => EVAL_BODY_INCLUDE : �±� ������ ������ ����� ��ȯ��(�±� ���� ����) - �⺻
		return SKIP_BODY;
	}
	
	//JSP �������� Ŀ���� �±��� �����±� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doEndTag() �޼ҵ� ȣ��");

		//doEndTag() �޼ҵ��� ��ȯ�� : SKIP_PAGE, EVAL_PAGE ��
		// => SKIP_PAGE : �����±� ��� �� JSP ������ ������ ������ ����� ��ȯ��
		// => EVAL_PAGE : �����±� ��� �� JSP ������ ��� ������ ��� ��ȯ�� - �⺻
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
}
