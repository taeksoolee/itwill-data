package site.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Container로부터 Spring Bean를 제공받아 사용하는 방법
// => Bean Configuration File(XML)의 bean 엘리먼트로 클래스를 Spring Bean으로 등록 설정 
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("방법-1.ApplicationContext 인터페이스를 상속받은 클래스 이용");
		//Bean Configuration File 읽기 전
		System.out.println("========== Spring Container 초기화 전 ==========");
		//ApplicationContext : Spring Container 기능을 제공하기 위한 인스턴스
		// => Bean Configuration File에 설정된 모든 bean 엘리먼트의 클래스를 Spring Bean으로 미리 생성하여 관리되도록 구현
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		//Bean Configuration File 읽은 후
		System.out.println("========== Spring Container 초기화 후 ==========");
		//DL(Dependency Lookup) : 컨테이너에게 필요한 객체를 반환받는 방법
		//ApplicationContext.getBean(String beanName) : beanName을 이용하여 Spring Bean을 반환하는 메소드
		// => Object 타입으로 반환하므로 객체 형변환하여 사용
		// => beanName으로 검색되는 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)context.getBean("createBean");
		bean1.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 인스턴스를 제거하는 메소드
		// => 컨테이너에 의해 관리되는 모든 Spring Bean 제거
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===========================================================================");
		System.out.println("방법-2.BeanFactory 인터페이스를 상속받은 클래스 이용");
		System.out.println("========== Spring Container 초기화 전 ==========");
		//BeanFactory : Spring Container 기능을 제공하기 위한 인스턴스
		// => Bean Configuration File을 읽어도 Spring Bean 미생성
		BeanFactory factory=new XmlBeanFactory
			(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("========== Spring Container 초기화 후 ==========");
		//BeanFactory.getBean(String beanName) : beanName을 이용하여 Spring Bean을 생성하여 반환하는 메소드
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		System.out.println("===========================================================================");
	}
}








