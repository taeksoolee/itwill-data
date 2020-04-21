package site.itwill02.factory;

//Factory 디자인 패턴이 적용된 클래스 - Factory 클래스 또는 Provider 클래스
// => 개발자가 원하는 클래스로 인스턴스를 생성하여 반환하는 기능 제공
// => 싱글톤 클래스로 작성하는 것을 권장
public class MessageObjectFactory {
	private static MessageObjectFactory _factory;
	
	private MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();		
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}
	
	//개발자가 원하는 클래스로 인스턴스를 생성하여 반환하는 메소드
	// => 인터페이스를 반환형으로 선언하면 자식 인스턴스 반환
	public MessageObject getMessageObject() {
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new ByeMessageObject();
		return object;
	}
}
