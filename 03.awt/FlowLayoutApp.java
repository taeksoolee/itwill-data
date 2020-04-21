package site.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

//FlowLayout : 컴퍼넌트를 왼쪽에서 오른쪽으로 차례대로 위치되도록 설정하는 배치관리자
// => 컨테이너의 크기를 벗어날 경우 자동으로 아래에 위치
public class FlowLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public FlowLayoutApp(String title) {
		super(title);
		
		Button button1=new Button("버튼-1"); 
		Button button2=new Button("버튼-2"); 
		Button button3=new Button("버튼-3"); 
		Button button4=new Button("버튼-4"); 
		Button button5=new Button("버튼-5");
		
		//프레임의 배치관리자를 BorderLayout에서 FlowLayout으로 변경
		setLayout(new FlowLayout());
		
		add(button1);	
		add(button2);	
		add(button3);	
		add(button4);	
		add(button5);	
		
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutApp("FlowLayout");
	}
}



