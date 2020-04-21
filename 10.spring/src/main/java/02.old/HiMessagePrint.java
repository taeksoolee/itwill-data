package site.itwill01.old;

public class HiMessagePrint {
	public void hiMessagePrint() {
		HiMessageObject object=new HiMessageObject();
		String message=object.getHiMessage();
		System.out.println("message = "+message);
	}
}
