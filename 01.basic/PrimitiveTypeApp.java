package basic;

public class PrimitiveTypeApp {
	public static void main(String[] args) {
		System.out.println("<< ������ >>");
		//��¸޼ҵ带 �̿��� ��� ������ ����� 10������ ���
		System.out.println("������ ���(10����)  = "+100);
		System.out.println("������ ���(8����) = "+0100);
		System.out.println("������ ���(16����) = "+0x100);
		
		//������ ����� ǥ�� ����(int - 4Byte) : -2147483648~2147483647
		System.out.println("������ ���(int) = "+2147483647);
		//ǥ�������� ��� int ����� ���� �߻�
		//System.out.println("������ ���(int) = "+2147483648);
		//������ ��� �ڿ� L�� ���� ��� long ����� 8Byte�� ǥ��
		System.out.println("������ ���(long) = "+2147483648L);
		
		byte a1=127;//byte(1Byte) : -128~127
		short a2=32767;//short(2Byte) : -32768~32767
		int a3=2147483647;//int(4Byte) : -2147483648~2147483647
		long a4=2147483648L;//long(8Byte)
		
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		//int a5=100L;//����Ÿ �ս� ���ɼ��� ���� ���� �߻�
		long a5=100;//����
		System.out.println("a5 = "+a5);
		System.out.println("===================================");
		System.out.println("<< �Ǽ��� >>");
		//�Ǽ��� ��� - double ���(8Byte)
		System.out.println("�Ǽ��� ���(double) = "+1.23);
		//�Ǽ��� ��� �ڿ� F�� ���� ��� float ���(4Byte)�� ǥ��
		System.out.println("�Ǽ��� ���(float) = "+1.23F);
		//�Ǽ��� ����� �������·� ǥ�� ����
		System.out.println("�Ǽ��� ���(double) = "+1.23E9);
		//�۰ų� ū �Ǽ������ ����� ��� �������·� ��ȭ�Ǿ� ��� 
		System.out.println("�Ǽ��� ���(double) = "+0.00000000123);
		
		//float b1=1.23456789;
		float b1=1.23456789F;//�������� ǥ������ : �Ҽ��� 7�ڸ�
		double b2=1.23456789;//�������� ǥ������ : �Ҽ��� 15�ڸ�
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
		System.out.println("===================================");
		System.out.println("<< ������ >>");
		//������ ����� ' ' �ȿ� �ϳ��� ���ڷ� ǥ�� - 2Byte
		System.out.println("������ ��� = "+'A');
		System.out.println("������ ��� = "+'��');
		//ǥ�� �Ұ����� ���ڴ� ȸ�ǹ���(Escape Character)�� ǥ�� - \ ��ȣ
		System.out.println("������ ��� = "+'\'');
		
		char c1='A';//���������� ��ӵ� ���ڿ� ���� ���������� ����
		char c2=65;//��ӵ� ���ڿ� ���� ������ ���� ����
		char c3='a'-32;//��ӵ� ���ڿ� ���� ������ ���� ����
		
		//���ں����� ����� ����� �������·� ��ȯ�Ǿ� ���
		System.out.println("c1 = "+c1);
		System.out.println("c2 = "+c2);
		System.out.println("c3 = "+c3);
		System.out.println("====================================");
		System.out.println("<< ���� >>");
		System.out.println("���� ��� = "+false);
		System.out.println("���� ��� = "+true);
		//�����(�񱳽�)�� ����� ���� ��� ��ȯ
		System.out.println("���� ��� = "+(20<10));
		System.out.println("���� ��� = "+(20>10));
		
		boolean d1=false;
		boolean d2=20>10;
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("====================================");
		System.out.println("<< ���ڿ� >>");
		//���ڿ� ����� " "(String ��ü) �ȿ� ���ڵ�� ǥ��
		System.out.println("�̸� = "+"ȫ�浿");
		System.out.println("\"���ѹα� ����\" ���ϱ�");
		
		//���ڿ��� String Ŭ����(������)�� �̿��Ͽ� ǥ��
		String e1="JAVA";
		String e2="JSP";
		//���ڿ� ����� ���� + �����ڴ� ���ڿ� ���� �ǹ�
		String e3=e1+" & "+e2;
		System.out.println("e3 = "+e3);
	}
}

