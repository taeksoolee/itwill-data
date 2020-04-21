package site.itwill.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PenguinMoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//�������� ���� ���̸� ǥ���ϱ� ���� ��� �ʵ�
	public static final int JFRAME_WIDTH=616; 
	public static final int JFRAME_HEIGHT=461;

	//����� ���� ���̸� ǥ���ϱ� ���� ��� �ʵ�
	public static final int PENGUIN_SIZE=60; 
	
	//��� �̹����� �����ϱ� ���� �ʵ�
	//Image : �̹��� ������ �����ϱ� ���� Ŭ����
	private Image backImage;
	
	//��� �̹����� �����ϱ� ���� �ʵ� - �迭 
	private Image[] penguins;
	
	//��� �̹����� �����ϱ� ���� �ʵ�
	private int penguinNo;
	
	//��� �̹����� ��µ� ��ǥ���� �����ϱ� ���� �ʵ�
	private int penguinX, penguinY;
	
	public PenguinMoveApp(String title) {
		super(title);
		
		//ImageIcon : �̹��� ���� ������ �����ϱ� ���� Ŭ����
		// => ImageIcon(URL url) : �̹��� ������ ��θ� �����Ͽ� ImageIcon �ν��Ͻ� ����
		// => Object.getClass() : �޸𸮿� �ε��� ���� Ŭ����(Clazz)�� ��ȯ�ϴ� �޼ҵ�
		// => Class.getResource(String name) : Ŭ������ �̿��Ͽ� ���ҽ� ������ �о� URL �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ImageIcon.getImage() : �̹��� ����(Image �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�

		//��� �̹����� �о� �ʵ忡 ����
		backImage=new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();

		//��� �̹����� �о� �ʵ�(�迭)�� ����
		penguins=new Image[3];
		for(int i=0;i<penguins.length;i++) {
			penguins[i]=new ImageIcon(getClass().getResource
					("/images/penguin"+(i+1)+".gif")).getImage();
		}
		
		//penguinNo=0;
		
		penguinX=JFRAME_WIDTH/2-PENGUIN_SIZE/2;
		penguinY=JFRAME_HEIGHT-PENGUIN_SIZE;
		
		//�����ӿ��� Ű���� ���� �̺�Ʈ�� �߻��� ��� ó���ϴ� �̺�Ʈ �ڵ鷯 ���
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
		//, int height, ImageObserver observer) : �̹����� ����ϴ� �޼ҵ�
		g.drawImage(backImage, 0, 0, JFRAME_WIDTH, JFRAME_HEIGHT, this);
		
		g.drawImage(penguins[penguinNo], penguinX, penguinY, PENGUIN_SIZE, PENGUIN_SIZE, this);
	}
	
	public static void main(String[] args) {
		new PenguinMoveApp("Penguin");
	}

	//Ű���带 ������ �̺�Ʈ�� �߻��� ��쿡 ���� �̺�Ʈ �ڵ鷯 Ŭ����
	public class PenguinMoveHandler implements KeyListener {
		//Ű���带 ������ ����� �� ȣ��Ǵ� �̺�Ʈ �ڵ鷯 �޼ҵ�
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		//Ű���带 ������ �� ȣ��Ǵ� �̺�Ʈ �ڵ鷯 �޼ҵ�
		@Override
		public void keyPressed(KeyEvent e) {
			//KeyEvent : Ű���� ������ �����ϱ� ���� Ŭ����
			// => �̺�Ʈ�� �߻���Ų Ű���� ������ ���޹޾� ����
			//KeyEvent.getKeyCode() : Ű������ �������� ��ȯ�ϴ� �޼ҵ� - H/W 
			int keyCode=e.getKeyCode();
			//KeyEvent.getKeyChar() : Ű������ ���ڰ��� ��ȯ�ϴ� �޼ҵ� - S/W 
			//int keyChar=e.getKeyChar();
			//System.out.println("keyCode = "+keyCode+", keyChar = "+keyChar);
			
			//�̺�Ʈ�� �߻��� Ű���带 �����Ͽ� �̺�Ʈ ó�� 
			switch (keyCode) {
			//���� ����Ű�� ���� ��� - X ��ǥ ���� �� ������Ʈ
			case KeyEvent.VK_LEFT:
				penguinX-=10;
				if(penguinX<=0) {
					penguinX=0;
				}
				penguinNo++;
				penguinNo%=3;
				repaint();
				break;
			
			//������ ����Ű�� ���� ��� - X ��ǥ ���� �� ������Ʈ
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

		//Ű���带 ����� �� ȣ��Ǵ� �̺�Ʈ �ڵ鷯 �޼ҵ�
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}




