package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect : Spring Bean으로 등록된 클래스에 Aspect 기능을 제공하기 위한 어노테이션
// => Bean Configuration File의 aspect 엘리먼트와 유사한 역활 수행
@Aspect
public class AopAnnotationAdvice {
	private static final Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class);
	
	//@Pointcut : PointCut을 설정하기 위한 어노테이션
	// => Bean Configuration File의 pointcut 엘리먼트와 유사한 역활 수행
	// => PointCut 설정에 대한 재사용을 위해 설정
	// => 메소드명와 매개변수가 PointCut 고유값으로 인식되어 메소드 호출 형태로 PointCut 사용
	// => 다른 클래스에 PointCut 설정 가능
	//value 속성 : PointCut을 지정하기 위한 정보(execution 또는 within)를 속성값으로 설정
	// => 다른 속성이 없는 경우 속성값만 설정 가능
	@Pointcut("within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}

	//@Before : Before Advice 메소드를 설정하는 어노테이션
	// => Bean Configuration File의 before 엘리먼트와 유사한 역활 수행
	//value 속성 : PointCut을 지정하기 위한 정보(execution 또는 within)를 속성값으로 설정
	// => value 속성값으로 @Pointcut 어노테이션의 메소드 호출하여 사용
	//@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		logger.info("[before]핵심관심코드 실행 전 삽입되어 실행되는 횡단관심코드");
	}
	
	//@AfterReturning : After Returning Advice 메소드를 설정하는 어노테이션 
	// => Bean Configuration File의 after-returning 엘리먼트와 유사한 역활 수행
	// => value 속성값 대신 pointcut 속성 사용 가능 
	//returning 속성 : 타겟메소드의 반환값을 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterReturning(pointcut = "aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning]핵심관심코드 정상 실행 후 삽입되어 실행되는 횡단관심코드");
	}
	
	//@AfterThrowing : After Throwing Advice 메소드를 설정하는 어노테이션 
	// => Bean Configuration File의 after-throwing 엘리먼트와 유사한 역활 수행
	// => value 속성값 대신 pointcut 속성 사용 가능 
	//throwing 속성 : 타겟메소드의 예외정보를 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing]핵심관심코드에서 예외 발생 후 삽입되어 실행되는 횡단관심코드");
	}
	
	//@After : After Advice 메소드를 설정하는 어노테이션 
	// => Bean Configuration File의 after 엘리먼트와 유사한 역활 수행
	@After("aopPointCut()")
	public void afterLog() {
		logger.info("[after]핵심관심코드 실행 후 무조건 삽입되어 실행되는 횡단관심코드");
	}
	
	//@Around : Around Advice 메소드를 설정하는 어노테이션 
	// => Bean Configuration File의 around 엘리먼트와 유사한 역활 수행
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심코드 실행 전 삽입되어 실행되는 횡단관심코드");
		Object object=joinPoint.proceed();
		logger.info("[around]핵심관심코드 실행 후 삽입되어 실행되는 횡단관심코드");
		return object;
	}
}








