package basic;

public class VariableApp {
	public static void main(String[] args) {
		//���� ����
		int num;
		
		//������ �� ���� - �ʱ�ȭ
		num=100;
		
		//������ ���
		System.out.print("���� �� ������ = ");
		System.out.println(num);
		
		//������ �� ���� - �� ���� >> ������(OverWrite)
		num=200;
		System.out.print("���� �� ������ = ");
		System.out.println(num);
		System.out.println("====================================");

		//���� ���� �� �ʱ�ȭ
		int su=300;

		//"��´��"+������ or ������+"��´��" >> ��´�� ������ ����(���ڿ� ��ȯ)
		System.out.println("su = "+su);
		System.out.println("====================================");
		System.out.println("���ش� "+2+0+1+9+"���Դϴ�.");
		System.out.println(2+0+1+9+"���� �������� ���Դϴ�.");
		System.out.println(""+2+0+1+9+"���� �������� ���Դϴ�.");
		System.out.println("====================================");
		//������ �ڷ����� ������ �����Ͽ� ���� ����
		int num1=10,num2=20;
		System.out.println("������ = "+num1+num2);
		System.out.println("������ = "+(num1+num2));
		System.out.println("������ = "+num1*num2);
		System.out.println("������ = "+(num1*num2));
		System.out.println("====================================");
		int kor=88, eng=90;
		//�������� ������ ����
		int tot=kor+eng;
		System.out.println("�����հ� = "+tot);		
		System.out.println("====================================");
		/*
		int number;
		//������ ���� ����Ǿ� ���� ���� ���·� ���� ��� ���� �߻�
		System.out.println("number = "+number);
		*/
		
		/*
		//������ ���� �Ұ����� ���� ������ ��� ���� �߻�
		int number=10.0;
		System.out.println("number = "+number);
		*/
	}
}






