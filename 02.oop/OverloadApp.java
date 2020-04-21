package oop;

public class OverloadApp {
	public static void main(String[] args) {
		Overload overload=new Overload();
		
		overload.displayInt(100);
		//overload.displayInt(12.34);		
		overload.displayBoolean(false);
		overload.displayString("홍길동");
		System.out.println("============================================");
		//매개변수에 전달되는 값에 따라서 다른 메소드 호출되어 실행
		// => 메소드 오버로드에 의한 다형성
		//다형성 : 같은 이름의 메소드를 호출해도 상태에 따라서 다른 메소드가 호출
		// => 메소드 오버로드, 메소드 오버라이드
		overload.display(200);
		//overload.display(12.34);
		overload.display(true);
		overload.display("임꺽정");
		System.out.println("============================================");
	}
}
