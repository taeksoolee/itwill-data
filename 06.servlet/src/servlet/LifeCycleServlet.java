package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//������ Ŭ���̾�Ʈ ��û�� ���� WAS �����̳ʰ� ���� Ŭ������ �ν��Ͻ���
//�ڵ� �����ϰ� �޼ҵ带 ȣ���Ͽ� ó���� ���� ��� ����
// => �����̳�(Container) : �ν��Ͻ��� �����ֱ�(LifeCycle)�� ����(����,���,�Ҹ�)�ϴ� ���α׷�
// => ���� Ŭ������ �ν��Ͻ��� �̹� ������ ��� �ν��Ͻ��� �������� �ʰ� ����
// => WAS ����� �����̳��� ���� ������ ��� ���� �ν��Ͻ��� �ڵ� �Ҹ�
@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	
	//������(Constructor) : �ν��Ͻ��� �����ϴ� Ư���� �޼ҵ�
	// => ���� �ν��Ͻ��� ������ �� �ѹ��� ȣ�� : �ʱ�ȭ �۾�(�ʵ� �ʱⰪ �ο�)
	public LifeCycleServlet() {
		System.out.println("### LifeCycleServlet Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	//init() : ���� �ν��Ͻ� ���� �� ���� ���� �ѹ��� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => ������ ��� �ʱ�ȭ �۾�(�ʵ� �ʱⰪ �ο�)
	//init() �޼ҵ带 �̿��Ͽ� �ʱ�ȭ �۾��� �ϴ� ������ ServletConfig �ν��Ͻ��� �����޾� ���
	// => ServletConfig : ȯ�漳�����Ͽ��� �����ϴ� ���� ����� �� �ִ� �ν��Ͻ�
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet Ŭ������ init() �޼ҵ� ȣ�� ###");
		//ServletConfig.getServletContext() : Ŭ���̾�Ʈ�� ��û�� ���ؽ�Ʈ��
		//����(ServletContext �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		//ServletContext.getInitParameter(String paramName) : [web.xml]���Ͽ���
		//�����ϴ� ��(context-param)�� ��ȯ�ϴ� �޼ҵ�
		name=config.getServletContext().getInitParameter("name");
	}
	
	//service() : Ŭ���̾�Ʈ ��û���� �����̳ʿ� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	//=> Ŭ���̾�Ʈ ��û�� ���� ó�� �� ��� ����(����)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet Ŭ������ service() �޼ҵ� ȣ�� ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� �����ֱ�</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"�� ȯ���մϴ�.</p>");
		out.println("<img src='image.itwill' width='300'>");
		out.println("</body>");
		out.println("</html>");
	}

	//destroy() : ���� �ν��Ͻ� �Ҹ� �� �ѹ��� �ڵ� ȣ��Ǵ� �޼ҵ� - ������ �۾�
	@Override
	public void destroy() {
		System.out.println("### LifeCycleServlet Ŭ������ destroy() �޼ҵ� ȣ�� ###");
	}
}
