package site.itwill02.factory;

//Factory ������ ������ ����� Ŭ���� - Factory Ŭ���� �Ǵ� Provider Ŭ����
// => �����ڰ� ���ϴ� Ŭ������ �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� ��� ����
// => �̱��� Ŭ������ �ۼ��ϴ� ���� ����
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
	
	//�����ڰ� ���ϴ� Ŭ������ �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => �������̽��� ��ȯ������ �����ϸ� �ڽ� �ν��Ͻ� ��ȯ
	public MessageObject getMessageObject() {
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new ByeMessageObject();
		return object;
	}
}
