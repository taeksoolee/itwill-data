package site.itwill.util;

//Ư�� Ŭ������ ��ӹ޾� Ŭ������ ���׸� Ÿ������ �����Ͽ� ���
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
