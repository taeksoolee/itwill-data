package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	//타겟메소드의 명령이 실행되는 처리시간(ms)을 계산하여 기록하기 위한 메소드
	// => Around Advice 메소드
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//타겟메소드의 명령 실행 전 시스템의 현재 시간정보(TimeStamp)를 반환받아 저장
		long startTime=System.currentTimeMillis();
		
		//타겟메소드의 명령 실행 - 타겟메소드 호출
		Object object=joinPoint.proceed();
		
		//타겟메소드의 명령 실행 후 시스템의 현재 시간정보를 반환받아 저장
		long stopTime=System.currentTimeMillis();
		
		logger.info("실행시간 = "+(stopTime-startTime)+"ms");
		
		//타겟메소드의 실행 결과값 반환
		return object;
		*/
		
		//StopWatch : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : 시간 측정 시작 메소드
		stopWatch.start();
		
		Object object=joinPoint.proceed();
		
		//StopWatch.stop() : 시간 측정 종료 메소드
		stopWatch.stop();

		logger.info("실행시간 = "+stopWatch.getTotalTimeMillis()+"ms");
		
		return object;
	}
}
