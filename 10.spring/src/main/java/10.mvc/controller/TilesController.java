package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	//����Ʈ�� ���� �������� ��û�� ��� ȣ��Ǵ� �޼ҵ�
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template() {
		//tiles.xml ���Ͽ� ����� definition ������Ʈ�� ������(name �Ӽ���)��
		//ViewName���� ��ȯ�ϸ� ������ ���ø� ������(JSP)�� ���� ó��
		return "main";
	}
	
	@RequestMapping(value = "/tiles1")
	public String tiles1() {
		//��ȯ�Ǵ� ViewName�� definition ������Ʈ�� �������� JSP ���ϸ����� ����
		return "hello_tiles";
	}
	
	@RequestMapping(value = "/tiles2")
	public String tiles2() {
		return "tiles/hi_tiles";
	}
	
	@RequestMapping(value = "/tiles3")
	public String tiles3() {
		return "tiles/good/bye_tiles";
	}
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/admin_hello")
	public String adminHello() {
		return "admin/hello";
	}
}
