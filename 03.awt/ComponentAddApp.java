package site.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class ComponentAddApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public ComponentAddApp(String title) {
		super(title);
		
		//Button : ��ư ����� �����ϴ� Ŭ���� - �󺧸� �ο�
		Button button=new Button("��ư");
		
		//Container.add(Component c) : �����̳ʿ� ���۳�Ʈ�� �����ϴ� �޼ҵ�
		add(button);//�����ӿ� ��ư ����
		
		setBounds(500, 100, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentAddApp("���۳�Ʈ");
	}
}
