package site.itwill.awt;

import java.awt.Frame;

//컴퍼넌트(Component) : GUI 프로그램의 디자인 요소를 구현하는 클래스
// => Button, Label, Canvas, Checkbox, Choice, List, Scrollbar, TextField, TextArea 등
//컨테이너(Container) : 컴퍼넌트를 담을 수 있는 컴퍼넌트
// => Frame, Window, Dialog, Panel, ScrollPane 등
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : 메뉴가 있는 창을 만들기 위한 컨테이너
		//Frame f=new Frame();//제목이 없는 프레임 생성
		Frame f=new Frame("프레임");//제목이 있는 프레임 생성
		
		//Frame.setTitle(String title) : 프레임의 제목을 변경하는 메소드
		//f.setTitle("프레임");
		
		/*
		//Component.setLocation(int x, int y) : 컴퍼넌트를 출력 위치를 변경하는 메소드
		// => 이동 또는 크기 단위 픽셀(Pixel) 사용
		//픽셀 : 하나의 색이 출력되는 점
		f.setLocation(500, 100);
		
		//Component.setSize(int width, int height) : 컴퍼넌트의 크기를 변경하는 메소드
		f.setSize(300, 400);
		*/
		
		//Component.setBounds(int x, int y, int width, int height) : 컴퍼넌트의
		//출력 위치와 크기를 변경하는 메소드
		f.setBounds(500, 100, 300, 400);
		
		//Frame.setResizable(boolean b) : 프레임의 크기 변경 여부를 설정하는 메소드
		// => false : 미변경,  true : 변경(기본) 
		f.setResizable(false);
		
		//Component.setVisible(boolean b) : 컴퍼넌트의 화면 출력 여부를 설정하는 메소드
		// => false : 미출력(기본),  true : 출력 
		// => 컨테이너에 설정된 결과는 컨테이너에 담긴 컴퍼넌트에 영향을 전달  
		f.setVisible(true);
	}
}










