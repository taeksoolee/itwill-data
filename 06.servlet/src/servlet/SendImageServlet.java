package site.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image.itwill")
public class SendImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ���� �̹��� ����(JPEG ����) ����
		// => �̹��� ������ �����ϹǷ� ĳ���ͼ� �̼���
		response.setContentType("image/jpeg");
		
		//Ŭ���̾�Ʈ���� ���õ���Ÿ�� ������ �� �ִ� ��½�Ʈ���� ��ȯ�޾� ����
		ServletOutputStream out=response.getOutputStream();
		
		//������ ����� �̹��� ������ ��θ� ��ȯ�޾� ����
		//HttpServletRequest.getServletContext() : Ŭ���̾�Ʈ�� ��û��
		//���ؽ�Ʈ�� ����(ServletContext �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		//ServletContext.getRealPath(String contextFilePath) : ���ؽ�Ʈ��
		//�����ϴ� ������ ���� �����θ� ��ȯ�ϴ� �޼ҵ�
		String filePath=request.getServletContext().getRealPath("/WEB-INF/Koala.jpg");
		//System.out.println("filePath = "+filePath);
		
		//������ ����� �̹��� ������ �б� ���� �Է½�Ʈ���� �����Ͽ� ����
		FileInputStream in=new FileInputStream(filePath);
		
		//�Է½�Ʈ��(����)���� ���õ���Ÿ�� �о� ��½�Ʈ��(Ŭ���̾�Ʈ)���� ����
		while(true) {
			int readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
		}
		
		//���� �Է½�Ʈ�� ����
		in.close();		
	}
}







