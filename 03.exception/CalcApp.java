package site.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//Ű����� ���� 2���� �Է¹޾� ���� ������� ����ϴ� ���α׷�
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է� >> ");
		//Scanner.nextInt() : Ű����� �Էµ� �������� ��ȯ�ϴ� �޼ҵ�
		// => �Է°��� ������ �ƴ� ��� InputMismatchException �߻�
		int num1=scanner.nextInt();
		
		System.out.print("�ι�° ���� �Է� >> ");
		int num2=scanner.nextInt();
		
		//0���� ���� ��� ArithmeticException �߻�
		System.out.println("[���]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//�ν��Ͻ� ���� - �������� ��� ����
			new CalcApp();
		} catch (InputMismatchException e) {
			System.out.println("[����]�������� �Է� �����մϴ�.");
		} catch (ArithmeticException e) {
			System.out.println("[����]0���� ���� �� �����ϴ�.");
		} catch (Exception e) {
			//Exception : ��� ����Ŭ������ �θ�Ŭ���� - ��� ����ó�� ����
			System.out.println("[����]���α׷� ���࿡ ����ġ ���� ������ �߻� �Ǿ����ϴ�.");
		}
		*/
		
		try {
			new CalcApp();
		} catch (InputMismatchException | ArithmeticException e) {
			//JDK1.7 �̻󿡼��� ����Ŭ������ | �����ڷ� �����Ͽ� �ۼ� ���� 
			System.out.println("[����]���Ŀ� �°� ���� �Է��� �ּ���.");
		} catch (Exception e) {
			//Exception : ��� ����Ŭ������ �θ�Ŭ���� - ��� ����ó�� ����
			System.out.println("[����]���α׷� ���࿡ ����ġ ���� ������ �߻� �Ǿ����ϴ�.");
		}
		
	}
}











