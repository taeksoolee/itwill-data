package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	//입력값을 전달받아 뷰페이지에게 제공하는 요청처리 메소드
	/*
	//입력태그의 name 속성값과 매개변수의 이름이 다르게 설정해도 400 에러코드 미발생
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email
		, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
	*/

	/*
	//입력값을 전달받아 저장하기 위해 매개변수에는 @RequestParam 어노테이션을 설정하는 것을 권장
	// => 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 400 에러코드 발생
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
		, @RequestParam String name, @RequestParam String email, @RequestParam String phone1
		, @RequestParam String phone2, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute : 뷰페이지에게 출력값을 제공하는 어노테이션
	// => 입력값을 전달받아 저장하는 매개변수에 @ModelAttribute 어노테이션을
	//    설정하면 입력값을 뷰페이지에게 자동으로 제공
	//value 속성 : 저장속성명을 속성값으로 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
	// => 입력태그의 name 속성값과 동일한 이름으로 설정해야만 매개변수에 입력값 저장
	// => 입력태그의 name 속성값 value 속성값이 다른 경우 매개변수에 입력값 미저장
	//value 속성이 생략될 경우 매개변수의 자료형이 자동으로 속성명으로 설정 - 첫문자는 소문자로 변경되어 제공 
	// => 매개변수의 자료형이 기본형(Wrapper) 또는 String인 경우 속성이 생략되면 뷰페이지에 값이 미제공
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd
		, @ModelAttribute("name") String name, @ModelAttribute("email") String email, @ModelAttribute("phone1") String phone1
		, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_display";
	}
	*/
	
	/*
	//매개변수의 자료형을 Map으로 선언한 경우 입력값이 Map의 엔트리로 자동 저장
	// => 입력태그의 name 속성값이 MapKey로 설정되며 입력값이 MapValue로 설정
	//Map 매개변수에 입력값이 저장되기 위해서는 반드시 @RequestParam 어노테이션 선언
	// => @RequestParam 어노테이션이 생략된 경우 EmptyMap이 매개변수에 저장
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("map", memberMap);
		return "join_display";
	}
	*/
	
	/*
	//매개변수의 자료형을 JavaBean으로 선언한 경우 입력값이 JavaBean 객체의 필드에 자동 저장
	// => 입력태그의 name 속성값과 같은 이름에 필드에 입력값 저장
	//JavaBean 매개변수에는 @ModelAttribute 어노테이션 선언
	// => @ModelAttribute 어노테이션 생략 가능
	//value 속성값을 사용하여 뷰페이지에 제공하는 속성명을 설정
	// => value 속성을 생략한 경우 클래스명이 자동으로 속성명으로 설정 - 첫문자는 소문자로 변환
	//Command 객체 : 입력값을 저장하여 뷰페이지 제공하는 객체
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) {
			model.addAttribute("message", "이미 사용중인 아이디 입니다.");
			return "join_form";
		}
		return "join_display";
	}
}









