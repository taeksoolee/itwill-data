package site.itwill10.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class ValidController {
	@RequestMapping(value = "/valid_html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	@RequestMapping(value = "/valid_html", method = RequestMethod.POST)
	public String html(@ModelAttribute Hewon hewon, Model model) {
		//요청처리 전 입력값에 대한 유효성 검사
		if(hewon.getId()==null || hewon.getId().equals("")) {
			model.addAttribute("idMsg", "아이디를 입력해 주세요.");
			return "valid/html_form";
		}
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, hewon.getId())) {
			model.addAttribute("idMsg", "아이디를 형식에 맞게 입력해 주세요.");
			return "valid/html_form";
		}
		return "valid/html_result";
	}
	
	@RequestMapping(value = "/valid_spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Hewon hewon) {
		return "valid/spring_form";
	}
	
	//@Valid : Spring form 태그에 의해 전달된 값을 Command 객체의 필드에 저장
	//하기 전 필드의 유효성 검사기능을 활성화 처리하기 위한 어노테이션
	// => JavaBean 클래스의 필드에 유효성 검사 관련 어노테이션 사용 
	//Errors : 유효성 검사 후 발생되는 모든 에러정보를 저장하기 위한 인스턴스
	@RequestMapping(value = "/valid_spring", method = RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Hewon hewon,Errors errors) {
		//Errors.hasErrors() : Errors 인스턴스에 에러정보가 존재할 경우 true을 반환하는 메소드
		if(errors.hasErrors()) {
			return "valid/spring_form";
		}
		return "valid/spring_result";
	}
	
	//메소드 반환값이 모든 요청처리 메소드의 뷰페이지에 제공 
	@ModelAttribute("genderList")
	public List<String> genderList() {
		return Arrays.asList("남자","여자");
	}
}





