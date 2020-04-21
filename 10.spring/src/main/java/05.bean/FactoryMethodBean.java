package site.itwill04.bean;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스
public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("### FactoryMethodBean 클래스의 기본 생성자 호출 ###");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		System.out.println("*** FactoryMethodBean 클래스의 getFactoryMethodBean() 메소드 호출 ***");
		return _bean;
	}
}
