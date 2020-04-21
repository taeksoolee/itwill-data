package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)에서 전달된 입력값을 반환받아 클라이언트에게 전달하는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//입력페이지로부터 값을 입력받아 POST 방식으로 요청하여 처리되는 서블릿
		// => 서블릿을 GET 방식으로 요청한 경우 비정상적인 요청
		// => 비정상적인 요청에 대한 처리 - 에러코드 전달하거나 에러 페이지 이동
		//HttpServletRequest.getMethod() : 클라이언트의 요청방식을 반환하는 메소드
		if(request.getMethod().equals("GET")) {//클라이언트가 GET 방식으로 요청한 경우
			/*
			//HttpServletResponse.sendError(int statusCode) : 클라이언트에게
			//상태코드(에러코드)를 전달하는 메소드
			// => 에러코드는 HttpServletResponse 인터페이스의 상수필드(Constant Field)를 이용하는 것을 권장
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);//405
			return;
			*/
			
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게
			//상태코드 301과 URL 주소를 전달하는 메소드 
			// => 301 코드 : 전달한 URL 주소로 요청하는 상태코드
			// => Java(Servlet)를 이용한 페이지 이동(리다이렉트 이동)
			// => 컨텍스트에 존재하는 자원으로만 이동 가능
			response.sendRedirect("error.html");
			return;
		}
		
		//POST 방식으로 요청하여 전달된 입력값에 대한 캐릭터셋(인코딩) 변경
		// => 리퀘스트 메세지의 기본 캐릭터셋 : ISO-8859-1(서유럽어)
		//HttpServletRequest.setCharacterEncoding(String encoding) : 
		//리퀘스트 메세지의 캐릭터셋를 변경하는 메소드
		request.setCharacterEncoding("utf-8");
		
		//입력페이지의 입력값을 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 입력값을 문자열로 반환하는 메소드
		// => 입력태그의 name 속성값을 매개변수에 전달하여 원하는 입력값 반환
		// => name 속성값이 없는 경우 null 반환 
		// => 입력값이 없는 경우 NullString 반환 
		String id=request.getParameter("id");
		//System.out.println("id = "+id);
		
		//반환받은 입력값에 검증 작업 - 비정상적인 요청에 대한 처리
		if(id==null || id.equals("")) {//입력값이 존재하지 않는 경우
			response.sendRedirect("error.html");
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {
			response.sendRedirect("error.html");
			return;
		}
		
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String sex=request.getParameter("sex");
		String job=request.getParameter("job");
		//name 속성값이 같은 입력값은 처음 입력값만 반환하여 저장
		//String hobby=request.getParameter("hobby");
		//HttpServletRequest.getParameterValues(String name) : name 
		//속성값이 같은 입력값들을 문자열 배열로 반환하는 메소드
		// => 입력값이 checkbox 형식으로 입력된 경우 사용하는 메소드
		String[] hobby=request.getParameterValues("hobby");
		String profile=request.getParameter("profile");
	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원정보 확인</h1>");
		out.println("<hr>");
		out.println("<ul>");
		out.println("<li>아이디 = "+id+"</li>");
		out.println("<li>비밀번호 = "+pass+"</li>");
		out.println("<li>이름 = "+name+"</li>");
		out.println("<li>주소 = "+addr+"</li>");
		out.println("<li>성별 = "+sex+"</li>");
		out.println("<li>직업 = "+job+"</li>");
		//out.println("<li>취미 = "+hobby+"</li>");
		if(hobby==null) {
			out.println("<li>취미 = 선택한 취미가 하나도 없습니다.</li>");
		} else {
			out.println("<li>취미 = ");
			for(int i=0;i<hobby.length;i++) {
				out.println(hobby[i]);
				if(i<hobby.length-1) {//마지막 배열 요소값이 아닌 경우 
					out.println(", ");
				}
			}
			out.println("</li>");
		}
		
		out.println("<li>자기소개<br>"+profile.replace("\n", "<br>")+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}
}





