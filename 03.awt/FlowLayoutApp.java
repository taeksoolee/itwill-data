package site.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

//FlowLayout : ���۳�Ʈ�� ���ʿ��� ���������� ���ʴ�� ��ġ�ǵ��� �����ϴ� ��ġ������
// => �����̳��� ũ�⸦ ��� ��� �ڵ����� �Ʒ��� ��ġ
public class FlowLayoutApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public FlowLayoutApp(String title) {
		super(title);
		
		Button button1=new Button("��ư-1"); 
		Button button2=new Button("��ư-2"); 
		Button button3=new Button("��ư-3"); 
		Button button4=new Button("��ư-4"); 
		Button button5=new Button("��ư-5");
		
		//�������� ��ġ�����ڸ� BorderLayout���� FlowLayout���� ����
		setLayout(new FlowLayout());
		
		add(button1);	
		add(button2);	
		add(button3);	
		add(button4);	
		add(button5);	
		
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutApp("FlowLayout");
	}
}



