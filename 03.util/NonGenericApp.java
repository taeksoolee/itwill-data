package site.itwill.util;

//Object Ÿ���� �ʵ尡 ����� Ŭ������ �ν��Ͻ��� �����Ͽ� ����ϴ� ���α׷�
// => �ʵ忡 ��� �ν��Ͻ��� �����Ͽ� ����(����) ����
// => �ʵ忡 ����� �ν��Ͻ��� ��ȯ�޾� ����� ��� �ݵ�� ����� ��ü ����ȯ �̿�
public class NonGenericApp {
	public static void main(String[] args) {
		NonGeneric ng1=new NonGeneric();
		
		//Object Ÿ���� �ʵ忡 Integer �ν��Ͻ� ����
		//ng1.setField(new Integer(100));
		ng1.setField(100);//����ڽ�
		
		//�ʵ尪�� ������ Object Ÿ������ ��ȯ => ����� ��ü ����ȯ �̿�
		int ng1Value=((Integer)ng1.getField()).intValue();
		
		//����� ��ü ����ȯ�� �߸��� ��� ClassCastException �߻�
		//int ng1Value=((Double)ng1.getField()).intValue();
		
		System.out.println("������ = "+ng1Value);
		System.out.println("============================================");
		NonGeneric ng2=new NonGeneric();
		
		//Object Ÿ���� �ʵ忡 Double �ν��Ͻ� ����
		ng2.setField(12.34);
		
		//instanceof �����ڸ� �̿��� ����� ��ü ����ȯ�� ���� �۾�
		if(ng2.getField() instanceof Double) {
			double ng2Value=((Double)ng2.getField()).doubleValue();
			System.out.println("�Ǽ��� = "+ng2Value);
		}
		System.out.println("============================================");
		NonGeneric ng3=new NonGeneric();

		//Object Ÿ���� �ʵ忡 String �ν��Ͻ� ����
		ng3.setField("ȫ�浿");
		
		if(ng3.getField() instanceof String) {
			String ng3Value=((String)ng3.getField()).replace("ȫ", "��");
			System.out.println("���ڿ� = "+ng3Value);
		}
		System.out.println("============================================");
	}
}
