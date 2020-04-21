package site.itwill.util;

//제네릭(Generic) : 필드의 자료형으로 클래스(인터페이스) 대신 사용하기 위한 미지정 자료형 - JDK1.5
// => 클래스(인터페이스)를 작성할 때 < > 안에 제네릭 타입 선언
// => 제네릭은 , 기호를 이용하여 나열 선언 가능
// => 제네릭 타입의 식별자는 대문자로 선언하는 것을 권장
public class Generic<T> {
	private T field;
	
	public Generic() {
		// TODO Auto-generated constructor stub
	}

	public Generic(T field) {
		super();
		this.field = field;
	}

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
}
