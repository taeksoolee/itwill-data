package site.itwill03.container;

public class MessagePrint {
	//MessageObject �������̽��� ��ӹ��� �ڽ� �ν��Ͻ��� �����ϱ� ���� �ʵ� - ����
	private MessageObject object;

	public MessageObject getObject() {
		return object;
	}

	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}





