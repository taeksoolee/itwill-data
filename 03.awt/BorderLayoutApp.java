package site.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//배치관리자(LayoutManager) : 컴퍼넌트의 출력 위치와 크기를 자동으로 변경
//하여 부착되도록 설정하는 기능을 제공하는 클래스
// => BorderLayout, FlowLayout, GridLayout 등

//모든 컨테이너에는 컴퍼넌트을 부착하기 위한 배치관리자가 기본적으로 설정
// => BorderLayout : Frame, Dialog 등 
// => FlowLayout : Panel 등   

//BorderLayout : 컴퍼넌트를 동, 서, 남, 북, 중앙에 위치되도록 설정하는 배치관리자
// => 컴퍼넌트를 부착할 경우 반드시 부착위치 지정 - 부착위치가 생략되면 중앙에 부착
// => 동일한 위치에 컴퍼넌트를 부착할 경우 덮어씌우기 발생
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public BorderLayoutApp(String title) {
		super(title);
		
		Button button1=new Button("버튼-1"); 
		Button button2=new Button("버튼-2"); 
		Button button3=new Button("버튼-3"); 
		Button button4=new Button("버튼-4"); 
		Button button5=new Button("버튼-5");
		
		/*
		//프레임의 배치관리자를 BorderLayout으로 변경
		// => 프레임의 기본 배치관리자가 BorderLayout이므로 변경 무의미
		//BorderLayout layout=new BorderLayout();
		//setLayout(layout);
		
		setLayout(new BorderLayout());
		*/
		
		//Container.add(Component c, Object constraints) : BorderLayout에서 컴퍼넌트를
		//원하는 위치에 부착하는 메소드 - 위치는 BorderLayout 클래스의 상수필드 사용
		add(button1, BorderLayout.CENTER);//중앙 - 필수
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.NORTH);
		
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}
}










