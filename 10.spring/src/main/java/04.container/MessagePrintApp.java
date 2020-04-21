package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container�� �̿��Ͽ� �ν��Ͻ��� �����޾� ���
// => �����ڰ� �ƴ� Spring Container�� �ν��Ͻ��� �����Ͽ� ���� - IoC
// => Spring Bean Configuration File(XML)�� �̿��Ͽ� �ν��Ͻ� ������ �������迡 ���� ����
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);//���԰���(��������) ����
		print.messagePrint();
		*/

		//ApplicationContext �ν��Ͻ� ���� - Spring Container
		// => Spring Bean Configuration File�� �о� Spring Bean ����
		ApplicationContext context
			=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container�κ��� Spring Bean�� �����޾� ����
		// => bean ������Ʈ�� �������� �����Ͽ� ���ϴ� Spring Bean ��ȯ
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		//Spring Container ����
		((ClassPathXmlApplicationContext)context).close();
	}
}





