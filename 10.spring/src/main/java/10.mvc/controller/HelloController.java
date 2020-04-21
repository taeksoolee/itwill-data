package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller : Command Controller 역활의 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => 기본적으로 클래스명을 beanName으로 설정 - 속성을 이용하여 변경 가능 
// => Controller 인터페이스를 상속받지 않아도 Command Controller 클래스로 작성 가능
// => @RequestMapping 어노테이션을 이용하여 클라이언트 요청에 대한 처리 메소드를 여러 개 선언 가능 
@Controller
public class HelloController {
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);
	//요청 처리메소드에서 Front Controller에게 ViewName를 제공하는 방법
	// => Front Controller는 ViewName를 전달받아 ViewResolver 클래스를 이용하여 JSP 파일경로로 변환하여 포워드 이동
	//1.요청 처리메소드의 반환형을 void로 선언하여 메소드명을 ViewName으로 제공
	//2.요청 처리메소드의 반환형을 String로 선언하여 반환값(String)을 ViewName으로 제공
	//3.요청 처리메소드의 반환형을 ModelAndView로 선언하여 반환값(ModelAndView)을 ViewName으로 제공
	
	//클라이언트의 요청을 처리하기 위한 메소드 
	//@RequestMapping : 클라이언트 요청정보를 제공받아 처리메소드를 호출하여 실행하는 어노테이션
	//value 속성 : 클라이언트 요청정보를 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능 
	@RequestMapping(value = "/hello")
	public void hello() {
		//요청처리 명령 구현 - Service 클래스의 메소드 호출
		logger.info("/hello 요청 >> HelloController 클래스의 hello() 메소드 호출 ");
	}
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/helloViewName 요청 >> HelloController 클래스의 helloViewName() 메소드 호출 ");
		return "hello";
	}
	
	//ModelAndView : 요청처리에 대한 결과값과 ViewName를 저장하기 위한 클래스
	@RequestMapping("/helloMAV")
	public ModelAndView helloModelAndView() {
		logger.info("/helloMAV 요청 >> HelloController 클래스의 helloModelAndView() 메소드 호출 ");
		/*
		ModelAndView modelAndView=new ModelAndView();
		//ModelAndView.setViewName(String viewName) : ViewName를 변경하는 메소드
		modelAndView.setViewName("hello");
		*/

		//ModelAndView 클래스의 생성자를 이용하여 ViewName를 초기화하여 저장	
		ModelAndView modelAndView=new ModelAndView("hello");
		return modelAndView;
	}
}











