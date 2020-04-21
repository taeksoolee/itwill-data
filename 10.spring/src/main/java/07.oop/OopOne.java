package site.itwill06.oop;

public class OopOne {
	//메소드에 중복코드가 존재할 경우 중복되는 코드가 작성된 메소드 선언하여 호출하여 사용
	// => 중복코드를 최소화하여 유지보수의 효율성 증가
	/*
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1() 메소드의 명령 실행 ***");
	}
	
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 메소드의 명령 실행 ***");
	}
	
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 기록될 내용 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 메소드의 명령 실행 ***");
	}
}
