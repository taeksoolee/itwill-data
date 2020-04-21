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
	//�Ű������� �ڷ����� HttpSession�� ��� �ڵ����� ������ ���ε��Ǿ� ����
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id
		, @RequestParam String passwd, Model model, HttpSession session) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//��������
			//������ �̵��Ǵ� ��������(JSP)���� ���� - Request Scope
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			model.addAttribute("id", id);
			return "session/login_form";
		}
		
		//���ؽ�Ʈ�� �����ϴ� ��� �ڿ����� ���� - Session Scope
		session.setAttribute("loginId", id);
		
		return "session/login_result";
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("abc123") || !hewon.getPasswd().equals("123456")) {//��������
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			return "session/login_form";
		}
		
		session.setAttribute("loginId", hewon.getId());
		
		return "session/login_result";
	}
}
