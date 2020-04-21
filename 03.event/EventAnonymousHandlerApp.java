package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAnonymousHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnonymousHandlerApp(String title) {
		super(title);
		
		Button exit=new Button("���α׷� ����");
		setLayout(new FlowLayout());
		add(exit);
		
		//�߻�Ŭ���� �Ǵ� �������̽��� �̿��Ͽ� �ν��Ͻ� ���� �Ұ���
		// => Ŭ������ ��ӹ޾� ����ϴ� ��� ���� �ڷ���
		//�߻�Ŭ����(�������̽�)�� �߻�޼ҵ带 ���� �������̵� �����Ͽ� �ν��Ͻ� ����
		// => ��ӹ��� �ڽ�Ŭ������ �̸��� �������� �ʰ� �ۼ� ����
		// => �͸��� ���� Ŭ����(Anonymous Inner Class)�� �ϳ��� �ν��Ͻ� ����
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnonymousHandlerApp("Event");
	}
}
