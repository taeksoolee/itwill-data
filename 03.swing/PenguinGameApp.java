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
	
	//��� �̹����� �̵� ���⼺�� �����ϱ� ���� �ʵ�
	// => 1 : ���� ����, 2 : ������ ����
	private int direction;
	
	//���� ���� ������ �����ϱ� ���� �ʵ�
	// => false : ��������, true : �������(�⺻)
	private boolean isRun;
	
	//��� ���� ������ �����ϱ� ���� �ʵ�
	// => false : ��������, true : ��������(�⺻)
	private boolean isPenguinAlive;

	//������ �̹��� ũ�⸦ ǥ���ϱ� ���� ����ʵ�
	private static final int STONE_SIZE=30;
	
	//������ �̹��� ������ �����ϱ� ���� �ʵ�
	private Image stoneImage;
	
	//���� ���� ������ ������ �����ϱ� ���� �ʵ� - �ݷ��� �ʵ�
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
		
		//�����ӿ��� �߻��Ǵ� Ű���� ���� �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 ���
		addKeyListener(new KeyEventHandler());
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(350, 100, JFREAME_WIDTH, JFREAME_HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinGameApp("PenguinGame");
	}
	
	//���� ���� ���� �ʱ�ȭ �۾� �޼ҵ� - �ʵ� �ʱ�ȭ
	// => ���� ���� ���� �Ǵ� ������� ��� ȣ��
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
		
		//�ݷ��� �ʵ忡 ����� ��� �����̸� ���
		synchronized (stoneSet) {
			for(Stone stone:stoneSet) {
				g.drawImage(stoneImage, stone.stoneX, stone.stoneY, STONE_SIZE, STONE_SIZE, this);
			}
		}
		
		//����� ���������̸鼭 ���� ���������� ���
		if(isPenguinAlive && !isRun) {
			g.setFont(new Font("����", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("�Ͻ� ����", 200, 200);
		}
		
		//����� ���������� ���
		if(!isPenguinAlive) {
			g.setFont(new Font("����", Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("���� ����", 200, 200);
			g.drawString("�ٽ� (F5)", 200, 300);
		}
	}
	
	//��� �̹����� �����̴� ����� �����ϱ� ���� ������ Ŭ����
	public class PenguinAnimationThread extends Thread {
		@Override
		public void run() {
			//����� ���������� ��쿡�� ��� ����
			// => ����� ���������� ��� �ݺ����� ����Ǿ� ������ �Ҹ�
			while(isPenguinAlive) {
				//����� ��������� ��쿡�� ��� ����
				// => ����� ���������� ��쿡�� ��� �̽���
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
	
	//�����ӿ��� �߻��Ǵ� Ű���� ���� �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯
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
				//���������� �ݴ�� �����Ͽ� �����ϴ� ��� - ���(Toggle)���
				isRun=!isRun;
				repaint();
				break;
			case KeyEvent.VK_F5:
				if(!isPenguinAlive) init();
				break;
			}
		}
	}
	
	//������ ������ �����ϱ� ���� Ŭ����
	// => ������ �̹����� �����̴� ����� �����ϱ� ���� ������ Ŭ����
	public class Stone extends Thread {
		//������ ��� ��ǥ���� �����ϱ� ���� �ʵ�
		private int stoneX, stoneY;
		
		//������ ���� ������ �����ϱ� ���� �ʵ�
		// => false : �Ҹ����, true : ��������(�⺻)
		private boolean isStoneAlive;
		
		//������ ���ϼӵ��� �����ϱ� ���� �ʵ�
		private int stoneSpeed;
		
		public Stone() {
			stoneX=new Random().nextInt(JFREAME_WIDTH-STONE_SIZE);
			stoneY=0;
			isStoneAlive=true;
			stoneSpeed=30;
			
			//������ �ν��Ͻ��� ������ �� ������ ����
			start();
		}
		
		@Override
		public void run() {
			while(isPenguinAlive && isStoneAlive) {
				if(isRun) {
					stoneY+=5;
					//�����̰� �ٴڿ� ���� ���
					// => �ݷ��� �ʵ忡 ����� ������ ������ ����
					if(stoneY>=JFREAME_HEIGHT-STONE_SIZE) {
						isStoneAlive=false;
						synchronized (stoneSet) {
							stoneSet.remove(this);
						}
					}
					
					//��� ��� ��ǥ���� ������ ��� ��ǥ���� ���Ͽ�
					//�ߺ��� ��� ����� ���¸� �������·� ����
					if(stoneY+20>=JFREAME_HEIGHT-PENGUIN_SIZE) {//Y ��ǥ ��
						if(stoneX+10>=penguinX && stoneX+10<=penguinX+PENGUIN_SIZE
							|| stoneX+20>=penguinX && stoneX+20<=penguinX+PENGUIN_SIZE) {//X ��ǥ ��
							isPenguinAlive=false;
							penguinX=penguinY=-PENGUIN_SIZE;//��ϼ����
							synchronized (stoneSet) {
								stoneSet.clear();//�ݷ��� �ʵ� �ʱ�ȭ
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
	
	//������(Stone �ν��Ͻ�)�� �����ϴ� ������ Ŭ����
	// => �ݷ��� �ʵ忡 ������ ������ �߰�
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