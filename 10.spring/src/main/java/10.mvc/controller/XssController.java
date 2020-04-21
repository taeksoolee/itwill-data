package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyncode.jtwig.functions.util.HtmlUtils;

@Controller
public class XssController {
	@RequestMapping(value = "/xss", method = RequestMethod.GET)
	public String xss() {
		return "xss/input";
	}
	
	//XSS : �Է��±׿� ���������� �ڵ带 �Է��Ͽ� ���α׷��� �����ϴ� ���
	// => XSS ���ݿ� ���� �� ���� ���� �ڵ� �ʿ�
	//1.������������ ó���ϴ� ��� : �±� ���� ���� ���ڸ� Escape ���ڷ� ��ȯ
	// => Core �±� ���̺귯���� out �±׸� ���
	// => Functions �±� ���̺귯���� escapeXML() �Լ��� ���
	//2.��ûó�� �޼ҵ忡�� ó���ϴ� ���  
	// => Spring���� �����ϴ� HtmlUtils Ŭ������ htmlEscape() �޼ҵ� ��� : �±� ���� ���� ���ڸ� Escape ���ڷ� ��ȯ
	@RequestMapping(value = "/xss", method = RequestMethod.POST)
	public String xss(@RequestParam String subject
			, @RequestParam String content, Model model) {
		/*
		model.addAttribute("subject", subject);
		model.addAttribute("content", content.replace("\n", "<br>"));
		*/
		
		/*
		model.addAttribute("subject", HtmlUtils.htmlEscape(subject));
		model.addAttribute("content", HtmlUtils.htmlEscape(content).replace("\n", "<br>"));
		*/
		
		model.addAttribute("subject", HtmlUtils.stripTags(subject));
		model.addAttribute("content", HtmlUtils.stripTags(content).replace("\n", "<br>"));
		
		return "xss/output";
	}
}
