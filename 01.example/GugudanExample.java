package example;

import java.util.Scanner;

//Ű����� ������ �Է¹޾� 1~9 ������ ������ ���� ����� ����ϴ� ���α׷��� �ۼ��ϼ���.
//��, �Էµ� ������ 2~9 ������ ������ ����ϸ� ���� ���� ������ �Է��� ��� ���Է�
//ex) ��(����) �Է�[2~9] >> 7
//    7 * 1 = 7
//    7 * 2 = 14
//    ...
//    7 * 9 = 63
public class GugudanExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int dan;
		while(true) {
			System.out.print("��(����) �Է�[2~9] >> ");
			dan=scanner.nextInt();
			if(dan>=2 && dan<=9) break;
			System.out.println("[����]�Է°��� 2~9 ������ ���ڸ� �Է� �����մϴ�.");
		}
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}
		
		scanner.close();
	}
}





