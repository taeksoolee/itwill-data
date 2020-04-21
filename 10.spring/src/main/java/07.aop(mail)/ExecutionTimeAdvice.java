package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	//Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð�(ms)�� ����Ͽ� ����ϱ� ���� �޼ҵ�
	// => Around Advice �޼ҵ�
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//Ÿ�ٸ޼ҵ��� ��� ���� �� �ý����� ���� �ð�����(TimeStamp)�� ��ȯ�޾� ����
		long startTime=System.currentTimeMillis();
		
		//Ÿ�ٸ޼ҵ��� ��� ���� - Ÿ�ٸ޼ҵ� ȣ��
		Object object=joinPoint.proceed();
		
		//Ÿ�ٸ޼ҵ��� ��� ���� �� �ý����� ���� �ð������� ��ȯ�޾� ����
		long stopTime=System.currentTimeMillis();
		
		logger.info("����ð� = "+(stopTime-startTime)+"ms");
		
		//Ÿ�ٸ޼ҵ��� ���� ����� ��ȯ
		return object;
		*/
		
		//StopWatch : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : �ð� ���� ���� �޼ҵ�
		stopWatch.start();
		
		Object object=joinPoint.proceed();
		
		//StopWatch.stop() : �ð� ���� ���� �޼ҵ�
		stopWatch.stop();

		logger.info("����ð� = "+stopWatch.getTotalTimeMillis()+"ms");
		
		return object;
	}
}
