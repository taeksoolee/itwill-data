package site.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	//�ν��Ͻ� ���� �� �ʱ�ȭ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	//�ν��Ͻ� �Ҹ� �� ������ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ�
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
