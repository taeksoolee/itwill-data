package oop;

//싱글톤 디자인 패턴을 적용하여 작성한 클래스 - 싱글톤 클래스
// => 프로그램에 하나의 인스턴스만을 제공하기 위한 클래스
public class Singleton {
	//클래스의 인스턴스를 저장하기 위한 시스템 필드 선언
	//시스템 필드 : 클래스 내부에서만 사용될 값을 저장한 필드
	// => Getter 메서드와 Setter 메소드 미선언
	// => 필드의 이름은 _로 시작되도록 선언하는 것을 권장
	//private static Singleton _instance=new Singleton();
	private static Singleton _instance;
	
	//정적영역(Static Block) : 클래스가 로딩된 후 실행될 명령을 작성하는 영역
	// => 정적영역의 명령은 한번만 실행
	static {
		_instance=new Singleton();
	}
	
	//생성자 은닉화 처리 - 인스턴스 생성 불가
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	//시스템 필드에 저장된 인스턴스를 반환하는 메소드
	public static Singleton getInstance() {
		return _instance;
	}
	
	public void display() {
		System.out.println("Singleton 클래스의 display() 메소드 호출");
	}
}






