package basic;

public class LocalVariableApp {
	public static void main(String[] args) {
		//��������(Local Variable) : �� ���ο��� ����� ����
		// => ����� �� ���ο����� ��� ����
		// => ����� ���� ����� ��� ���� �ڵ� �Ҹ�
		int num1=100;

		//���Ǻ�
		{
			int num2=200;
			System.out.println("========== ���Ǻ� ���� ==========");
			System.out.println("num1 = "+num1);
			System.out.println("num2 = "+num2);
		}

		System.out.println("========== ���Ǻ� �ܺ� ==========");
		System.out.println("num1 = "+num1);
		//���Ǻ� ����� num2 ���� �ڵ� �Ҹ�Ǿ� ��� �Ұ���
		//System.out.println("num2 = "+num2);
	}
}



