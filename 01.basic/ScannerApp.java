package basic;

import java.util.Scanner;

public class ScannerApp {
	public static void main(String[] args) {
		//Scanner Ŭ���� : �Է���ġ(Ű����, ���� ��)�� ���� �Է¹޾� �����ϴ� �޼ҵ尡 ����� Ŭ����
		//Scanner ��ü ���� >> Ű����� ���� �Է¹ޱ� ���� ��ü
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("�̸� �Է� >> ");
		//Scanner.nextLine() : Ű���� �Է°��� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		// => Ű���� �Է°��� �������� ���� ��� �����尡 �Ͻ� ����
		// => Ű����� ���� �Է��� �� ���͸� �Է��ؾ߸� ������ �����
		String name=scanner.nextLine();
		
		System.out.print("�¾ �⵵ �Է� >> ");
		//Scanner.nextInt() : Ű���� �Է°��� ���������� ��ȯ�ϴ� �޼ҵ�
		// => Ű���� �Է°��� ������ �ƴ� ��� ����(Exception) �߻�
		int birthYear=scanner.nextInt();
		
		System.out.println("[���]"+name+"���� "+birthYear+"�⿡ �¾���ϴ�.");
		
		//Scanner.close() : Scanner ��ü ���� �޼ҵ�
		scanner.close();
	}
}
