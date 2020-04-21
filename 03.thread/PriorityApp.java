package site.itwill.thread;

public class PriorityApp {
	public static void main(String[] args) {
		PriorityOne one=new PriorityOne();
		PriorityTwo two=new PriorityTwo();
		
		//Thread.setPriority(int newPriority) : �������� �켱(Priority)������ �����ϴ� �޼ҵ�
		// => newPriority : 1~10 ������ ������ - �������� �������� �켱������ ����.
		// => ����ʵ�� ǥ�� ���� : MIN_PRIORITY(1), NORM_PRIORITY(5) ,MAX_PRIORITY(10)
		one.setPriority(Thread.MIN_PRIORITY);
		two.setPriority(Thread.MAX_PRIORITY);
		
		one.start();
		two.start();
	}
}
