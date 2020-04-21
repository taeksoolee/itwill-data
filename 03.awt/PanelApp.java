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
		
		Button red=new Button("������");
		Button green=new Button("�ʷϻ�");
		Button blue=new Button("�Ķ���");
		
		//Panel : ���۳�Ʈ�� �����ϱ� ���� �����̳� - FlowLayout  
		Panel panel=new Panel();
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		
		TextArea area=new TextArea();
		
		TextField field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
		
		//Component.setFont(Font f) : ���۳�Ʈ�� ���� ���� �Ӽ��� �����ϴ� �޼ҵ�
		//Font : ���� ���� �Ӽ��� �����ϱ� ���� Ŭ����
		// => Font(String name, int style, int size) : name(�۲�), style(��Ÿ��), size(ũ��)
		//�����̳��� ������ �Ӽ��� �����ϸ� ���ӵ� ���۳�Ʈ�� ����
		panel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		area.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 16));
		
		//Component.setForeground(Color c) : ���۳�Ʈ ���ڻ��� �����ϴ� �޼ҵ�
		//Color : ��������(RED:0~255, GREEN:0~255, BLUE:0~255)�� �����ϱ� ���� Ŭ����
		red.setForeground(new Color(255, 0, 0));
		green.setForeground(new Color(0, 255, 0));
		blue.setForeground(new Color(0, 0, 255));
		
		//Component.setBackground(Color c) : ���۳�Ʈ ������ �����ϴ� �޼ҵ�
		// => Color �ν��Ͻ��� ����ʵ�� ����
		// => �����̳ʿ� ���ӵ� ���۳�Ʈ�� ���� ������ ���� �Ұ�
		panel.setBackground(Color.GRAY);
		
		//Component.setEnabled(boolean b) : ���۳�Ʈ�� Ȱ�� ���θ� �����ϱ� ���� �޼ҵ�
		// => false : ��Ȱ��ȭ, true : Ȱ��ȭ(�⺻)
		red.setEnabled(false);
		
		//TextComponent.setEditable(boolean b) : �ؽ�Ʈ ���۳�Ʈ�� ���� ���θ� �����ϱ� ���� �޼ҵ�
		// => false : ���� �Ұ���, true : ���� ����(�⺻)
		//area.setEditable(false);

		//Component.setFocusable(boolean b) : ���۳�Ʈ�� ��Ŀ��(����) ��ġ ���θ� �����ϱ� ���� �޼ҵ�
		// => false : ��Ŀ�� ��ġ �Ұ���, true : ��Ŀ�� ��ġ ����(�⺻)
		area.setFocusable(false);
		
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PanelApp("Panel");
	}
}





