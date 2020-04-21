package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//입력페이지에 대한 요청처리 메소드
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	//출력페이지에 대한 요청처리 메소드
	// => 입력값을 전달받아 뷰페이지에서 출력되도록 제공
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request) throws UnsupportedEncodingException {
		//HttpServletRequest.setCharacterEncoding(String encoding) 
		// : 입력값에 대한 캐릭터셋을 변경하는 메소드
		// => UnsupportedEncodingException 발생 - 예외처리
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output1";
	}
	
	//입력페이지에 대한 요청처리 메소드
	//method 속성 : 요청방식을 속성값으로 설정 
	// => 클라이언트 요청방식에 의해 요청처리 메소드 호출
	// => RequestMethod(Enum 자료형)의 상수필드를 속성값으로 사용
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	//출력페이지에 대한 요청처리 메소드
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output2"; 
	}
}





