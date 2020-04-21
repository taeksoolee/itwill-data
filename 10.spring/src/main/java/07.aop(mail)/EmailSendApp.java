package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-3_email.xml");
		System.out.println("===============================================================================");
		EmailSendBean bean=context.getBean("emailSendBean",EmailSendBean.class);
		bean.sendEmail("ocj1778@hanmail.net"
				, "JavaMail 기능을 이용한 이메일 전송"
				, "잘 도착했는지 답장 부탁 드립니다.");		
		System.out.println("===============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
