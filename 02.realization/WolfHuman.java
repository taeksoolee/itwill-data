package realization;

//클래스는 extends 키워드를 이용하여 상속 처리 - 단일상속
//인터페이스는 implements 키워드를 이용하여 상속 처리 - 다중상속
// => 상속받은 인터페이스의 모든 메소드를 반드시 오버라이드 선언 >> 실체화
public class WolfHuman extends Human implements Wolf {
	@Override
	public void cryLoudly() {
		System.out.println("[늑대]큰 소리로 울부짖을 수 있는 능력");
	}

	@Override
	public void fastWalk() {
		System.out.println("[늑대]네 발로 빠르게 달릴 수 있는 능력");
	}

	public void change() {
		System.out.println("[늑대인간]변신할 수 있는 능력");
	}
}




