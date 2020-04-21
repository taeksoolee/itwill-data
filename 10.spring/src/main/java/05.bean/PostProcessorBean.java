package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//BeanPostProcessor 인터페이스를 상속받은 클래스
// => 다른 클래스의 대한 Spring Bean 초기화 작업을 제공하기 위한 메소드를 오버라이드 선언
// => Bean Configuration File에 선언된 모든 클래스에 대한 초기화 작업
public class PostProcessorBean implements BeanPostProcessor {
	public PostProcessorBean() {
		System.out.println("### PostProcessorBean 클래스의 기본 생성자 호출 ###");
	}
	
	//InitializingBean 인터페이스의 afterPropertiesSet() 메소드 호출 전 자동 호출 
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("### PostProcessorBean 클래스의 postProcessBeforeInitialization() 메소드 호출 ###");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	//InitializingBean 인터페이스의 afterPropertiesSet() 메소드 호출 후 자동 호출 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("### PostProcessorBean 클래스의 postProcessAfterInitialization() 메소드 호출 ###");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
