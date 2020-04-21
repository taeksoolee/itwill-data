package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�Է�������(form.html)���� ���޵� �Է°��� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ����
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//�Է��������κ��� ���� �Է¹޾� POST ������� ��û�Ͽ� ó���Ǵ� ����
		// => ������ GET ������� ��û�� ��� ���������� ��û
		// => ���������� ��û�� ���� ó�� - �����ڵ� �����ϰų� ���� ������ �̵�
		//HttpServletRequest.getMethod() : Ŭ���̾�Ʈ�� ��û����� ��ȯ�ϴ� �޼ҵ�
		if(request.getMethod().equals("GET")) {//Ŭ���̾�Ʈ�� GET ������� ��û�� ���
			/*
			//HttpServletResponse.sendError(int statusCode) : Ŭ���̾�Ʈ����
			//�����ڵ�(�����ڵ�)�� �����ϴ� �޼ҵ�
			// => �����ڵ�� HttpServletResponse �������̽��� ����ʵ�(Constant Field)�� �̿��ϴ� ���� ����
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
			return;
			*/
			
			//HttpServletResponse.sendRedirect(String url) : Ŭ���̾�Ʈ����
			//�����ڵ� 301�� URL �ּҸ� �����ϴ� �޼ҵ� 
			// => 301 �ڵ� : ������ URL �ּҷ� ��û�ϴ� �����ڵ�
			// => Java(Servlet)�� �̿��� ������ �̵�(�����̷�Ʈ �̵�)
			// => ���ؽ�Ʈ�� �����ϴ� �ڿ����θ� �̵� ����
			response.sendRedirect("error.html");
			return;
		}
		
		//POST ������� ��û�Ͽ� ���޵� �Է°��� ���� ĳ���ͼ�(���ڵ�) ����
		// => ������Ʈ �޼����� �⺻ ĳ���ͼ� : ISO-8859-1(��������)
		//HttpServletRequest.setCharacterEncoding(String encoding) : 
		//������Ʈ �޼����� ĳ���ͼ¸� �����ϴ� �޼ҵ�
		request.setCharacterEncoding("utf-8");
		
		//�Է��������� �Է°��� ��ȯ�޾� ����
		//HttpServletRequest.getParameter(String name) : �Է°��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		// => �Է��±��� name �Ӽ����� �Ű������� �����Ͽ� ���ϴ� �Է°� ��ȯ
		// => name �Ӽ����� ���� ��� null ��ȯ 
		// => �Է°��� ���� ��� NullString ��ȯ 
		String id=request.getParameter("id");
		//System.out.println("id = "+id);
		
		//��ȯ���� �Է°��� ���� �۾� - ���������� ��û�� ���� ó��
		if(id==null || id.equals("")) {//�Է°��� �������� �ʴ� ���
			response.sendRedirect("error.html");
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {
			response.sendRedirect("error.html");
			return;
		}
		
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		//name �Ӽ����� ���� �Է°��� ó�� �Է°��� ��ȯ�Ͽ� ����
		//String hobby=request.getParameter("hobby");
		//HttpServletRequest.getParameterValues(String name) : name 
		//�Ӽ����� ���� �Է°����� ���ڿ� �迭�� ��ȯ�ϴ� �޼ҵ�
		// => �Է°��� checkbox �������� �Էµ� ��� ����ϴ� �޼ҵ�
		String[] hobby=request.getParameterValues("hobby");
		String profile=request.getParameter("profile");
	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ȸ������ Ȯ��</h1>");
		out.println("<hr>");
		out.println("<ul>");
		out.println("<li>���̵� = "+id+"</li>");
		out.println("<li>��й�ȣ = "+pass+"</li>");
		out.println("<li>�̸� = "+name+"</li>");
		out.println("<li>�ּ� = "+addr+"</li>");
		out.println("<li>���� = "+sex+"</li>");
		out.println("<li>���� = "+job+"</li>");
		//out.println("<li>��� = "+hobby+"</li>");
		if(hobby==null) {
			out.println("<li>��� = ������ ��̰� �ϳ��� �����ϴ�.</li>");
		} else {
			out.println("<li>��� = ");
			for(int i=0;i<hobby.length;i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {//������ �迭 ��Ұ��� �ƴ� ��� 
					out.println(", ");
				}
			}
			out.println("</li>");
		}
		
		out.println("<li>�ڱ�Ұ�<br>"+profile.replace("\n", "<br>")+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}





