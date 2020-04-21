package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-5_beanAttribute.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//ApplicationContext.getBean(String beanName) : Object Ÿ�Կ� Spring Bean�� ��ȯ�ϴ� �޼ҵ�
		// => ��ü ����ȯ�� �̿��ؾ߸� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		//ApplicationContext.getBean(String beanName, Class<T> clazz) : 
		//�ڽ� �ν��Ͻ� Ÿ������ ����ȯ�� Spring Bean�� ��ȯ�ϴ� �޼ҵ�
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



