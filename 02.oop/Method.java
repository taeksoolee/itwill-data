package oop;

public class Method {
	//식별자 변경(Refactor >> Rename) : 커서 위치 >> Alt+Shift+R >> 변경 >> 엔터
	void displayOne() {
		System.out.println("Method 클래스의 displayOne() 메소드 호출");
	}
	
	void displayTwo() {
		System.out.println("Method 클래스의 displayTwo() 메소드 호출");
	}
	
	void printTotOne() {
		int tot=0;//지역변수(Local Variable)
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수 합계 = "+tot);
	}
	
	void printTotTwo(int num) {
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" 범위의 정수 합계 = "+tot);
	}
	
	void printTotThree(int num1,int num2) {
		//매개변수에 전달된 값에 대한 유효성 검사
		if(num1>num2) {//비정상적인 값이 전달된 경우
			System.out.println("[에러]첫번째 전달값이 두번째 전달값보다 작아야 됩니다.");
			return;//메소드 종료
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" 범위의 정수 합계 = "+tot);
	}
	
	int returnTot(int num1,int num2) {
		if(num1>num2) {
			System.out.println("[에러]첫번째 전달값이 두번째 전달값보다 작아야 됩니다.");
			return 0;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		
		//return 명령을 이용하여 결과값을 반환하며 메소드 종료
		// => 반환값의 자료형 메소드의 반환형으로 선언
		return tot;
	}
	
	//전달받은 매개변수값이 짝수인 경우 false, 홀수인 경우 true 반환하는 메소드  
	boolean isOdd(int num) {
		if(num%2==0) {
			return false;
		} else {
			return true;
		}
	}
	
	//객체(인스턴스 - Instance)를 전달받고 객체를 반환하는 메소드 
	String getHello(String name) {
		return name+"님 안녕하세요.";
	}
	
	//배열(요소들에 저장된 값)을 반환하는 메소드
	int[] getArray() {
		int[] array={10,20,30,40,50};
		return array;
	}
	
	//매개변수에 값들을 전달받아 합계를 계산하여 반환하는 메소드
	// => 매개변수의 갯수만큼 값을 전달받아 처리
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//매개변수에 값들을 전달받아 합계를 계산하여 반환하는 메소드
	// => 배열에 요소값의 갯수에 상관없이 전달받아 처리
	int sumTwo(int[] num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
	//매개변수에 값들을 전달받아 합계를 계산하여 반환하는 메소드
	// => 매개변수 생략 기호(...)를 사용한 경우 값을 0개 이상 입력받아 배열과 동일하게 처리 
	int sumThree(int... num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
}













