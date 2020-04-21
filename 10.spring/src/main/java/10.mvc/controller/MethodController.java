package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//�Է��������� ���� ��ûó�� �޼ҵ�
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	//����������� ���� ��ûó�� �޼ҵ�
	// => �Է°��� ���޹޾� ������������ ��µǵ��� ����
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request) throws UnsupportedEncodingException {
		//HttpServletRequest.setCharacterEncoding(String encoding) 
		// : �Է°��� ���� ĳ���ͼ��� �����ϴ� �޼ҵ�
		// => UnsupportedEncodingException �߻� - ����ó��
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output1";
	}
	
	//�Է��������� ���� ��ûó�� �޼ҵ�
	//method �Ӽ� : ��û����� �Ӽ������� ���� 
	// => Ŭ���̾�Ʈ ��û��Ŀ� ���� ��ûó�� �޼ҵ� ȣ��
	// => RequestMethod(Enum �ڷ���)�� ����ʵ带 �Ӽ������� ���
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}
	
	//����������� ���� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output2"; 
	}
}





