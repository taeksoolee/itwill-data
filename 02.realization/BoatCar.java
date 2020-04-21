package realization;

//인터페이스는 extends 키워드를 이용하여 다른 인터페이스 상속 - 다중 상속 가능
public interface BoatCar extends Car, Boat {
	void floating();
}
