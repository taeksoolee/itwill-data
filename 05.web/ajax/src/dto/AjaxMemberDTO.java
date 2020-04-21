package site.itwill.dto;

/*
이름     널?       유형            
------ -------- ------------- 
ID     NOT NULL VARCHAR2(20)  
PASSWD          VARCHAR2(50)  
NAME            VARCHAR2(50)  
EMAIL           VARCHAR2(100) 
*/

public class AjaxMemberDTO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public AjaxMemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
}



