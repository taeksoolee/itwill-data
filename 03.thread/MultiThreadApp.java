package site.itwill.thread;

//���� ������ ���α׷� �ۼ� ��� - ������ ����
// => ��� �����尡 �Ҹ�Ǹ� ���α׷� ���� 

//1.Thread Ŭ������ ��ӹ޴� �ڽ�Ŭ���� �ۼ�
// => Thread Ŭ������ ��ӹ��� ���� ��� Runnable �ν����̽� ���
//2.�ڽ�Ŭ�������� run() �޼ҵ� �������̵� ����
// => Thread.run() : ������ �����尡 ������ ����� �ۼ��ϴ� �޼ҵ�
//3.Thread Ŭ������ ��ӹ޴� �ڽ�Ŭ������ �ν��Ͻ� ���� - ������ �ν��Ͻ�
// => Runnable �ν����̽��� ��ӹ��� �ڽ�Ŭ������ �ν��Ͻ� �����Ͽ� Thread �ν��Ͻ� ������ �����ڿ��� ����
//4.������ �ν��Ͻ��� start() �޼ҵ� ȣ��
// => Thread.start() : �����带 �����Ͽ� run() �޼ҵ��� ����� �����ϴ� �޼ҵ�
//����)������ �ν��Ͻ��� �ϳ��� �����常 ���� ����
public class MultiThreadApp {
	public static void main(String[] args) throws InterruptedException {
		new MultiThreadOne().start();
		new MultiThreadOne().start();

		//Thread(Runnable target) : Runnable �������̽��� ��ӹ��� �ڽ�
		//�ν��Ͻ��� ���޹޾� Thread �ν��Ͻ��� �����ϱ� ���� ������
		new Thread(new MultiThreadTwo()).start();
		
		/*
		System.out.println("MultiThreadApp Ŭ������ main() �޼ҵ� >> ["
			+Thread.currentThread().getName()+"] �����忡 ���� ��� ����");
		*/

		//main �����忡 ���� ����Ǵ� ���
		for(int i=1;i<=9;i++) {
			System.out.print(i);
			//Thread.sleep(long ms) : ���ϴ� �ð�(ms)���� �������� �����ϴ� �޼ҵ�
			// => InterruptedException �߻� - ����ó��
			Thread.sleep(500);
		}
	}
}