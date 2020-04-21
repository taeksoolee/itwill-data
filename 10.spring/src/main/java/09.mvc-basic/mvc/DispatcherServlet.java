package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 URL 주소를 분석하여 
//요청에 대한 모델 클래스(Model)의 메소드를 호출하여 요청 처리 후 JSP 문서
//(View)로 응답되도록 흐름을 제어하기 위한 서블릿 클래스
//=> web.xml 파일에서 클래스를 서블릿으로 등록하고 단일 진입점 역활로 실행될 수 있도록 URL 패턴으로 매핑 처리
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트 요청을 처리하기 위해 WAS 프로그램이 자동 호출하는 메소드
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.클라이언트의 요청 URL 주소 분석 - 요구사항 파악
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//2.요청에 대한 컨트롤러 클래스의 처리 메소드 호출하고 응답페이지 정보를 반환받아 저장 
		// => 요청 처리 클래스 : Model >> Controller
		/*
		Controller controller=null;
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/

		//요청정보를 전달하여 처리 인스턴스를 반환받아 처리
		HandlerMapping handlerMapping=new HandlerMapping();
		Controller controller=handlerMapping.getController(command);
		
		//처리메소드를 호출하고 응답페이지 정보를 반환받아 저장
		String view=controller.handleRequest(request, response);
		
		//3.응답페이지로 포워드 이동하여 클라이언트에게 응답결과 제공
		// => 반환받은 응답페이지를 정보를 뷰페이지로 변환하여 포워드 이동
		ViewResolver viewResolver=new ViewResolver();
		String viewPage=viewResolver.getViewPage(view);		
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
}








