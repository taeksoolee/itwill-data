package basic;

public class BreakApp {
	public static void main(String[] args) {
		//���ǽ��� ������ ��� �ݺ��� ����
		for(int i=1;i<=5;i++) {
			//break : �ݺ����� �����ϴ� Ű����
			if(i==3) break;
			System.out.println("i = "+i);
		}
		System.out.println("============================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//���Ե� �ݺ��� ���� >> for(int j=1;j<=5;j++) ����
				if(j==3) break;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
		//�ݺ����� ��(�ĺ���)�� �ο� ���� 
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//�ش� ���� �ݺ��� ���� >> for(int i=1;i<=5;i++) ����
				if(j==3) break loop;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
	}
}




