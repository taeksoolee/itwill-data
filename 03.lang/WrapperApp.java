package site.itwill.lang;

//Wrapper : �⺻ �ڷ���(Primitive Type) ��� �����Ǵ� Ŭ����
// => Byte, Short, Integer, Long, Float, Double, Character, Boolean
public class WrapperApp {
	public static void main(String[] args) {
		/*
		int num1=100, num2=200;
		int num3=num1+num2;
		System.out.println("�հ� = "+num3);
		*/
		
		/*
		Integer num1=new Integer(100);
		Integer num2=new Integer("200");
		Integer num3=Integer.valueOf(num1.intValue()+num2.intValue());
		System.out.println("�հ� = "+num3.intValue());
		*/
		
		//JDK1.5���� ����ڽ̰� �����ڽ� ��� �߰�
		//����ڽ�(Auto Boxing) : ���� �ν��Ͻ��� �ڵ� ��ȯ�ϴ� ���
		Integer num1=100, num2=200;
		//�����ڽ�(Auto UnBoxing) : �ν��Ͻ��� ������ �ڵ� ��ȯ�ϴ� ���
		//System.out.println("num1 = "+num1);
		Integer num3=num1+num2;
		System.out.println("�հ� = "+num3);
		System.out.println("============================================");
		Integer number=50;
		//Integer number=-50;
		System.out.println("number(10����) = "+number);
		System.out.println("number(8����) = "+Integer.toOctalString(number));
		System.out.println("number(16����) = "+Integer.toHexString(number));
		System.out.println("number(2����) = "+Integer.toBinaryString(number));
		System.out.println("============================================");
		String su1="123", su2="456";
		System.out.println("�հ� = "+(su1+su2));//���ڿ� ����
		//Integer.parseInt(String s) : ���ڿ��� ���޹޾� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ���޹��� ���ڿ��� ���������� ��ȯ���� ���� ��� NumberFormatException �߻�
		System.out.println("�հ� = "+(Integer.parseInt(su1)+Integer.parseInt(su2)));
		System.out.println("============================================");
		
				
	}
}








