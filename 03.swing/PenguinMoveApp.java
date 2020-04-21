package site.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//프레임의 폭과 높이를 표현하기 위한 상수 필드
	public static final int JFRAME_WIDTH=616; 
	public static final int JFRAME_HEIGHT=461;

	//펭귄의 폭과 높이를 표현하기 위한 상수 필드
	public static final int PENGUIN_SIZE=60; 
	
	//배경 이미지를 저장하기 위한 필드
	//Image : 이미지 정보를 저장하기 위한 클래스
	private Image backImage;
	
	//펭귄 이미지를 저장하기 위한 필드 - 배열 
	private Image[] penguins;
	
	//펭귄 이미지를 선택하기 위한 필드
	private int penguinNo;
	
	//펭귄 이미지가 출력될 좌표값을 저장하기 위한 필드
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		super(title);
		
		//ImageIcon : 이미지 파일 정보를 저장하기 위한 클래스
		// => ImageIcon(URL url) : 이미지 파일의 경로를 전달하여 ImageIcon 인스턴스 생성
		// => Object.getClass() : 메모리에 로딩된 현재 클래스(Clazz)를 반환하는 메소드
		// => Class.getResource(String name) : 클래스를 이용하여 리소스 파일을 읽어 URL 인스턴스를 반환하는 메소드
		//ImageIcon.getImage() : 이미지 정보(Image 인스턴스)를 반환하는 메소드

		//배경 이미지를 읽어 필드에 저장
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();

		//펭귄 이미지를 읽어 필드(배열)에 저장
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource
					("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		//penguinNo=0;
		
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		//프레임에서 키보드 관련 이벤트가 발생된 경우 처리하는 이벤트 핸들러 등록
		addKeyListener(new PenguinMoveHandler());
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(350, 100, JFRAME_WIDTH, JFRAME_HEIGHT);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//Graphics.drawImage(Image image, int x, int y, int width
		//, int height, ImageObserver observer) : 이미지를 출력하는 메소드
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("Penguin");
	}

	//키보드를 누르는 이벤트가 발생된 경우에 대한 이벤트 핸들러 클래스
	public class PenguinMoveHandler implements KeyListener {
		//키보드를 눌렀다 띄었을 때 호출되는 이벤트 핸들러 메소드
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		//키보드를 눌렀을 때 호출되는 이벤트 핸들러 메소드
		@Override
		public void keyPressed(KeyEvent e) {
			//KeyEvent : 키보드 정보를 저장하기 위한 클래스
			// => 이벤트를 발생시킨 키보드 정보를 전달받아 저장
			//KeyEvent.getKeyCode() : 키보드의 고유값을 반환하는 메소드 - H/W 
			int keyCode=e.getKeyCode();
			//KeyEvent.getKeyChar() : 키보드의 문자값을 반환하는 메소드 - S/W 
			//int keyChar=e.getKeyChar();
			//System.out.println("keyCode = "+keyCode+", keyChar = "+keyChar);
			
			//이벤트를 발생한 키보드를 구분하여 이벤트 처리 
			switch (keyCode) {
			//왼쪽 방향키를 누른 경우 - X 좌표 감소 후 리페인트
			case KeyEvent.VK_LEFT:
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			
			//오른쪽 방향키를 누른 경우 - X 좌표 증가 후 리페인트
			case KeyEvent.VK_RIGHT:
				penguinX+=10;
				if(penguinX>=JFRAME_WIDTH-PENGUIN_SIZE) {
					penguinX=JFRAME_WIDTH-PENGUIN_SIZE;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			}
			
		}

		//키보드를 띄었을 때 호출되는 이벤트 핸들러 메소드
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}




