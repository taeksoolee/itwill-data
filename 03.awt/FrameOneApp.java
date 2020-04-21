package site.itwill.awt;

import java.awt.Frame;

//���۳�Ʈ(Component) : GUI ���α׷��� ������ ��Ҹ� �����ϴ� Ŭ����
// => Button, Label, Canvas, Checkbox, Choice, List, Scrollbar, TextField, TextArea ��
//�����̳�(Container) : ���۳�Ʈ�� ���� �� �ִ� ���۳�Ʈ
// => Frame, Window, Dialog, Panel, ScrollPane ��
public class FrameOneApp {
	public static void main(String[] args) {
		//Frame : �޴��� �ִ� â�� ����� ���� �����̳�
		//Frame f=new Frame();//������ ���� ������ ����
		Frame f=new Frame("������");//������ �ִ� ������ ����
		
		//Frame.setTitle(String title) : �������� ������ �����ϴ� �޼ҵ�
		//f.setTitle("������");
		
		/*
		//Component.setLocation(int x, int y) : ���۳�Ʈ�� ��� ��ġ�� �����ϴ� �޼ҵ�
		// => �̵� �Ǵ� ũ�� ���� �ȼ�(Pixel) ���
		//�ȼ� : �ϳ��� ���� ��µǴ� ��
		f.setLocation(500, 100);
		
		//Component.setSize(int width, int height) : ���۳�Ʈ�� ũ�⸦ �����ϴ� �޼ҵ�
		f.setSize(300, 400);
		*/
		
		//Component.setBounds(int x, int y, int width, int height) : ���۳�Ʈ��
		//��� ��ġ�� ũ�⸦ �����ϴ� �޼ҵ�
		f.setBounds(500, 100, 300, 400);
		
		//Frame.setResizable(boolean b) : �������� ũ�� ���� ���θ� �����ϴ� �޼ҵ�
		// => false : �̺���,  true : ����(�⺻) 
		f.setResizable(false);
		
		//Component.setVisible(boolean b) : ���۳�Ʈ�� ȭ�� ��� ���θ� �����ϴ� �޼ҵ�
		// => false : �����(�⺻),  true : ��� 
		// => �����̳ʿ� ������ ����� �����̳ʿ� ��� ���۳�Ʈ�� ������ ����  
		f.setVisible(true);
	}
}










