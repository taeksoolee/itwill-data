package site.itwill.jdbc;

public class StaticBlockApp {
	public static void main(String[] args) {
		/*
		//1.Class Loader 프로그램에 의해 클래스(Class 파일)를 읽어 메모리에 저장 - 자동
		//2.new 연산자로 메모리에 저장된 클래스(Clazz)의 생성자를 호출하여 인스턴스 생성
		// => 생성된 인스턴스를 참조변수에 저장
		StaticBlock sb=new StaticBlock();
				
		//3.참조변수를 이용하여 인스턴스의 메소드 호출 - 기능 구현
		sb.display();
		*/
		
		//Class.forName(String className) : 문자열로 표현된 패키지를 포함한
		//클래스를 전달받아 ClassLoader 프로그램을 이용하여 메모리에 저장하는 메소드
		// => 메모리에 저장된 클래스 정보(Class 인스턴스 - Clazz) 반환
		// => ClassNotFoundException 발생 - 예외처리
		//Class.newInstance() : 메모리에 저장된 클래스(Clazz)의 생성자를 
		//이용하여 인스턴스를 생성하는 메소드
		// => Object 타입의 인스턴스 반환 - 명시적 객체 형변환
		// => InstantiationException과 IllegalAccessException 발생 - 예외처리
		//리플렉션(Reflection) : 클래스를 직접 메모리에 저장하여 인스턴스를 생성하는 방법
		/*
		try {
			StaticBlock sb=(StaticBlock)Class.forName
					("site.itwill.jdbc.StaticBlock").newInstance();
			sb.display();
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]클래스가 존재하지 않습니다.");
		} catch (Exception e) {
			System.out.println("[에러]실행 프로그램에 문제가 발생 하였습니다.");
		} 
		*/
		
		try {
			Class.forName("site.itwill.jdbc.StaticBlock");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]클래스가 존재하지 않습니다.");
		}
	}
}






