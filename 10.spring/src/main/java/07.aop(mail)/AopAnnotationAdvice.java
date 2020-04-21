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
//@Aspect : Spring Bean���� ��ϵ� Ŭ������ Aspect ����� �����ϱ� ���� ������̼�
// => Bean Configuration File�� aspect ������Ʈ�� ������ ��Ȱ ����
@Aspect
public class AopAnnotationAdvice {
	private static final Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class);
	
	//@Pointcut : PointCut�� �����ϱ� ���� ������̼�
	// => Bean Configuration File�� pointcut ������Ʈ�� ������ ��Ȱ ����
	// => PointCut ������ ���� ������ ���� ����
	// => �޼ҵ��� �Ű������� PointCut ���������� �νĵǾ� �޼ҵ� ȣ�� ���·� PointCut ���
	// => �ٸ� Ŭ������ PointCut ���� ����
	//value �Ӽ� : PointCut�� �����ϱ� ���� ����(execution �Ǵ� within)�� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Pointcut("within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}

	//@Before : Before Advice �޼ҵ带 �����ϴ� ������̼�
	// => Bean Configuration File�� before ������Ʈ�� ������ ��Ȱ ����
	//value �Ӽ� : PointCut�� �����ϱ� ���� ����(execution �Ǵ� within)�� �Ӽ������� ����
	// => value �Ӽ������� @Pointcut ������̼��� �޼ҵ� ȣ���Ͽ� ���
	//@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//@AfterReturning : After Returning Advice �޼ҵ带 �����ϴ� ������̼� 
	// => Bean Configuration File�� after-returning ������Ʈ�� ������ ��Ȱ ����
	// => value �Ӽ��� ��� pointcut �Ӽ� ��� ���� 
	//returning �Ӽ� : Ÿ�ٸ޼ҵ��� ��ȯ���� �����ϱ� ���� �Ű��������� �Ӽ������� ����
	@AfterReturning(pointcut = "aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning]�ٽɰ����ڵ� ���� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//@AfterThrowing : After Throwing Advice �޼ҵ带 �����ϴ� ������̼� 
	// => Bean Configuration File�� after-throwing ������Ʈ�� ������ ��Ȱ ����
	// => value �Ӽ��� ��� pointcut �Ӽ� ��� ���� 
	//throwing �Ӽ� : Ÿ�ٸ޼ҵ��� ���������� �����ϱ� ���� �Ű��������� �Ӽ������� ����
	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing]�ٽɰ����ڵ忡�� ���� �߻� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//@After : After Advice �޼ҵ带 �����ϴ� ������̼� 
	// => Bean Configuration File�� after ������Ʈ�� ������ ��Ȱ ����
	@After("aopPointCut()")
	public void afterLog() {
		logger.info("[after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//@Around : Around Advice �޼ҵ带 �����ϴ� ������̼� 
	// => Bean Configuration File�� around ������Ʈ�� ������ ��Ȱ ����
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
		Object object=joinPoint.proceed();
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
		return object;
	}
}








