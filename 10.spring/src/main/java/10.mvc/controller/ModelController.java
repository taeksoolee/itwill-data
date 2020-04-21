package site.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name","홍길동");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		*/
		return "model_display1";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name","임꺽정");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		*/
		return "model_display2";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name","전우치");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
		*/
		return "model_display3";
	}
	
	//@ModelAttribute : 메소드에 선언된 경우 현재 컨트롤러에 선언된 모든  
	//요청처리 메소드의 뷰페이지에 반환값을 저장하여 제공하기 위한 어노테이션  
	//value(name) 속성 : 뷰페이지에 사용하기 위한 고유값을 속성값으로 설정 - 속성값만 설정 가능
	@ModelAttribute("now")
	public String getNow() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	}
}






