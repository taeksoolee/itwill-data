package site.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 클라이언트 요청에 의해 WAS 컨테이너가 서블릿 클래스로 인스턴스를
//자동 생성하고 메소드를 호출하여 처리와 응답 결과 제공
// => 컨테이너(Container) : 인스턴스의 생명주기(LifeCycle)를 관리(생성,사용,소멸)하는 프로그램
// => 서블릿 클래스의 인스턴스가 이미 존재할 경우 인스턴스를 생성하지 않고 재사용
// => WAS 종료시 컨테이너의 의해 생성된 모든 서블릿 인스턴스를 자동 소멸
@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	
	//생성자(Constructor) : 인스턴스를 생성하는 특별한 메소드
	// => 서블릿 인스턴스를 생성할 때 한번만 호출 : 초기화 작업(필드 초기값 부여)
	public LifeCycleServlet() {
		System.out.println("### LifeCycleServlet 클래스의 기본 생성자 호출 ###");
	}
	
	//init() : 서블릿 인스턴스 생성 후 가장 먼저 한번만 자동 호출되는 메소드
	// => 생성자 대신 초기화 작업(필드 초기값 부여)
	//init() 메소드를 이용하여 초기화 작업을 하는 이유는 ServletConfig 인스턴스를 제공받아 사용
	// => ServletConfig : 환경설정파일에서 제공하는 값을 사용할 수 있는 인스턴스
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet 클래스의 init() 메소드 호출 ###");
		//ServletConfig.getServletContext() : 클라이언트가 요청한 컨텍스트의
		//정보(ServletContext 인스턴스)를 반환하는 메소드
		//ServletContext.getInitParameter(String paramName) : [web.xml]파일에서
		//제공하는 값(context-param)을 반환하는 메소드
		name=config.getServletContext().getInitParameter("name");
	}
	
	//service() : 클라이언트 요청마다 컨테이너에 의해 자동 호출되는 메소드
	//=> 클라이언트 요청에 대한 처리 후 결과 전달(응답)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet 클래스의 service() 메소드 호출 ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 생명주기</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"님 환영합니다.</p>");
		out.println("<img src='image.itwill' width='300'>");
		out.println("</body>");
		out.println("</html>");
	}

	//destroy() : 서블릿 인스턴스 소멸 전 한번만 자동 호출되는 메소드 - 마무리 작업
	@Override
	public void destroy() {
		System.out.println("### LifeCycleServlet 클래스의 destroy() 메소드 호출 ###");
	}
}
