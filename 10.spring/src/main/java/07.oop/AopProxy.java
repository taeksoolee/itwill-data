package site.itwill06.oop;

//Proxy 클래스 : 핵심관심모듈과 횡단관심모듈을 결합하기 위한 클래스 - Aspect
// => 핵심관심코드에 횡단관심코드를 삽입한 메소드 선언
public class AopProxy implements AopInterface {
	//핵심관심모듈을 저장하기 위한 필드
	private AopInterface target;
	
	//횡단관심모듈을 저장하기 위한 필드
	private AopLogger logger;
	
	//핵심관심모듈과 횡단관심모듈을 전달받아 필드에 저장하는 생성자
	public AopProxy(AopInterface target) {
		this.target=target;
		this.logger=new AopLogger();
	}
	
	//횡단관심코드를 핵심관심코드에 전에 삽입한 메소드 - Weaving 
	// => 삽입 위치 설정 : JoinPoint
	@Override
	public void display1() {
		logger.beforeLog();//횡단관심코드
		target.display1();//핵심관심코드
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
