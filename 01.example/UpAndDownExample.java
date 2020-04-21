package example;

import java.util.Scanner;

//��ǻ�ͷκ��� ������ ���������� Ű����� �Է��Ͽ� ���ߴ� ���α׷��� �ۼ��ϼ���.
// => 1~100 ������ ���������� ���� �޵��� �ۼ�
// => ������ ���� �� �ִ� ��ȸ�� 10���� �����ǵ��� �ۼ�
// => Ű���� �Է°��� 1~100 ������ �ƴ� ��� ���Է�
// => ������ �Է°��� ������ ��� �Է�Ƚ�� ��� �� ���α׷� ����
// => ������ �Է°��� �ٸ� ��� "ū�� �Է�" �Ǵ� "������ �Է�" ������ �޼��� ���
// => ������ 10�� �ȿ� ������ ���� ��� ���� ���
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//1~100 ������ ���������� �����޾� ����
		int dap=(int)(Math.random()*100)+1;
		
		//���� ���� ���������� �����ϱ� ���� ����
		// => false : ����(X), true : ����(O)
		boolean result=false;
		
		//10���� �Է� ��ȸ ���� >> �Է°��� ���� ��� ���
		for(int i=1;i<=10;i++) {
			int input;
			while(true) {
				System.out.print(i+"��° ������ �Է�[1~100] >> ");
				input=scanner.nextInt();
				if(input>=1 && input<=100) break;
				System.out.println("[����]1~100 ������ �������� �Է� �����մϴ�.");
			}
			
			if(input>dap) {
				System.out.println("[���]"+input+"���� ���� ���� �Է��� ������.");
			} else if(input<dap) {
				System.out.println("[���]"+input+"���� ū ���� �Է��� ������.");
			} else {
				System.out.println("[�޼���]�����մϴ�. "+i+"������ ������ϴ�.");
				result=true;
				break;
			}
		}//for(int i=1;i<=10;i++) ����

		if(!result) {//������ ������ ���� ���
			System.out.println("[�޼���]������ ������ ���߱���. ������ <"+dap+">�Դϴ�.");
		}
		
		scanner.close();
	}
}
