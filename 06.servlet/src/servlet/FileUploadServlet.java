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

//입력페이지(file_upload.html)에서 전달된 입력파일을 서버에 저장(업로드)하고
//입력값과 입력파일명을 클라이언트에게 전달하는 서블릿
//입력페이지에 전달된 폼데이타를 처리하기 위해서는 폼데이타 처리 클래스 필요
// => Apache 그룹에서 제공하는 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드 
// => Oreilly 그룹에서 제공하는 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드

//Oreilly 그룹에서 제공하는 cos 라이브러리를 다운로드 받아 프로젝트에 빌드(Build) 처리하는 방법
//1.http://www.servlets.com >> com.oreilly.servlet 클릭 >> cos-20.08.zip 다운로드
//2.cos-20.08.zip 압축 풀기 >> 압축 디렉토리 >> cos.jar
//3.프로젝트 >> WebContent >> WEB-INF >> lib >> cos.jar 붙여넣기 - 자동으로 라이브러리 빌드 처리
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//비정상적인 요청에 대한 응답처리
		if(request.getMethod().equalsIgnoreCase("get")) {
			response.sendRedirect("error.html");
			return;
		}
		
		//입력파일을 저장하기 위한 업로드 디렉토리의 시스템 경로를 반환받아 저장
		// => 작업 디렉토리(WorkSpace)가 아닌 웹 디렉토리(WebApps)의 시스템 경로 반환
		// => WAS 실행시 작업 디렉토리가 웹 디렉토리로 동기화 처리되면서 기존 업로드 파일 삭제 가능   
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println("saveDirectory = "+saveDirectory);
		
		//MultipartRequest 클래스로 인스턴스 생성 : 폼데이타를 처리하는 인스턴스
		// => 인스턴스를 생성하면 모든 입력파일을 서버 디렉토리에 무조건 업로드 처리
		//MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize][, String encoding][, FileRenamePolicy policy]) 생성자
		// => HttpServletRequest request : HttpServletRequest 인스턴스(request) 전달
		// => String saveDirectory : 입력파일이 저장되는 디렉토리 경로 전달
		// => int maxPostSize : 처리 가능한 폼데이타의 최대 크기(Byte) 전달
		// => String encoding : 폼데이타의 처리 캐릭터셋(인코딩) 전달
		// => FileRenamePolicy policy : FileRenamePolicy 인스턴스 전달
		//FileRenamePolicy : 파일 업로드시 입력파일과 같은 이름의 파일이 존재할
		//경우 입력파일에 대한 이름 변경 기능을 제공하는 인스턴스  
		// => FileRenamePolicy 인스턴스를 전달하지 않을 경우 기존 파일 덮어씌우기 발생
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
		
		//DefaultFileRenamePolicy : FileRenamePolicy 인터페이스를 상속받아 작성된 클래스
		// => 입력파일명 뒤에 숫자를 붙여 변경하는 기능을 제공하는 클래스
		MultipartRequest mr=new MultipartRequest(request, saveDirectory
				, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		//입력값을 반환받아 저장
		//MultipartRequest.getParameter(String name) : 입력값을 반환하는 메소드
		String name=mr.getParameter("name");
		
		//입력파일명을 반환받아 저장
		//MultipartRequest.getOriginalFileName(String name) : 입력파일명을 반환하는 메소드
		//String fileone=mr.getOriginalFileName("fileone");
		//String filetwo=mr.getOriginalFileName("filetwo");
		
		//업로드된 파일명을 반환받아 저장
		//MultipartRequest.getFilesystemName(String name) : 업로드된 파일명을 반환하는 메소드
		String fileone=mr.getFilesystemName("fileone");
		String filetwo=mr.getFilesystemName("filetwo");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력값과 입력파일명 확인</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+name+"</p>");
		out.println("<p>파일-1 = "+fileone+"</p>");
		out.println("<p>파일-2 = "+filetwo+"</p>");
		out.println("</body>");
		out.println("</html>");
	}	
}
