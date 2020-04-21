package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class JoinPointAdvice {
	//Around Advice 메소드는 기본적으로 반환형을 Object 타입으로 선언하고
	//ProceedingJoinPoint 매개변수를 이용하여 메소드 선언
	// => 타겟메소드에서 발생되는 예외를 Throwable 타입으로 제공하여 예외 처리 
	
	//Around Advice 메소드를 제외한 다른 Advice 메소드는 기본적으로 반환형을
	//void 하고 매개변수 없이 메소드 선언
	// => Around Advice 메소드를 제외한 다른 Advice 메소드는 JoinPoint 자료형의 매개변수 선언 가능
	// => Advice 메소드에 따라 다른 자료형의 매개변수를 선언
	// => 선언된 매개변수에는 Spring Container에 의해 인스턴스가 자동 저장
	
	//JoinPoint : 타겟 메소드의 정보를 저장하는 인스턴스
	// => Advice 메소드에서 타겟 메소드 정보를 이용하여 횡단관심코드 작성
	// => ProceedingJoinPoint 인스턴스는 타겟 메소드 호출 가능
	
	//Before Advice 메소드
	public void displayTarget(JoinPoint joinPoint) {
		//System.out.println("[before]핵심관심코드 실행 전에 삽입되어 동작될 횡단관심코드");
		
		/*
		//JoinPoint.getTarget() : 타겟 메소드를 호출하는 핵심관심모듈(인스턴스)를 반환하는 메소드
		//Object.getClass() : 핵심관심모듈(인스턴스)의 클래스(Clazz)을 반환하는 메소드
		//Class.getName() : 클래스(Clazz)의 패키지를 포함한 클래스명을 반환하는 메소드
		//System.out.println(joinPoint.getTarget().getClass().getName());
		
		//Class.getSimpleName() : 클래스(Clazz)의 클래스명을 반환하는 메소드
		String className=joinPoint.getTarget().getClass().getSimpleName();
		
		//JoinPoint.getSignature() : 타겟 메소드의 정보(Signature 인스턴스)를 반환하는 메소드
		//Signature.getName() : 타겟 메소드의 이름을 반환하는 메소드
		String methodName=joinPoint.getSignature().getName();
		System.out.println("[before]"+className+" 클래스의 "+methodName+"() 메소드 호출");
		*/
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		//JoinPoint.getArgs() : 타겟 메소드의 매개변수를 Object 배열로 반환하는 메소드 
		Object[] objects=joinPoint.getArgs();		
		System.out.println("[before]"+className+" 클래스의 "+methodName+"() 메소드의 매개변수 갯수 = "+objects.length);
	}
	
	//After Returning Advice 메소드
	// => 매개변수를 선언하여 타겟메소드의 반환값을 전달받아 저장
	// => 타겟메소드의 반환형을 지정하지 않은 경우 매개변수를 Object 타입으로 설정
	public void displayName(Object object) {
		//System.out.println("[after-returning]핵심관심코드 정상 실행 후에 삽입되어 동작될 횡단관심코드");
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"님 환영합니다.");
		}
	}
	
	//After Throwing Advice 메소드
	// => 매개변수를 선언하여 타겟메소드의 예외정보를 전달받아 저장
	// => 타겟메소드의 예외를 지정하지 않은 경우 매개변수를 Exception 타입으로 설정
	public void displayException(Exception exception) {
		//System.out.println("[after-throwing]핵심관심코드 실행 시 예외가 발생될 경우 삽입되어 동작될 횡단관심코드");
		System.out.println("[after-throwing]예외 메세지 = "+exception.getMessage());
	}
}








