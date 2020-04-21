package site.itwill.exception;

//예외클래스는 Exception 클래스 상속받아 작성
// => 개발자에 의해 인위적 예외 발생
public class PasswordMissMatchException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PasswordMissMatchException() {
		//super();
	}
	
	//예외 메세지를 전달받아 필드 초기값으로 저장하는 생성자
	public PasswordMissMatchException(String message) {
		//부모클래스의 생성자를 호출하여 필드에 초기값 부여
		super(message);
	}
}







