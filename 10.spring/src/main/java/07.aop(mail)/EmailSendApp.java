package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-3_email.xml");
		System.out.println("===============================================================================");
		EmailSendBean bean=context.getBean("emailSendBean",EmailSendBean.class);
		bean.sendEmail("ocj1778@hanmail.net"
				, "JavaMail ����� �̿��� �̸��� ����"
				, "�� �����ߴ��� ���� ��Ź �帳�ϴ�.");		
		System.out.println("===============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
