package oop;

public class Overload {
	public void displayInt(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void displayBoolean(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void displayString(String param) {
		System.out.println("문자열 = "+param);
	}
	
	//메소드 오버로드(Overload) 선언
	// => 동일한 기능을 제공하는 메소드가 존재할 경우 메소드명을 같도록 선언
	// => 동일한 메소드명으로 선언하지만 매개변수는 다르게 선언
	// => 접근지정자 또는 반환형은 오버로드 선언과 아무런 관계가 없다.
	public void display(int param) {
		System.out.println("정수값 = "+param);
	}
	
	public void display(boolean param) {
		System.out.println("논리값 = "+param);
	}
	
	public void display(String param) {
		System.out.println("문자열 = "+param);
	}
}








