package basic;

//컴퓨터에게 난수를 제공받아 출력하는 프로그램을 작성하세요.
// => 난수 : 불규칙적으로 발생되는 숫자
public class MathRandomApp {
	public static void main(String[] args) {
		//Math 클래스 : 수학 관련 기능의 메소드가 선언된 클래스
		
		//Math.random() : 0.0 보다 크거나 같고 1.0보다 작은 실수난수를 반환하는 메소드
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 실수난수 = "+Math.random());
		}
		System.out.println("============================================");
		//0~99 범위의 정수난수를 제공받아 출력
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 정수난수(0~99) = "+(int)(Math.random()*100));
		}
		System.out.println("============================================");
		//1~45 범위의 정수난수를 제공받아 출력
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 정수난수(1~45) = "+((int)(Math.random()*100)%45+1));
		}
		System.out.println("============================================");
	}
}










