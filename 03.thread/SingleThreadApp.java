package site.itwill.thread;

//������(Thread) : ���α׷��� ����� �����ϱ� ���� ó�� ���� - ���α׷� �帧
//JVM�� ���α׷� ����� main() �޼ҵ� ȣ���� �� �ڵ����� main ������ ����
//���� ������ ���α׷� : main �����常 �̿��Ͽ� ���α׷� ����
// => main �޼ҵ尡 ������ main �����尡 �Ҹ�Ǿ� ���α׷� ����
public class SingleThreadApp {
	public static void main(String[] args) {
		/*
		System.out.println("SingleThreadApp Ŭ������ main() �޼ҵ� ����");
		System.out.println("SingleThreadApp Ŭ������ main() �޼ҵ� ����-1");
		//�ν��Ͻ��� �޼ҵ� ����� �����ϱ� ���� ������ �̵�
		// => �޼ҵ尡 ����Ǹ� ������� ���̵��Ǿ� ���ƿ�
		new SingleThread().display();
		System.out.println("SingleThreadApp Ŭ������ main() �޼ҵ� ����-2");
		System.out.println("SingleThreadApp Ŭ������ main() �޼ҵ� ����");
		*/
	
		/*
		//Thread.currentThread() : ���� ����� �����ϴ� �������� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Thread.getName() : ������ �ν��Ͻ��� ����� ��������� ��ȯ�ϴ� �޼ҵ�
		System.out.println("SingleThreadApp Ŭ������ main() �޼ҵ� >> ["
			+Thread.currentThread().getName()+"] �����忡 ���� ��� ����");
		
		new SingleThread().display();
		*/
		
		new SingleThread().display();
	
		for(int i=1;i<=9;i++) {
			System.out.print(i);
		}
	}
}



