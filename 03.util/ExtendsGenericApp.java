package site.itwill.util;

public class ExtendsGenericApp {
	public static void main(String[] args) {
		ExtendsGeneric<Integer> eg1=new ExtendsGeneric<Integer>();
		
		eg1.setField(100);
		
		System.out.println("������ = "+eg1.getField());
		System.out.println("============================================");
		ExtendsGeneric<Double> eg2=new ExtendsGeneric<Double>();
		
		eg2.setField(12.34);
		
		System.out.println("�Ǽ��� = "+eg2.getField());
		System.out.println("============================================");
		//���ظ� Ÿ�Կ� ���޵� Ŭ������ �ݵ�� Ư�� Ŭ������ ��� ���� Ŭ������ ���� ����
		//ExtendsGeneric<String> eg3=new ExtendsGeneric<String>();
		
	}
}












