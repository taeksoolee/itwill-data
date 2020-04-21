package basic;

import java.util.Scanner;

//���������� ���� ���α׷��� �ۼ��ϼ���.
// => ��ǻ��(����)�� ���̸�(Ű����)�� ���������� ���
// => ���̸Ӱ� �̱� ��� ����� �ݺ� �����ϸ� �� ��� ���� ����
// => ������ ����� �� ���̸Ӱ� �̱� Ƚ�� ���
public class RpaGameApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		//����Ƚ���� �����ϱ� ���� ���� ����
		int count=0;
		
		//���������� ��� �ݺ� ����
		while(true) {
			//��ǻ�Ϳ��� ���������� �� �ϳ��� �����޾� ���� >> ����(1~3)
			// => 1 : ����, 2 : ����, 3 : ��
			int computer=(int)(Math.random()*10)%3+1;
			
			//���̸ӿ��� ���������� �� �ϳ��� �����޾� ���� >> Ű����(1~3)
			// => �Է°��� 1~3 ������ �������� �ƴ� ��� ���Է�
			int gamer;
			while(true) {
				System.out.print("���������� �Է�[1:����,2:����,3:��] >> ");
				gamer=scanner.nextInt();
				if(gamer>=1 && gamer<=3) break;
				System.out.println("[����]����, ����, �� �� �� �ϳ��� �Է� �����մϴ�.");
			}
			
			//��ǻ�Ϳ� ���̸��� �Է°� ���
			System.out.print("[�Է�]��ǻ�� = ");
			if(computer==1) System.out.print("����");
			else if(computer==2) System.out.print("����");
			else System.out.print("��");
			
			System.out.print(", ���̸� = ");
			if(gamer==1) System.out.print("����");
			else if(gamer==2) System.out.print("����");
			else System.out.print("��");
			
			System.out.println();
			
			//��ǻ�Ϳ� ���̸��� ���������� �Ǵ��Ͽ� ��� ���
			// => ���̸Ӱ� �̱� ��� ���� Ƚ�� ���� >> ����
			// => ���̸Ӱ� �� ��� �ݺ��� ����
			if(computer==gamer) {
				System.out.println("[���]��ǻ�Ϳ� ���̸Ӱ� �����ϴ�.");
			} else if((computer==1 && gamer==2) || (computer==2 && gamer==3)
					 || (computer==3 && gamer==1)) {
				System.out.println("[���]���̸Ӱ� ��ǻ�Ϳ��� �̰���ϴ�.");
				count++;//����Ƚ�� ����
			} else {
				System.out.println("[���]���̸Ӱ� ��ǻ�Ϳ��� �����ϴ�.");
				break;//�ݺ��� ���� >> ���� ����
			}
			System.out.println();
		}
		
		System.out.println();
		if(count==0) {
			System.out.println("[�޼���]���̸Ӱ� ��ǻ�Ϳ��� �ѹ��� �̱��� ���߽��ϴ�.");
		} else {
			System.out.println("[�޼���]���̸Ӱ� ��ǻ�Ϳ��� "+count+"�� �������� �̰���ϴ�.");
		}
		
		scanner.close();
	}
}
