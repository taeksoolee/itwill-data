package site.itwill.el;

//EL 함수로 사용하기 위한 메소드를 선언하는 클래스
public class HelloEL {
	//EL 함수에 대한 메소드는 반드시 정적 메소드로 선언
	public static String hello(String name) {
		return name+"님 환영합니다.";
	}
}
