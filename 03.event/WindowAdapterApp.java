package site.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Adapter 클래스 : Listener 인터페이스 대신 이벤트 처리가 위해 선언된 클래스
// => Listener 인터페이스의 추상메소드가 여러 개 선언된 경우 Adapter 클래스 제공
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowAdapterHandler());
		
		//익명의 자식클래스로 인스턴스를 생성하여 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		});
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("WindowAdapter");
	}

	//Adapter 클래스를 상속 받은 경우 필요한 이벤트 핸들러 메소드만 오버라이드 선언
	public class WindowAdapterHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}	
	}
}




