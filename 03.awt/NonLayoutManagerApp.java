package site.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class NonLayoutManagerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public NonLayoutManagerApp(String title) {
		super(title);
		
		Button button1=new Button("버튼-1");
		Button button2=new Button("버튼-2");
		
		//Container.setLayout(LayoutManager l) : 컨테이너의 배치관리자를 변경하는 메소드
		// => 배치관리자(LayoutManager)을 null로 변경한 경우 배치관리자 미사용
		setLayout(null);
		
		//배치관리자가 없는 경우 컴퍼넌트의 출력 위치와 크기를 변경 후 부착
		button1.setBounds(80, 100, 50, 80);
		button2.setBounds(190, 130, 100, 120);
		
		add(button1);
		add(button2);
		
		setBounds(500, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("NonLayoutManager");
	}
}