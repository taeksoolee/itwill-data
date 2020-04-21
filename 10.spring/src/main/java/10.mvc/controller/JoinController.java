package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	//�Է°��� ���޹޾� ������������ �����ϴ� ��ûó�� �޼ҵ�
	/*
	//�Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ��� �����ص� 400 �����ڵ� �̹߻�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email
		, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
	*/

	/*
	//�Է°��� ���޹޾� �����ϱ� ���� �Ű��������� @RequestParam ������̼��� �����ϴ� ���� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� 400 �����ڵ� �߻�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
		, @RequestParam String name, @RequestParam String email, @RequestParam String phone1
		, @RequestParam String phone2, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute : ������������ ��°��� �����ϴ� ������̼�
	// => �Է°��� ���޹޾� �����ϴ� �Ű������� @ModelAttribute ������̼���
	//    �����ϸ� �Է°��� ������������ �ڵ����� ����
	//value �Ӽ� : ����Ӽ����� �Ӽ������� ���� - �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	// => �Է��±��� name �Ӽ����� ������ �̸����� �����ؾ߸� �Ű������� �Է°� ����
	// => �Է��±��� name �Ӽ��� value �Ӽ����� �ٸ� ��� �Ű������� �Է°� ������
	//value �Ӽ��� ������ ��� �Ű������� �ڷ����� �ڵ����� �Ӽ������� ���� - ù���ڴ� �ҹ��ڷ� ����Ǿ� ���� 
	// => �Ű������� �ڷ����� �⺻��(Wrapper) �Ǵ� String�� ��� �Ӽ��� �����Ǹ� ���������� ���� ������
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd
		, @ModelAttribute("name") String name, @ModelAttribute("email") String email, @ModelAttribute("phone1") String phone1
		, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_display";
	}
	*/
	
	/*
	//�Ű������� �ڷ����� Map���� ������ ��� �Է°��� Map�� ��Ʈ���� �ڵ� ����
	// => �Է��±��� name �Ӽ����� MapKey�� �����Ǹ� �Է°��� MapValue�� ����
	//Map �Ű������� �Է°��� ����Ǳ� ���ؼ��� �ݵ�� @RequestParam ������̼� ����
	// => @RequestParam ������̼��� ������ ��� EmptyMap�� �Ű������� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("map", memberMap);
		return "join_display";
	}
	*/
	
	/*
	//�Ű������� �ڷ����� JavaBean���� ������ ��� �Է°��� JavaBean ��ü�� �ʵ忡 �ڵ� ����
	// => �Է��±��� name �Ӽ����� ���� �̸��� �ʵ忡 �Է°� ����
	//JavaBean �Ű��������� @ModelAttribute ������̼� ����
	// => @ModelAttribute ������̼� ���� ����
	//value �Ӽ����� ����Ͽ� ���������� �����ϴ� �Ӽ����� ����
	// => value �Ӽ��� ������ ��� Ŭ�������� �ڵ����� �Ӽ������� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
	//Command ��ü : �Է°��� �����Ͽ� �������� �����ϴ� ��ü
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc123")) {
			model.addAttribute("message", "�̹� ������� ���̵� �Դϴ�.");
			return "join_form";
		}
		return "join_display";
	}
}









