package site.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddApp(String title) {
		super(title);
		
		//Button : 버튼 모양을 제공하는 클래스 - 라벨명 부여
		Button button=new Button("버튼");
		
		//Container.add(Component c) : 컨테이너에 컴퍼넌트를 부착하는 메소드
		add(button);//프레임에 버튼 부착
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("컴퍼넌트");
	}
}
