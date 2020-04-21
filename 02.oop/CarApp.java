package oop;

//Car 클래스를 이용한 프로그램 작성
public class CarApp {
	public static void main(String[] args) {
		//클래스를 이용하여 인스턴스 생성 후 참조변수에 저장
		// => 생성된 인스턴스의 필드에는 기본값이 자동으로 저장
		// => 필드 기본값 : 숫자형(0), 논리형(false), 참조형(null)
		Car tico=new Car();
		Car sonata=new Car();
		
		//참조변수에 저장된 인스턴스를 출력할 경우 "클래스이름@메모리주소" 형태로 출력
		System.out.println("tico = "+tico);
		System.out.println("sonata = "+sonata);
		System.out.println("============================================");
		//참조변수에 저장된 인스턴스를 이용하여 필드 또는 메소드 접근 가능
		//문제)인스턴스를 이용하여 필드에 직접하여 사용할 경우 비정성적인 값 저장에 의한 실행 오류 발생
		//해결)인스턴스를 이용하여 필드에 접근하지 못하도록 은닉화 처리
		// => 은닉화 처리된 필드에 접근할 경우 에러 발생
		// => Getter 메소드 또는 Setter 메소드를 호출하여 접근
		//tico.modelName="티코";
		tico.setModelName("티코");
		//tico.engineStatus=false;
		tico.setEngineStatus(false);
		//tico.currentSpeed=0;
		tico.setCurrentSpeed(0);
		
		//System.out.println("모델이름 = "+tico.modelName);
		System.out.println("모델이름 = "+tico.getModelName());
		//System.out.println("엔진상태 = "+tico.engineStatus);
		System.out.println("엔진상태 = "+tico.isEngineStatus());
		//System.out.println("현재속도 = "+tico.currentSpeed);
		System.out.println("현재속도 = "+tico.getCurrentSpeed());
		System.out.println("============================================");
		sonata.setModelName("쏘나타");
		
		System.out.println("모델이름 = "+sonata.getModelName());
		System.out.println("엔진상태 = "+sonata.isEngineStatus());
		System.out.println("현재속도 = "+sonata.getCurrentSpeed());
		System.out.println("============================================");
		tico.startEngine();
		tico.speedUp(30);
		tico.speedUp(50);
		tico.speedDown(20);
		tico.speedZero();
		tico.stopEngine();
		System.out.println("============================================");
	}
}






