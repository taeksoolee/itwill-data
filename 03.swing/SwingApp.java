package site.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JMenuItem init, exit;
	JButton red, green, blue, black;
	JTextArea area;
	JTextField field;
	
	public SwingApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		
		JMenu menu=new JMenu("����(F)");
		//JMenu.setMnemonic(char mnemonic) : �޴��� ���ڷ� �����ϵ��� �����ϴ� �޼ҵ�
		// => [Alt]+[����]�� �޴� ���� - �󺧸� �����ϴ� ���ڿ� _ ǥ�� 
		menu.setMnemonic('F');
		//JMenuItem ���۳�Ʈ�� Mnemonic ����� �ʱⰪ���� �ο� ����
		
		init=new JMenuItem("ȭ�� �ʱ�ȭ(I)",'I');
		exit=new JMenuItem("���α׷� ����(E)",'E');
		//JMenuItem.setAccelerator(KeyStroke keyStroke) : KeyStroke 
		//�ν��Ͻ��� �޴������ۿ� ����Ű�� �����ϴ� �޼ҵ�
		// => KeyStroke : ���Ű�� ���ڸ� �����ϱ� ���� Ŭ����
		//KeyStroke.getKeyStroke(int keyCode, int modifiers) : ���ڿ� 
		//���Ű�� ��ϵ� KeyStroke �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		red=new JButton("������");	
		green=new JButton("�ʷϻ�");	
		blue=new JButton("�Ķ���");	
		black=new JButton("������");	
		
		JPanel panel=new JPanel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new JTextArea();
		field=new JTextField();
		
		JScrollPane pane=new JScrollPane(area);
		
		//JFrame.getContentPane() : �������� Container �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => JFrame�� ���� �������� �ʰ� Container�� �̿��Ͽ� ���� 
		Container container=getContentPane();
		
		container.add(panel, BorderLayout.NORTH);
		container.add(pane, BorderLayout.CENTER);
		container.add(field, BorderLayout.SOUTH);
		
		black.setEnabled(false);
		area.setFocusable(false);
		area.setFont(new Font("����", Font.BOLD, 16));
		field.setFont(new Font("����", Font.BOLD, 16));
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		black.setForeground(Color.BLACK);
		area.setBackground(Color.YELLOW);
		
		//JFrame.setDefaultCloseOperation(int operation) : �ݱ��ư�� ���� 
		//��� ���۵� ����� �����ϴ� �޼ҵ� - �Ű������� ����ʵ� ����
		// => DO_NOTHING_ON_CLOSE (WindowConstants) : �̵��� 
		// => HIDE_ON_CLOSE (WindowConstants) : ������ ����(�⺻) 
		// => DISPOSE_ON_CLOSE (WindowConstants) : �޸� ���� �� ���α׷� ���� 
		// => EXIT_ON_CLOSE(JFrame) : ���α׷� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		new SwingApp("Swing");
	}
	
	public class MultiEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource instanceof JMenuItem) {
				if(eventSource==init) {
					area.setText("");
				} else if(eventSource==exit) {
					System.exit(0);
				} 
			} else if(eventSource instanceof JButton) {
				red.setEnabled(true);
				green.setEnabled(true);
				blue.setEnabled(true);
				black.setEnabled(true);
				
				((JButton)eventSource).setEnabled(false);
				if(eventSource==red) {
					area.setForeground(Color.RED);
				} else if(eventSource==green) {
					area.setForeground(Color.GREEN);
				} else if(eventSource==blue) {
					area.setForeground(Color.BLUE);
				} else if(eventSource==black) {
					area.setForeground(Color.BLACK);
				}
			} else if(eventSource instanceof JTextField) {
				String text=field.getText();
				
				if(!text.equals("")) {
					area.append("[��]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
