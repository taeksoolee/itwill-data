package site.itwill.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//���� ��¥�� �������� ������ ������ �о� Ŭ���̾�Ʈ���� �����ϴ� ����
// => ���� ��¥�� �������� ������ ���� ��� ���������� ������ �˸��� �޼��� ����
// => ���� ��¥�� �������� ������ ������� �̿��Ͽ� �ۼ� >> ex)20200108.txt
@WebServlet("/notice.itwill")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//��¥������ �̿��Ͽ� �������� ������ �����Ͽ� ����
		String noticeFileName=new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
		//System.out.println("noticeFileName = "+noticeFileName);
		
		//�������� ���Ͽ� ���� �ý��� ��θ� ��ȯ�޾� ����
		String noticeFilePath=request.getServletContext()
				.getRealPath("/WEB-INF/notice/"+noticeFileName);
		//System.out.println("noticeFilePath = "+noticeFilePath);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align: center;'>��������</h1>");
		out.println("<hr>");
		String displayNow=new SimpleDateFormat("yyyy�� MM�� dd��").format(new Date());
		out.println("<p style='text-align: center;'>["+displayNow+"]�� ��������</p>");
		
		try {
			//�������� ���Ͽ� ���� �Է½�Ʈ���� �����Ͽ� ����
			BufferedReader in=new BufferedReader(new FileReader(noticeFilePath));
			
			//�������� ������ ������ �о� Ŭ���̾�Ʈ���� ����
			out.println("<p>");
			while(true) {
				//�������� ������ ������ �� �� �о� ����
				String text=in.readLine();
				if(text==null) break;
				if(text.equals("")) text="&nbsp;";
				out.println("<div>"+text+"</div>");
			}
			out.println("</p>");
			
			//���� �Է½�Ʈ�� ����
			in.close();
		} catch (FileNotFoundException e) {//�������� ������ ���� ���
			out.println("<p>������ ���������� �����ϴ�.</p>");
		}
		
		out.println("<br>");
		out.println("<div style='text-align: center;'>");
		out.println("<button type='button' onclick='window.close();'>�ݱ�</button>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

}







