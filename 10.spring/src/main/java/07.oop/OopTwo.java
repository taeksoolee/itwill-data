package site.itwill06.oop;

public class OopTwo {
	/*
	public void beforeLog() {
		System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display1() �޼ҵ��� ��� ���� ***");
	}
	
	public void display2() {
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display2() �޼ҵ��� ��� ���� ***");
	}
	
	public void display3() {
		//System.out.println("### �޼ҵ��� ��� ���� �� ��ϵ� ���� ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display3() �޼ҵ��� ��� ���� ***");
	}
}
