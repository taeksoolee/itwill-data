package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//��ûó�� �޼ҵ忡�� ��������(JSP)���� ����� �� �ֵ��� ó������� �����ϴ� ���
//1.ModelAndView �ν��Ͻ��� �̿��Ͽ� ó����� ���� - ModelAndView ��ȯ
//2.HttpServletRequest �ν��Ͻ��� �̿��Ͽ� ó����� ���� - String ��ȯ
//3.Model �ν��Ͻ��� �̿��Ͽ� ó����� ���� - String ��ȯ

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// : ViewPage���� ���ǵ��� �������� �����ϴ� �޼ҵ�(Request Scope)
		modelAndView.addObject("mav", "ȫ�浿");		
		return modelAndView;
	}
	*/
	
	//��ûó�� �޼ҵ�� Front Controller�� ���� �ڵ� ȣ��
	//��ûó�� �޼ҵ忡 �Ű������� �����ϸ� Spring Container�κ��� �ν��Ͻ���
	//�����޾� �ڵ����� �Ű������� �����Ͽ� ���� 
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "ȫ�浿");		
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("requestName", "�Ӳ���");
		return "result_display";
	}
	
	//Model �ν��Ͻ� : ó������� �����ϱ� ���� �ν��Ͻ�
	//Model.addObject(String attributeName, Object attributeValue)
	// : ViewPage���� ���ǵ��� �������� �����ϴ� �޼ҵ�(Request Scope)
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
	
	//ModelMap Ŭ���� : Model �������̽��� ��ӹ޾� �ۼ��� Ŭ���� - Model �ν��Ͻ�
	@RequestMapping("/resultMap")
	public String modelResult(ModelMap map) {
		map.addAttribute("mapName", "������");
		return "result_display";
	}
}