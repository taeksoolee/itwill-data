package site.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//ActionEvent 발생하는 경우
//1.Button 컴퍼넌트를 누르는 경우
//2.MenuItem 컴퍼넌트를 선택한 경우
//3.TextFeild 컴퍼넌트에서 엔터를 입력한 경우
public class EventSourceGetApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	MenuItem init, exit;
	Button red, green, blue, black;
	TextArea area;
	TextField field;

	public EventSourceGetApp(String title) {
		super(title);
		
		MenuBar bar=new MenuBar();
		Menu menu=new Menu("파일");
		init=new MenuItem("화면 초기화", new MenuShortcut(KeyEvent.VK_I));
		exit=new MenuItem("프로그램 종료", new MenuShortcut(KeyEvent.VK_E));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setMenuBar(bar);
		
		red=new Button("빨간색");
		green=new Button("초록색");
		blue=new Button("파란색");
		black=new Button("검정색");
		
		Panel panel=new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new TextArea();
		field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);

		black.setEnabled(false);
		area.setFocusable(false);
		panel.setBackground(Color.GRAY);
		area.setBackground(Color.YELLOW);
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		black.setForeground(Color.BLACK);
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		init.addActionListener(new MultiEventHandler());
		exit.addActionListener(new MultiEventHandler());
		red.addActionListener(new MultiEventHandler());
		green.addActionListener(new MultiEventHandler());
		blue.addActionListener(new MultiEventHandler());
		black.addActionListener(new MultiEventHandler());
		field.addActionListener(new MultiEventHandler());
		
		setBounds(500, 100, 400, 500);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new EventSourceGetApp("MultiEvent");
	}
	
	//ActionEvent를 발생하는 모든 컴퍼넌트의 이벤트 처리 핸들러
	public class MultiEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//XXXEvent.getSource() : 이벤트를 발생시킨 컴퍼넌트를 반환하는 메소드
			// => 컴퍼넌트를 Object 타입으로 반환
			Object eventSource=e.getSource();
			
			//이벤트 소스를 컴퍼넌트(클래스)로 구분
			if(eventSource instanceof MenuItem) {
				//이벤트 소스를 컴퍼넌트(인스턴스)로 구분
				if(eventSource==init) {
					//TextComponent.setText(String text) : 텍스트 컴퍼넌트의 문자열을 변경하는 메소드
					area.setText("");//화면 초기화
				} else if(eventSource==exit) {
					System.exit(0);
				} 
			} else if(eventSource instanceof Button) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				((Button)eventSource).setEnabled(false);
				if(eventSource==red) {
					area.setForeground(Color.RED);
				} else if(eventSource==green) {
					area.setForeground(Color.GREEN);
				} else if(eventSource==blue) {
					area.setForeground(Color.BLUE);
				} else if(eventSource==black) {
					area.setForeground(Color.BLACK);
				}
			} else if(eventSource instanceof TextField) {
				//TextComponent.getText() : 텍스트 컴퍼넌트의 문자열을 반환하는 메소드
				String text=field.getText();//엔터 미반환
				
				if(!text.equals("")) {//입력 문자열이 존재할 경우
					//TextComponent.append(String text) : 텍스트 컴퍼넌트의 문자열을 추가하는 메소드
					area.append("[나]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
