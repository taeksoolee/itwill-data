package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("05-2_collection.xml");
		System.out.println("========================================================================");
		CollectionBean bean=context.getBean("collectionBean", CollectionBean.class);
		System.out.println("nameList = "+bean.getNameList());
		System.out.println("nameSet = "+bean.getNameSet());
		System.out.println("controllerList = "+bean.getControllerList());
		System.out.println("controllerSet = "+bean.getControllerSet());
		System.out.println("controllerMap = "+bean.getControllerMap());
		System.out.println("properties = "+bean.getProperties());
		System.out.println("========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
