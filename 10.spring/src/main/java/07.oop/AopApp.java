package site.itwill06.oop;

//인스턴스의 메소드를 호출할 경우 메소드의 명령 실행전 로그가 기록되도록 설정
public class AopApp {
	public static void main(String[] args) {
		/*
		AopOne one=new AopOne();
		AopTwo two=new AopTwo();
		
		one.display1();
		one.display2();
		one.display3();
		
		two.display1();
		two.display2();
		two.display3();
		*/
		
		AopProxy proxyOne=new AopProxy(new AopOne());
		AopProxy proxyTwo=new AopProxy(new AopTwo());
		
		proxyOne.display1();
		proxyOne.display2();
		proxyOne.display3();
		
		proxyTwo.display1();
		proxyTwo.display2();
		proxyTwo.display3();
	}
}
