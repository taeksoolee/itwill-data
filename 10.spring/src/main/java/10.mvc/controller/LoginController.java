package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login_form";
	}
	
	/*
	//매개변수의 자료형이 HttpSession인 경우 자동으로 세션이 바인딩되어 제공
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id
		, @RequestParam String passwd, Model model, HttpSession session) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//인증실패
			//포워드 이동되는 뷰페이지(JSP)에만 제공 - Request Scope
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			model.addAttribute("id", id);
			return "session/login_form";
		}
		
		//컨텍스트에 존재하는 모든 자원에게 제공 - Session Scope
		session.setAttribute("loginId", id);
		
		return "session/login_result";
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("abc123") || !hewon.getPasswd().equals("123456")) {//인증실패
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "session/login_form";
		}
		
		session.setAttribute("loginId", hewon.getId());
		
		return "session/login_result";
	}
}
