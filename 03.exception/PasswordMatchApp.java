package site.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//Ű����� �������� �Է¹޾� ��й�ȣ�� ���Ͽ� ����� ����ϴ� ���α׷�
public class PasswordMatchApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		try {
			System.out.print("��й�ȣ �Է� >> ");
			int password=scanner.nextInt();
			
			/*
			if(password==1234) {
				System.out.println("[���]�Է��� ��й�ȣ�� �½��ϴ�.");
			} else {
				System.out.println("[���]�Է��� ��й�ȣ�� �ٸ��ϴ�.");
			}
			*/
			
			if(password!=1234) {
				//throw Ű���� �̿��Ͽ� ������ ���� �߻�(���� �ν��Ͻ� ����)
				// => ����� �߻��Ǵ� ���ܰ� �ƴ� ��� ����ó�� ���� ���� ��� ���� �߻�
				throw new PasswordMissMatchException("[���]�Է��� ��й�ȣ�� �ٸ��ϴ�.");
			}
			
			System.out.println("[���]�Է��� ��й�ȣ�� �½��ϴ�.");

		} catch (InputMismatchException e) {
			System.out.println("[����]���ڸ� �Է� �����մϴ�.");
		} catch (PasswordMissMatchException e) {
			//����� �߻��Ǵ� ���ܰ� �ƴ� ��� ����ó�� �� ���α׷� ���� - finally ���� �ʿ�
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}








