package site.itwill.lang;

//Wrapper : 기본 자료형(Primitive Type) 대신 제공되는 클래스
// => Byte, Short, Integer, Long, Float, Double, Character, Boolean
public class WrapperApp {
	public static void main(String[] args) {
		/*
		int num1=100, num2=200;
		int num3=num1+num2;
		System.out.println("합계 = "+num3);
		*/
		
		/*
		Integer num1=new Integer(100);
		Integer num2=new Integer("200");
		Integer num3=Integer.valueOf(num1.intValue()+num2.intValue());
		System.out.println("합계 = "+num3.intValue());
		*/
		
		//JDK1.5에서 오토박싱과 오토언박싱 기능 추가
		//오토박싱(Auto Boxing) : 값을 인스턴스로 자동 변환하는 기능
		Integer num1=100, num2=200;
		//오토언박싱(Auto UnBoxing) : 인스턴스를 값으로 자동 변환하는 기능
		//System.out.println("num1 = "+num1);
		Integer num3=num1+num2;
		System.out.println("합계 = "+num3);
		System.out.println("============================================");
		Integer number=50;
		//Integer number=-50;
		System.out.println("number(10진수) = "+number);
		System.out.println("number(8진수) = "+Integer.toOctalString(number));
		System.out.println("number(16진수) = "+Integer.toHexString(number));
		System.out.println("number(2진수) = "+Integer.toBinaryString(number));
		System.out.println("============================================");
		String su1="123", su2="456";
		System.out.println("합계 = "+(su1+su2));//문자열 결합
		//Integer.parseInt(String s) : 문자열을 전달받아 정수값으로 변환하여 반환하는 메소드
		// => 전달받은 문자열이 정수값으로 변환되지 않을 경우 NumberFormatException 발생
		System.out.println("합계 = "+(Integer.parseInt(su1)+Integer.parseInt(su2)));
		System.out.println("============================================");
		
				
	}
}








