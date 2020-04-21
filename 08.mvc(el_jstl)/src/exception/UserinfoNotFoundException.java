package site.itwill.exception;

//회원정보가 검색되지 않은 경우 발생되는 예외  
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message); 
	}
}
