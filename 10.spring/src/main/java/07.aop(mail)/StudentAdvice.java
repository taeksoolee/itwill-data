package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Ⱦ�ܰ��ɸ�� : Ⱦ�ܰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ���� - Advice Ŭ����
public class StudentAdvice {
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
	//Before Advice �޼ҵ� : Ÿ�� �޼ҵ��� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ����� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//After Advice �޼ҵ� : Ÿ�� �޼ҵ��� ���� �� ������ ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterLog() {
		logger.info("[after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//After Returning Advice �޼ҵ� : Ÿ�� �޼ҵ��� �������� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterReturningLog() {
		logger.info("[after-returning]�ٽɰ����ڵ��� �������� ���� �� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//After Throwing Advice �޼ҵ� : Ÿ�� �޼ҵ� ����� ���ܰ� �߻��� ��� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterThrowingLog() {
		logger.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
	//Around Advice �޼ҵ� : Ÿ�� �޼ҵ� ���� �� �Ǵ� �Ŀ� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	//Around Advice �޼ҵ�� ��ȯ���� Object Ÿ������ �����ϰ� �Ű�������
	//ProceedingJoinPoint Ÿ������ �����ϸ� Throwable ���� �߻�
	//ProceedingJoinPoint : Ÿ�ٸ޼ҵ忡 ���� ������ �����ϴ� �ν��Ͻ�
	// => Spring Container�� ���� �ν��Ͻ��� ���޹޾� �Ű������� �ڵ� ����
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
		//ProceedingJoinPoint.proceed() : Ÿ�� �޼ҵ带 ȣ���ϴ� �޼ҵ�
		// => Ÿ�� �޼ҵ��� ��ȯ���� �����޾� ���� - ���尪 ��ȯ
		// => Ÿ�� �޼ҵ忡�� �߻��Ǵ� ���� ó�� - throws ó��
		Object object=joinPoint.proceed();
		logger.info("[around]�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
		return object;
	}
}





