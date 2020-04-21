package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//Factory Ŭ�����κ��� �ν��Ͻ��� ��ȯ�޾� ���� - IoC
		// => �������̽��� ��ӹ��� �ڽ� �ν��Ͻ� ��ȯ�Ǿ� ���� 
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		
		//�������̽��� �̿��Ͽ� �޼ҵ带 ȣ���� ��� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		// => �������̵忡 ���� ������
		String message=object.getMessage();
		System.out.println("message = "+message);		
	}
}
