package site.itwill01.old;

//���ø����̼� �ۼ��� �ʿ��� ����� �����ϱ� ���� Ŭ���� - ��� 
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
