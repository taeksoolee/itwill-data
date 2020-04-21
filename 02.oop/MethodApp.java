package oop;

//실행 목적의 클래스 - 어플리케이션(Application)
// => main() 메소드 선언
public class MethodApp {
	public static void main(String[] args) {
		//클래스명 참조변수 : 객체정보를 저장하기 위한 참조변수 생성
		//new 클래스명() : new 연산자로 생성자(Constructor)를 호출하여 객체 생성
		
		//동일 패키지의 클래스는 패키지 표현없이 접근 가능
		//객체를 생성하여 객체정보를 참조변수에 저장
		// => 참조변수를 이용하여 객체요소(필드 또는 메소드) 접근 가능 - . 연산자
		Method method=new Method();
		
		//메소드 호출(invoke) : 메소드에 선언된 명령 실행
		// => 메소드명과 전달값에 의해 메소드 호출 - 전달값이 잘못된 경우 메소드 호출 불가
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("============================================");
		method.printTotOne();
		method.printTotOne();
		
		//메소드의 매개변수(Parameter)에 값을 전달하여 메소드 호출
		method.printTotTwo(50);
		method.printTotTwo(75);
		
		method.printTotThree(55, 80);
		method.printTotThree(2, 36);
		
		method.printTotThree(90, 10);
		System.out.println("============================================");
		//메소드를 호출하여 반환된 값을 변수에 저장
		int tot=method.returnTot(30, 60);
		System.out.println("합계 = "+tot);
		
		System.out.println("합계 = "+method.returnTot(40, 80));
		System.out.println("============================================");
		boolean result=method.isOdd(10);
		if(result) {
			System.out.println("[결과]홀수");
		} else {
			System.out.println("[결과]짝수");
		}
		
		//조건식 대신 boolean 상수값을 반환하는 메소드 호출 가능
		if(method.isOdd(11)) {
			System.out.println("[결과]홀수");
		} else {
			System.out.println("[결과]짝수");
		}
		System.out.println("============================================");
		System.out.println(method.getHello("홍길동"));
		System.out.println(method.getHello("임꺽정"));
		System.out.println("============================================");
		int[] num=method.getArray();
		System.out.print("반환된 배열 요소값 = ");
		for(int temp:num) {
			System.out.print(temp+" ");
		}
		System.out.println();
		System.out.println("============================================");
		System.out.println("합계 = "+method.sumOne(10, 20, 30));
		//매개변수에 전달될 값이 부족하거나 많은 경우 또는 자료형이 맞지 
		//않는 경우 메소드 호출 불가능 - 에러 발생
		//System.out.println("합계 = "+method.sumOne(10));
		//System.out.println("합계 = "+method.sumOne(10,20,30,40));
		System.out.println("============================================");
		
		int[] array={10,20,30};
		System.out.println("합계 = "+method.sumTwo(array));
		System.out.println("합계 = "+method.sumTwo(new int[]{10,20,30,40,50}));
		System.out.println("============================================");
		System.out.println("합계 = "+method.sumThree());
		System.out.println("합계 = "+method.sumThree(10));
		System.out.println("합계 = "+method.sumThree(10,20,30));
		System.out.println("합계 = "+method.sumThree(10,20,30,40,50));
		System.out.println("============================================");
	}
}