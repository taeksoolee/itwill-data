package basic;

public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			//continue : �ݺ����� �����  ��� �����ϴ� Ű����
			// => continue ��� �Ʒ��� �����ϴ� ��� ���� ����
			if(i==3) continue;
			System.out.println("i = "+i);
		}
		System.out.println("============================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//���Ե� �ݺ��� ��� ���� >> for(int j=1;j<=5;j++) ��� ����
				if(j==3) continue;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//�ش� ���� �ݺ��� ��� ���� >> for(int i=1;i<=5;i++) ��� ����
				// => break ��ɿ� ����
				if(j==3) continue loop;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
	}
}
