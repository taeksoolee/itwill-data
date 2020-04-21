package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car=new Car("홍길동", "싼타페");
		
		//Car 인스턴스를 이용하여 Car 클래스의 메소드 호출
		System.out.println("소유주 = "+car.getUserName());
		System.out.println("모델명 = "+car.getModelName());
		System.out.println("============================================");
		//Object 클래스의 메소드 호출 가능 - Object 클래스는 Car 클래스의 부모클래스
		//Object.toString() : 참조변수에 저장된 인스턴스를 문자열로 변환하여 반환하는 메소드
		// => 오버라이드 선언하여 자식클래스의 메소드 호출 - 필드값 확인
		System.out.println("car.toString() = "+car.toString());
		//참조변수를 출력할 경우 자동으로 toString() 메소드 호출
		System.out.println("car = "+car);
		System.out.println("============================================");
		String name="임꺽정";
		//String 클래스에서 Object 클래스의 toString() 메소드 오버라이드 선언
		// => String 인스턴스에 저장된 문자열 반환
		System.out.println("이름 = "+name.toString());
		System.out.println("이름 = "+name);
		System.out.println("============================================");
	}
}








