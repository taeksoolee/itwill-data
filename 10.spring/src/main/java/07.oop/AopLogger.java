package site.itwill06.oop;

//횡단관심모듈 : 횡단관심코드로만 작성된 메소드가 선언된 클래스 - Advice
public class AopLogger {
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
	}
}
