package site.itwill03.container;

public class MessagePrint {
	//MessageObject 인터페이스를 상속받은 자식 인스턴스를 저장하기 위한 필드 - 포함
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





