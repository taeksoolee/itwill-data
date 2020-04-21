package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAnonymousHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnonymousHandlerApp(String title) {
		super(title);
		
		Button exit=new Button("프로그램 종료");
		setLayout(new FlowLayout());
		add(exit);
		
		//추상클래스 또는 인터페이스를 이용하여 인스턴스 생성 불가능
		// => 클래스가 상속받아 사용하는 상속 전용 자료형
		//추상클래스(인터페이스)의 추상메소드를 직접 오버라이드 선언하여 인스턴스 생성
		// => 상속받은 자식클래스의 이름을 선언하지 않고 작성 가능
		// => 익명의 내부 클래스(Anonymous Inner Class)로 하나의 인스턴스 생성
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnonymousHandlerApp("Event");
	}
}
