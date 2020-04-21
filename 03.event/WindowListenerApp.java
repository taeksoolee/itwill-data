package site.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame Ŭ���������� WindowEvent �߻� 
// => WindowListener �������̽��� ��ӹ޾� �̺�Ʈ �ڵ鷯 �޼ҵ带 �������̵� �����Ͽ� �̺�Ʈ ó��
// => WindowListener �������̽��� 7���� �߻�޼ҵ带 ��� �������̵� ����
public class WindowListenerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowListenerApp(String title) {
		super(title);
		
		//Frame ���۳�Ʈ�� �̺�Ʈ �ڵ鷯 �ν��Ͻ� ��� 
		addWindowListener(new WindowListenerHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("WindowListener");
	}

	//Listener �������̽��� ��� ���� ��� ���ʿ��� �̺�Ʈ �ڵ鷯 �޼ҵ嵵 �������̵� ����
	public class WindowListenerHandler implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened() �޼ҵ� ȣ��");
		}
	
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing() �޼ҵ� ȣ��");
			System.exit(0);
		}
	
		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("windowClosed() �޼ҵ� ȣ��");
		}
	
		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified() �޼ҵ� ȣ��");
		}
	
		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified() �޼ҵ� ȣ��");
		}
	
		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated() �޼ҵ� ȣ��");
		}
	
		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated() �޼ҵ� ȣ��");
		}
	}
}
