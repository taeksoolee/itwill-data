package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print")
	public String forward(Model model) {
		//������������ ��µ� ������ ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		//��������(JSP)�� ������ �̵� 
		// => Ŭ���̾�Ʈ �������� ��û URL �ּ� �̺���
		// => Request Scope�� �����Ǵ� ���� ��� ����
		return "redirect/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(Model model) {
		model.addAttribute("name", "�Ӳ���");
		return "redirect/redirect_display";//������ �̵�
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//��ȯ�Ǵ� ViewName�� redirect ���λ�(NameSpace)�� ����ϸ� �����̷�Ʈ �̵�
		// => Ŭ���̾�Ʈ���� 301 �ڵ�� ��û URL �����Ͽ� ���û ����
		// => Ŭ���̾�Ʈ �������� ��û URL �ּ� ����
		return "redirect:/redirect_print";
	}
	*/
	
	/*
	@RequestMapping("/redirect_print")
	public String redirect(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		
		//�����̷�Ʈ �̵��Ǳ� ���� �����Ǵ� ������ ��� �Ұ���  
		return "redirect/redirect_display";
	}
	
	//Request Scope�� �����Ǵ� ������ �����̷�Ʈ �������� QueryString �������� ����
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("name", "����ġ");
		return "redirect:/redirect_print";
	}
	*/
	
	@RequestMapping("/redirect_print")
	public String redirect() {
		return "redirect/redirect_display";
	}
	
	//RedirectAttributes : �����̷�Ʈ �̵��� ���� ȣ��� ��ûó�� �޼ҵ���
	//���������� ������ �����ϱ� ���� ����� �ν��Ͻ�
	//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue) 
	// : �����̷�Ʈ �̵��� ���������� ��ü�� �����ϴ� �޼ҵ�
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		attributes.addFlashAttribute("name", "������");
		return "redirect:/redirect_print";
	}
}







