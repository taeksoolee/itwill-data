package site.itwill.awt;

import java.awt.Frame;

//GUI ���α׷��� Frame Ŭ������ ��ӹ޾� �ۼ��ϴ� ���� ����
public class FrameTwoApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	//�����ӿ� ���� ������ �۾�
	public FrameTwoApp(String title) {
		//super Ű���带 �̿��Ͽ� Frame Ŭ������ ������ ȣ�� - ���� �ο�
		super(title);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//�θ� �ν��Ͻ� ���� �� �ڽ� �ν��Ͻ� ����
		// => Frame �ν��Ͻ� ���� - ������ ����
		new FrameTwoApp("������");
	}
}
