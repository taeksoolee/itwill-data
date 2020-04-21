package site.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame 클래스에서는 WindowEvent 발생 
// => WindowListener 인터페이스를 상속받아 이벤트 핸들러 메소드를 오버라이드 선언하여 이벤트 처리
// => WindowListener 인터페이스의 7개의 추상메소드를 모두 오버라이드 선언
public class WindowListenerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowListenerApp(String title) {
		super(title);
		
		//Frame 컴퍼넌트의 이벤트 핸들러 인스턴스 등록 
		addWindowListener(new WindowListenerHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("WindowListener");
	}

	//Listener 인터페이스를 상속 받은 경우 불필요한 이벤트 핸들러 메소드도 오버라이드 선언
	public class WindowListenerHandler implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened() 메소드 호출");
		}
	
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing() 메소드 호출");
			System.exit(0);
		}
	
		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("windowClosed() 메소드 호출");
		}
	
		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified() 메소드 호출");
		}
	
		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified() 메소드 호출");
		}
	
		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated() 메소드 호출");
		}
	
		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated() 메소드 호출");
		}
	}
}
