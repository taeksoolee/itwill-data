package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import site.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : 컨트롤러의 요청처리 메소드에서 제공하는 값을 모든
//요청처리 메소드의 뷰페이지에서 사용할 수 있도록 제공하는 어노테이션
// => 뷰페이지에 값을 제공할 때 Request Scope가 아닌 Session Scope 사용
// => Session Scope를 사용하지만 컨트롤러의 자원만 사용 가능
// => 변경 처리시 다른 요청처리 메소드에서 필요한 정보를 전달하거나 검색하는 작업 제거
//value 속성 : Session Scope로 제공되기 위한 속성명을 속성값으로 설정
@SessionAttributes(value = "hewon")
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 반환하는 메소드 - Service 클래스의 메소드
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setPasswd("123456");
		hewon.setName("홍길동");
		hewon.setEmail("abc@itwill.site");
		hewon.setGender("남자");
		return hewon;
	}
	
	//아이디를 전달받아 해당 아이디의 회원정보를 뷰페이지에 제공하는 요청처리 메소드
	// => 반환받은 회원정보를 뷰페이지의 일반태그 출력
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		//회원정보를 검색하여 반환받아 저장 - Service 클래스의 메소드 호출
		Hewon hewon=getHewon("abc123");
	
		//Model 객체를 이용하여 뷰페이지에게 값을 제공 - Request Scope
		//model.addAttribute("hewon", hewon);
		
		//Model.addAttribute(Object attributeValue) : 뷰페이지에 제공되는 
		//속성명이 생략된 경우 제공되는 값의 자료형을 속성명으로 자동 설정
		// => 기본형(Wrapper) 또는 문자열(String)은 자료형에서 제외
		//@SessionAttributes 어노테이션에 의해 Session Scope로 제공
		model.addAttribute(hewon);
		
		return "session/hewon_view";
	}
	
	/*
	//아이디를 전달받아 해당 아이디의 회원정보를 뷰페이지에 제공하는 요청처리 메소드
	// => 반환받은 회원정보를 뷰페이지의 입력태그에 출력
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "session/hewon_update";
	}
	*/
	
	//Session Scope에 의해 회원정보가 제공되므로 아이디를 이용한 회원정보
	//검색 기능 불필요
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate() {
		return "session/hewon_update";
	}
	
	//변경할 회원정보를 전달받아 회원정보를 변경하는 요청처리 메소드
	//Session Scope로 제공되는 회원정보를 Command 객체에 자동 저장 후
	//입력값을 제공받아 Command 객체의 필드에 저장
	//SessionStatus : @SessionAttributes 어노테이션에 의해 제공되는 값의
	//상태정보를 저장하는 인스턴스
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon
			, SessionStatus status) {
		//입력값이 전달되지 않아도 Session Scope로 제공된 회원정보 사용
		//System.out.println("아이디 = "+hewon.getId());
		
		//SessionStatus.setComplete() : @SessionAttributes 어노테이션에 
		//의해 제공되는 값을 제거하는 메소드
		status.setComplete();
		
		return "session/hewon_view";
	}
}








