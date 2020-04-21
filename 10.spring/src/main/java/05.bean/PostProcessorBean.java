package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//BeanPostProcessor �������̽��� ��ӹ��� Ŭ����
// => �ٸ� Ŭ������ ���� Spring Bean �ʱ�ȭ �۾��� �����ϱ� ���� �޼ҵ带 �������̵� ����
// => Bean Configuration File�� ����� ��� Ŭ������ ���� �ʱ�ȭ �۾�
public class PostProcessorBean implements BeanPostProcessor {
	public PostProcessorBean() {
		System.out.println("### PostProcessorBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	//InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ�� �� �ڵ� ȣ�� 
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("### PostProcessorBean Ŭ������ postProcessBeforeInitialization() �޼ҵ� ȣ�� ###");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	//InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ�� �� �ڵ� ȣ�� 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("### PostProcessorBean Ŭ������ postProcessAfterInitialization() �޼ҵ� ȣ�� ###");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
