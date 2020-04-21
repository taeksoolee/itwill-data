package inheritance;

//�ڵ��� ����(������,�𵨸�)�� �����ϱ� ���� Ŭ����
//��� Ŭ������ �⺻������ Object Ŭ����(�ֻ��� Ŭ����)�� ������ ��ӹ޾� ó��
public class Car /* extends Object */ {
	private String userName;
	private String modelName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String userName, String modelName) {
		super();
		this.userName = userName;
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	//Object Ŭ����(�θ�Ŭ����)�� �޼ҵ带 �������̵� ����
	// => �ʵ忡 ����� ������ �ϳ��� ���ڿ��� �����Ͽ� ��ȯ - �ʵ尪 Ȯ��
	@Override
	public String toString() {
		return "������ : "+userName+", �𵨸� : "+modelName;
	}
}




