package site.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//�̸��� ���� ����� �����ϴ� Ŭ���� - �ٽɰ��ɸ��
public class EmailSendBean {
	//�̸��� ������ ���� JavaMailSender �ν��Ͻ��� �����ϱ� ���� �ʵ�
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	//�̸��� ���� �޼ҵ� - �ٽɰ����ڵ�
	// => �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	// => �޴� ����� �̸��� �ּ� ��ȯ - �α�
	public String sendEmail(String email, String subject, String content) {
		//JavaMailSender.createMimeMessage() : MimeMessage �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//MimeMessage : �̸��� ���� ���� ������ �����ϱ� ���� Ŭ���� 
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			//MimeMessage.setSubject(String subject) : �̸��� ������ �����ϴ� �޼ҵ�
			message.setSubject(subject);
			
			//MimeMessage.setText(String text) : �̸��� ������ �����ϴ� �޼ҵ�
			// => �ؽ�Ʈ �޼����θ� �����Ͽ� ���� ����
			message.setText(content);
			
			//MimeMessage.setRecipients(RecipientType type, InternetAddress email) : 
			//�̸����� �޴� ����� ���� ������ �����ϴ� �޼ҵ� - �޴� ����� �̸��� �ּ� ����
			// => �޴� ����� �̸��� �ּҴ� InternetAddress �ν��Ͻ� ��� ���ڿ�(String) ���� ���� 
			//InternetAddress.parse(String addressList) : ���ڿ��� ���޹޾�
			//InternetAddress �ν��Ͻ� �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			//JavaMailSender.send(MimeMessage message) : �̸����� �����ϴ� �޼ҵ�
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}










