package site.itwill01.old;

//어플리케이션 작성에 필요한 기능을 제공하기 위한 클래스 - 모듈 
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
