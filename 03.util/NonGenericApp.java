package site.itwill.util;

//Object 타입의 필드가 선언된 클래스로 인스턴스를 생성하여 사용하는 프로그램
// => 필드에 모든 인스턴스를 전달하여 저장(포함) 가능
// => 필드에 저장된 인스턴스를 반환받아 사용할 경우 반드시 명시적 객체 형변환 이용
public class NonGenericApp {
	public static void main(String[] args) {
		NonGeneric ng1=new NonGeneric();
		
		//Object 타입의 필드에 Integer 인스턴스 저장
		//ng1.setField(new Integer(100));
		ng1.setField(100);//오토박싱
		
		//필드값은 무조건 Object 타입으로 반환 => 명시적 객체 형변환 이용
		int ng1Value=((Integer)ng1.getField()).intValue();
		
		//명시적 객체 형변환을 잘못할 경우 ClassCastException 발생
		//int ng1Value=((Double)ng1.getField()).intValue();
		
		System.out.println("정수값 = "+ng1Value);
		System.out.println("============================================");
		NonGeneric ng2=new NonGeneric();
		
		//Object 타입의 필드에 Double 인스턴스 저장
		ng2.setField(12.34);
		
		//instanceof 연산자를 이용한 명시적 객체 형변환의 검증 작업
		if(ng2.getField() instanceof Double) {
			double ng2Value=((Double)ng2.getField()).doubleValue();
			System.out.println("실수값 = "+ng2Value);
		}
		System.out.println("============================================");
		NonGeneric ng3=new NonGeneric();

		//Object 타입의 필드에 String 인스턴스 저장
		ng3.setField("홍길동");
		
		if(ng3.getField() instanceof String) {
			String ng3Value=((String)ng3.getField()).replace("홍", "고");
			System.out.println("문자열 = "+ng3Value);
		}
		System.out.println("============================================");
	}
}
