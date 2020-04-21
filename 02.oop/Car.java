package oop;

//접근지정자(Access Modifies) : private, protected, public
//private : 클래스 내부에서 접근 가능하며 클래스 외부에서 접근 불가능 하도록 설정하는 키워드
// => 필드 선언시 사용하여 은닉화 처리 
//public : 모든 패키지의 클래스에서 접근 가능하도록 설정하는 키워드
// => 메소드 선언시 사용하여 접근 처리
public class Car {
	//필드(Field) : 대상에 대한 속성을 정의
	private String modelName;//모델명
	private boolean engineStatus;//엔진상태 >> 시동(false : Off, true : On)
	private int currentSpeed;//현재속도
	
	//생성자(Constructor) : 객체 생성을 제공하기 위한 메소드
	// => 생략 : 기본 생성자(Default Constructor)가 내부적으로 선언되어 사용
	
	//메소드(Method) : 대상에 대한 행위를 정의
	// => 필드를 이용하여 원하는 기능 구현
	public void startEngine() { //시동을 켰는 메소드
		engineStatus=true;
		System.out.println(modelName+"의 시동을 켰습니다.");
	}
	
	public void stopEngine() { //시동을 끄는 메소드
		if(currentSpeed>0) {
			/*
			currentSpeed=0;
			System.out.println(modelName+"이(가) 멈췄습니다.");
			*/
			//메소드 내부에서 다른 메소드 호출 가능
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(modelName+"의 시동을 껐습니다.");
	}
	
	public void speedUp(int speed) { //속도를 증가 시키는 메소드
		if(!engineStatus) {//시동이 꺼져 있는 경우
			System.out.println(modelName+"의 시동을 꺼져 있습니다.");
			return;
		}
		
		if(currentSpeed+speed>150) {
			speed=150-currentSpeed;
		}
		
		currentSpeed+=speed;
		System.out.println(modelName+"의 속도가 "
			+speed+"Km/h 증가 되었습니다. 현재 속도는 "+currentSpeed+"Km/h입니다.");
	}

	public void speedDown(int speed) { //속도를 감소 시키는 메소드
		if(!engineStatus) {//시동이 꺼져 있는 경우
			System.out.println(modelName+"의 시동을 꺼져 있습니다.");
			return;
		}
		
		if(currentSpeed<speed) {
			speed=currentSpeed;
		}
		
		currentSpeed-=speed;
		System.out.println(modelName+"의 속도가 "
			+speed+"Km/h 감소 되었습니다. 현재 속도는 "+currentSpeed+"Km/h입니다.");
	}
	
	public void speedZero() {//속도를 0으로 변경하는 메소드
		currentSpeed=0;
		System.out.println(modelName+"이(가) 멈췄습니다.");
	}
	
	//은닉화 선언된 필드는 필드값을 반환하는 메소드(Getter)와 필드값을 
	//변경하는 메소드(Setter) 선언 => 캡슐화
	//캡슐화 메소드 자동 완성 : [Alt]+[Shift]+[S] >> [R] >> 필드 선택 >> Generator
	public String getModelName() {
		//필드값 반환
		return modelName;
	}
	
	public void setModelName(String modelName) {
		//매개변수에 전달되어 저장된 값을 이용하여 필드값 변경
		// => 매개변수에 저장된 값에 대한 유효성 검사
		this.modelName=modelName;
	}

	//필드의 자료형의 boolean이면 Getter 메소드 대신 Is 메소드 생성 
	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		if(currentSpeed!=0) {
			currentSpeed=0;
		}
		this.currentSpeed = currentSpeed;
	}
}
