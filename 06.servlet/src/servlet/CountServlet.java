package site.itwill.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� ���� ��ûȽ���� Ŭ���̾�Ʈ���� �����ϴ� ����
// => Ŭ���̾�Ʈ�� ���� ��ûȽ���� ī��Ʈ ���Ͽ� �����Ͽ� ���
@WebServlet("/count.itwill")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//���� ��û Ƚ���� �����ϱ� ���� �ʵ�
	// => WAS ����� �ν��Ͻ� �Ҹ� >> �ʵ� �Ҹ� - �ʵ尪 ���� �Ұ���
	private int count;	

	//ī��Ʈ ���� ��θ� �����ϱ� ���� �ʵ�
	private String countFilePath;
	
	//�ʱ�ȭ �۾� : ī��Ʈ ���Ͽ� ����� ��(ī��Ʈ)�� �о� �ʵ忡 ����
	// => ī��Ʈ ������ ���� ��� �ʵ忡 �ʱⰪ���� 0 ����
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ī��Ʈ ������ �ý��� ��θ� ��ȯ�޾� ����
		// => WorkSpace ���丮�� �ƴ� WebApps ���丮 ��� ��ȯ
		countFilePath=config.getServletContext().getRealPath("/WEB-INF/count.txt");
		//System.out.println("countFilePath = "+countFilePath);
		
		try {
			//ī��Ʈ ���Ͽ� ���� �Է½�Ʈ���� �����Ͽ� ����
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(countFilePath));
			
			//ī��Ʈ ���Ͽ� ����� ������(ī��Ʈ)�� �о� �ʵ忡 ����
			count=(Integer)in.readObject();
			
			//���� �Է½�Ʈ�� ����
			in.close();
		} catch (Exception e) {
			count=0;
		}
	}
	
	//������ �۾� : �ʵ忡 ����� ������(ī��Ʈ)�� ī��Ʈ ���Ͽ� ����
	@Override
	public void destroy() {
		try {
			//ī��Ʈ ���Ͽ� ���� ��½�Ʈ���� �����Ͽ� ����
			// => ī��Ʈ ������ ���� ��� ���� ����
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(countFilePath));
			
			//�ʵ尪�� ���Ͽ� �����Ͽ� ����
			out.writeObject(count);
			
			//���� ��½�Ʈ�� ����
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���� ��û Ƚ���� �����ϱ� ���� ����
		// => �޼ҵ尡 ����Ǹ� �ڵ� �Ҹ�Ǵ� �������� - ������ ���� �Ұ���
		//int count=0;
		
		//���� ��û Ƚ�� ����
		count++;
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���� ī��Ʈ</h1>");
		out.println("<hr>");
		out.println("<p>���� ��û Ƚ�� = "+count+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
