package site.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//��ġ������(LayoutManager) : ���۳�Ʈ�� ��� ��ġ�� ũ�⸦ �ڵ����� ����
//�Ͽ� �����ǵ��� �����ϴ� ����� �����ϴ� Ŭ����
// => BorderLayout, FlowLayout, GridLayout ��

//��� �����̳ʿ��� ���۳�Ʈ�� �����ϱ� ���� ��ġ�����ڰ� �⺻������ ����
// => BorderLayout : Frame, Dialog �� 
// => FlowLayout : Panel ��   

//BorderLayout : ���۳�Ʈ�� ��, ��, ��, ��, �߾ӿ� ��ġ�ǵ��� �����ϴ� ��ġ������
// => ���۳�Ʈ�� ������ ��� �ݵ�� ������ġ ���� - ������ġ�� �����Ǹ� �߾ӿ� ����
// => ������ ��ġ�� ���۳�Ʈ�� ������ ��� ������ �߻�
public class BorderLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;

	public BorderLayoutApp(String title) {
		super(title);
		
		Button button1=new Button("��ư-1"); 
		Button button2=new Button("��ư-2"); 
		Button button3=new Button("��ư-3"); 
		Button button4=new Button("��ư-4"); 
		Button button5=new Button("��ư-5");
		
		/*
		//�������� ��ġ�����ڸ� BorderLayout���� ����
		// => �������� �⺻ ��ġ�����ڰ� BorderLayout�̹Ƿ� ���� ���ǹ�
		//BorderLayout layout=new BorderLayout();
		//setLayout(layout);
		
		setLayout(new BorderLayout());
		*/
		
		//Container.add(Component c, Object constraints) : BorderLayout���� ���۳�Ʈ��
		//���ϴ� ��ġ�� �����ϴ� �޼ҵ� - ��ġ�� BorderLayout Ŭ������ ����ʵ� ���
		add(button1, BorderLayout.CENTER);//�߾� - �ʼ�
		add(button2, BorderLayout.EAST);
		add(button3, BorderLayout.WEST);
		add(button4, BorderLayout.SOUTH);
		add(button5, BorderLayout.NORTH);
		
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutApp("BorderLayout");
	}
}










