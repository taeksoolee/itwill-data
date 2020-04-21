package site.itwill.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinGameApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int JFREAME_WIDTH=616;
	private static final int JFREAME_HEIGHT=461;
	
	private static final int PENGUIN_SIZE=60;

	
	private Image backImage;
	private Image[] penguins;
	private int penguinNo;
	private int penguinX, penguinY;
	
	//펭귄 이미지의 이동 방향성을 저장하기 위한 필드
	// => 1 : 왼쪽 방향, 2 : 오른쪽 방향
	private int direction;
	
	//게임 상태 정보를 저장하기 위한 필드
	// => false : 중지상태, true : 실행상태(기본)
	private boolean isRun;
	
	//펭귄 상태 정보를 저장하기 위한 필드
	// => false : 죽음상태, true : 생존상태(기본)
	private boolean isPenguinAlive;

	//돌멩이 이미지 크기를 표현하기 위한 상수필드
	private static final int STONE_SIZE=30;
	
	//돌멩이 이미지 정보를 저장하기 위한 필드
	private Image stoneImage;
	
	//여러 개의 돌멩이 정보를 저장하기 위한 필드 - 콜렉션 필드
	private Set<Stone> stoneSet;
	
	public PenguinGameApp(String title) {
		super(title);
		
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource
					("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		stoneImage=new ImageIcon(getClass().getResource("/images/stone.gif")).getImage();
		
		stoneSet=new HashSet<Stone>();
		
		init();
		
		//프레임에서 발생되는 키보드 관련 이벤트를 처리하기 위한 이벤트 핸들러 등록
		addKeyListener(new KeyEventHandler());
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(350, 100, JFREAME_WIDTH, JFREAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinGameApp("PenguinGame");
	}
	
	//게임 실행 관련 초기화 작업 메소드 - 필드 초기화
	// => 게임 최초 실행 또는 재실행할 경우 호출
	private void init() {
		penguinNo=0;
		penguinX=JFREAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFREAME_HEIGHT-PENGUIN_SIZE;
		
		direction=2;
		
		isRun=true;
		isPenguinAlive=true;
		
		new PenguinAnimationThread().start();
		
		new CreateStone().start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(backImage, 0, 0, JFREAME_WIDTH, JFREAME_HEIGHT, this);
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
		
		//콜렉션 필드에 저장된 모든 돌멩이를 출력
		synchronized (stoneSet) {
			for(Stone stone:stoneSet) {
				g.drawImage(stoneImage, stone.stoneX, stone.stoneY, STONE_SIZE, STONE_SIZE, this);
			}
		}
		
		//펭귄이 생존상태이면서 게임 중지상태인 경우
		if(isPenguinAlive && !isRun) {
			g.setFont(new Font("굴림", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("일시 중지", 200, 200);
		}
		
		//펭귄이 죽음상태인 경우
		if(!isPenguinAlive) {
			g.setFont(new Font("굴림", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("게임 종료", 200, 200);
			g.drawString("다시 (F5)", 200, 300);
		}
	}
	
	//펭귄 이미지를 움직이는 기능을 구현하기 위한 스레드 클래스
	public class PenguinAnimationThread extends Thread {
		@Override
		public void run() {
			//펭귄이 생존상태인 경우에만 명령 실행
			// => 펭귄이 죽음상태인 경우 반복문이 종료되어 스레드 소멸
			while(isPenguinAlive) {
				//펭귄이 실행상태인 경우에만 명령 실행
				// => 펭귄이 중지상태인 경우에만 명령 미실행
				if(isRun) {
					switch (direction) {
					case 1:
						penguinX-=5;
						if(penguinX<=0) {
							penguinX=0;
						}
						break;
	
					case 2:
						penguinX+=5;
						if(penguinX>=JFREAME_WIDTH-PENGUIN_SIZE) {
							penguinX=JFREAME_WIDTH-PENGUIN_SIZE;
						}	
						break;
					}
					
					penguinNo++;
					penguinNo%=3;
					repaint();
				}
				
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//프레임에서 발생되는 키보드 관련 이벤트를 처리하기 위한 이벤트 핸들러
	public class KeyEventHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode=e.getKeyCode();
			
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				direction=1;
				break;

			case KeyEvent.VK_RIGHT:
				direction=2;
				break;
			case KeyEvent.VK_P:
				//상태정보를 반대로 변경하여 저장하는 명령 - 토글(Toggle)기능
				isRun=!isRun;
				repaint();
				break;
			case KeyEvent.VK_F5:
				if(!isPenguinAlive) init();
				break;
			}
		}
	}
	
	//돌멩이 정보를 저장하기 위한 클래스
	// => 돌멩이 이미지를 움직이는 기능을 구현하기 위한 스레드 클래스
	public class Stone extends Thread {
		//돌멩이 출력 좌표값을 저장하기 위한 필드
		private int stoneX, stoneY;
		
		//돌멩이 상태 정보를 저장하기 위한 필드
		// => false : 소멸상태, true : 생존상태(기본)
		private boolean isStoneAlive;
		
		//돌멩이 낙하속도를 저장하기 위한 필드
		private int stoneSpeed;
		
		public Stone() {
			stoneX=new Random().nextInt(JFREAME_WIDTH-STONE_SIZE);
			stoneY=0;
			isStoneAlive=true;
			stoneSpeed=30;
			
			//스레드 인스턴스를 생성한 후 스레드 동작
			start();
		}
		
		@Override
		public void run() {
			while(isPenguinAlive && isStoneAlive) {
				if(isRun) {
					stoneY+=5;
					//돌멩이가 바닥에 닿은 경우
					// => 콜렉션 필드에 저장된 돌멩이 정보를 제거
					if(stoneY>=JFREAME_HEIGHT-STONE_SIZE) {
						isStoneAlive=false;
						synchronized (stoneSet) {
							stoneSet.remove(this);
						}
					}
					
					//펭귄 출력 좌표값과 돌멩이 출력 좌표값을 비교하여
					//중복될 경우 펭귄의 상태를 죽음상태로 변경
					if(stoneY+20>=JFREAME_HEIGHT-PENGUIN_SIZE) {//Y 좌표 비교
						if(stoneX+10>=penguinX && stoneX+10<=penguinX+PENGUIN_SIZE
							|| stoneX+20>=penguinX && stoneX+20<=penguinX+PENGUIN_SIZE) {//X 좌표 비교
							isPenguinAlive=false;
							penguinX=penguinY=-PENGUIN_SIZE;//펭귄숨기기
							synchronized (stoneSet) {
								stoneSet.clear();//콜렉션 필드 초기화
							}
						}
					}
					
					repaint();
				}
				
				try {
					Thread.sleep(stoneSpeed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//돌멩이(Stone 인스턴스)를 생성하는 스레드 클래스
	// => 콜렉션 필드에 돌멩이 정보를 추가
	public class CreateStone extends Thread {
		@Override
		public void run() {
			while (isPenguinAlive) {
				if(isRun) {
					synchronized (stoneSet) {
						stoneSet.add(new Stone());
					}
				}
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}