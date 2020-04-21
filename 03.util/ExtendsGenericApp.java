package site.itwill.util;

public class ExtendsGenericApp {
	public static void main(String[] args) {
		ExtendsGeneric<Integer> eg1=new ExtendsGeneric<Integer>();
		
		eg1.setField(100);
		
		System.out.println("정수값 = "+eg1.getField());
		System.out.println("============================================");
		ExtendsGeneric<Double> eg2=new ExtendsGeneric<Double>();
		
		eg2.setField(12.34);
		
		System.out.println("실수값 = "+eg2.getField());
		System.out.println("============================================");
		//제넥릭 타입에 전달될 클래스는 반드시 특정 클래스를 상속 받은 클래스만 전달 가능
		//ExtendsGeneric<String> eg3=new ExtendsGeneric<String>();
		
	}
}












