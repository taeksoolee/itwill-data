package site.itwill.exception;

//비밀번호가 맞지 않는 경우 발생되는 예외  
public class PasswordMissMatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissMatchException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordMissMatchException(String message) {
		super(message); 
	}
}
