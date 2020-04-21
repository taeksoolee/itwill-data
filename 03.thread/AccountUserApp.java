package site.itwill.thread;

//다중 스레드 문제점 : 동일한 형태의 스레드 여러 개가 같은 인스턴스의 메소드를
//호출할 경우 메소드 명령의 처리에 대한 순서가 불규칙하여 잘못된 결과 발생 
//해결법)먼저 메소드를 요청한 스레드가 메소드 명령이 끝날 때까지 다른 
//스레드를 대기상태(Lock)로 변경 - 스레드 동기화
// => 스레드가 요청하는 인스턴스의 메소드를 synchronized 키워드로 동기화 메소드 선언
// => 스레드가 인스턴스의 메소드를 동기화(synchronized) 영역에서 호출
public class AccountUserApp {
	public static void main(String[] args) {
		Account account=new Account(10000);//잔액 : 10000원
		
		//스레드 인스턴스로 스레드를 생성하여 run() 메소드의 명령 실행
		// => 스레드 하나당 1초마다 입금 처리를 3번 반복 
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
	}
}
