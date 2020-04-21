package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//���� ���ε��Ͽ� Ŭ���̾�Ʈ���� ���������� �����ϴ� ����
//���� ���ε�(Session Binding) : ������ �������� ����� �� �ֵ��� �����ϴ� �۾�
// => Ŭ���̾�Ʈ���� JSESSIONID ��Ű�� �������� ���� ��� ���� ���� �� ���ε�
// => Ŭ���̾�Ʈ���� JSESSIONID ��Ű�� �������� ��� ���� Ʈ��ŷ �� ���ε�
//���� Ʈ��ŷ(Session Tracking) : �������� JSESSIONID ��Ű���� ������ ���̵� ���ϴ� �۾�
@WebServlet("/session.itwill")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//HttpServletRequest.getSession() : ���� ���ε� ó���� Session �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => Session �ν��Ͻ��� �����ϰų� ���� Session �ν��Ͻ��� ���ε��Ͽ� ��ȯ
		//HttpSession : ���� ���Ӽ��� �����ϱ� ���� ������ �����ϱ� ���� �ν��Ͻ�
		HttpSession session=request.getSession();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>����(Session)</h1>");
		out.println("<hr>");
		//HttpSession.isNew() : ������ Ʈ��ŷ�Ǿ� ���ε��� ��� false, ����
		//�Ǿ� ���ε��� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(session.isNew()) {
			out.println("<p>������ �����Ͽ� ���ε� �Ǿ����ϴ�.</p>");
			
			Cookie cookie=new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(60*60);//1�ð� ����
			response.addCookie(cookie);
		} else {
			out.println("<p>������ Ʈ��ŷ�Ͽ� ���ε� �Ǿ����ϴ�.</p>");
		}
		
		//HttpSession.getId() : ������ �������� ��ȯ�ϴ� �޼ҵ�
		out.println("<p>���� ���̵� = "+session.getId()+"</p>");
		//HttpSession.getCreationTime() : ������ ������ �ð�(TimeStamp)�� ��ȯ�ϴ� �޼ҵ�
		out.println("<p>���� �����ð� = "+session.getCreationTime()+"</p>");
		//HttpSession.getMaxInactiveInterval() : ���� �����ð�(��)�� ��ȯ�ϴ� �޼ҵ�
		out.println("<p>���� �����ð� = "+session.getMaxInactiveInterval()+"</p>");

		//HttpSession.setAttribute(String name, Object value) : Session 
		//�ν��Ͻ��� �̿��Ͽ� �Ӽ���� �ν��Ͻ��� �����Ͽ� ����
		// => �ٸ� �����ø����̼ǿ��� �Ӽ������� �ν��Ͻ��� �����Ͽ� ���� 
		session.setAttribute("now", new Date());
		
		//HttpSession.getAttribute(String name) : Session �ν��Ͻ��� ����
		//�Ǿ� ������ �ν��Ͻ��� �Ӽ������� ��ȯ�ϴ� �޼ҵ�
		// => �ٸ� �����ø����̼ǿ��� ������ �ν��Ͻ��� ��ȯ�޾� ���
		// => Object Ÿ������ �ν��Ͻ��� ��ȯ�ϹǷ� ��ü ����ȯ �� ���
		// => �Ӽ����� �����ϱ� ���� ��� null ��ȯ
		Date now=(Date)session.getAttribute("now");
		
		out.println("<p>������ ���� �ν��Ͻ� = "+now+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}








