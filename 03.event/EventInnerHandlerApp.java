package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventInnerHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventInnerHandlerApp(String title) {
		super(title);
		
		Button exit=new Button("���α׷� ����");
		setLayout(new FlowLayout());
		add(exit);

		exit.addActionListener(new ButtonEventHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventInnerHandlerApp("Event");
	}
	
	//�̺�Ʈ �ڵ鷯 Ŭ������ ������ Ŭ������ ����Ŭ������ ����
	// => �̺�Ʈ �ڵ鷯 Ŭ������ �̺�Ʈ ó�� �޼ҵ忡�� ������ Ŭ������ ���۳�Ʈ ��� ����
	public class ButtonEventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}