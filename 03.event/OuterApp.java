package site.itwill.event;

import site.itwill.event.Outer.Inner;
import site.itwill.event.Outer.Nested;

public class OuterApp {
	public static void main(String[] args) {
		//����Ŭ������ �̿��Ͽ� �ν��Ͻ� ���� �Ұ���
		//Inner inner=new Inner(100);
		
		Outer outer=new Outer(100);
		outer.outerDisplay();
		System.out.println("============================================");
		//�ܺ�Ŭ������ �ν��Ͻ��� �̿��Ͽ� ����Ŭ������ �ν��Ͻ� ���� ����
		Inner inner=outer.new Inner(200);
		inner.innerDisplay();
		System.out.println("============================================");
		//����Ŭ������ �̿��Ͽ� �ν��Ͻ� ���� ����
		Nested nested=new Nested(300);
		nested.nestedDisplay();
		System.out.println("============================================");
	}
}







