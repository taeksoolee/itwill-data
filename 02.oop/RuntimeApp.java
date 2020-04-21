package oop;

//Runtime 클래스 : 현재 실행되는 Java 프로그램의 정보를 저장하기 위한 클래스
public class RuntimeApp {
	public static void main(String[] args) {
		//Runtime 클래스의 생성자는 은닉화 처리되어 new 연산자로 인스턴스 생성 불가
		//Runtime rt=new Runtime();
		
		//Runtime.getRuntime() : Runtime 인스턴스를 반환하는 메소드
		// => Runtime 클래스는 인스턴스를 생성하지 못하고 인스턴스를 반환받아 사용
		Runtime rt1=Runtime.getRuntime();
		System.out.println("rt1 = "+rt1);

		//내부적으로 하나의 인스턴스를 미리 생성하여 계속 제공
		// => 프로그램에 하나의 인스턴스만을 제공하는 클래스 - 싱글톤(Singleton) 클래스
		Runtime rt2=Runtime.getRuntime();
		System.out.println("rt2 = "+rt2);
		
		//싱글톤 클래스는 참조변수 없이 인스턴스를 직접 반환받아 메소드 호출
		System.out.println("Runtime.getRuntime() = "+Runtime.getRuntime());
		System.out.println("=============================================");
		System.out.println("청소 전 사용 메모리 크기 = "+(Runtime.getRuntime()
			.totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		
		//Runtime.getRuntime().gc();
		System.gc();
		
		System.out.println("청소 후 사용 메모리 크기 = "+(Runtime.getRuntime()
			.totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		System.out.println("=============================================");
	}
}








