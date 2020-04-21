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

//Rest(RePresentational State Transfer) 기능을 제공하는 컨트롤러
// => 하나의 요청 URL 자원이 하나의 리소스를 대표하도록 제공
// => 다양한 기기에서 요청에 대한 응답결과로 공통적으로 처리할 수 있는 
//    형식의 텍스트 데이타(XML 또는 JSON)를 전달하는 것이 목적
// => 웹사이트에서는 Ajax 기능으로 요청하여 응답결과를 제공받아 DHTML를 구현 
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
	
	//@ResponseBody : 반환결과를 ViewResolver에게 전달하지 않고 요청처리
	//메소드에서 직접 응답 처리하도록 설정하는 어노테이션
	// => 요청처리 메소드의 반환값이 ViewName이 아닌 응답결과로 제공 
	//@RequestBody : POST, PUT, DELETE 등의 요청에 의해 전달된 모든 입력값을
	//JSON 형식의 텍스트 데이타(JavaScript 객체)로 전달받아 저장하기 위한 어노테이션
	// => GET 방식으로 요청하여 전달된 데이타 저장 불가능
	// => Ajax 요청에 의해 전달된 입력값을 저장하기 위해 사용
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
	
	//클라이언트 요청에 대한 회원정보를 XML 텍스트 데이타로 응답하는 요청처리 메소드
	// => 문자열(String)이 아닌 Java 객체를 응답할 경우 500 에러 발생
	// => Java 객체를 XML 또는 JSON 형식의 텍스트 데이타(String)로 자동 변환하여 응답되도록 설정
	//Java 객체를 XML 형식의 문자열로 응답하는 메소드
	// => 반환되는 클래스 자료형에서 JAXB(Java Architecture for XML Binding) 기능을 이용하여 변환
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
	
	//클라이언트 요청에 대한 회원목록을 XML 텍스트 데이타로 응답하는 요청처리 메소드
	@RequestMapping("/xml_list")
	@ResponseBody
	public RestMemberListXML restMemberListXML() {
		RestMemberListXML listXML=new RestMemberListXML();
		listXML.setRestMemberList(restMemberService.getRestMemberListXML());
		return listXML;
	}

	//회원목록을 AJAX 기능으로 요청하여 XML로 응답받아 출력하는 요청처리 메소드
	@RequestMapping("/xml_print")
	public String displayXML() {
		return "rest/display_xml";
	}
	
	//클라이언트 요청에 대한 회원정보를 JSON 텍스트 데이타로 응답하는 요청처리 메소드
	// => jackson-databind 기능을 이용하여 Java 객체를 JSON 형식의 문자열로 자동 변환하여 응답되도록 설정
	// => Maven를 이용하여 jackson-databind 라이브러리 빌드 처리
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}
	
	//클라이언트 요청에 대한 회원목록을 JSON 텍스트 데이타로 응답하는 요청처리 메소드
	@RequestMapping("/json_list")
	@ResponseBody
	public List<RestMemberJSON> restMemberListJSON() {
		return restMemberService.getRestMemberListJSON();
	}
	
	//회원목록을 AJAX 기능으로 요청하여 JSON로 응답받아 출력하는 요청처리 메소드
	@RequestMapping("/json_print")
	public String displayJSON() {
		return "rest/display_json";
	}
	
	@RequestMapping(value = "/json_map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	//모든 입력값을 Map 객체의 엔트리로 저장받아 요청 처리
	//Map 객체를 반환하면 jackson-databind 기능을 이용하여 JSON 타입의 문자열로 응답
	// => JavaBean(DTO) 클래스가 없는 경우 Map 객체를 이용하여 응답 처리
	@RequestMapping(value = "/json_map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> input(@RequestParam Map<String, String> map) {
		return map;
	}
	
	//ResponseEntity : 요청에 대한 응답을 요청처리 메소드에서 직접 제공하기 위한 클래스
	// => @ResponseBody 어노테이션 역활을 제공하는 클래스
	// => 제네릭에 응답 객체의 자료형을 설정
	@RequestMapping("/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemberList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
			//ResponseEntity 객체 생성시 요청에 대한 응답결과와 응답코드 저장
			entity=new ResponseEntity<List<RestMemberJSON>>
				(restMemberService.getRestMemberListJSON(), HttpStatus.OK);
		} catch (Exception e) {
			//ResponseEntity 객체 생성시 요청에 대한 응답코드 저장
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
}








