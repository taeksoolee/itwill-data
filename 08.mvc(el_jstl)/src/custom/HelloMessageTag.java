package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� �Ӽ��� ������ �±� ������ ���� �±� Ŭ����
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//�±� �Ӽ����� �����ϱ� ���� �ʵ� : �±� �Ӽ���� ������ �̸����� �ۼ�
	private String name;
	
	//�ʱ�ȭ �۾� - �ʵ忡 �ʿ��� �� ����
	public HelloMessageTag() {
		//�±� �Ӽ��� ���� �⺻ �ʱⰪ�� ������ ��� �ۼ�
		// => �±� �Ӽ��� �ʼ��� ��� �ʱⰪ ���� ���� 
		//name="ȫ�浿";
	}
	
	public String getName() {
		return name;
	}

	//�±��� �Ӽ����� �Ű������� �����޾� �ʵ尪�� �����ϵ��� �ڵ� ȣ�� 
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("ȫ�浿")) {
				pageContext.getOut().println("<h3>�����ڴ�, �ȳ��ϼ���.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"��, �ȳ��ϼ���.</h3>");
			}
		} catch (IOException e) {
			//�������� ���� �޼����� ������ ��� ������ ���� �߻�
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	/*
	//doEndTag() �޼ҵ带 �������̵� �������� ���� ��� �����±� ����
	//�θ�Ŭ������ �޼ҵ� ȣ��
	// => �θ�Ŭ������ �޼ҵ�� ������ ��� �������̵� �������� �ʰ� ��� 
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	*/
}







