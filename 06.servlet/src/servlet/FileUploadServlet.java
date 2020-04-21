package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//�Է�������(file_upload.html)���� ���޵� �Է������� ������ ����(���ε�)�ϰ�
//�Է°��� �Է����ϸ��� Ŭ���̾�Ʈ���� �����ϴ� ����
//�Է��������� ���޵� ������Ÿ�� ó���ϱ� ���ؼ��� ������Ÿ ó�� Ŭ���� �ʿ�
// => Apache �׷쿡�� �����ϴ� commons-fileupload ���̺귯���� Ŭ���� ��� - ������ ���� ���ε� 
// => Oreilly �׷쿡�� �����ϴ� cos ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�

//Oreilly �׷쿡�� �����ϴ� cos ���̺귯���� �ٿ�ε� �޾� ������Ʈ�� ����(Build) ó���ϴ� ���
//1.http://www.servlets.com >> com.oreilly.servlet Ŭ�� >> cos-20.08.zip �ٿ�ε�
//2.cos-20.08.zip ���� Ǯ�� >> ���� ���丮 >> cos.jar
//3.������Ʈ >> WebContent >> WEB-INF >> lib >> cos.jar �ٿ��ֱ� - �ڵ����� ���̺귯�� ���� ó��
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���������� ��û�� ���� ����ó��
		if(request.getMethod().equalsIgnoreCase("get")) {
			response.sendRedirect("error.html");
			return;
		}
		
		//�Է������� �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		// => �۾� ���丮(WorkSpace)�� �ƴ� �� ���丮(WebApps)�� �ý��� ��� ��ȯ
		// => WAS ����� �۾� ���丮�� �� ���丮�� ����ȭ ó���Ǹ鼭 ���� ���ε� ���� ���� ����   
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println("saveDirectory = "+saveDirectory);
		
		//MultipartRequest Ŭ������ �ν��Ͻ� ���� : ������Ÿ�� ó���ϴ� �ν��Ͻ�
		// => �ν��Ͻ��� �����ϸ� ��� �Է������� ���� ���丮�� ������ ���ε� ó��
		//MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize][, String encoding][, FileRenamePolicy policy]) ������
		// => HttpServletRequest request : HttpServletRequest �ν��Ͻ�(request) ����
		// => String saveDirectory : �Է������� ����Ǵ� ���丮 ��� ����
		// => int maxPostSize : ó�� ������ ������Ÿ�� �ִ� ũ��(Byte) ����
		// => String encoding : ������Ÿ�� ó�� ĳ���ͼ�(���ڵ�) ����
		// => FileRenamePolicy policy : FileRenamePolicy �ν��Ͻ� ����
		//FileRenamePolicy : ���� ���ε�� �Է����ϰ� ���� �̸��� ������ ������
		//��� �Է����Ͽ� ���� �̸� ���� ����� �����ϴ� �ν��Ͻ�  
		// => FileRenamePolicy �ν��Ͻ��� �������� ���� ��� ���� ���� ������ �߻�
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
		
		//DefaultFileRenamePolicy : FileRenamePolicy �������̽��� ��ӹ޾� �ۼ��� Ŭ����
		// => �Է����ϸ� �ڿ� ���ڸ� �ٿ� �����ϴ� ����� �����ϴ� Ŭ����
		MultipartRequest mr=new MultipartRequest(request, saveDirectory
				, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		//�Է°��� ��ȯ�޾� ����
		//MultipartRequest.getParameter(String name) : �Է°��� ��ȯ�ϴ� �޼ҵ�
		String name=mr.getParameter("name");
		
		//�Է����ϸ��� ��ȯ�޾� ����
		//MultipartRequest.getOriginalFileName(String name) : �Է����ϸ��� ��ȯ�ϴ� �޼ҵ�
		//String fileone=mr.getOriginalFileName("fileone");
		//String filetwo=mr.getOriginalFileName("filetwo");
		
		//���ε�� ���ϸ��� ��ȯ�޾� ����
		//MultipartRequest.getFilesystemName(String name) : ���ε�� ���ϸ��� ��ȯ�ϴ� �޼ҵ�
		String fileone=mr.getFilesystemName("fileone");
		String filetwo=mr.getFilesystemName("filetwo");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�Է°��� �Է����ϸ� Ȯ��</h1>");
		out.println("<hr>");
		out.println("<p>�ø��� = "+name+"</p>");
		out.println("<p>����-1 = "+fileone+"</p>");
		out.println("<p>����-2 = "+filetwo+"</p>");
		out.println("</body>");
		out.println("</html>");
	}	
}
