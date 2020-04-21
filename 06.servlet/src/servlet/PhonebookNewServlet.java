package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dao.PhonebookDAO;
import site.itwill.dto.PhonebookDTO;

//PHONEBOOK 테이블에 저장된 모든 행을 검색하여 클라이언트에게 전달하는 서블릿
// => DAO 클래스 이용
@WebServlet("/new.itwill")
public class PhonebookNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//PHONEBOOK 테이블에 저장된 모든 행을 검색하여 반환하는 DAO 클래스의 메소드 호출
		List<PhonebookDTO> phonebookList=PhonebookDAO.getDAO().getPhonebookList();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>전화번호부(JDBC)</h1>");
		out.println("<hr>");
		out.println("<table border='1' cellspacing='0' width='600'>");
		out.println("<tr>");
		out.println("<th>전화번호</th><th>이름</th><th>주소</th>");
		out.println("</tr>");
		
		//반환받은 결과를 클라이언트에게 전달 - 반복 결과
		for(PhonebookDTO phonebook:phonebookList) {
			out.println("<tr align='center'>");
			out.println("<td>"+phonebook.getPhone()+"</td>");
			out.println("<td>"+phonebook.getName()+"</td>");
			out.println("<td>"+phonebook.getAddress()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}









