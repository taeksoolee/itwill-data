package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//이메일 전송 관련 메세지 기능을 제공하는 클래스 - 횡단관심모듈
public class EmailSendAdvice {
	//이메일 전송 전 실행될 명령을 구현한 메소드 - Before Advice 메소드
	// => 타겟메소드의 매개변수값을 JoinPoint 인스턴스로 제공받아 메세지 처리
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[메세지]<"+email+">님에게 <"+subject+"> 제목의 이메일을 전송합니다.");
	}
	
	//이메일 전송이 성공한 경우 실행될 명령을 구현한 메소드 - After Returning Advice 메소드
	// => 타겟메소드의 반환값을 매개변수로 제공받아 메세지 처리
	public void successMessage(String email) {
		System.out.println("[메세지]<"+email+">님에게 이메일을 성공적으로 전송 하였습니다.");
	}

	//이메일 전송이 실패한 경우 실행될 명령을 구현한 메소드 - After Throwing Advice 메소드
	// => 타겟메소드에서 발생된 예외 인스턴스를 매개변수로 제공받아 메세지 처리
	public void failMessage(Exception exception) {
		//예외처리 명령
		System.out.println("[에러]이메일 전송 실패 = "+exception.getMessage());
	}
}
