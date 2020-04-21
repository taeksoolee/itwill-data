package enumerate;

public enum StringEnum {
	//�����ڸ� ������ ��� ����ʵ� ����� �ʱⰪ�� �����ؾ߸� ����ʵ� ����
	INSERT("Insert"), UPDATE("Update"), DELETE("Delete"), SELECT("Select");
	
	//����ʵ��� �ڷ����� �����ϱ� ���� �ʵ� ����
	// => private final �ʵ� ����
	// => ����ʵ忡 ���ϴ� ���� �����ϱ� ���� �����ڸ� �ݵ�� ����
	private final String value;
	
	//����ʵ忡 �ʱⰪ�� �����Ͽ� �����ϱ� ���� ������ ����
	// => �����ڴ� private ���������ڷ� ����ȭ ����
	// => �Ű������� ���� ���޹޾� ����ʵ忡 �ʱⰪ ����
	private StringEnum(String value) {
		this.value=value;
	}

	//����ʵ尪�� Ȯ���ϱ� ���� Getter �޼ҵ� ����
	public String getValue() {
		return value;
	}
}






