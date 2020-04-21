package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-5_beanAttribute.xml");
		System.out.println("========== Spring Container 초기화 후 ==========");
		//ApplicationContext.getBean(String beanName) : Object 타입에 Spring Bean을 반환하는 메소드
		// => 객체 형변환을 이용해야만 자식 인스턴스의 메소드 호출
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		//ApplicationContext.getBean(String beanName, Class<T> clazz) : 
		//자식 인스턴스 타입으로 형변환된 Spring Bean을 반환하는 메소드
		InitDestroyMethodBean bean=context.getBean
				("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean.init();
		bean.display();
		//bean.destroy();
		System.out.println("================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		System.out.println("================================================");
		ScopeBean bean4=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean", ScopeBean.class);
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}



