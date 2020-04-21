package site.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

public class NonLayoutManagerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public NonLayoutManagerApp(String title) {
		super(title);
		
		Button button1=new Button("��ư-1");
		Button button2=new Button("��ư-2");
		
		//Container.setLayout(LayoutManager l) : �����̳��� ��ġ�����ڸ� �����ϴ� �޼ҵ�
		// => ��ġ������(LayoutManager)�� null�� ������ ��� ��ġ������ �̻��
		setLayout(null);
		
		//��ġ�����ڰ� ���� ��� ���۳�Ʈ�� ��� ��ġ�� ũ�⸦ ���� �� ����
		button1.setBounds(80, 100, 50, 80);
		button2.setBounds(190, 130, 100, 120);
		
		add(button1);
		add(button2);
		
		setBounds(500, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("NonLayoutManager");
	}
}