package site.itwill.exception;

//ȸ�������� �˻����� ���� ��� �߻��Ǵ� ����  
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message); 
	}
}
