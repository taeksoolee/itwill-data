package site.itwill.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 필요한 기능을 모델(Model)를
//사용하고 구현하고 응답결과를 뷰(View)를 사용하여 전달되도록 구현하는 서블릿

//1.클라이언트의 모든 요청을 받을 수 있는 단일 진입점의 기능 구현
//@WebServlet("URL") : 서블릿이 실행되기 위한 URL 주소를 매핑하는 어노테이션
// => URL 주소에 패턴기호(* 또는 ?)를 이용하여 설정
// => ex)@WebServlet("*.do") : 클라이언트가 ~.do 형식의 URL 주소로 요청한 경우 서블릿 실행
//web.xml 파일에 서블릿을 실행할 수 있도록 설정
// => 서블릿 클래스의 소스파일 변경 없이 다양한 환경설정 가능
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//요청정보(Key)와 모델 인스턴스(Value)를 저장하기 위한 콜렉션 필드
	private Map<String, Action> actionMap;
	
	/*
	//클래스를 인스턴스로 생성하기 위한 생성자 - 초기화 작업
	public ControllerServlet() {
		actionMap=new HashMap<String, Action>();
	}
	*/
	
	//클라이언트 요청에 의해 서블릿 클래스가 인스턴스로 생성된 후 가장 
	//먼저 한번만 자동 호출되는 메소드 - 초기화 작업
	// => 매개변수에 자동 저장된 ServletConfig 인스턴스를 이용하여 외부파일의 값을 제공받아 초기화 작업 
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("ControllerServlet 클래스의 init() 메소드 호출");
		//콜렉션 필드에 인스턴스를 생성하여 저장
		actionMap=new HashMap<String, Action>();
		
		/*
		//콜렉션 필드(인스턴스)에 요청정보(Key)와 모델 인스턴스(Value)를 추가
		// => 모델 인스턴스를 미리 생성하여 저장한 후 필요한 경우 제공 : 실행속도 증가
		actionMap.put("/loginform.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeform.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyform.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties 파일에 요청정보와 모델 클래스를 저장하고 파일의 내용을
		//읽어 콜렉션 필드에 추가 - 유지보수의 효율성 증가
		//Properties 파일(~.properties) : 프로그램 실행에 필요한 정보를 제공하기 위한 텍스트 파일
		
		//Properties 파일의 시스템 경로를 반환받아 저장
		//ServletConfig.getServletContext() : ServletContext 인스턴스
		//(컨텍스트 정보 저장)를 반환하는 메소드
		//ServletContext.getRealPath(String path) : 컨텍스트에 존재하는 자원의 시스템 경로를 반환하는 메소드
		//String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		
		//ServletConfig.getInitParameter(String name) : web.xml 파일의
		//서블릿에 설정에서 init-param 엘리먼트의 제공값을 반환하는 메소드 
		String configFile=config.getInitParameter("configFile");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		
		//Properties 인스턴스 생성 : Properties 파일의 정보를 저장하기 위한 인스턴스
		Properties properties=new Properties();
		
		try {
			//Properties 파일을 읽기 위한 파일 입력스트림 생성
			FileInputStream in=new FileInputStream(configFilePath);
			
			//Properties 파일을 읽어 Properties 인스턴스에 저장
			//Properties.load(InputStream in) : 파일 입력스트림을 통해 
			//Properties 파일의 정보를 읽어 Properties 인스턴스에 저장하는 메소드 
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties 인스턴스에 저장된 정보를 이용하여 콜렉션 필드에 엔트리 추가
		//Properties.keySet() : Properties 인스턴스의 모든 키들을 반환하는 메소드 
		for(Object key:properties.keySet()) {
			//요청정보(Key)를 반환받아 저장
			String actionCommand=(String)key;
			
			//모델클래스(Value)를 반환받아 저장
			//Properties.get(String key) : Properties 인스턴스에 저장된 
			//값을 키를 이용하여 반환하는 메소드
			String actionClass=(String)properties.get(key);
			
			//클래스를 이용하여 인스턴스 생성하여 저장 - 리플렉션 기능 이용
			//Class.forName(String className) : 클래스명을 전달받아 해당 
			//클래스를 메모리에 저장하는 메소드
			//Class.newInstance() : 메모리에 저장된 클래스의 기본 생성자를 
			//이용하여 인스턴스를 생성하여 반환하는 메소드
			try {
				Action actionObject=(Action)Class.forName(actionClass).newInstance();
				
				//콜렉션 필드에 요청정보와 모델 인스턴스를 하나의 엔트리로 추가
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//클라이언트의 GET 또는 POST 방식의 요청을 실행하기 위해 호출되는 메소드
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ControllerServlet 클래스의 service() 메소드 호출");
		
		//2.클라이언트의 요청 분석 : URL 주소 이용 - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : 요청 URL 주소의 URI 값을 반환하는 메소드 - /mvc/XXX.do
		String requestURI=request.getRequestURI();
		//request.getContextPath() : 요청 URL 주소의 컨텍스트 경로를 반환하는 메소드 - /mvc
		String contextPath=request.getContextPath();
		//클라이언트의 요청정보를 반환받아 저장
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command = "+command);
		
		//3.요청정보에 따른 모델(Model) 클래스를 인스턴스로 생성하여 처리 메소드 호출
		// => 모델(Model) 클래스의 처리 메소드를 이용하여 클라이언트 요청에 대한 기능 구현
		/*
		/loginform.do  : 로그인 입력페이지(환영메세지 출력페이지) >> LoginFormModel - "user_login.jsp" 포워드 이동
		/login.do      : 로그인 처리페이지 >> LoginModel - "login.do" 리다이렉트 이동
		/logout.do     : 로그아웃 처리페이지 >> LogoutModel - "loginform.do" 리다이렉트 이동
		/writeform.do  : 회원정보 저장 입력페이지 >> WriteFormModel - "user_write.jsp" 포워드 이동
		/write.do      : 회원정보 저장 처리페이지 >> WriteModel - "loginform.do" 리다이렉트 이동
		/list.do       : 회원목록 출력페이지 >> ListModel - "user_list.jsp" 포워드 이동
		/view.do       : 회원정보 출력페이지 >> ViewModel - "user_view.jsp" 포워드 이동
		/modifyform.do : 회원정보 변경 입력페이지 >> ModifyFormModel - "user_modify.jsp" 포워드 이동
		/modify.do     : 회원정보 변경 처리페이지 >> ModifyModel - "view.do" 리다이렉트 이동
		/remove.do     : 회원정보 삭제 처리페이지 >> RemoveModel - "list.do" 리다이렉트 이동
		/error.do      : 에러메세지 출력페이지 >> ErrorModel - "user_error.jsp" 포워드 이동
		*/
		
		/*
		//인터페이스를 이용하여 참조변수 생성
		// => 참조변수에는 인터페이스를 상속받은 자식클래스의 인스턴스 저장
		Action action=null;
		
		//모델클래스를 인스턴스로 생성하여 저장
		if(command.equals("/loginform.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if(command.equals("/writeform.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyform.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {
			action=new ErrorModel();
		}
		*/

		//요청정보(Key)를 이용하여 콜렉션 필드에 저장된 모델 인스턴스
		//(value)를 반환받아 부모 참조변수에 저장
		Action action=actionMap.get(command);
		//요청정보에 대한 모델 인스턴스가 존재하지 않을 경우
		if(action==null) {
			action=actionMap.get("/error.do");
		}
		
		//부모 참조변수에 저장된 자식 인스턴스에 따라 다른 메소드 호출
		//모델클래스의 처리메소드를 호출하여 요청 실행 후 뷰 관련 정보를 반환받아 저장
		ActionForward actionForward=action.execute(request, response);
		
		//4.반환받은 뷰 관련 정보를 이용하여 클라이언트에게 응답하도록 설정
		if(actionForward.isForward()) {//forward 필드값이 true인 경우
			//JSP 문서로 응답되도록 포워드 처리
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//forward 필드값이 false인 경우
			//클라이언트가 다른 자원을 요청하도록 리다이렉트 처리
			response.sendRedirect(actionForward.getPath());
		}
	}
}
