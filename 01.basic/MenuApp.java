package basic;

import java.util.Scanner;

//Ű����� �޴� �� �ϳ��� �Է¹޾� ���ø޴��� ���� ����� �����ϴ� ���α׷��� �ۼ��ϼ���.
// => [���α׷� ����] �޴��� �����ϱ� ������ ����ڿ��� ���ϴ� ����� ��� ����
// => ���ø޴��� �������� �ʴ� ��� �����޼��� ��� �� ���Է�
public class MenuApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			//�޴� ���
			System.out.println("1.�л����� �Է�");
			System.out.println("2.�л����� ����");
			System.out.println("3.�л����� ����");
			System.out.println("4.�л����� �˻�");
			System.out.println("5.���α׷� ����");

			//�޴� ����
			System.out.print("�޴� ����[1~5] >> ");
			int choice=scanner.nextInt();
			
			//�Է°��� ���� ��ȿ�� �˻�
			if(choice<1 || choice>5) {
				System.out.println("[����]������ �޴��� �������� �ʽ��ϴ�.\n");
				continue;
			}
			
			//[���α׷� ����] �޴� ���ÿ� ���� ó�� >> �ݺ��� ����
			if(choice==5) break;
			
			//���� �޴��� ���� ó��
			switch (choice) {
			case 1:
				System.out.println("[ó�����]�л������� ���� �Ͽ����ϴ�.");
				break;
			case 2:
				System.out.println("[ó�����]�л������� ���� �Ͽ����ϴ�.");
				break;
			case 3:
				System.out.println("[ó�����]�л������� ���� �Ͽ����ϴ�.");
				break;
			case 4:
				System.out.println("[ó�����]�л������� �˻� �Ͽ����ϴ�.");
				break;
			}
			System.out.println();
		}
		
		System.out.println("[�޼���]�л����� ���α׷��� �����մϴ�.");
		scanner.close();
	}
}
