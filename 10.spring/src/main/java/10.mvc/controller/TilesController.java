package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	//사이트의 메인 페이지를 요청한 경우 호출되는 메소드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template() {
		//tiles.xml 파일에 선언된 definition 엘리먼트의 고유값(name 속성값)을
		//ViewName으로 반환하면 설정된 템플릿 페이지(JSP)로 응답 처리
		return "main";
	}
	
	@RequestMapping(value = "/tiles1")
	public String tiles1() {
		//반환되는 ViewName이 definition 엘리먼트의 고유값과 JSP 파일명으로 설정
		return "hello_tiles";
	}
	
	@RequestMapping(value = "/tiles2")
	public String tiles2() {
		return "tiles/hi_tiles";
	}
	
	@RequestMapping(value = "/tiles3")
	public String tiles3() {
		return "tiles/good/bye_tiles";
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/admin_hello")
	public String adminHello() {
		return "admin/hello";
	}
}
