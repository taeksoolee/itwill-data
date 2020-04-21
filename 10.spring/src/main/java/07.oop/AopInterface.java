package site.itwill06.oop;

//로그를 기록하기 위한 메소드를 설정하기 위한 인터페이스
// => 횡단관심코드가 삽입될 메소드를 추상메소드 선언 - PointCut
public interface AopInterface {
	void display1();
	void display2();
	void display3();
}
