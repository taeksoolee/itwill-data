package realization;

public interface Printable {
	void print();
	
	//인터페이스에 명령을 작성할 수 있는 기본 메소드 선언 - JDK1.8 이상
	// => 인터페이스를 상속 받은 자식클래스에서 오버라이드 선언하지 않아도 에러 미발생
	// => 자식클래스에서 오버라이드 선언하지 않을 경우 기본 메소드 호출
	default void scan() {
		System.out.println("[에러]스캔 기능을 제공하지 않습니다.");
	}
}
