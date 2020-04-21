package site.itwill01.old;

public class ByeMessagePrint {
	public void byeMessagePrint() {
		ByeMessageObject object=new ByeMessageObject();
		String message=object.getByeMessage();
		System.out.println("message = "+message);
	}
}
