package site.itwill10.exception;

import site.itwill10.dto.Userinfo;

//ȸ����Ͻ� ����ڰ� �Է��� ���̵� �̹� ������ ��� �߻��Ǵ� ����Ŭ���� 
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//����ó�� �޼ҵ�(ExceptionHandler)���� ���� ���� ������ �����ϱ� ���� �ʵ�
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
