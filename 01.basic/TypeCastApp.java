package basic;

public class TypeCastApp {
	public static void main(String[] args) {
		//�ڷ����� �ٸ� ��� ����� �ڵ� ����ȯ�Ǿ� ���� ó��
		System.out.println("��� = "+(3+1.5));
		
		System.out.println("��� = "+(95/10));
		System.out.println("��� = "+(95/10.0));
		
		byte a1=10,a2=20;
		//int ���� ���� �ڷ����� ��� ������ ������ int �ڷ������� ��ȯ�Ǿ� ���� ó��
		//byte a3=a1+a2;
		int a3=a1+a2;
		System.out.println("a3 = "+a3);
		System.out.println("===================================");
		//Cast �����ڸ� �̿��Ͽ� ����� ������ ����ȯ�Ͽ� ���� ó��
		int num=(int)12.3;//(int)12.3 >> 12
		System.out.println("num = "+num);
		
		int num1=95,num2=10;
		double num3=(double)num1/num2;
		System.out.println("num3 = "+num3);
		
		//������ ū ��� _�� �̿��Ͽ� ���� ǥ�� ����
		int su1=100_000_000,su2=30;
		//����)�������� ���������� �ʰ��ϹǷ� ������ �߻�
		//int su3=su1*su2;
		//�ذ��)Cast �����ڸ� �̿��� ���� ����ȯ �̿�
		long su3=(long)su1*su2;
		System.out.println("su3 = "+su3);
		
		double number=1.23456789;
		System.out.println("number = "+number);
		//�Ҽ��� 2�ڸ������� ��µǵ��� �ۼ�
		System.out.println("number(�ø�) = "+(int)(number*100+0.9)/100.0);
		System.out.println("number(�ݿø�) = "+(int)(number*100+0.5)/100.);
		System.out.println("number(����) = "+(int)(number*100)/100.);
	}
}






