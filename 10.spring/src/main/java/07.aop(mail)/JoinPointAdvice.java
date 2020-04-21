package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class JoinPointAdvice {
	//Around Advice �޼ҵ�� �⺻������ ��ȯ���� Object Ÿ������ �����ϰ�
	//ProceedingJoinPoint �Ű������� �̿��Ͽ� �޼ҵ� ����
	// => Ÿ�ٸ޼ҵ忡�� �߻��Ǵ� ���ܸ� Throwable Ÿ������ �����Ͽ� ���� ó�� 
	
	//Around Advice �޼ҵ带 ������ �ٸ� Advice �޼ҵ�� �⺻������ ��ȯ����
	//void �ϰ� �Ű����� ���� �޼ҵ� ����
	// => Around Advice �޼ҵ带 ������ �ٸ� Advice �޼ҵ�� JoinPoint �ڷ����� �Ű����� ���� ����
	// => Advice �޼ҵ忡 ���� �ٸ� �ڷ����� �Ű������� ����
	// => ����� �Ű��������� Spring Container�� ���� �ν��Ͻ��� �ڵ� ����
	
	//JoinPoint : Ÿ�� �޼ҵ��� ������ �����ϴ� �ν��Ͻ�
	// => Advice �޼ҵ忡�� Ÿ�� �޼ҵ� ������ �̿��Ͽ� Ⱦ�ܰ����ڵ� �ۼ�
	// => ProceedingJoinPoint �ν��Ͻ��� Ÿ�� �޼ҵ� ȣ�� ����
	
	//Before Advice �޼ҵ�
	public void displayTarget(JoinPoint joinPoint) {
		//System.out.println("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		
		/*
		//JoinPoint.getTarget() : Ÿ�� �޼ҵ带 ȣ���ϴ� �ٽɰ��ɸ��(�ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		//Object.getClass() : �ٽɰ��ɸ��(�ν��Ͻ�)�� Ŭ����(Clazz)�� ��ȯ�ϴ� �޼ҵ�
		//Class.getName() : Ŭ����(Clazz)�� ��Ű���� ������ Ŭ�������� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getTarget().getClass().getName());
		
		//Class.getSimpleName() : Ŭ����(Clazz)�� Ŭ�������� ��ȯ�ϴ� �޼ҵ�
		String className=joinPoint.getTarget().getClass().getSimpleName();
		
		//JoinPoint.getSignature() : Ÿ�� �޼ҵ��� ����(Signature �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
		//Signature.getName() : Ÿ�� �޼ҵ��� �̸��� ��ȯ�ϴ� �޼ҵ�
		String methodName=joinPoint.getSignature().getName();
		System.out.println("[before]"+className+" Ŭ������ "+methodName+"() �޼ҵ� ȣ��");
		*/
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		//JoinPoint.getArgs() : Ÿ�� �޼ҵ��� �Ű������� Object �迭�� ��ȯ�ϴ� �޼ҵ� 
		Object[] objects=joinPoint.getArgs();		
		System.out.println("[before]"+className+" Ŭ������ "+methodName+"() �޼ҵ��� �Ű����� ���� = "+objects.length);
	}
	
	//After Returning Advice �޼ҵ�
	// => �Ű������� �����Ͽ� Ÿ�ٸ޼ҵ��� ��ȯ���� ���޹޾� ����
	// => Ÿ�ٸ޼ҵ��� ��ȯ���� �������� ���� ��� �Ű������� Object Ÿ������ ����
	public void displayName(Object object) {
		//System.out.println("[after-returning]�ٽɰ����ڵ� ���� ���� �Ŀ� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"�� ȯ���մϴ�.");
		}
	}
	
	//After Throwing Advice �޼ҵ�
	// => �Ű������� �����Ͽ� Ÿ�ٸ޼ҵ��� ���������� ���޹޾� ����
	// => Ÿ�ٸ޼ҵ��� ���ܸ� �������� ���� ��� �Ű������� Exception Ÿ������ ����
	public void displayException(Exception exception) {
		//System.out.println("[after-throwing]�ٽɰ����ڵ� ���� �� ���ܰ� �߻��� ��� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		System.out.println("[after-throwing]���� �޼��� = "+exception.getMessage());
	}
}








