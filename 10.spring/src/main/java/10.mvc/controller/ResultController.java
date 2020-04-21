package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//요청처리 메소드에서 뷰페이지(JSP)에서 사용할 수 있도록 처리결과를 저장하는 방법
//1.ModelAndView 인스턴스를 이용하여 처리결과 저장 - ModelAndView 반환
//2.HttpServletRequest 인스턴스를 이용하여 처리결과 저장 - String 반환
//3.Model 인스턴스를 이용하여 처리결과 저장 - String 반환

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// : ViewPage에서 사용되도록 실행결과를 저장하는 메소드(Request Scope)
		modelAndView.addObject("mav", "홍길동");		
		return modelAndView;
	}
	*/
	
	//요청처리 메소드는 Front Controller에 의해 자동 호출
	//요청처리 메소드에 매개변수를 선언하면 Spring Container로부터 인스턴스를
	//제공받아 자동으로 매개변수에 전달하여 저장 
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "홍길동");		
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "임꺽정");
		return "result_display";
	}
	
	//Model 인스턴스 : 처리결과를 저장하기 위한 인스턴스
	//Model.addObject(String attributeName, Object attributeValue)
	// : ViewPage에서 사용되도록 실행결과를 저장하는 메소드(Request Scope)
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
	
	//ModelMap 클래스 : Model 인터페이스를 상속받아 작성된 클래스 - Model 인스턴스
	@RequestMapping("/resultMap")
	public String modelResult(ModelMap map) {
		map.addAttribute("mapName", "일지매");
		return "result_display";
	}
}