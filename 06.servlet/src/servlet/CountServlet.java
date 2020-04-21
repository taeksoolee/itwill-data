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

//클라이언트의 서블릿 요청횟수를 클라이언트에게 제공하는 서블릿
// => 클라이언트의 서블릿 요청횟수를 카운트 파일에 저장하여 사용
@WebServlet("/count.itwill")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서블릿 요청 횟수를 저장하기 위한 필드
	// => WAS 종료시 인스턴스 소멸 >> 필드 소멸 - 필드값 유지 불가능
	private int count;	

	//카운트 파일 경로를 저장하기 위한 필드
	private String countFilePath;
	
	//초기화 작업 : 카운트 파일에 저장된 값(카운트)를 읽어 필드에 저장
	// => 카운트 파일이 없는 경우 필드에 초기값으로 0 저장
	@Override
	public void init(ServletConfig config) throws ServletException {
		//카운트 파일의 시스템 경로를 반환받아 저장
		// => WorkSpace 디렉토리가 아닌 WebApps 디렉토리 경로 반환
		countFilePath=config.getServletContext().getRealPath("/WEB-INF/count.txt");
		//System.out.println("countFilePath = "+countFilePath);
		
		try {
			//카운트 파일에 대한 입력스트림을 생성하여 저장
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(countFilePath));
			
			//카운트 파일에 저장된 정수값(카운트)를 읽어 필드에 저장
			count=(Integer)in.readObject();
			
			//파일 입력스트림 제거
			in.close();
		} catch (Exception e) {
			count=0;
		}
	}
	
	//마무리 작업 : 필드에 저장된 정수값(카운트)를 카운트 파일에 저장
	@Override
	public void destroy() {
		try {
			//카운트 파일에 대한 출력스트림을 생성하여 저장
			// => 카운트 파일이 없는 경우 파일 생성
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(countFilePath));
			
			//필드값을 파일에 전달하여 저장
			out.writeObject(count);
			
			//파일 출력스트림 제거
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//서블릿 요청 횟수를 저장하기 위한 변수
		// => 메소드가 종료되면 자동 소멸되는 지역변수 - 변수값 유지 불가능
		//int count=0;
		
		//서블릿 요청 횟수 누적
		count++;
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 카운트</h1>");
		out.println("<hr>");
		out.println("<p>서블릿 요청 횟수 = "+count+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
