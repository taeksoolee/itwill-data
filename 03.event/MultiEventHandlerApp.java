package site.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//색상버튼을 누른 경우 캔버스의 배경을 변경하는 프로그램
public class MultiEventHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	//이벤트 핸들러 메소드에서 사용할 컴퍼넌트는 필드로 선언하여 저장
	Canvas canvas;
	Button red, green, blue, white;
	
	public MultiEventHandlerApp(String title) {
		super(title);
		
		red=new Button("빨간색");
		green=new Button("초록색");
		blue=new Button("파란색");
		white=new Button("하얀색");
		
		Panel panel=new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		canvas=new Canvas();

		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setBackground(Color.GRAY);
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		white.setEnabled(false);
		
		/*
		red.addActionListener(new RedButtonEventHandler());
		green.addActionListener(new GreenButtonEventHandler());
		blue.addActionListener(new BlueButtonEventHandler());
		white.addActionListener(new WhiteButtonEventHandler());
		*/
		
		red.addActionListener(new ColorButtonEventHandler());
		green.addActionListener(new ColorButtonEventHandler());
		blue.addActionListener(new ColorButtonEventHandler());
		white.addActionListener(new ColorButtonEventHandler());
		
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MultiEventHandlerApp("MultiEvent");
	}
	
	/*
	//모든 버튼을 활성화 처리하는 메소드
	public void initColor() {
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		white.setEnabled(true);
	}
	
	public class RedButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			initColor();
			red.setEnabled(false);
			canvas.setBackground(Color.RED);	
		}
	}
	
	public class GreenButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			initColor();
			green.setEnabled(false);
			canvas.setBackground(Color.GREEN);	
		}
	}
	
	public class BlueButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			initColor();
			blue.setEnabled(false);
			canvas.setBackground(Color.BLUE);	
		}
	}
	
	public class WhiteButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			initColor();
			white.setEnabled(false);
			canvas.setBackground(Color.WHITE);	
		}
	}
	*/
	
	public class ColorButtonEventHandler implements ActionListener {
		//이벤트 소스에서 발생된 이벤트 정보를 자동으로 매개변수에 저장
		@Override
		public void actionPerformed(ActionEvent e) {
			red.setEnabled(true);
			green.setEnabled(true);
			blue.setEnabled(true);
			white.setEnabled(true);
			
			//이벤트 소스를 구분하여 이벤트 처리
			//ActionEvent.getActionCommand() : 이벤트 소스의 ActionCommand를 반환하는 메소드
			// => ActionCommand : ActionEvent를 발생한 컴퍼넌트의 대표값
			// => Button 컴퍼넌트는 라벨명을 ActionCommand 설정
			String actionComment=e.getActionCommand();
			
			if(actionComment.equals("빨간색")) {
				red.setEnabled(false);
				canvas.setBackground(Color.RED);	
			} else if(actionComment.equals("초록색")) {
				green.setEnabled(false);
				canvas.setBackground(Color.GREEN);	
			} else if(actionComment.equals("파란색")) {
				blue.setEnabled(false);
				canvas.setBackground(Color.BLUE);	
			} else if(actionComment.equals("하얀색")) {
				white.setEnabled(false);
				canvas.setBackground(Color.WHITE);	
			}
		}
	}
}







