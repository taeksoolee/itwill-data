package realization;

//클래스가 인터페이스를 상속 받을 경우 implements 키워드 이용 
//상속 받은 인터페이스의 모든 추상메소드를 반드시 오버라이드 선언
public class BoatCarReal implements BoatCar {
	@Override
	public void run() {
		System.out.println("땅 위를 달리는 능력");
	}

	@Override
	public void navigate() {
		System.out.println("물 위를 향해하는 능력");
	}

	@Override
	public void floating() {
		System.out.println("공중에 떠오르는 능력");
	}
	
}
