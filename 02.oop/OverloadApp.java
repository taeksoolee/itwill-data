package oop;

public class OverloadApp {
	public static void main(String[] args) {
		Overload overload=new Overload();
		
		overload.displayInt(100);
		//overload.displayInt(12.34);		
		overload.displayBoolean(false);
		overload.displayString("ȫ�浿");
		System.out.println("============================================");
		//�Ű������� ���޵Ǵ� ���� ���� �ٸ� �޼ҵ� ȣ��Ǿ� ����
		// => �޼ҵ� �����ε忡 ���� ������
		//������ : ���� �̸��� �޼ҵ带 ȣ���ص� ���¿� ���� �ٸ� �޼ҵ尡 ȣ��
		// => �޼ҵ� �����ε�, �޼ҵ� �������̵�
		overload.display(200);
		//overload.display(12.34);
		overload.display(true);
		overload.display("�Ӳ���");
		System.out.println("============================================");
	}
}
