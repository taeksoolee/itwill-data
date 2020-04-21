package site.itwill.util;

//Generic Ÿ���� �ʵ尡 ����� Ŭ������ �ν��Ͻ��� �����Ͽ� ����ϴ� ���α׷�
// => Generic Ÿ������ ���޵� Ŭ������ �ν��Ͻ��� ����(����) ����
// => ��ü ����ȯ�� ���� �ʾƵ� �ʵ尪�� ��ȯ�޾� ���
public class GenericApp {
	public static void main(String[] args) {
		//���׸� Ŭ����(�������̽�)�� ����ϰ��� �� ��� Generic Ÿ�Կ�
		//Ŭ����(�������̽�)�� �����ؾ߸� ��� ����
		// => Generic Ÿ�� ��� ���޵� Ŭ����(�������̽�)�� �̿��Ͽ� �ʵ� ����
		Generic<Integer> g1=new Generic<Integer>();
		
		g1.setField(100);
		//���ظ� ��� ���޵� Ŭ������ �ν��Ͻ��� �ƴ� ��� �ʵ忡 ������ �� �����Ƿ� ���� �߻�
		//g1.setField(12.34);
		
		//���ظ� ��� ���޵� Ŭ������ �ν��Ͻ� ��ȯ
		int g1Value=g1.getField().intValue();
		
		System.out.println("������ = "+g1Value);
		System.out.println("============================================");
		Generic<Double> g2=new Generic<Double>();

		g2.setField(12.34);
		
		double g2Value=g2.getField().doubleValue();
		System.out.println("�Ǽ��� = "+g2Value);
		System.out.println("============================================");
		Generic<String> g3=new Generic<String>();

		g3.setField("ȫ�浿");
		
		String g3Value=g3.getField().replace("ȫ", "��");
		System.out.println("���ڿ� = "+g3Value);
		System.out.println("============================================");
	}
}











