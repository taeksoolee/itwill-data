package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container는 Spring Bean의 생성, 사용, 소멸에 대한 생명주기(LifeCycle) 관리

//Spring Bean 생성에 대한 초기화 작업 순서
//1.생성자(Constructor) 호출 : 인스턴스를 생성시 XML 파일로부터 인스턴스(값)을 전달받아 필드값 변경 - Constructor Injection
//2.Setter 메소드 호출 : 인스턴스를 생성후 XML 파일로부터 인스턴스(값)을 전달받아 필드값 변경 - Setter Injection
//3.BeanNameAware 인터페이스의 setBeanName() 메소드 호출 : 인스턴스 생성후 컨테이너에게 beanName을 제공받아 필드값 변경
//4.BeanClassLoaderAware 인터페이스의 setBeanClassLoader() 메소드 호출 : 인스턴스 생성후 컨테이너에게 ClassLoader 인스턴스를 제공받아 필드값 변경
//5.BeanFactoryAware 인터페이스의 setBeanFactory() 메소드 호출 : 인스턴스 생성후 컨테이너에게 BeanFactory 인스턴스를 제공받아 필드값 변경
//6.ResourceLoaderAware 인터페이스의 setResourceLoader() 메소드 호출 : 인스턴스 생성후 컨테이너에게 ResourceLoader 인스턴스를 제공받아 필드값 변경
//7.ApplicationEventPublisherAware 인터페이스의 setApplicationEventPublisher() 메소드 호출 : 인스턴스 생성후 컨테이너에게 ApplicationEventPublisher 인스턴스를 제공받아 필드값 변경
//8.MessageSourceAware 인터페이스의 setMessageSource() 메소드 호출 : 인스턴스 생성후 컨테이너에게 MessageSource 인스턴스를 제공받아 필드값 변경
//9.ApplicationContextAware 인터페이스의 setApplicationContext() 메소드 호출 : 인스턴스 생성후 컨테이너에게 ApplicationContext 인스턴스를 제공받아 필드값 변경
//10.BeanPostProcessor 인터페이스의 postProcessBeforeInitialization() 메소드 호출
//11.InitializingBean 인터페이스의 afterPropertiesSet() 메소드 호출 : 인스턴스 생성후 Properties 파일을 읽어 필드값 변경
//12.bean 엘리먼트의 init-method 속성값으로 설정된 메소드 호출
//13.BeanPostProcessor 인터페이스의 postProcessAfterInitialization() 메소드 호출

//Spring Bean 소멸에 대한 마무리 작업 순서
//1.DisposableBean 인터페이스의 destroy() 메소드 호출
//2.bean 엘리먼트의 destroy-method 속성값으로 설정된 메소드 호출
public class LifeCycleBeanApp {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanLifeCycle.xml");
		System.out.println("========== Spring Container 초기화 후 ==========");
		LifeCycleBean bean=(LifeCycleBean)context.getBean("lifeCycleBean");
		bean.display();
		System.out.println("========== Spring Container 마무리 전 ==========");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("========== Spring Container 마무리 후 ==========");
	}
}
