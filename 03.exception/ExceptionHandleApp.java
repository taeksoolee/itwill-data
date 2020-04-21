package site.itwill.exception;

//����(Exception) : ���α׷��� ��� ���࿡ ���� �߻��Ǵ� ����
// => ���ܰ� �߻��Ǵ� ��ɿ� ���� ó�� �ʿ� - ����ó��
// => �ɰ��� ������ ��� ���α׷� ���� �� ����ó���� ���� ���� ��� ������ ǥ��
// => �ɰ����� ���� ������ ��� JVM�� ���� �ڵ� ���� ó�� - �����
public class ExceptionHandleApp {
	public static void main(String[] args) {
		int[] array={10,20,30,40,50};
		
		//try ������ �ۼ��� ��ɿ��� ���ܰ� �߻��Ǵ����� ����
		// => ���ܰ� �߻��� ��� ���� ó�� Ŭ������ �ν��Ͻ��� ����
		// => ���� �߻� ��� �Ʒ��� �����ϴ� ��� �̽��� - ������(���α׷� �帧) �̵�
		try {
			//�迭 ����� ÷�ڰ� ������ ��� ��� ArrayIndexOutOfBoundsException ���� �߻�
			for(int i=0;i<=array.length;i++) {
				System.out.println("array["+i+"] = "+array[i]);
			}
		
			//�� ��ɿ��� ���ܰ� �߻��� ��� ��� �̽��� 
			System.out.println("[���]���α׷��� ���������� ���� �Ͽ����ϴ�.");
		} catch (ArrayIndexOutOfBoundsException e) {
			//���ܰ� �߻��� ��� catch ������ ��� ����
			// => try �������� �߻��� �ش� ���� �ν��Ͻ��� ���޹޾� �����Ͽ� ���� ó��
			//����ó�� : ���α׷� ����ڿ��� �޼����� �����ϰų� �����ڿ��� �����α� ����
			System.out.println("[����]���α׷� ���࿡ ����ġ ���� ������ �߻� �Ǿ����ϴ�.");
			
			//Throwable.getMessage() : ���� �ν��Ͻ��� �޼����� ��ȯ�ϴ� �޼ҵ�
			//Throwable : ����(Error)�� ����(Exception)�� �θ�Ŭ����
			//System.out.println("[�α�]���� �޼��� = "+e.getMessage());
			
			//Throwable.printStackTrace() : ���ܰ� �߻��� �帧�� ������ �����Ͽ� ����ϴ� �޼ҵ� 
			//e.printStackTrace();
		} finally {
			//finally �������� ���ܿ� ������� ������ ����� ����� �ۼ� - ��� �ν��Ͻ� ����
			System.out.println("# ������ ����� ��� #");
		}
	}
}
