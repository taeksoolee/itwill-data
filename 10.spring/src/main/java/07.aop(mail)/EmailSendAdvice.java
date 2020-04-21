package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//�̸��� ���� ���� �޼��� ����� �����ϴ� Ŭ���� - Ⱦ�ܰ��ɸ��
public class EmailSendAdvice {
	//�̸��� ���� �� ����� ����� ������ �޼ҵ� - Before Advice �޼ҵ�
	// => Ÿ�ٸ޼ҵ��� �Ű��������� JoinPoint �ν��Ͻ��� �����޾� �޼��� ó��
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[�޼���]<"+email+">�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	}
	
	//�̸��� ������ ������ ��� ����� ����� ������ �޼ҵ� - After Returning Advice �޼ҵ�
	// => Ÿ�ٸ޼ҵ��� ��ȯ���� �Ű������� �����޾� �޼��� ó��
	public void successMessage(String email) {
		System.out.println("[�޼���]<"+email+">�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}

	//�̸��� ������ ������ ��� ����� ����� ������ �޼ҵ� - After Throwing Advice �޼ҵ�
	// => Ÿ�ٸ޼ҵ忡�� �߻��� ���� �ν��Ͻ��� �Ű������� �����޾� �޼��� ó��
	public void failMessage(Exception exception) {
		//����ó�� ���
		System.out.println("[����]�̸��� ���� ���� = "+exception.getMessage());
	}
}
