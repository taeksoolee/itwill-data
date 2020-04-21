package site.itwill.util;

//Generic 타입의 필드가 선언된 클래스로 인스턴스를 생성하여 사용하는 프로그램
// => Generic 타입으로 전달된 클래스의 인스턴스만 저장(포함) 가능
// => 객체 형변환을 하지 않아도 필드값을 반환받아 사용
public class GenericApp {
	public static void main(String[] args) {
		//제네릭 클래스(인터페이스)를 사용하고자 할 경우 Generic 타입에
		//클래스(인터페이스)를 전달해야만 사용 가능
		// => Generic 타입 대신 전달된 클래스(인터페이스)를 이용하여 필드 선언
		Generic<Integer> g1=new Generic<Integer>();
		
		g1.setField(100);
		//제넥릭 대신 전달된 클래스의 인스턴스가 아닌 경우 필드에 저장할 수 없으므로 에러 발생
		//g1.setField(12.34);
		
		//제넥릭 대신 전달된 클래스의 인스턴스 반환
		int g1Value=g1.getField().intValue();
		
		System.out.println("정수값 = "+g1Value);
		System.out.println("============================================");
		Generic<Double> g2=new Generic<Double>();

		g2.setField(12.34);
		
		double g2Value=g2.getField().doubleValue();
		System.out.println("실수값 = "+g2Value);
		System.out.println("============================================");
		Generic<String> g3=new Generic<String>();

		g3.setField("홍길동");
		
		String g3Value=g3.getField().replace("홍", "고");
		System.out.println("문자열 = "+g3Value);
		System.out.println("============================================");
	}
}











