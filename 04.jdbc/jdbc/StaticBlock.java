package site.itwill.jdbc;

public class StaticBlock {
	//정적영역(Static Block) : Class Loader 프로그램에 의해 클래스가 메모리에
	//저장된 후 실행되는 명령을 작성하는 영역 - 프로그램에서 한 번만 실행 
	static {
		System.out.println("### StaticBlock 클래스의 정적영역의 명령 실행 ###");
		StaticBlock sb=new StaticBlock();
		sb.display();
	}
	
	public StaticBlock() {
		System.out.println("### StaticBlock 클래스의 생성자 호출 - 인스턴스 생성 ###");
	}
	
	public void display() {
		System.out.println("### StaticBlock 클래스의 display() 메소드 호출 ###");
	}
}
