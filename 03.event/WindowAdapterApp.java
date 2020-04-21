package site.itwill.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Adapter Ŭ���� : Listener �������̽� ��� �̺�Ʈ ó���� ���� ����� Ŭ����
// => Listener �������̽��� �߻�޼ҵ尡 ���� �� ����� ��� Adapter Ŭ���� ����
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowAdapterHandler());
		
		//�͸��� �ڽ�Ŭ������ �ν��Ͻ��� �����Ͽ� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		});
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowAdapterApp("WindowAdapter");
	}

	//Adapter Ŭ������ ��� ���� ��� �ʿ��� �̺�Ʈ �ڵ鷯 �޼ҵ常 �������̵� ����
	public class WindowAdapterHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}	
	}
}




