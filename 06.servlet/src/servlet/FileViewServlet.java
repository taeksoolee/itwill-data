package site.itwill.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�Է�������(file_view.html)���� ���޵� �Է°��� �Է�����(����)�� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ����
@WebServlet("/view.itwill")
public class FileViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���������� ��û�� ���� ����ó��
		if(request.getMethod().equalsIgnoreCase("get")) {
			response.sendRedirect("error.html");
			return;
		}
		
		//�Է°��� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//�Է°�(�ø���)�� ��ȯ�޾� ����
		//form �±��� enctype �Ӽ����� "multipart/form-data"�� ������ ���
		//getParameter() �޼ҵ�� �Է°��� ��ȯ �Ұ���
		String name=request.getParameter("name");
		
		//Ŭ���̾�Ʈ���� �Է°��� �Է������� ������ ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�Է°��� �Է����� ���� Ȯ��</h1>");
		out.println("<hr>");
		out.println("<p>�ø��� = "+name+"</p>");
		out.println("<hr>");
		
		//�Է������� ������ �б� ���� �Է½�Ʈ���� ��ȯ�޾� ����
		//HttpServletRequest.getInputStream() : ������Ʈ �޼����� ������Ÿ��
		//���õ���Ÿ�� �������� �� �ִ� �Է½�Ʈ��(ServletInputStream)�� ��ȯ�ϴ� �޼ҵ�
		//HttpServletRequest.getReader() : ������Ʈ �޼����� ������Ÿ��
		//�ؽ�Ÿ����Ÿ�� �������� �� �ִ� �Է½�Ʈ��(BufferedReader)�� ��ȯ�ϴ� �޼ҵ�
		//ServletInputStream in=request.getInputStream();
		InputStreamReader in=new InputStreamReader(request.getInputStream(),"utf-8");
		
		//�Է������� ������ �о� Ŭ���̾�Ʈ���� ����
		// => form �±׷� �ԷµǾ� ���޵� ��(������Ÿ) ��ȯ
		out.println("<p>[�Է����ϳ���]</p>");
		out.println("<pre>");
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		out.println("</pre>");
		out.println("</body>");
		out.println("</html>");

	}
}





