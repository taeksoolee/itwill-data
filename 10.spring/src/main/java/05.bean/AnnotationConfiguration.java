package site.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : Ŭ������ Spring Bean���� ����ϴ� ����� �����ϴ� ������̼�
// => Bean Configuration File�� beans ������Ʈ�� ������ ��� ����
@Configuration
public class AnnotationConfiguration {
	//@Bean : Spring Container���� Spring Bean�� �����Ͽ� ��ȯ�ϴ� �޼ҵ带 �����ϱ� ���� ������̼�
	// => Bean Configuration File�� bean ������Ʈ�� ������ ��� ����
	// => �޼ҵ���� �ڵ����� beanName���� ����
	// => name ������̼� �Ӽ��� �̿��ϸ� beanName ���� ����
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}

}
