package site.itwill.exception;

//����Ŭ������ Exception Ŭ���� ��ӹ޾� �ۼ�
// => �����ڿ� ���� ������ ���� �߻�
public class PasswordMissMatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissMatchException() {
		//super();
	}
	
	//���� �޼����� ���޹޾� �ʵ� �ʱⰪ���� �����ϴ� ������
	public PasswordMissMatchException(String message) {
		//�θ�Ŭ������ �����ڸ� ȣ���Ͽ� �ʵ忡 �ʱⰪ �ο�
		super(message);
	}
}







