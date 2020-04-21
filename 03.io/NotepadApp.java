package site.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//�ؽ�Ʈ ���� ������ ���α׷� - �޸���
public class NotepadApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem init,open,save,exit;
	private JTextArea area;
	private FileDialog openDialog, saveDialog;
	
	//���� �۾����� ���� ��θ� �����ϱ� ���� �ʵ�
	private String filePath;
	
	//JTextArea ���۳�Ʈ�� ���� ���� ���¸� �����ϱ� ���� �ʵ�
	// => false : �̺���, true : ����
	private boolean state;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar bar=new JMenuBar();
		JMenu menu=new JMenu("����(F)");
		menu.setMnemonic('F');
		init=new JMenuItem("���� �����(N)", 'N');
		open=new JMenuItem("����(O)", 'O');
		save=new JMenuItem("����(S)", 'S');
		exit=new JMenuItem("������(X)", 'X');
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));		
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));		
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menu.add(init);
		menu.add(open);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		bar.add(menu);
		setJMenuBar(bar);
		
		area=new JTextArea();
		area.setFont(new Font("����", Font.PLAIN, 16));
		JScrollPane pane=new JScrollPane(area);
		getContentPane().add(pane, BorderLayout.CENTER);
		
		openDialog=new FileDialog(this, "����", FileDialog.LOAD);
		saveDialog=new FileDialog(this, "����", FileDialog.SAVE);
		
		init.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		
		//JTextArea ���۳�Ʈ���� Ű���� ���� �̺�Ʈ�� �߻��� ��� �̺�Ʈ�� ó���� �̺�Ʈ �ڵ鷯 ���
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//�̺�Ʈ �߻� Ű������ ���ڰ��� NULL ���ڰ� �ƴ� ��� 
				if(e.getKeyChar()!='\0') {
					state=true;
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(saveConfirm()) System.exit(0);
			}
		});
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(150, 50, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("���� ���� - �޸���");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventSource=e.getSource();
		
		if(eventSource==init) {
			if(saveConfirm()) {
				//JTextArea ���۳�Ʈ �ʱ�ȭ
				area.setText("");
				//JFrame ���۳�Ʈ�� ���� �ʱ�ȭ
				setTitle("���� ���� - �޸���");
				//�۾� ������ �����ϴ� �ʵ尪 �ʱⰪ
				filePath=null;
			}
		} else if(eventSource==open) {
			if(!saveConfirm()) return;
			
			//���� ���� FileDialog ���۳�Ʈ�� ȭ�鿡 ���
			// => ������ �����ϰų� ����� ��� FileDialog ���۳�Ʈ�� �ڵ����� ��������.
			//FileDialog.getDirectory() : ���� ������ �����ϴ� ���丮 ��θ� ��ȯ�ϴ� �޼ҵ� 
			//FileDialog.getFile() : ���� ������ ��ȯ�ϴ� �޼ҵ�
			openDialog.setVisible(true);
			
			//FileDialog ���۳�Ʈ���� ��Ҹ� ������ ��� �̺�Ʈ �ڵ鷯 �޼ҵ� ���
			if(openDialog.getFile()==null) return;
			
			//���� ������ ���� ��θ� ��ȯ�޾� �ʵ尪���� ����
			filePath=openDialog.getDirectory()+openDialog.getFile();
			
			//JFrame ���۳�Ʈ�� ���� ����
			setTitle(openDialog.getFile()+" - �޸���");
			
			//JTextArea ���۳�Ʈ �ʱ�ȭ
			area.setText("");
			
			try {
				//���� �Է½�Ʈ���� ��뷮 �Է½�Ʈ������ Ȯ���Ͽ� ����
				BufferedReader in=new BufferedReader(new FileReader(filePath));
				
				//���Ͽ� ����� ������ �� �پ� �о� JTextArea ���۳�Ʈ�� �߰�
				while(true) {
					//������������ ���ڵ��� �о� ���ڿ��� ��ȯ - �� �پ� �о�� ���� 
					String text=in.readLine();
					if(text==null) break;
					area.append(text+"\n");
				}
				
				in.close();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "������ ������ �������� �ʽ��ϴ�."
					, "����", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�."
					, "����", JOptionPane.ERROR_MESSAGE);
			}
		} else if(eventSource==save) {
			//���� �۾� ���� ������ ���� ���
			if(filePath==null) {
				//���� ���� FileDialog ���۳�Ʈ�� ȭ�鿡 ���
				saveDialog.setVisible(true);
				if(saveDialog.getFile()==null) return;
				filePath=saveDialog.getDirectory()+saveDialog.getFile();
				setTitle(saveDialog.getFile()+" - �޸���");
			}
			
			try {
				//���� ��½�Ʈ���� ��뷮 ��½�Ʈ������ Ȯ���Ͽ� ����
				BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
				
				//JTextArea ���۳�Ʈ�� ��� ���ڿ��� ��ȯ�޾� ����
				String text=area.getText();
				
				//Windows �ü�������� ���͸� "\n"�� �ƴ� "\r\n"���� ǥ��
				//String text=area.getText().replace("\n", "\r\n");
				
				//���� ��½�Ʈ���� ���ڿ��� ���� => ���� ����
				out.write(text);
				
				out.close();

				//JTextArea ���۳�Ʈ�� ���� ���� ���� �ʱ�ȭ
				state=false;
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�."
						, "����", JOptionPane.ERROR_MESSAGE);
			}
		} else if(eventSource==exit) {
			if(saveConfirm()) System.exit(0);
		}
	}
	
	//JTextArea ���۳�Ʈ�� ������ ����� ��� Ư�� �̺�Ʈ���� JTextArea
	//���۳�Ʈ�� ���泻�뿡 ���� ���� ������ ���� ó���ϱ� ���� �޼ҵ�
	// => ��ȯ�� - false : ��� ����, true : ���� �Ǵ� ������ ����
	public boolean saveConfirm() {
		//JTextArea ���۳�Ʈ�� ������ ����� ���
		if(state) {
			//JOptionPane.showConfirmDialog(Component parentComponent
			//, Object message, String title, int optionType) :
			//���� ���̾�α׸� ����ϴ� �޼ҵ� - ���� ����� ��ȯ
			int choice=JOptionPane.showConfirmDialog(this, "����� ������ ���� �Ͻðڽ��ϱ�?"
				, "Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION);
			
			//���� ������ ������ ���
			if(choice==JOptionPane.YES_OPTION) {
				if(filePath==null) {
					saveDialog.setVisible(true);
					if(saveDialog.getFile()==null) return false;
					filePath=saveDialog.getDirectory()+saveDialog.getFile();
					setTitle(saveDialog.getFile()+" - �޸���");
				}
				
				try {
					BufferedWriter out=new BufferedWriter(new FileWriter(filePath));
					String text=area.getText();
					out.write(text);
					out.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(this, "���α׷��� ������ �߻� �Ͽ����ϴ�."
							, "����", JOptionPane.ERROR_MESSAGE);
				} 
			} else if(choice==JOptionPane.CANCEL_OPTION) {//��Ҹ� ������ ���
				return false;
			} 
		}
		
		//JTextArea ���۳�Ʈ�� ���� ���� ���� �ʱ�ȭ
		state=false;
		
		//���� �Ǵ� �������� ������ ���
		return true;
	}
}








