package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class LifeCycleBean implements BeanNameAware, BeanClassLoaderAware
	, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware 
	, MessageSourceAware, ApplicationContextAware, InitializingBean
	, DisposableBean {
	public LifeCycleBean() {
		System.out.println("### LifeCycleBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** LifeCycleBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### LifeCycleBean Ŭ������ setBeanName() �޼ҵ� ȣ�� ###");
		//System.out.println("name = "+name);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("### LifeCycleBean Ŭ������ setBeanClassLoader() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("### LifeCycleBean Ŭ������ setBeanFactory() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("### LifeCycleBean Ŭ������ setResourceLoader() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("### LifeCycleBean Ŭ������ setApplicationEventPublisher() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("### LifeCycleBean Ŭ������ setMessageSource() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("### LifeCycleBean Ŭ������ setApplicationContext() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("### LifeCycleBean Ŭ������ afterPropertiesSet() �޼ҵ� ȣ�� ###");
	}
	
	public void initMethod() {
		System.out.println("### LifeCycleBean Ŭ������ initMethod() �޼ҵ� ȣ�� ###");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("### LifeCycleBean Ŭ������ destroy() �޼ҵ� ȣ�� ###");
	}
	
	public void destroyMethod() {
		System.out.println("### LifeCycleBean Ŭ������ destroyMethod() �޼ҵ� ȣ�� ###");
	}
}










