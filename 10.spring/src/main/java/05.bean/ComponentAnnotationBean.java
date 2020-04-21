package site.itwill04.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component : Ŭ������ Spring Bean���� ����ϴ� ������̼�
// => Ŭ�������� �ڵ����� beanName���� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
//@Component
//value ������̼� �Ӽ������� beanName ���� ����
// => �ٸ� �Ӽ��� �������� ���� ��� value Ű���� ���� ����
//bean ������Ʈ�� �Ӽ��� ������ ����� �����ϴ� ������̼� - @Lazy, @Scope ��
@Lazy
@Component("cab")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
