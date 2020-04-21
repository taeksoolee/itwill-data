package inheritance;

//자동차 정보(소유주,모델명)를 저장하기 위한 클래스
//모든 클래스는 기본적으로 Object 클래스(최상위 클래스)를 무조건 상속받아 처리
public class Car /* extends Object */ {
	private String userName;
	private String modelName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String userName, String modelName) {
		super();
		this.userName = userName;
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	//Object 클래스(부모클래스)의 메소드를 오버라이드 선언
	// => 필드에 저장된 값들을 하나의 문자열로 결합하여 반환 - 필드값 확인
	@Override
	public String toString() {
		return "소유주 : "+userName+", 모델명 : "+modelName;
	}
}




