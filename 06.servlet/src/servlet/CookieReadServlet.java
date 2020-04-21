package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ���� ������ ��Ű�� �о� Ŭ���̾�Ʈ���� �����ϴ� ����
// => Ŭ���̾�Ʈ�� ������ ��û�� �� �������� ������ ��Ű�� ������ ���� 
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
	
		//Ŭ���̾�Ʈ�� ������ ��Ű���� ��ȯ�޾� ����
		//HttpServletRequest.getCookies() : Ŭ���̾�Ʈ�� ������ ��Ű���� ��ȯ�ϴ� �޼ҵ�
		// => Cookie �ν��Ͻ� �迭 ��ȯ
		Cookie[] cookies=request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>��Ű �б�� ���</h1>");
		out.println("<hr>");
		if(cookies==null) {
			out.println("<p>�� �ȿ� ��Ű ����.</p>");
		} else {
			String id="";
			String count="";
			
			//���ϴ� ��Ű���� ��ȯ�޾� ����
			for(Cookie cookie:cookies) {
				//Cookie.getName() : Cookie �ν��Ͻ��� ��Ű���� ��ȯ�ϴ� �޼ҵ�
				if(cookie.getName().equals("id")) {
					//Cookie.getValue() : Cookie �ν��Ͻ��� ��Ű���� ��ȯ�ϴ� �޼ҵ�
					id=cookie.getValue();
				} else if(cookie.getName().equals("count")) {
					count=cookie.getValue();
				}
			}
			
			//Ŭ���̾�Ʈ���� ��Ű�� ����(���)
			if(!id.equals("")) {
				out.println("<p>���̵� = "+id+"</p>");
			}
			
			if(!count.equals("")) {
				int cnt=Integer.parseInt(count)+1;
				out.println("<p>��ûȽ�� = "+cnt+"</p>");
				
				//Ŭ���̾�Ʈ���� Cookie �ν��Ͻ� ����
				// => ��Ű���� ���� ��� ���� ��Ű ������
				Cookie cookie=new Cookie("count", cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
		}
		
		out.println("<hr>");
		out.println("<p><a href='create.itwill'>��Ű ����</a></p>");
		out.println("<p><a href='remove.itwill'>��Ű ����</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}







