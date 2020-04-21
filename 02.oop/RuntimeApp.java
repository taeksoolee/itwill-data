package oop;

//Runtime Ŭ���� : ���� ����Ǵ� Java ���α׷��� ������ �����ϱ� ���� Ŭ����
public class RuntimeApp {
	public static void main(String[] args) {
		//Runtime Ŭ������ �����ڴ� ����ȭ ó���Ǿ� new �����ڷ� �ν��Ͻ� ���� �Ұ�
		//Runtime rt=new Runtime();
		
		//Runtime.getRuntime() : Runtime �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => Runtime Ŭ������ �ν��Ͻ��� �������� ���ϰ� �ν��Ͻ��� ��ȯ�޾� ���
		Runtime rt1=Runtime.getRuntime();
		System.out.println("rt1 = "+rt1);

		//���������� �ϳ��� �ν��Ͻ��� �̸� �����Ͽ� ��� ����
		// => ���α׷��� �ϳ��� �ν��Ͻ����� �����ϴ� Ŭ���� - �̱���(Singleton) Ŭ����
		Runtime rt2=Runtime.getRuntime();
		System.out.println("rt2 = "+rt2);
		
		//�̱��� Ŭ������ �������� ���� �ν��Ͻ��� ���� ��ȯ�޾� �޼ҵ� ȣ��
		System.out.println("Runtime.getRuntime() = "+Runtime.getRuntime());
		System.out.println("=============================================");
		System.out.println("û�� �� ��� �޸� ũ�� = "+(Runtime.getRuntime()
			.totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		
		//Runtime.getRuntime().gc();
		System.gc();
		
		System.out.println("û�� �� ��� �޸� ũ�� = "+(Runtime.getRuntime()
			.totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		System.out.println("=============================================");
	}
}








