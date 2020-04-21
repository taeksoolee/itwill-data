package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.GuestDAO;
import site.itwill.dto.GuestDTO;

//GUEST 테이블에 저장된 모든 방명록 게시글을 검색하여 클라이언트에게 전달하는 서블릿 - 출력페이지 
@WebServlet("/select.itwill")
public class GuestSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//GUEST 테이블에 저장된 모든 행을 검색하여 반환하는 DAO 클래스의 메소드 호출
		List<GuestDTO> guestList=GuestDAO.getDAO().selectAllGuest();
		
		//반환받은 검색결과를 클라이언트에게 전달
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='ext/html; charset=UTF-8'>");
		out.println("<title>::: 방명록:::</title>");
		out.println("<link rel='stylesheet' type='text/css' href='css/common.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table width='80%' align='center' border='0' cellspacing='0' cellpadding='0'>");
		out.println("<tr bgcolor='#000080' valign='middle'>");
		out.println("<td height='25' class='t1' align='center'>");
		out.println("<b><font color='#FFFFFF'>:::방명록 읽기 :::</font></b>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td height='30' align='right' valign='bottom' class='t1'>");
		out.println("<a href='insert.html'>방명록 쓰기</a></td>");
		out.println("</tr>");
		
		if(guestList.isEmpty()) {
			out.println("<tr align='center'>");
			out.println("<td>방명록에 저장된 글이 하나도 없습니다.</td>");
			out.println("</tr>");
		} else {
			for(GuestDTO guest:guestList) {
				out.println("<tr>");
				out.println("<td>");
				out.println("<table width='100%' align='center' border='1' cellspacing='0' bgcolor='#f5f5f5'>");
				out.println("<tr>");
				out.println("<td>");
				out.println("<table width='100%' align='center' border='0' cellspacing='0'>");
				out.println("<tr>");
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>");
				out.println("<font color='#FFFFFF'>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</font></td>");
				out.println("<td height='20' width='80%' class='t1'>");
				out.println("<b><font color='#0000FF'>&nbsp;&nbsp;"+guest.getTitle()+"</font></b></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
		
				out.println("<tr>");
				out.println("<td>");
				out.println("<table width='100%' align='center' border='0' cellspacing='0'>");
				out.println("<tr>");
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>");
				out.println("<font color='#FFFFFF'>작 성 자</font></td>");
				out.println("<td align='center' height='20' width='30%' class='t1'>"+guest.getName()+"</td>");
				out.println("<td bgcolor='#808000' align='center' height='20' width='20%' class='t1'>");
				out.println("<font color='#FFFFFF'>작 성 일</font></td>");
				out.println("<td align='center' height='20' width='30%' class='t1'>"+guest.getRegdate().substring(0, 19)+"</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
		
				out.println("<tr>");
				out.println("<td>");
				out.println("<table width='100%' align='center' border='0' cellspacing='10'>");
				
				out.println("<tr>");
				out.println("<td height='50' width='100%' class='t1'>");
				out.println(guest.getContent().replace("\n", "<br>"));
				out.println("</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td height='50' width='100%' class='t1'>");
				out.println("<button type='button' class='t1' onclick='location.href=\"delete.itwill?no="+guest.getNo()+"\";'>삭제</button>");
				out.println("</td>");
				out.println("</tr>");
				
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td height='20'>");
				out.println("<hr color='#000077'>");
				out.println("</td>");
				out.println("</tr>");
			}
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
