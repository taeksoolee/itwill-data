package realization;

public class PrinterApp {
	public static void main(String[] args) {
		//기본 메소드를 호출하기 위해서는 참조변수를 인터페이스로 생성
		Printable printerOne=new PrinterSingle();
		printerOne.print();
		//오버라이드 선언하지 않은 경우 인터페이스의 기본 메소드 호출
		printerOne.scan();
		System.out.println("============================================");
		Printable printerTwo=new PrinterMultiple();
		printerTwo.print();
		//오버라이드 선언된 경우 자식클래스의 오버라이드 메소드 호출
		printerTwo.scan();
		System.out.println("============================================");
	}
}
