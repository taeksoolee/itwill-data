package site.itwill.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//ActionEvent �߻��ϴ� ���
//1.Button ���۳�Ʈ�� ������ ���
//2.MenuItem ���۳�Ʈ�� ������ ���
//3.TextFeild ���۳�Ʈ���� ���͸� �Է��� ���
public class EventSourceGetApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	MenuItem init, exit;
	Button red, green, blue, black;
	TextArea area;
	TextField field;

	public EventSourceGetApp(String title) {
		super(title);
		
		MenuBar bar=new MenuBar();
		Menu menu=new Menu("����");
		init=new MenuItem("ȭ�� �ʱ�ȭ", new MenuShortcut(KeyEvent.VK_I));
		exit=new MenuItem("���α׷� ����", new MenuShortcut(KeyEvent.VK_E));
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setMenuBar(bar);
		
		red=new Button("������");
		green=new Button("�ʷϻ�");
		blue=new Button("�Ķ���");
		black=new Button("������");
		
		Panel panel=new Panel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new TextArea();
		field=new TextField();
		
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);

		black.setEnabled(false);
		area.setFocusable(false);
		panel.setBackground(Color.GRAY);
		area.setBackground(Color.YELLOW);
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		black.setForeground(Color.BLACK);
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		area.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		field.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		init.addActionListener(new MultiEventHandler());
		exit.addActionListener(new MultiEventHandler());
		red.addActionListener(new MultiEventHandler());
		green.addActionListener(new MultiEventHandler());
		blue.addActionListener(new MultiEventHandler());
		black.addActionListener(new MultiEventHandler());
		field.addActionListener(new MultiEventHandler());
		
		setBounds(500, 100, 400, 500);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new EventSourceGetApp("MultiEvent");
	}
	
	//ActionEvent�� �߻��ϴ� ��� ���۳�Ʈ�� �̺�Ʈ ó�� �ڵ鷯
	public class MultiEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//XXXEvent.getSource() : �̺�Ʈ�� �߻���Ų ���۳�Ʈ�� ��ȯ�ϴ� �޼ҵ�
			// => ���۳�Ʈ�� Object Ÿ������ ��ȯ
			Object eventSource=e.getSource();
			
			//�̺�Ʈ �ҽ��� ���۳�Ʈ(Ŭ����)�� ����
			if(eventSource instanceof MenuItem) {
				//�̺�Ʈ �ҽ��� ���۳�Ʈ(�ν��Ͻ�)�� ����
				if(eventSource==init) {
					//TextComponent.setText(String text) : �ؽ�Ʈ ���۳�Ʈ�� ���ڿ��� �����ϴ� �޼ҵ�
					area.setText("");//ȭ�� �ʱ�ȭ
				} else if(eventSource==exit) {
					System.exit(0);
				} 
			} else if(eventSource instanceof Button) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				((Button)eventSource).setEnabled(false);
				if(eventSource==red) {
					area.setForeground(Color.RED);
				} else if(eventSource==green) {
					area.setForeground(Color.GREEN);
				} else if(eventSource==blue) {
					area.setForeground(Color.BLUE);
				} else if(eventSource==black) {
					area.setForeground(Color.BLACK);
				}
			} else if(eventSource instanceof TextField) {
				//TextComponent.getText() : �ؽ�Ʈ ���۳�Ʈ�� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
				String text=field.getText();//���� �̹�ȯ
				
				if(!text.equals("")) {//�Է� ���ڿ��� ������ ���
					//TextComponent.append(String text) : �ؽ�Ʈ ���۳�Ʈ�� ���ڿ��� �߰��ϴ� �޼ҵ�
					area.append("[��]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
