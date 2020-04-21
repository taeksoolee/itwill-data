package site.itwill10.exception;

import site.itwill10.dto.Userinfo;

//회원등록시 사용자가 입력한 아이디가 이미 존재할 경우 발생되는 예외클래스 
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//예외처리 메소드(ExceptionHandler)에게 예외 관련 정보를 전달하기 위한 필드
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}

	public UserinfoExistsException(Userinfo userinfo, String message) {
		super(message);
		this.userinfo = userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	
	
}
