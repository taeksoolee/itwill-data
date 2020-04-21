package site.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;

public class WindowBuilderApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField field;
	private JTextArea area;
	private JMenuItem init;
	private JMenuItem exit;
	private JButton red;
	private JButton green;
	private JButton blue;
	private JButton black;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setResizable(false);
		setTitle("WindowBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 400, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("ÆÄÀÏ(F)");
		menu.setMnemonic('F');
		menuBar.add(menu);
		
		init = new JMenuItem("\uD654\uBA74 \uCD08\uAE30\uD654(I)",KeyEvent.VK_I);
		init.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("");
			}
		});
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menu.add(init);
		
		menu.addSeparator();
		
		exit = new JMenuItem("\uD504\uB85C\uADF8\uB7A8 \uC885\uB8CC(E)",KeyEvent.VK_E);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		menu.add(exit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setFocusable(false);
		area.setFont(new Font("±¼¸²", Font.BOLD, 14));
		area.setBackground(Color.YELLOW);
		scrollPane.setViewportView(area);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		
		red = new JButton("\uBE68\uAC04\uC0C9");
		red.setFont(new Font("±¼¸²", Font.BOLD, 12));
		red.setForeground(Color.RED);
		panel.add(red);
		
		green = new JButton("\uCD08\uB85D\uC0C9");
		green.setFont(new Font("±¼¸²", Font.BOLD, 12));
		green.setForeground(Color.GREEN);
		panel.add(green);
		
		blue = new JButton("\uD30C\uB780\uC0C9");
		blue.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 12));
		blue.setForeground(Color.BLUE);
		panel.add(blue);
		
		black = new JButton("\uAC80\uC815\uC0C9");
		black.setEnabled(false);
		black.setFont(new Font("±¼¸²", Font.BOLD, 12));
		black.setForeground(Color.BLACK);
		panel.add(black);
		
		field = new JTextField();
		contentPane.add(field, BorderLayout.SOUTH);
		field.setFont(new Font("±¼¸²", Font.BOLD, 14));
		field.setColumns(10);
	}

}
