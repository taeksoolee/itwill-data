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
		model.addAttribute("name","ȫ�浿");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		*/
		return "model_display1";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name","�Ӳ���");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		*/
		return "model_display2";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name","����ġ");
		/*
		model.addAttribute("now", new SimpleDateFormat
				("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		*/
		return "model_display3";
	}
	
	//@ModelAttribute : �޼ҵ忡 ����� ��� ���� ��Ʈ�ѷ��� ����� ���  
	//��ûó�� �޼ҵ��� ���������� ��ȯ���� �����Ͽ� �����ϱ� ���� ������̼�  
	//value(name) �Ӽ� : ���������� ����ϱ� ���� �������� �Ӽ������� ���� - �Ӽ����� ���� ����
	@ModelAttribute("now")
	public String getNow() {
		return new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date());
	}
}






