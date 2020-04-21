package site.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//����(Filter) Ŭ���� : Ŭ���̾�Ʈ�� Ư�� ��û�� ���� ó�� �� ��û������
//�����ϰų� ���� �� ���������� �����ϱ� ���� Ŭ����
// => Filter �������̽��� ��ӹ޾� �ۼ�

//Ŭ���̾�Ʈ�� ��� ��û�� ���� ��û������ ĳ���ͼ��� �����ϴ� ���� Ŭ����
// => @WebFilter ������̼��� �̿��ϰų� web.xml ������ �����Ͽ� ���� Ŭ������ ���۵ǵ��� ����
public class EncodingFilter implements Filter  {
	//������ ĳ���ͼ��� ���ڵ� ������ �����ϱ� ���� �ʵ�
	private String encoding;
	
	//���� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� �ѹ��� ȣ��Ǵ� �޼ҵ� - �ʱ�ȭ �۾� 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding="UTF-8";
		
		//FilterConfig.getInitParameter(String name) : web.xml ������ �������� ��ȯ�ϴ� �޼ҵ�
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//Ŭ���̾�Ʈ Ư�� ��û�� ���� �ݺ� ȣ��Ǵ� �޼ҵ� - ��û���� �Ǵ� �������� ����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��û���� ���� - ĳ���ͼ��� ���ڵ� ���� ����
		if(request.getCharacterEncoding()==null 
				|| !request.getCharacterEncoding().equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �����ø����̼�(Servlet OR JSP) ����
		//FilterChain.doFilter(request, response) : Ŭ���̾�Ʈ�� ��û�� 
		//ó���ϴ� �����ø����̼��� �����ϱ� ���� �޼ҵ�
		chain.doFilter(request, response);
		
		//�������� ����
		//response.setCharacterEncoding("UTF-8");
	}
}





