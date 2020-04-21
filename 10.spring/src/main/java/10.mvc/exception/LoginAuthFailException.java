package site.itwill10.exception;

//회원 인증 실패시 발생되는 예외클래스
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}

	public LoginAuthFailException(String userid, String message) {
		super(message);
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
