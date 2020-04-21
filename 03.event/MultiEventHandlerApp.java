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

//�����ư�� ���� ��� ĵ������ ����� �����ϴ� ���α׷�
public class MultiEventHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	//�̺�Ʈ �ڵ鷯 �޼ҵ忡�� ����� ���۳�Ʈ�� �ʵ�� �����Ͽ� ����
	Canvas canvas;
	Button red, green, blue, white;
	
	public MultiEventHandlerApp(String title) {
		super(title);
		
		red=new Button("������");
		green=new Button("�ʷϻ�");
		blue=new Button("�Ķ���");
		white=new Button("�Ͼ��");
		
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
	//��� ��ư�� Ȱ��ȭ ó���ϴ� �޼ҵ�
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
		//�̺�Ʈ �ҽ����� �߻��� �̺�Ʈ ������ �ڵ����� �Ű������� ����
		@Override
		public void actionPerformed(ActionEvent e) {
			red.setEnabled(true);
			green.setEnabled(true);
			blue.setEnabled(true);
			white.setEnabled(true);
			
			//�̺�Ʈ �ҽ��� �����Ͽ� �̺�Ʈ ó��
			//ActionEvent.getActionCommand() : �̺�Ʈ �ҽ��� ActionCommand�� ��ȯ�ϴ� �޼ҵ�
			// => ActionCommand : ActionEvent�� �߻��� ���۳�Ʈ�� ��ǥ��
			// => Button ���۳�Ʈ�� �󺧸��� ActionCommand ����
			String actionComment=e.getActionCommand();
			
			if(actionComment.equals("������")) {
				red.setEnabled(false);
				canvas.setBackground(Color.RED);	
			} else if(actionComment.equals("�ʷϻ�")) {
				green.setEnabled(false);
				canvas.setBackground(Color.GREEN);	
			} else if(actionComment.equals("�Ķ���")) {
				blue.setEnabled(false);
				canvas.setBackground(Color.BLUE);	
			} else if(actionComment.equals("�Ͼ��")) {
				white.setEnabled(false);
				canvas.setBackground(Color.WHITE);	
			}
		}
	}
}







