package site.itwill.dto;

/*
MYUSER ���̺� : ȸ�������� �����ϱ� ���� ���̺� - ���̵�, �̸�
=> DBMS �ĺ��ڴ� ��ҹ��ڸ� �������� �����Ƿ� ����� ǥ���(UnderCase)�� �̿��Ͽ� �ܾ� ����
 
�̸�        ��?       ����           
--------- -------- ------------ 
USER_ID   NOT NULL VARCHAR2(20) 
USER_NAME          VARCHAR2(30) 
*/

public class MyUser {
	//Java �ĺ��ڴ� ��ҹ��ڸ� �����ϹǷ� ī��ǥ���(CamelCase)�� �̿��Ͽ� �ܾ� ����
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







