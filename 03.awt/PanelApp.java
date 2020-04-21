package site.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class PanelApp extends Frame {
	private static final long serialVersionUID = 1L;

	public PanelApp(String title) {
		super(title);
		
		Button red=new Button("빨간색");
		Button green=new Button("초록색");
		Button blue=new Button("파란색");
		
		//Panel : 컴퍼넌트를 부착하기 위한 컨테이너 - FlowLayout  
		Panel panel=new Panel();
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		TextArea area=new TextArea();
		
		TextField field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		//Component.setFont(Font f) : 컴퍼넌트의 글자 관련 속성을 변경하는 메소드
		//Font : 글자 관련 속성을 저장하기 위한 클래스
		// => Font(String name, int style, int size) : name(글꼴), style(스타일), size(크기)
		//컨테이너의 디자인 속성을 변경하면 종속된 컴퍼넌트도 변경
		panel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		area.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForeground(Color c) : 컴퍼넌트 글자색을 변경하는 메소드
		//Color : 색상정보(RED:0~255, GREEN:0~255, BLUE:0~255)를 저장하기 위한 클래스
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : 컴퍼넌트 배경색을 변경하는 메소드
		// => Color 인스턴스는 상수필드로 제공
		// => 컨테이너에 종속된 컴퍼넌트에 배경색 변경은 적용 불가
		panel.setBackground(Color.GRAY);
		
		//Component.setEnabled(boolean b) : 컴퍼넌트의 활성 여부를 설정하기 위한 메소드
		// => false : 비활성화, true : 활성화(기본)
		red.setEnabled(false);
		
		//TextComponent.setEditable(boolean b) : 텍스트 컴퍼넌트의 변경 여부를 설정하기 위한 메소드
		// => false : 변경 불가능, true : 변경 가능(기본)
		//area.setEditable(false);

		//Component.setFocusable(boolean b) : 컴퍼넌트의 포커스(촛점) 위치 여부를 설정하기 위한 메소드
		// => false : 포커스 위치 불가능, true : 포커스 위치 가능(기본)
		area.setFocusable(false);
		
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PanelApp("Panel");
	}
}





