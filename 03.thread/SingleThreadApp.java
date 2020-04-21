package site.itwill.thread;

//스레드(Thread) : 프로그램에 명령을 실행하기 위한 처리 단위 - 프로그램 흐름
//JVM이 프로그램 실행시 main() 메소드 호출한 후 자동으로 main 스레드 생성
//단일 스레드 프로그램 : main 스레드만 이용하여 프로그램 실행
// => main 메소드가 끝나면 main 스레드가 소멸되어 프로그램 종료
public class SingleThreadApp {
	public static void main(String[] args) {
		/*
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작");
		System.out.println("SingleThreadApp 클래스의 main() 메소드 실행-1");
		//인스턴스의 메소드 명령을 실행하기 위해 스레드 이동
		// => 메소드가 종료되면 스레드는 재이동되어 돌아옴
		new SingleThread().display();
		System.out.println("SingleThreadApp 클래스의 main() 메소드 실행-2");
		System.out.println("SingleThreadApp 클래스의 main() 메소드 종료");
		*/
	
		/*
		//Thread.currentThread() : 현재 명령을 실행하는 스레드의 인스턴스를 반환하는 메소드
		//Thread.getName() : 스레드 인스턴스에 저장된 스레드명을 반환하는 메소드
		System.out.println("SingleThreadApp 클래스의 main() 메소드 >> ["
			+Thread.currentThread().getName()+"] 스레드에 의해 명령 실행");
		
		new SingleThread().display();
		*/
		
		new SingleThread().display();
	
		for(int i=1;i<=9;i++) {
			System.out.print(i);
		}
	}
}



