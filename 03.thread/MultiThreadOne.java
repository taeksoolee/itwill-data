package site.itwill.thread;

public class MultiThreadOne extends Thread {
	@Override
	public void run() {
		/*
		System.out.println("MultiThreadOne Ŭ������ run() �޼ҵ� >> ["
			+Thread.currentThread().getName()+"] �����忡 ���� ��� ����");
		*/
		
		//������ �ν��Ͻ��� ������ �����忡 ���� ����Ǵ� ���
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
