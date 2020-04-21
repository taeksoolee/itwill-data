package site.itwill.util;

//���׸�(Generic) : �ʵ��� �ڷ������� Ŭ����(�������̽�) ��� ����ϱ� ���� ������ �ڷ��� - JDK1.5
// => Ŭ����(�������̽�)�� �ۼ��� �� < > �ȿ� ���׸� Ÿ�� ����
// => ���׸��� , ��ȣ�� �̿��Ͽ� ���� ���� ����
// => ���׸� Ÿ���� �ĺ��ڴ� �빮�ڷ� �����ϴ� ���� ����
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
