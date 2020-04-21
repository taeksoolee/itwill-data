package site.itwill.awt;

import java.awt.Frame;

//GUI 프로그램은 Frame 클래스를 상속받아 작성하는 것을 권장
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//프레임에 대한 디자인 작업
	public FrameTwoApp(String title) {
		//super 키워드를 이용하여 Frame 클래스의 생성자 호출 - 제목 부여
		super(title);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//부모 인스턴스 생성 후 자식 인스턴스 생성
		// => Frame 인스턴스 생성 - 프레임 생성
		new FrameTwoApp("프레임");
	}
}
