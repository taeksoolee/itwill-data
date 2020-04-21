package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����(������ ����Ǵ� ���α׷�) �ۼ� ���
//1.HttpServlet Ŭ������ ��ӹ޾� �ۼ� - ���� Ŭ����
// => HttpServlet Ŭ������ ��ӹ��� �ڽ�Ŭ������ ��ü����ȭ Ŭ������ 
//    serialVersionUID �ʵ带 �����ϴ� ���� ����
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//2.doGet() �Ǵ� doPost() �޼ҵ带 �������̵� ����
	// => Ŭ���̾�Ʈ ��û�� ���� ó���� ������ ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	// => doGet() : Ŭ���̾�Ʈ�� GET ������� ��û�� ��� ȣ��
	// => doPost() : Ŭ���̾�Ʈ�� POST ������� ��û�� ��� ȣ��
	// => doGet() �Ǵ� doPost() �޼ҵ� ��� service() �޼ҵ� �������̵� ����
	// => service() �޼ҵ尡 doGet() �Ǵ� doPost() �޼ҵ庸�� ȣ�� �켱������ ����.
	//WAS(Web Application Server)�� ���� �޼ҵ尡 ȣ��� �� HttpServletRequest �ν��Ͻ���
	//HttpServletResponse �ν��Ͻ��� �Ű������� �ڵ����� �����Ͽ� ����
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest �ν��Ͻ� : ������Ʈ �޼���(��û����)�� �����ϴ� �ν��Ͻ�
		//HttpServletResponse �ν��Ͻ� : �������� �޼���(��������)�� �����ϴ� �ν��Ͻ�
		
		//3.Ŭ���̾�Ʈ���� ������ ����(����) ����(MimeType) ����
		// => ���� �������� ������ ��� ������ ĳ���ͼ�(Character Encoding) ����
		// => �⺻ ���� ���� ���� : text/html, ĳ���ͼ� : ISO-8859-1(��������)
		//����)HttpServletResponse.setContentType(String MimeType[;charset=Encoding])
		// => ���� ���� ������ �����ϴ� �޼ҵ�
		response.setContentType("text/html;charset=UTF-8");
		
		//4.Ŭ���̾�Ʈ���� ��û�� ���� ���� ����� ����(����)�ϱ� ����
		//��½�Ʈ���� ��ȯ�޾� ����
		//����)HttpServletResponse.getOutputStream() : ���õ���Ÿ(1Byte)��
		//������ �� �ִ� ��½�Ʈ��(ServletOutputStream)�� ��ȯ�ϴ� �޼ҵ�
		// => �׸�,����,������ ���ϵ��� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��½�Ʈ��
		//����)HttpServletResponse.getWriter() : �ؽ�Ʈ����Ÿ(2Byte)�� 
		//������ �� �ִ� ��½�Ʈ��(PrintWriter)�� ��ȯ�ϴ� �޼ҵ�
		// => HTML,XML,Text ���ϵ��� Ŭ���̾�Ʈ���� �����ϱ� ���� ����ϴ� ��½�Ʈ��
		PrintWriter out=response.getWriter();
		
		//5.�Է°��� ���޹޾� ó��(JDBC) �� ����� Ŭ���̾�Ʈ���� ����(����)
		// => ��½�Ʈ���� �޼ҵ带 ȣ���Ͽ� ����� Ŭ���̾�Ʈ���� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>����(Servlet)</h1>");
		out.println("<hr>");
		out.println("<p>Hello, Servlet!!!</p>");
		out.println("</body>");
		out.println("</html>");
		
		//6.[web.xml]���Ͽ��� ���� Ŭ������ �������� ����ϰ� URL �ּҷ�
		//���� �����ؾ߸� Ŭ���̾�Ʈ�� ��û�� �޾� �����Ͽ� ���� ����
	}
}



