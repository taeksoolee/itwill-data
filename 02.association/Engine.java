package association;

//��������(����Ÿ��, ��ⷮ)�� �����ϱ� ���� Ŭ����
public class Engine {
	private String fualType;
	private int displacement;
	
	public Engine() {
		// TODO Auto-generated constructor stub
	}

	public Engine(String fualType, int displacement) {
		super();
		this.fualType = fualType;
		this.displacement = displacement;
	}

	public String getFualType() {
		return fualType;
	}

	public void setFualType(String fualType) {
		this.fualType = fualType;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	public void engineDisplay() {
		System.out.println("����Ÿ�� = "+fualType);
		System.out.println("��ⷮ = "+displacement);
	}
}







