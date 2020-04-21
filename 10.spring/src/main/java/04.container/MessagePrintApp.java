package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container를 이용하여 인스턴스를 제공받아 사용
// => 개발자가 아닌 Spring Container가 인스턴스를 생성하여 제공 - IoC
// => Spring Bean Configuration File(XML)을 이용하여 인스턴스 생성과 의존관계에 대한 설정
public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);//포함관계(의존관계) 설정
		print.messagePrint();
		*/

		//ApplicationContext 인스턴스 생성 - Spring Container
		// => Spring Bean Configuration File을 읽어 Spring Bean 생성
		ApplicationContext context
			=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container로부터 Spring Bean를 제공받아 저장
		// => bean 엘리먼트의 고유값을 전달하여 원하는 Spring Bean 반환
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		//Spring Container 제거
		((ClassPathXmlApplicationContext)context).close();
	}
}





