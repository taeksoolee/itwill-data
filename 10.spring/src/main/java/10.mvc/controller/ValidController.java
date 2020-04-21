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
		//��ûó�� �� �Է°��� ���� ��ȿ�� �˻�
		if(hewon.getId()==null || hewon.getId().equals("")) {
			model.addAttribute("idMsg", "���̵� �Է��� �ּ���.");
			return "valid/html_form";
		}
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, hewon.getId())) {
			model.addAttribute("idMsg", "���̵� ���Ŀ� �°� �Է��� �ּ���.");
			return "valid/html_form";
		}
		return "valid/html_result";
	}
	
	@RequestMapping(value = "/valid_spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Hewon hewon) {
		return "valid/spring_form";
	}
	
	//@Valid : Spring form �±׿� ���� ���޵� ���� Command ��ü�� �ʵ忡 ����
	//�ϱ� �� �ʵ��� ��ȿ�� �˻����� Ȱ��ȭ ó���ϱ� ���� ������̼�
	// => JavaBean Ŭ������ �ʵ忡 ��ȿ�� �˻� ���� ������̼� ��� 
	//Errors : ��ȿ�� �˻� �� �߻��Ǵ� ��� ���������� �����ϱ� ���� �ν��Ͻ�
	@RequestMapping(value = "/valid_spring", method = RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Hewon hewon,Errors errors) {
		//Errors.hasErrors() : Errors �ν��Ͻ��� ���������� ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(errors.hasErrors()) {
			return "valid/spring_form";
		}
		return "valid/spring_result";
	}
	
	//�޼ҵ� ��ȯ���� ��� ��ûó�� �޼ҵ��� ���������� ���� 
	@ModelAttribute("genderList")
	public List<String> genderList() {
		return Arrays.asList("����","����");
	}
}





