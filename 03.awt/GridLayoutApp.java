package site.itwill.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

//GridLayout : 컴퍼넌트를 행열에 위치되도록 설정하는 배치관리자
// => 행의 갯수와 열의 갯수를 반드시 지정
public class GridLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public GridLayoutApp(String title) {
		super(title);
		
		Button button1=new Button("버튼-1"); 
		Button button2=new Button("버튼-2"); 
		Button button3=new Button("버튼-3"); 
		Button button4=new Button("버튼-4"); 
		Button button5=new Button("버튼-5");
		Button button6=new Button("버튼-6");
		
		//프레임의 배치관리자를 BorderLayout에서 GridLayout으로 변경
		setLayout(new GridLayout(3, 2));
	
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new GridLayoutApp("GridLayout");
	}
}
