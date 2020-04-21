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

//현재 날짜의 공지사항 파일의 내용을 읽어 클라이언트에게 전달하는 서블릿
// => 현재 날짜의 공지사항 파일이 없는 경우 공지사항이 없음을 알리는 메세지 전달
// => 현재 날짜의 공지사항 파일은 년월일을 이용하여 작성 >> ex)20200108.txt
@WebServlet("/notice.itwill")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//날짜정보를 이용하여 공지사항 파일을 생성하여 저장
		String noticeFileName=new SimpleDateFormat("yyyyMMdd").format(new Date())+".txt";
		//System.out.println("noticeFileName = "+noticeFileName);
		
		//공지사항 파일에 대한 시스템 경로를 반환받아 저장
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
		out.println("<h1 style='text-align: center;'>공지사항</h1>");
		out.println("<hr>");
		String displayNow=new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
		out.println("<p style='text-align: center;'>["+displayNow+"]의 공지사항</p>");
		
		try {
			//공지사항 파일에 대한 입력스트림을 생성하여 저장
			BufferedReader in=new BufferedReader(new FileReader(noticeFilePath));
			
			//공지사항 파일의 내용을 읽어 클라이언트에게 전달
			out.println("<p>");
			while(true) {
				//공지사항 파일의 내용을 한 줄 읽어 저장
				String text=in.readLine();
				if(text==null) break;
				if(text.equals("")) text="&nbsp;";
				out.println("<div>"+text+"</div>");
			}
			out.println("</p>");
			
			//파일 입력스트림 제거
			in.close();
		} catch (FileNotFoundException e) {//공지사항 파일이 없는 경우
			out.println("<p>오늘은 공지사항이 없습니다.</p>");
		}
		
		out.println("<br>");
		out.println("<div style='text-align: center;'>");
		out.println("<button type='button' onclick='window.close();'>닫기</button>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

}







