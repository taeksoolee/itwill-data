package site.itwill.exception;

//예외를 위해 개발자가 직접 작성한 클래스 : Exception 클래스를 상속받아 작성
//회원정보 저장 전 중복 아이디가 입력될 경우 발생되는 예외  
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message) {
		super(message); 
	}
}
