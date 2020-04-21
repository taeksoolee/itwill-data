package site.itwill10.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberListXML;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.service.RestMemberService;

//Rest(RePresentational State Transfer) ����� �����ϴ� ��Ʈ�ѷ�
// => �ϳ��� ��û URL �ڿ��� �ϳ��� ���ҽ��� ��ǥ�ϵ��� ����
// => �پ��� ��⿡�� ��û�� ���� �������� ���������� ó���� �� �ִ� 
//    ������ �ؽ�Ʈ ����Ÿ(XML �Ǵ� JSON)�� �����ϴ� ���� ����
// => ������Ʈ������ Ajax ������� ��û�Ͽ� �������� �����޾� DHTML�� ���� 
@Controller
public class RestfulController {
	@Autowired
	private RestMemberService restMemberService;
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id
			, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/
	
	//@ResponseBody : ��ȯ����� ViewResolver���� �������� �ʰ� ��ûó��
	//�޼ҵ忡�� ���� ���� ó���ϵ��� �����ϴ� ������̼�
	// => ��ûó�� �޼ҵ��� ��ȯ���� ViewName�� �ƴ� �������� ���� 
	//@RequestBody : POST, PUT, DELETE ���� ��û�� ���� ���޵� ��� �Է°���
	//JSON ������ �ؽ�Ʈ ����Ÿ(JavaScript ��ü)�� ���޹޾� �����ϱ� ���� ������̼�
	// => GET ������� ��û�Ͽ� ���޵� ����Ÿ ���� �Ұ���
	// => Ajax ��û�� ���� ���޵� �Է°��� �����ϱ� ���� ���
	/*
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody 	
	public String rest(@RequestBody String input) {
		return input;
	}
	*/
	
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public @ResponseBody String rest(@RequestBody String input) {
		return input;
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ�������� XML �ؽ�Ʈ ����Ÿ�� �����ϴ� ��ûó�� �޼ҵ�
	// => ���ڿ�(String)�� �ƴ� Java ��ü�� ������ ��� 500 ���� �߻�
	// => Java ��ü�� XML �Ǵ� JSON ������ �ؽ�Ʈ ����Ÿ(String)�� �ڵ� ��ȯ�Ͽ� ����ǵ��� ����
	//Java ��ü�� XML ������ ���ڿ��� �����ϴ� �޼ҵ�
	// => ��ȯ�Ǵ� Ŭ���� �ڷ������� JAXB(Java Architecture for XML Binding) ����� �̿��Ͽ� ��ȯ
	@RequestMapping("/xml_member")
	@ResponseBody
	public RestMemberXML restMemberXML() {
		return restMemberService.getRestMemberListXML().get(0);
	}
	
	/*
	@RequestMapping("/xml_list")
	@ResponseBody
	public List<RestMemberXML> restMemberListXML() {
		return restMemberService.getRestMemberListXML();
	}
	*/
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ������� XML �ؽ�Ʈ ����Ÿ�� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/xml_list")
	@ResponseBody
	public RestMemberListXML restMemberListXML() {
		RestMemberListXML listXML=new RestMemberListXML();
		listXML.setRestMemberList(restMemberService.getRestMemberListXML());
		return listXML;
	}

	//ȸ������� AJAX ������� ��û�Ͽ� XML�� ����޾� ����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/xml_print")
	public String displayXML() {
		return "rest/display_xml";
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ�������� JSON �ؽ�Ʈ ����Ÿ�� �����ϴ� ��ûó�� �޼ҵ�
	// => jackson-databind ����� �̿��Ͽ� Java ��ü�� JSON ������ ���ڿ��� �ڵ� ��ȯ�Ͽ� ����ǵ��� ����
	// => Maven�� �̿��Ͽ� jackson-databind ���̺귯�� ���� ó��
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ������� JSON �ؽ�Ʈ ����Ÿ�� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/json_list")
	@ResponseBody
	public List<RestMemberJSON> restMemberListJSON() {
		return restMemberService.getRestMemberListJSON();
	}
	
	//ȸ������� AJAX ������� ��û�Ͽ� JSON�� ����޾� ����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/json_print")
	public String displayJSON() {
		return "rest/display_json";
	}
	
	@RequestMapping(value = "/json_map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	//��� �Է°��� Map ��ü�� ��Ʈ���� ����޾� ��û ó��
	//Map ��ü�� ��ȯ�ϸ� jackson-databind ����� �̿��Ͽ� JSON Ÿ���� ���ڿ��� ����
	// => JavaBean(DTO) Ŭ������ ���� ��� Map ��ü�� �̿��Ͽ� ���� ó��
	@RequestMapping(value = "/json_map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> input(@RequestParam Map<String, String> map) {
		return map;
	}
	
	//ResponseEntity : ��û�� ���� ������ ��ûó�� �޼ҵ忡�� ���� �����ϱ� ���� Ŭ����
	// => @ResponseBody ������̼� ��Ȱ�� �����ϴ� Ŭ����
	// => ���׸��� ���� ��ü�� �ڷ����� ����
	@RequestMapping("/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemberList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
			//ResponseEntity ��ü ������ ��û�� ���� �������� �����ڵ� ����
			entity=new ResponseEntity<List<RestMemberJSON>>
				(restMemberService.getRestMemberListJSON(), HttpStatus.OK);
		} catch (Exception e) {
			//ResponseEntity ��ü ������ ��û�� ���� �����ڵ� ����
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
}








