package site.itwill04.bean;

public class FactoryPostProcessorBeanOne {
	private String name;
	
	public FactoryPostProcessorBeanOne() {
		System.out.println("### FactoryPostProcessorBeanOne Ŭ������ �⺻ ������ ȣ�� ###");
		//name="ȫ�浿";
	}
	
	public void display() {
		System.out.println("*** FactoryPostProcessorBeanOne Ŭ������ display() �޼ҵ� ȣ�� ***");
		System.out.println("FactoryPostProcessorBeanOne Ŭ������ name �ʵ尪 = "+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
