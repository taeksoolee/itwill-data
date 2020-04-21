package site.itwill.thread;

public class PriorityTwo extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.print("1");
		}
	}
}
