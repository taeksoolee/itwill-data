package site.itwill.util;

//특정 클래스를 상속받아 클래스만 제네릭 타입으로 전달하여 사용
public class ExtendsGeneric<T extends Number> {
	private T field;
	
	public ExtendsGeneric() {
		// TODO Auto-generated constructor stub
	}

	public ExtendsGeneric(T field) {
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
