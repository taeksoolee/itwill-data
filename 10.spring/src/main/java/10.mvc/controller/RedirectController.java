package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print")
	public String forward(Model model) {
		//뷰페이지에서 출력될 정보를 제공 - Request Scope
		model.addAttribute("name", "홍길동");
		
		//뷰페이지(JSP)로 포워드 이동 
		// => 클라이언트 브라우저의 요청 URL 주소 미변경
		// => Request Scope로 제공되는 정보 출력 가능
		return "redirect/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		return "redirect/redirect_display";//포워드 이동
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//반환되는 ViewName에 redirect 접두사(NameSpace)를 사용하면 리다이렉트 이동
		// => 클라이언트에게 301 코드와 요청 URL 전달하여 재요청 구현
		// => 클라이언트 브라우저의 요청 URL 주소 변경
		return "redirect:/redirect_print";
	}
	*/
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		
		//리다이렉트 이동되기 전에 제공되는 정보는 출력 불가능  
		return "redirect/redirect_display";
	}
	
	//Request Scope로 제공되는 정보는 리다이렉트 페이지에 QueryString 형식으로 전달
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("name", "전우치");
		return "redirect:/redirect_print";
	}
	*/
	
	@RequestMapping("/redirect_print")
	public String redirect() {
		return "redirect/redirect_display";
	}
	
	//RedirectAttributes : 리다이렉트 이동에 의해 호출된 요청처리 메소드의
	//뷰페이지에 정보를 제공하기 위한 기능의 인스턴스
	//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue) 
	// : 리다이렉트 이동된 뷰페이지에 객체를 제공하는 메소드
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		attributes.addFlashAttribute("name", "일지매");
		return "redirect:/redirect_print";
	}
}







