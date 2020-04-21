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
	//�Ű������� �����ϸ� ���ް��� �ڵ����� �����޾� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� ���� ��� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� �Ű������� NULL ����
	//������)�Է°��� ���� ĳ���ͼ� ���� �Ұ��� - �ѱ� �Է� �Ұ���
	// => ���ڵ� ���͸� ����Ͽ� �Է°��� �����޾� �����ϱ� ���� ĳ���ͼ� ���� - web.xml
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam  : �Է°��� ���޹޾� �����ϱ� ���� �Ű������� �����ϴ� ������̼�
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� 400 �����ڵ� �߻�
	// => �Է°��� �ݵ�� �Ű������� ���޹޾� �����ϱ� ���� ����ϴ� ������̼�
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//@RequestParam ������̼��� �Ӽ��� �̿��Ͽ� �Է°��� ���� ���� ����
	//value �Ӽ� : �Է��±��� �������� �Ӽ��� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� ���
	// => �Է��±��� name �Ӽ����� �����Ͽ� �Է°��� �Ű������� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("userName") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	/*
	//required �Ӽ� : false �Ǵ� true�� �Ӽ������� ����
	// => false : name �Ӽ����� �Ű������� �̸��� ���� �ʾƵ� 400 �����ڵ� �̹߻�
	// => true(�⺻) : name �Ӽ����� �Ű������� �̸��� ���� ���� ��� 400 �����ڵ� �߻�
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
	*/
	
	//defaultValue �Ӽ� : �Ű������� ����� �⺻���� �Ӽ������� ����
	// => �Ű������� �Է°��� ������� ���� ��� �ڵ� ����Ǵ� �� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value="userName", defaultValue = "�Ӳ���") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
}










