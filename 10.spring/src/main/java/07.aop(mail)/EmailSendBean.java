package site.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//이메일 전송 기능을 제공하는 클래스 - 핵심관심모듈
public class EmailSendBean {
	//이메일 전송을 위한 JavaMailSender 인스턴스를 저장하기 위한 필드
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	//이메일 전송 메소드 - 핵심관심코드
	// => 받는 사람의 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	// => 받는 사람의 이메일 주소 반환 - 로그
	public String sendEmail(String email, String subject, String content) {
		//JavaMailSender.createMimeMessage() : MimeMessage 인스턴스를 반환하는 메소드
		//MimeMessage : 이메일 전송 관련 정보를 저장하기 위한 클래스 
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			//MimeMessage.setSubject(String subject) : 이메일 제목을 변경하는 메소드
			message.setSubject(subject);
			
			//MimeMessage.setText(String text) : 이메일 내용을 변경하는 메소드
			// => 텍스트 메세지로만 변경하여 전달 가능
			message.setText(content);
			
			//MimeMessage.setRecipients(RecipientType type, InternetAddress email) : 
			//이메일을 받는 사람에 대한 정보를 변경하는 메소드 - 받는 사람의 이메일 주소 변경
			// => 받는 사람의 이메일 주소는 InternetAddress 인스턴스 대신 문자열(String) 전달 가능 
			//InternetAddress.parse(String addressList) : 문자열을 전달받아
			//InternetAddress 인스턴스 배열로 변환하여 반환하는 메소드
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			//JavaMailSender.send(MimeMessage message) : 이메일을 전송하는 메소드
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}










