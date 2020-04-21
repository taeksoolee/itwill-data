package basic;

public class PrimitiveTypeApp {
	public static void main(String[] args) {
		System.out.println("<< 정수형 >>");
		//출력메소드를 이용할 경우 정수형 상수는 10진수로 출력
		System.out.println("정수형 상수(10진수)  = "+100);
		System.out.println("정수형 상수(8진수) = "+0100);
		System.out.println("정수형 상수(16진수) = "+0x100);
		
		//정수형 상수의 표현 범위(int - 4Byte) : -2147483648~2147483647
		System.out.println("정수형 상수(int) = "+2147483647);
		//표현범위를 벗어난 int 상수는 에러 발생
		//System.out.println("정수형 상수(int) = "+2147483648);
		//정수형 상수 뒤에 L를 붙인 경우 long 상수로 8Byte로 표현
		System.out.println("정수형 상수(long) = "+2147483648L);
		
		byte a1=127;//byte(1Byte) : -128~127
		short a2=32767;//short(2Byte) : -32768~32767
		int a3=2147483647;//int(4Byte) : -2147483648~2147483647
		long a4=2147483648L;//long(8Byte)
		
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		//int a5=100L;//데이타 손실 가능성에 의한 에러 발생
		long a5=100;//가능
		System.out.println("a5 = "+a5);
		System.out.println("===================================");
		System.out.println("<< 실수형 >>");
		//실수형 상수 - double 상수(8Byte)
		System.out.println("실수형 상수(double) = "+1.23);
		//실수형 상수 뒤에 F를 붙인 경우 float 상수(4Byte)로 표현
		System.out.println("실수형 상수(float) = "+1.23F);
		//실수형 상수는 지수형태로 표현 가능
		System.out.println("실수형 상수(double) = "+1.23E9);
		//작거나 큰 실수상수를 출력할 경우 지수형태로 변화되어 출력 
		System.out.println("실수형 상수(double) = "+0.00000000123);
		
		//float b1=1.23456789;
		float b1=1.23456789F;//가수부의 표현범위 : 소숫점 7자리
		double b2=1.23456789;//가수부의 표현범위 : 소숫점 15자리
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
		System.out.println("===================================");
		System.out.println("<< 문자형 >>");
		//문자형 상수는 ' ' 안에 하나의 문자로 표현 - 2Byte
		System.out.println("문자형 상수 = "+'A');
		System.out.println("문자형 상수 = "+'한');
		//표현 불가능한 문자는 회피문자(Escape Character)로 표현 - \ 기호
		System.out.println("문자형 상수 = "+'\'');
		
		char c1='A';//내부적으로 약속된 문자에 대한 정수값으로 저장
		char c2=65;//약속된 문자에 대한 정수값 저장 가능
		char c3='a'-32;//약속된 문자에 대한 정수값 연산 가능
		
		//문자변수에 저장된 상수는 문자형태로 변환되어 출력
		System.out.println("c1 = "+c1);
		System.out.println("c2 = "+c2);
		System.out.println("c3 = "+c3);
		System.out.println("====================================");
		System.out.println("<< 논리형 >>");
		System.out.println("논리형 상수 = "+false);
		System.out.println("논리형 상수 = "+true);
		//관계식(비교식)의 결과로 논리형 상수 반환
		System.out.println("논리형 상수 = "+(20<10));
		System.out.println("논리형 상수 = "+(20>10));
		
		boolean d1=false;
		boolean d2=20>10;
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("====================================");
		System.out.println("<< 문자열 >>");
		//문자열 상수는 " "(String 객체) 안에 문자들로 표현
		System.out.println("이름 = "+"홍길동");
		System.out.println("\"대한민국 만세\" 말하기");
		
		//문자열은 String 클래스(참조형)를 이용하여 표현
		String e1="JAVA";
		String e2="JSP";
		//문자열 상수에 대한 + 연산자는 문자열 결합 의미
		String e3=e1+" & "+e2;
		System.out.println("e3 = "+e3);
	}
}

