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
		
		JMenu menu=new JMenu("파일(F)");
		//JMenu.setMnemonic(char mnemonic) : 메뉴를 문자로 선택하도록 변경하는 메소드
		// => [Alt]+[문자]로 메뉴 선택 - 라벨명에 존재하는 문자에 _ 표시 
		menu.setMnemonic('F');
		//JMenuItem 컴퍼넌트는 Mnemonic 기능을 초기값으로 부여 가능
		
		init=new JMenuItem("화면 초기화(I)",'I');
		exit=new JMenuItem("프로그램 종료(E)",'E');
		//JMenuItem.setAccelerator(KeyStroke keyStroke) : KeyStroke 
		//인스턴스로 메뉴아이템에 단축키를 변경하는 메소드
		// => KeyStroke : 기능키와 문자를 저장하기 위한 클래스
		//KeyStroke.getKeyStroke(int keyCode, int modifiers) : 문자와 
		//기능키가 등록된 KeyStroke 인스턴스를 반환하는 메소드
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E
				, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		
		menu.add(init);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		red=new JButton("빨간색");	
		green=new JButton("초록색");	
		blue=new JButton("파란색");	
		black=new JButton("검정색");	
		
		JPanel panel=new JPanel();
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(black);
		
		area=new JTextArea();
		field=new JTextField();
		
		JScrollPane pane=new JScrollPane(area);
		
		//JFrame.getContentPane() : 프레임의 Container 인스턴스를 반환하는 메소드
		// => JFrame를 직접 조작하지 않고 Container를 이용하여 조작 
		Container container=getContentPane();
		
		container.add(panel, BorderLayout.NORTH);
		container.add(pane, BorderLayout.CENTER);
		container.add(field, BorderLayout.SOUTH);
		
		black.setEnabled(false);
		area.setFocusable(false);
		area.setFont(new Font("굴림", Font.BOLD, 16));
		field.setFont(new Font("굴림", Font.BOLD, 16));
		red.setForeground(Color.RED);
		green.setForeground(Color.GREEN);
		blue.setForeground(Color.BLUE);
		black.setForeground(Color.BLACK);
		area.setBackground(Color.YELLOW);
		
		//JFrame.setDefaultCloseOperation(int operation) : 닫기버튼을 누른 
		//경우 동작될 기능을 변경하는 메소드 - 매개변수에 상수필드 전달
		// => DO_NOTHING_ON_CLOSE (WindowConstants) : 미동작 
		// => HIDE_ON_CLOSE (WindowConstants) : 프레임 숨김(기본) 
		// => DISPOSE_ON_CLOSE (WindowConstants) : 메모리 정리 후 프로그램 종료 
		// => EXIT_ON_CLOSE(JFrame) : 프로그램 종료
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
					area.append("[나]"+text+"\n");
					field.setText("");
				}
			}
		}
	}
}
