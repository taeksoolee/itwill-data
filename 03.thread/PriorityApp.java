package site.itwill.thread;

public class PriorityApp {
	public static void main(String[] args) {
		PriorityOne one=new PriorityOne();
		PriorityTwo two=new PriorityTwo();
		
		//Thread.setPriority(int newPriority) : 스레드의 우선(Priority)순위를 변경하는 메소드
		// => newPriority : 1~10 범위의 정수값 - 정수값이 높을수록 우선순위가 높다.
		// => 상수필드로 표현 가능 : MIN_PRIORITY(1), NORM_PRIORITY(5) ,MAX_PRIORITY(10)
		one.setPriority(Thread.MIN_PRIORITY);
		two.setPriority(Thread.MAX_PRIORITY);
		
		one.start();
		two.start();
	}
}
