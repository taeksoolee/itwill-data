package site.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ä�� Ŭ���̾�Ʈ ���α׷�
// => �������� ������ �޼����� ��ȯ�޾� ���۳�Ʈ�� ��� - �ݺ�ó��
// => ���۳�Ʈ�� �޼����� �Է��Ͽ� ������ ���� - �̺�Ʈ �ڵ鷯
public class ChatClientApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField field;//�Է� ���۳�Ʈ
	private JTextArea area;//��� ���۳�Ʈ
	
	//���� ���� ���������� �����ϱ� ���� �ʵ�
	private Socket socket;
	
	//�������� ������ �޼����� �ޱ� ���� �Է½�Ʈ���� �����ϱ� ���� �ʵ�
	private BufferedReader in;
	
	//������ �޼����� ������ ���� ��½�Ʈ���� �����ϱ� ���� �ʵ�
	private PrintWriter out;
	
	private String aliesName;//��ȭ�� ���� �ʵ�
	
	public ChatClientApp(String title) {
		super(title);
		
		field=new JTextField();
		area=new JTextArea();
		
		JScrollPane pane=new JScrollPane(area);
		
		getContentPane().add(pane, BorderLayout.CENTER);
		getContentPane().add(field, BorderLayout.SOUTH);
		
		field.setFont(new Font("����", Font.BOLD, 20));
		area.setFont(new Font("����", Font.BOLD, 20));
		area.setFocusable(false);
		
		//�Է� ���۳�Ʈ���� �̺�Ʈ�� �߻��� ��� ó���� �̺�Ʈ �ڵ鷯 ���
		field.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 50, 400, 500);
		setVisible(true);
		
		try {
			socket=new Socket("192.168.14.31", 6000);//���� ����
			
			//������ �Է½�Ʈ���� �����޾� ���ڿ��� �б� ���� ��Ʈ������ Ȯ��
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//������ ��½�Ʈ���� �����޾� ���ڿ��� �����ϱ� ���� ��Ʈ������ Ȯ��
			out=new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "������ ������ �� �����ϴ�."
					, "���ӿ���", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//��ȭ���� �Է¹޾� ����
		while(true) {
			//�Է� ���̾�α׸� ����Ͽ� ��ȭ���� �Է¹޾� ����
			aliesName=JOptionPane.showInputDialog(this, "��ȭ���� �Է��� �ּ���."
				,"��ȭ�� �Է�",JOptionPane.QUESTION_MESSAGE);
			if(aliesName!=null && !aliesName.equals("")) break;
			JOptionPane.showMessageDialog(this, "��ȭ���� �ݵ�� �Է��� �ּ���."
				, "�Է¿���", JOptionPane.ERROR_MESSAGE);
		}
		
		//�Էµ� ��ȭ���� ������ ����
		out.println(aliesName);
		
		//�������� ������ �޼����� ���޹޾� ���۳�Ʈ�� ��� - ���ѷ���
		while(true) {
			try {
				area.append(in.readLine()+"\n");
				
				//JTextArea.setCaretPosition(int position) : JTextArea 
				//���۳�Ʈ�� ��ġ�� �����ϴ� �޼ҵ� 
				area.setCaretPosition(area.getText().length());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "�������� ������ ���������ϴ�."
					, "���ӿ���", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("ä�� ���α׷�");
	}

	//�̺�Ʈ �ڵ鷯 �޼ҵ� - ���۳�Ʈ���� �Էµ� �޼����� ������ ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//�Է� ���۳�Ʈ�� ���ڿ��� ��ȯ�޾� ����
		String message=field.getText();
		
		if(!message.equals("")) {//�޼����� ������ ���
			out.println(message);//������ �޼��� ����
			field.setText("");//�Է� ���۳�Ʈ �ʱ�ȭ
		}
	}
}






