package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventInnerHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventInnerHandlerApp(String title) {
		super(title);
		
		Button exit=new Button("프로그램 종료");
		setLayout(new FlowLayout());
		add(exit);

		exit.addActionListener(new ButtonEventHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventInnerHandlerApp("Event");
	}
	
	//이벤트 핸들러 클래스를 디자인 클래스의 내부클래스로 선언
	// => 이벤트 핸들러 클래스의 이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 가능
	public class ButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}