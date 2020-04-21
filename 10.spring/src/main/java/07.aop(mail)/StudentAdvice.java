package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//횡단관심모듈 : 횡단관심코드로 작성된 메소드가 선언된 클래스 - Advice 클래스
public class StudentAdvice {
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
	//Before Advice 메소드 : 타겟 메소드의 실행 전 삽입될 코드를 작성하기 위한 메소드
	public void beforeLog() {
		logger.info("[before]핵심관심코드 실행된 삽입되어 동작되는 횡단관심코드");
	}
	
	//After Advice 메소드 : 타겟 메소드의 실행 후 무조건 삽입될 코드를 작성하기 위한 메소드
	public void afterLog() {
		logger.info("[after]핵심관심코드 실행 후 무조건 삽입되어 동작되는 횡단관심코드");
	}
	
	//After Returning Advice 메소드 : 타겟 메소드의 정상적인 실행 후 삽입될 코드를 작성하기 위한 메소드
	public void afterReturningLog() {
		logger.info("[after-returning]핵심관심코드의 정상적인 실행 후 삽입되어 동작되는 횡단관심코드");
	}
	
	//After Throwing Advice 메소드 : 타겟 메소드 실행시 예외가 발생된 경우 삽입될 코드를 작성하기 위한 메소드
	public void afterThrowingLog() {
		logger.info("[after-throwing]핵심관심코드 실행시 예외가 발생된 경우 삽입되어 동작되는 횡단관심코드");
	}
	
	//Around Advice 메소드 : 타겟 메소드 실행 전 또는 후에 삽입될 코드를 작성하기 위한 메소드
	//Around Advice 메소드는 반환형을 Object 타입으로 설정하고 매개변수를
	//ProceedingJoinPoint 타입으로 선언하며 Throwable 예외 발생
	//ProceedingJoinPoint : 타겟메소드에 대한 정보를 저장하는 인스턴스
	// => Spring Container에 의해 인스턴스를 전달받아 매개변수에 자동 저장
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심코드 실행 전에 삽입되어 동작되는 횡단관심코드");
		//ProceedingJoinPoint.proceed() : 타겟 메소드를 호출하는 메소드
		// => 타겟 메소드의 반환값을 제공받아 저장 - 저장값 반환
		// => 타겟 메소드에서 발생되는 예외 처리 - throws 처리
		Object object=joinPoint.proceed();
		logger.info("[around]핵심관심코드 실행 후에 삽입되어 동작되는 횡단관심코드");
		return object;
	}
}





