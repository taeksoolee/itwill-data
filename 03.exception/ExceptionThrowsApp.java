package site.itwill.exception;

public class ExceptionThrowsApp {
	//�޼ҵ� ���� ��ɿ� ���� �߻��Ǵ� ���ܸ� �ܺη� ����
	public static void displayArray() throws ArrayIndexOutOfBoundsException {
		int[] array={10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
	}
	
	//JVM���� ���ܰ� ���޵� ��� �ڵ� ����ó��
	public static void main(String[] args) /* throws ArrayIndexOutOfBoundsException */ {
		//���ܰ� �߻��Ǵ� �޼ҵ带 ȣ���� ��� ����ó�� 
		// => �޼ҵ忡�� �߻��Ǵ� ���ܸ� �ٽ� ���� ����
		try {
			//ExceptionThrowsApp.displayArray();
			displayArray();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[����]���α׷� ���࿡ ����ġ ���� ������ �߻� �Ǿ����ϴ�.");
		}
	}
}




