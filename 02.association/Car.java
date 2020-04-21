package association;

//자동차 정보(모델명, 생산년도, 엔진정보)를 저장하기 위한 클래스
public class Car {
	private String modelName;
	private int productionYear;
	//엔진정보(Engine 인스턴스)를 저장하기 위한 참조필드 - 포함관계 
	private Engine engine;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, int productionYear, Engine engine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.engine = engine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void carDisplay() {
		System.out.println("모델명 = "+modelName);
		System.out.println("생산년도 = "+productionYear);
		//System.out.println("엔진정보 = "+engine);
		//포함관계로 구현된 인스턴스의 메소드 호출
		// => 참조변수에 인스턴스가 저장되지 않은 상태로 메소드를 호출할 경우 NullPointerException 발생
		//NullPointerException : 참조변수에 null이 저장된 상태로 메소드를 호출할 경우 발생되는 예외
		/*
		System.out.println("연료타입 = "+engine.getFualType());
		System.out.println("배기량 = "+engine.getDisplacement());
		*/
		//코드의 중복을 최소화하여 유지보수의 효율성 증가
		engine.engineDisplay();
	}
}








