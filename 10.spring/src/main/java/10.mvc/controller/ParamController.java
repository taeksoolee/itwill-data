package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//매개변수를 선언하면 전달값을 자동으로 제공받아 저장
	// => 입력태그의 name 속성값과 매개변수의 이름이 같은 경우 저장
	// => 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 매개변수에 NULL 저장
	//문제점)입력값에 대한 캐릭터셋 변경 불가능 - 한글 입력 불가능
	// => 인코딩 필터를 사용하여 입력값을 제공받아 저장하기 전에 캐릭터셋 변경 - web.xml
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam  : 입력값을 전달받아 저장하기 위한 매개변수에 선언하는 어노테이션
	// => 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 400 에러코드 발생
	// => 입력값을 반드시 매개변수에 전달받아 저장하기 위해 사용하는 어노테이션
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam 어노테이션의 속성을 이용하여 입력값에 대한 전달 설정
	//value 속성 : 입력태그의 고유값을 속성값 설정
	// => 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 사용
	// => 입력태그의 name 속성값을 설정하여 입력값을 매개변수에 저장
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("userName") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//required 속성 : false 또는 true를 속성값으로 설정
	// => false : name 속성값과 매개변수의 이름이 같지 않아도 400 에러코드 미발생
	// => true(기본) : name 속성값과 매개변수의 이름이 같지 않은 경우 400 에러코드 발생
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	//defaultValue 속성 : 매개변수에 저장될 기본값을 속성값으로 설정
	// => 매개변수에 입력값이 저장되지 않을 경우 자동 저장되는 값 설정
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value="userName", defaultValue = "임꺽정") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
}










