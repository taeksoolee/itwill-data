package site.itwill.thread;

public class MultiThreadOne extends Thread {
	@Override
	public void run() {
		/*
		System.out.println("MultiThreadOne 클래스의 run() 메소드 >> ["
			+Thread.currentThread().getName()+"] 스레드에 의해 명령 실행");
		*/
		
		//스레드 인스턴스로 생성된 스레드에 의해 실행되는 명령
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
