package basic;

public class TypeCastApp {
	public static void main(String[] args) {
		//자료형이 다른 상수 연산시 자동 형변환되어 연산 처리
		System.out.println("결과 = "+(3+1.5));
		
		System.out.println("결과 = "+(95/10));
		System.out.println("결과 = "+(95/10.0));
		
		byte a1=10,a2=20;
		//int 보다 작은 자료형의 상수 연산은 무조건 int 자료형으로 변환되어 연산 처리
		//byte a3=a1+a2;
		int a3=a1+a2;
		System.out.println("a3 = "+a3);
		System.out.println("===================================");
		//Cast 연산자를 이용하여 상수를 강제로 형변환하여 연산 처리
		int num=(int)12.3;//(int)12.3 >> 12
		System.out.println("num = "+num);
		
		int num1=95,num2=10;
		double num3=(double)num1/num2;
		System.out.println("num3 = "+num3);
		
		//정수가 큰 경우 _를 이용하여 구분 표현 가능
		int su1=100_000_000,su2=30;
		//문제)연산결과가 정수범위를 초과하므로 쓰레기 발생
		//int su3=su1*su2;
		//해결법)Cast 연산자를 이용한 강제 형변환 이용
		long su3=(long)su1*su2;
		System.out.println("su3 = "+su3);
		
		double number=1.23456789;
		System.out.println("number = "+number);
		//소숫점 2자리까지만 출력되도록 작성
		System.out.println("number(올림) = "+(int)(number*100+0.9)/100.0);
		System.out.println("number(반올림) = "+(int)(number*100+0.5)/100.);
		System.out.println("number(내림) = "+(int)(number*100)/100.);
	}
}






