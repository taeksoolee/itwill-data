package site.itwill.swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//마우스의 클릭 좌표값을 저장하기 위한 필드
	private int x, y;
	
	public PaintApp(String title) {
		super(title);
		
		//프레임에서 발생되는 마우스 이벤트를 처리하기 위한 이벤트 핸들러 등록
		addMouseListener(new MouseAdapter() {
			//마우스 버튼을 클릭할 경우 자동 호출되는 이벤트 핸들러 메소드 
			@Override
			public void mouseClicked(MouseEvent e) {
				//MouseEvent.getX() : 클릭한 위치의 X 좌표값을 반환하는 메소드
				x=e.getX();
				//MouseEvent.getY() : 클릭한 위치의 Y 좌표값을 반환하는 메소드
				y=e.getY();
				
				//Window.repaint() : paint() 메소드를 호출하는 메소드
				// => paint() 메소드를 직접 호출할 수 없으므로 제공된 메소드
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	//Window.paint(Graphics g) : 컨테이너(프레임, 다이얼로그 등)를 출력하는 메소드
	//paint() 메소드는 컨테이너 관련 이벤트가 발생될 경우 자동 호출
	// => 프로그램이 실행될 경우 및 컨테이너가 활성화 되거나 크기가 변경될 경우
	//Graphics : 그림을 그리기 위한 기능을 제공하는 클래스
	@Override
	public void paint(Graphics g) {
		//System.out.println("["+Thread.currentThread().getName()
		//	+"] 스레드에 의해 paint() 메소드 호출");
	
		//부모클래스의 숨겨진 메소드 호출 - 화면 초기화
		super.paint(g);
		
		/*
		g.setColor(Color.RED);
		g.drawRect(20, 40, 50, 50);
		g.fillRect(20, 100, 50, 100);
		
		g.setColor(Color.BLUE);
		g.drawOval(125, 175, 50, 50);
		g.fillOval(100, 100, 100, 50);
		
		g.setColor(Color.GREEN);
		g.drawString("홍길동", 100, 300);
		*/
		
		g.drawString("["+x+", "+y+"]", x, y);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
}
