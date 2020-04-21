package site.itwill.thread;

//다중 스레드 프로그램 작성 방법 - 스레드 생성
// => 모든 스레드가 소멸되면 프로그램 종료 

//1.Thread 클래스를 상속받는 자식클래스 작성
// => Thread 클래스를 상속받지 못할 경우 Runnable 인스페이스 상속
//2.자식클래스에서 run() 메소드 오버라이드 선언
// => Thread.run() : 생성된 스레드가 실행할 명령을 작성하는 메소드
//3.Thread 클래스를 상속받는 자식클래스로 인스턴스 생성 - 스레드 인스턴스
// => Runnable 인스페이스를 상속받은 자식클래스로 인스턴스 생성하여 Thread 인스턴스 생성시 생성자에게 전달
//4.스레드 인스턴스로 start() 메소드 호출
// => Thread.start() : 스레드를 생성하여 run() 메소드의 명령을 실행하는 메소드
//주의)스레드 인스턴스는 하나의 스레드만 생성 가능
public class MultiThreadApp {
	public static void main(String[] args) throws InterruptedException {
		new MultiThreadOne().start();
		new MultiThreadOne().start();

		//Thread(Runnable target) : Runnable 인터페이스를 상속받은 자식
		//인스턴스를 전달받아 Thread 인스턴스를 생성하기 위한 생성자
		new Thread(new MultiThreadTwo()).start();
		
		/*
		System.out.println("MultiThreadApp 클래스의 main() 메소드 >> ["
			+Thread.currentThread().getName()+"] 스레드에 의해 명령 실행");
		*/

		//main 스레드에 의해 실행되는 명령
		for(int i=1;i<=9;i++) {
			System.out.print(i);
			//Thread.sleep(long ms) : 원하는 시간(ms)동안 스레드을 중지하는 메소드
			// => InterruptedException 발생 - 예외처리
			Thread.sleep(500);
		}
	}
}