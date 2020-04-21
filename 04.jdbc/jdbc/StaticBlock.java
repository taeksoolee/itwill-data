package site.itwill.jdbc;

public class StaticBlock {
	//��������(Static Block) : Class Loader ���α׷��� ���� Ŭ������ �޸𸮿�
	//����� �� ����Ǵ� ����� �ۼ��ϴ� ���� - ���α׷����� �� ���� ���� 
	static {
		System.out.println("### StaticBlock Ŭ������ ���������� ��� ���� ###");
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock Ŭ������ ������ ȣ�� - �ν��Ͻ� ���� ###");
	}
	
	public void display() {
		System.out.println("### StaticBlock Ŭ������ display() �޼ҵ� ȣ�� ###");
	}
}
