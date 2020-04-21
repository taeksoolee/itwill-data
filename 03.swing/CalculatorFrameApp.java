package site.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//�ܼ� ��Ģ ������� �Է¹޾� ���� ����� ����ϴ� ���α׷�
public class CalculatorFrameApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	//������� �Է��ϱ� ���� �ʵ�(���۳�Ʈ)
	private JButton b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_equals, b_plus,
			b_minus, b_multi, b_div, b_C;

	//���� ����� ����ϱ� ���� �ʵ�(���۳�Ʈ)
	private JLabel label;

	//������� �����ϱ� ���� �ʵ�
	private String operation="";
	
	public CalculatorFrameApp(String title) {
		super(title);
		initButtons();
		init();
	}

	private void init() {
		label = new JLabel("0");
		label.setFont(new Font("DIALOG", Font.BOLD, 30));
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setBackground(Color.LIGHT_GRAY);
		label.setForeground(Color.WHITE);

		JPanel p = new JPanel(new GridLayout(4, 4, 5, 5));
		p.setBackground(Color.BLACK);
		
		p.add(b_multi);
		p.add(b_div);
		p.add(b_plus);
		p.add(b_minus);
		p.add(b_1);
		p.add(b_2);
		p.add(b_3);
		p.add(b_4);
		p.add(b_5);
		p.add(b_6);
		p.add(b_7);
		p.add(b_8);
		p.add(b_9);
		p.add(b_0);
		p.add(b_equals);
		p.add(b_C);
		
		Container container=getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		container.setBackground(Color.BLACK);
		container.add(label, BorderLayout.NORTH);
		container.add(p, BorderLayout.CENTER);
		
		b_0.addActionListener(this);
		b_1.addActionListener(this);
		b_2.addActionListener(this);
		b_3.addActionListener(this);
		b_4.addActionListener(this);
		b_5.addActionListener(this);
		b_6.addActionListener(this);
		b_7.addActionListener(this);
		b_8.addActionListener(this);
		b_9.addActionListener(this);
		b_div.addActionListener(this);
		b_plus.addActionListener(this);
		b_minus.addActionListener(this);
		b_multi.addActionListener(this);
		b_C.addActionListener(this);
		b_equals.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}

	private void initButtons() {
		b_0 = new JButton("0");
		b_1 = new JButton("1");
		b_2 = new JButton("2");
		b_3 = new JButton("3");
		b_4 = new JButton("4");
		b_5 = new JButton("5");
		b_6 = new JButton("6");
		b_7 = new JButton("7");
		b_8 = new JButton("8");
		b_9 = new JButton("9");
		b_equals = new JButton("=");
		b_plus = new JButton("+");
		b_minus = new JButton("-");
		b_multi = new JButton("*");
		b_div = new JButton("/");
		b_C = new JButton("C");

		b_0.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_1.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_2.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_3.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_4.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_5.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_6.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_7.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_8.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_9.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_div.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_plus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_minus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_multi.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_C.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_equals.setFont(new Font("DIALOG", Font.PLAIN, 20));
		
		b_0.setBackground(Color.WHITE);
		b_1.setBackground(Color.WHITE);
		b_2.setBackground(Color.WHITE);
		b_3.setBackground(Color.WHITE);
		b_4.setBackground(Color.WHITE);
		b_5.setBackground(Color.WHITE);
		b_6.setBackground(Color.WHITE);
		b_7.setBackground(Color.WHITE);
		b_8.setBackground(Color.WHITE);
		b_9.setBackground(Color.WHITE);
		b_div.setBackground(Color.YELLOW);
		b_plus.setBackground(Color.YELLOW);
		b_minus.setBackground(Color.YELLOW);
		b_multi.setBackground(Color.YELLOW);
		b_C.setBackground(Color.GREEN);
		b_equals.setBackground(Color.CYAN);
	}

	public static void main(String[] args) {
		new CalculatorFrameApp("����");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object button=e.getSource();
		
		if(button==b_equals) {//Equals ��ư�� ���� ���
			//�ʵ忡 ����� ����Ŀ��� �����ڸ� �˻��Ͽ� ��ġ��(÷��)�� ��ȯ�޾� ����
			String[] operatorArray={"*","/","+","-"};
			int index=-1;
			for(String temp:operatorArray) {
				index=operation.lastIndexOf(temp);
				if(index!=-1) break;
			}
			
			//�����ڰ� �������� ���� ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ����
			if(index==-1) return;
			
			try {
				//�������� ��ġ���� �̿��Ͽ� �����ڿ� �ǿ����ڸ� �и��Ͽ� ����
				int num1=Integer.parseInt(operation.substring(0, index));
				String operator=operation.substring(index, index+1);
				int num2=Integer.parseInt(operation.substring(index+1));
				
				//���� ��� ����
				int result=0;
				switch (operator) {
				case "*": result=num1*num2;	break;
				case "/": result=num1/num2;	break;
				case "+": result=num1+num2;	break;
				case "-": result=num1-num2;	break;
				}
				
				//��� ���۳�Ʈ�� ���� ��������� ����
				label.setText(String.valueOf(result));
				
				//����� ���� �ʵ忡 ���� �ʱ�ȭ
				//operation="";
				operation=result+"";
			} catch (ArithmeticException exception) {
				operation="";
				label.setText("0���� ������ �����ϴ�.");
			} catch (NumberFormatException exception) {
				operation="";
				//JOptionPane.showMessageDialog(Component parentComponent
				//, Object message, String title, int messageType) : 
				//�޼��� ��� ���̾�α׸� �����ִ� �޼ҵ�
				JOptionPane.showMessageDialog(this, "�Է� ������� �߸� �Ǿ����ϴ�."
						, "����", JOptionPane.ERROR_MESSAGE);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(this, "���α׷� ���࿡ ������ �߻� �Ͽ����ϴ�."
						, "����", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} else if(button==b_C) {//Clear ��ư�� ���� ���
			//����� ���� �ʵ忡 ���� �ʱ�ȭ
			operation="";
			//��� ���۳�Ʈ �ʱ�ȭ
			//JLabel.setText(String text) : JLabel ���۳�Ʈ�� ���ڿ��� �����ϴ� �޼ҵ�
			label.setText("0");
		} else {//����� ���� ��ư�� ���� ���
			//����� ���� �ʵ忡 �̺�Ʈ �߻� ��ư�� ���ڿ��� ���� �߰�
			//JButton.getText() : JButton ���۳�Ʈ�� �󺧸��� ��ȯ�ϴ� �޼ҵ�
			operation+=((JButton)button).getText();
			
			//��� ���۳�Ʈ�� ���ڿ��� ����� ���� �ʵ尪���� ����
			label.setText(operation);
		}
	}
}
