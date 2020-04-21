package site.itwill.event;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�̺�Ʈ ���α׷� �ۼ����
//1.���۳�Ʈ(�����̳�)�� �̿��Ͽ� ������ Ŭ���� �ۼ� - Frame Ŭ���� ���
// => ���۳�Ʈ(�����̳�)������ �پ��� �̺�Ʈ �߻� - �̺�Ʈ �ҽ�(Event Source)
//2.�̺�Ʈ�� ó���ϱ� ���� �̺�Ʈ �ڵ鷯 Ŭ���� �ۼ�
// => ���۳�Ʈ���� �߻��� �̺�Ʈ�� ó���ϱ� ���� Ŭ����
// => XXXEvent�� ó���ϱ� ���� XXXListener �������̽��� ��ӹ޾� �ۼ�
// => ������ �������̽� : �̺�Ʈ�� ó���ϱ� ���� �߻�޼ҵ尡 ����� �������̽�
// => �߻�޼ҵ带 �������̵� �����Ͽ� �޼ҵ忡 �̺�Ʈ ó�� ����� �ۼ�
//3.�̺�Ʈ �ҽ����� �̺�Ʈ�� �߻��� ��� �̺�Ʈ �ڵ鷯�� ���۵ǵ��� �̺�Ʈ ���
// => Component.addXXXListener(XXXListener l) : ���۳�Ʈ���� �̺�Ʈ�� �߻���
//    ��� �̺�Ʈ �ڵ鷯 �ν��Ͻ��� �̿��Ͽ� �̺�Ʈ ó���ϴ� �޼ҵ�

//������ Ŭ���� - Frame Ŭ���� ��ӹ޾� �ۼ�
public class EventHandlerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public EventHandlerApp(String title) {
		super(title);

		//Button ���۳�Ʈ�� ����ڸ� ���� ��� ActionEvent �߻�
		// => �ý���(OS)���� ���۳�Ʈ�� �̺�Ʈ�� ���� �ν��Ͻ� �ڵ� ����
		Button exit=new Button("���α׷� ����");
		setLayout(new FlowLayout());
		add(exit);
		
		//Button ���۳�Ʈ���� ActionEvent�� �߻��� ��� ButtonEventHandler
		//�ν��Ͻ��� �̿��Ͽ� �̺�Ʈ ó���ǵ��� ���
		// => �̺�Ʈ �ڵ鷯 �ν��Ͻ��� �̺�Ʈ ó�� �޼ҵ� �ڵ� ȣ��
		exit.addActionListener(new ButtonEventHandler());
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandlerApp("Event");
	}
}

//�̺�Ʈ �ڵ鷯 Ŭ���� - ������ �������̽��� ��ӹ޾� �ۼ�
//Button ���۳�Ʈ���� �߻��� ActionEvent�� ó���ϱ� ���� Ŭ����
class ButtonEventHandler implements ActionListener {
	//Button ���۳�Ʈ ���� ��� ȣ��Ǿ� ����Ǵ� �̺�Ʈ ó�� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}






