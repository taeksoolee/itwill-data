package site.itwill10.dto;

/*
이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(200) 
EMAIL             VARCHAR2(300) 
STATUS            NUMBER(1)     
*/

public class Userinfo {
	private String userid;
	private String password;
	private String name;
	private String email;
	private int status;
	
	public Userinfo() {
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
