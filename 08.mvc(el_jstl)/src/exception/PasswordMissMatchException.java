package site.itwill.exception;

//��й�ȣ�� ���� �ʴ� ��� �߻��Ǵ� ����  
public class PasswordMissMatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissMatchException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordMissMatchException(String message) {
		super(message); 
	}
}
