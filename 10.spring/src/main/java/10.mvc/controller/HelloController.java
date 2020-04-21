package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller : Command Controller ��Ȱ�� Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => �⺻������ Ŭ�������� beanName���� ���� - �Ӽ��� �̿��Ͽ� ���� ���� 
// => Controller �������̽��� ��ӹ��� �ʾƵ� Command Controller Ŭ������ �ۼ� ����
// => @RequestMapping ������̼��� �̿��Ͽ� Ŭ���̾�Ʈ ��û�� ���� ó�� �޼ҵ带 ���� �� ���� ���� 
@Controller
public class HelloController {
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);
	//��û ó���޼ҵ忡�� Front Controller���� ViewName�� �����ϴ� ���
	// => Front Controller�� ViewName�� ���޹޾� ViewResolver Ŭ������ �̿��Ͽ� JSP ���ϰ�η� ��ȯ�Ͽ� ������ �̵�
	//1.��û ó���޼ҵ��� ��ȯ���� void�� �����Ͽ� �޼ҵ���� ViewName���� ����
	//2.��û ó���޼ҵ��� ��ȯ���� String�� �����Ͽ� ��ȯ��(String)�� ViewName���� ����
	//3.��û ó���޼ҵ��� ��ȯ���� ModelAndView�� �����Ͽ� ��ȯ��(ModelAndView)�� ViewName���� ����
	
	//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ� 
	//@RequestMapping : Ŭ���̾�Ʈ ��û������ �����޾� ó���޼ҵ带 ȣ���Ͽ� �����ϴ� ������̼�
	//value �Ӽ� : Ŭ���̾�Ʈ ��û������ �Ӽ������� ���� - �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ���� 
	@RequestMapping(value = "/hello")
	public void hello() {
		//��ûó�� ��� ���� - Service Ŭ������ �޼ҵ� ȣ��
		logger.info("/hello ��û >> HelloController Ŭ������ hello() �޼ҵ� ȣ�� ");
	}
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/helloViewName ��û >> HelloController Ŭ������ helloViewName() �޼ҵ� ȣ�� ");
		return "hello";
	}
	
	//ModelAndView : ��ûó���� ���� ������� ViewName�� �����ϱ� ���� Ŭ����
	@RequestMapping("/helloMAV")
	public ModelAndView helloModelAndView() {
		logger.info("/helloMAV ��û >> HelloController Ŭ������ helloModelAndView() �޼ҵ� ȣ�� ");
		/*
		ModelAndView modelAndView=new ModelAndView();
		//ModelAndView.setViewName(String viewName) : ViewName�� �����ϴ� �޼ҵ�
		modelAndView.setViewName("hello");
		*/

		//ModelAndView Ŭ������ �����ڸ� �̿��Ͽ� ViewName�� �ʱ�ȭ�Ͽ� ����	
		ModelAndView modelAndView=new ModelAndView("hello");
		return modelAndView;
	}
}











