package site.itwill.util;

//�ʵ��� �ڷ����� ���� ���� ���� Ŭ������ �����Ͽ� ���
//�ذ� >> �ʵ� Ÿ���� Object Ŭ������ �����Ͽ� ��� �ν��Ͻ� ����
public class NonGeneric {
	private Object field;
	
	public NonGeneric() {
		// TODO Auto-generated constructor stub
	}

	public NonGeneric(Object field) {
		super();
		this.field = field;
	}

	public Object getField() {
		return field;
	}

	public void setField(Object field) {
		this.field = field;
	}
}
