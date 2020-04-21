package oop;

//�̱��� ������ ������ �����Ͽ� �ۼ��� Ŭ���� - �̱��� Ŭ����
// => ���α׷��� �ϳ��� �ν��Ͻ����� �����ϱ� ���� Ŭ����
public class Singleton {
	//Ŭ������ �ν��Ͻ��� �����ϱ� ���� �ý��� �ʵ� ����
	//�ý��� �ʵ� : Ŭ���� ���ο����� ���� ���� ������ �ʵ�
	// => Getter �޼���� Setter �޼ҵ� �̼���
	// => �ʵ��� �̸��� _�� ���۵ǵ��� �����ϴ� ���� ����
	//private static Singleton _instance=new Singleton();
	private static Singleton _instance;
	
	//��������(Static Block) : Ŭ������ �ε��� �� ����� ����� �ۼ��ϴ� ����
	// => ���������� ����� �ѹ��� ����
	static {
		_instance=new Singleton();
	}
	
	//������ ����ȭ ó�� - �ν��Ͻ� ���� �Ұ�
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	//�ý��� �ʵ忡 ����� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	public static Singleton getInstance() {
		return _instance;
	}
	
	public void display() {
		System.out.println("Singleton Ŭ������ display() �޼ҵ� ȣ��");
	}
}






