package site.itwill.thread;

public class SingleThread {
	public void display() {
		/*
		System.out.println("SingleThread Ŭ������ display() �޼ҵ� ����");
		System.out.println("SingleThread Ŭ������ display() �޼ҵ� ����");
		System.out.println("SingleThread Ŭ������ display() �޼ҵ� ����");
		*/
		
		/*
		System.out.println("SingleThread Ŭ������ display() �޼ҵ� >> ["
			+Thread.currentThread().getName()+"] �����忡 ���� ��� ����");
		*/
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
		}
	}
}
