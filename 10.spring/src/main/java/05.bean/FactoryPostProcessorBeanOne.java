package site.itwill04.bean;

public class FactoryPostProcessorBeanOne {
	private String name;
	
	public FactoryPostProcessorBeanOne() {
		System.out.println("### FactoryPostProcessorBeanOne 클래스의 기본 생성자 호출 ###");
		//name="홍길동";
	}
	
	public void display() {
		System.out.println("*** FactoryPostProcessorBeanOne 클래스의 display() 메소드 호출 ***");
		System.out.println("FactoryPostProcessorBeanOne 클래스의 name 필드값 = "+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
