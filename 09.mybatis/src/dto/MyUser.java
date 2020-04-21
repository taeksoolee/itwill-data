package site.itwill.dto;

/*
MYUSER 테이블 : 회원정보를 저장하기 위한 테이블 - 아이디, 이름
=> DBMS 식별자는 대소문자를 구분하지 않으므로 언더바 표기법(UnderCase)를 이용하여 단어 구분
 
이름        널?       유형           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(20) 
USER_NAME          VARCHAR2(30) 
*/

public class MyUser {
	//Java 식별자는 대소문자를 구분하므로 카멜표기법(CamelCase)를 이용하여 단어 구분
	private String userId;
	private String userName;
	
	public MyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}







