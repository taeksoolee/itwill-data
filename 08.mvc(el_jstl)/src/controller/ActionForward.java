package site.itwill.controller;

//��(View) ���� ������ �����ϱ� ���� Ŭ����
public class ActionForward {
	//���� ���� ������ �����ϱ� ���� �ʵ�
	// => false : �����̷�Ʈ, true : ������ 
	private boolean forward;
	//�����̷�Ʈ ��û(~.do) �Ǵ� ������ �̵�(~.jsp)�� ���õ� URL �ּҸ� �����ϱ� ���� �ʵ� 
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
