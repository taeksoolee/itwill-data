package association;

//�ڵ��� ����(�𵨸�, ����⵵, ��������)�� �����ϱ� ���� Ŭ����
public class Car {
	private String modelName;
	private int productionYear;
	//��������(Engine �ν��Ͻ�)�� �����ϱ� ���� �����ʵ� - ���԰��� 
	private Engine engine;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, int productionYear, Engine engine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.engine = engine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void carDisplay() {
		System.out.println("�𵨸� = "+modelName);
		System.out.println("����⵵ = "+productionYear);
		//System.out.println("�������� = "+engine);
		//���԰���� ������ �ν��Ͻ��� �޼ҵ� ȣ��
		// => ���������� �ν��Ͻ��� ������� ���� ���·� �޼ҵ带 ȣ���� ��� NullPointerException �߻�
		//NullPointerException : ���������� null�� ����� ���·� �޼ҵ带 ȣ���� ��� �߻��Ǵ� ����
		/*
		System.out.println("����Ÿ�� = "+engine.getFualType());
		System.out.println("��ⷮ = "+engine.getDisplacement());
		*/
		//�ڵ��� �ߺ��� �ּ�ȭ�Ͽ� ���������� ȿ���� ����
		engine.engineDisplay();
	}
}








