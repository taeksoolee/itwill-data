package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//이벤트 프로그램 작성방법
//1.컴퍼넌트(컨테이너)를 이용하여 디자인 클래스 작성 - Frame 클래스 상속
// => 컴퍼넌트(컨테이너)에서는 다양한 이벤트 발생 - 이벤트 소스(Event Source)
//2.이벤트를 처리하기 위한 이벤트 핸들러 클래스 작성
// => 컴퍼넌트에서 발생된 이벤트를 처리하기 위한 클래스
// => XXXEvent를 처리하기 위해 XXXListener 인터페이스를 상속받아 작성
// => 리스너 인터페이스 : 이벤트를 처리하기 위한 추상메소드가 선언된 인터페이스
// => 추상메소드를 오버라이드 선언하여 메소드에 이벤트 처리 명령을 작성
//3.이벤트 소스에서 이벤트가 발생될 경우 이벤트 핸들러가 동작되도록 이벤트 등록
// => Component.addXXXListener(XXXListener l) : 컴퍼넌트에서 이벤트가 발생될
//    경우 이벤트 핸들러 인스턴스를 이용하여 이벤트 처리하는 메소드

//디자인 클래스 - Frame 클래스 상속받아 작성
public class EventHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventHandlerApp(String title) {
		super(title);

		//Button 컴퍼넌트를 사용자를 누를 경우 ActionEvent 발생
		// => 시스템(OS)에서 컴퍼넌트의 이벤트에 대한 인스턴스 자동 생성
		Button exit=new Button("프로그램 종료");
		setLayout(new FlowLayout());
		add(exit);
		
		//Button 컴퍼넌트에서 ActionEvent가 발생될 경우 ButtonEventHandler
		//인스턴스를 이용하여 이벤트 처리되도록 등록
		// => 이벤트 핸들러 인스턴스의 이벤트 처리 메소드 자동 호출
		exit.addActionListener(new ButtonEventHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandlerApp("Event");
	}
}

//이벤트 핸들러 클래스 - 리스너 인터페이스를 상속받아 작성
//Button 컴퍼넌트에서 발생된 ActionEvent를 처리하기 위한 클래스
class ButtonEventHandler implements ActionListener {
	//Button 컴퍼넌트 누른 경우 호출되어 실행되는 이벤트 처리 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}






