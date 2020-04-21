package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//Factory 클래스로부터 인스턴스를 반환받아 저장 - IoC
		// => 인터페이스를 상속받은 자식 인스턴스 반환되어 저장 
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		
		//인터페이스를 이용하여 메소드를 호출한 경우 자식 인스턴스의 메소드 호출
		// => 오버라이드에 의한 다형성
		String message=object.getMessage();
		System.out.println("message = "+message);		
	}
}
