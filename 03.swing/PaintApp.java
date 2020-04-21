package site.itwill.swing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//���콺�� Ŭ�� ��ǥ���� �����ϱ� ���� �ʵ�
	private int x, y;
	
	public PaintApp(String title) {
		super(title);
		
		//�����ӿ��� �߻��Ǵ� ���콺 �̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 ���
		addMouseListener(new MouseAdapter() {
			//���콺 ��ư�� Ŭ���� ��� �ڵ� ȣ��Ǵ� �̺�Ʈ �ڵ鷯 �޼ҵ� 
			@Override
			public void mouseClicked(MouseEvent e) {
				//MouseEvent.getX() : Ŭ���� ��ġ�� X ��ǥ���� ��ȯ�ϴ� �޼ҵ�
				x=e.getX();
				//MouseEvent.getY() : Ŭ���� ��ġ�� Y ��ǥ���� ��ȯ�ϴ� �޼ҵ�
				y=e.getY();
				
				//Window.repaint() : paint() �޼ҵ带 ȣ���ϴ� �޼ҵ�
				// => paint() �޼ҵ带 ���� ȣ���� �� �����Ƿ� ������ �޼ҵ�
				repaint();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	//Window.paint(Graphics g) : �����̳�(������, ���̾�α� ��)�� ����ϴ� �޼ҵ�
	//paint() �޼ҵ�� �����̳� ���� �̺�Ʈ�� �߻��� ��� �ڵ� ȣ��
	// => ���α׷��� ����� ��� �� �����̳ʰ� Ȱ��ȭ �ǰų� ũ�Ⱑ ����� ���
	//Graphics : �׸��� �׸��� ���� ����� �����ϴ� Ŭ����
	@Override
	public void paint(Graphics g) {
		//System.out.println("["+Thread.currentThread().getName()
		//	+"] �����忡 ���� paint() �޼ҵ� ȣ��");
	
		//�θ�Ŭ������ ������ �޼ҵ� ȣ�� - ȭ�� �ʱ�ȭ
		super.paint(g);
		
		/*
		g.setColor(Color.RED);
		g.drawRect(20, 40, 50, 50);
		g.fillRect(20, 100, 50, 100);
		
		g.setColor(Color.BLUE);
		g.drawOval(125, 175, 50, 50);
		g.fillOval(100, 100, 100, 50);
		
		g.setColor(Color.GREEN);
		g.drawString("ȫ�浿", 100, 300);
		*/
		
		g.drawString("["+x+", "+y+"]", x, y);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
}
