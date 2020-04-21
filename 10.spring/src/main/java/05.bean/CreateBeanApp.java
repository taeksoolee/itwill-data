package site.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Container�κ��� Spring Bean�� �����޾� ����ϴ� ���
// => Bean Configuration File(XML)�� bean ������Ʈ�� Ŭ������ Spring Bean���� ��� ���� 
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("���-1.ApplicationContext �������̽��� ��ӹ��� Ŭ���� �̿�");
		//Bean Configuration File �б� ��
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//ApplicationContext : Spring Container ����� �����ϱ� ���� �ν��Ͻ�
		// => Bean Configuration File�� ������ ��� bean ������Ʈ�� Ŭ������ Spring Bean���� �̸� �����Ͽ� �����ǵ��� ����
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		//Bean Configuration File ���� ��
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//DL(Dependency Lookup) : �����̳ʿ��� �ʿ��� ��ü�� ��ȯ�޴� ���
		//ApplicationContext.getBean(String beanName) : beanName�� �̿��Ͽ� Spring Bean�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ������ ��ȯ�ϹǷ� ��ü ����ȯ�Ͽ� ���
		// => beanName���� �˻��Ǵ� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean1=(CreateBean)context.getBean("createBean");
		bean1.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext �ν��Ͻ��� �����ϴ� �޼ҵ�
		// => �����̳ʿ� ���� �����Ǵ� ��� Spring Bean ����
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===========================================================================");
		System.out.println("���-2.BeanFactory �������̽��� ��ӹ��� Ŭ���� �̿�");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//BeanFactory : Spring Container ����� �����ϱ� ���� �ν��Ͻ�
		// => Bean Configuration File�� �о Spring Bean �̻���
		BeanFactory factory=new XmlBeanFactory
			(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//BeanFactory.getBean(String beanName) : beanName�� �̿��Ͽ� Spring Bean�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		System.out.println("===========================================================================");
	}
}








