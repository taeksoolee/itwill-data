package site.itwill.lang;

import java.util.Scanner;

//Ű����� �ֹε�Ϲ�ȣ�� �Է¹޾� �������, ������ �����Ͽ� ����ϴ� ���α׷�
// => �Էµ� �ֹε�Ϲ�ȣ�� 14�ڸ��̸� 7�� ��ġ���� - ���ڰ� ���� : ��ȿ�� �˻�
// => �߸��� ������ �ֹε�Ϲ�ȣ�� �Է��� ��� �����޼��� ��� �� ���Է�
//ex) �ֹε�Ϲ�ȣ �Է�[ex.900101-1234567] >> 901225-1234567
//    [���]������� = 1990�� 12�� 25��, ���� = ����
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String number;
		while(true) {
			System.out.print("�ֹε�Ϲ�ȣ �Է�[ex.900101-1234567] >> ");
			number=scanner.nextLine();
			//if(number.length()==14 && number.charAt(6)=='-') break;
			if(number.length()==14 && number.indexOf("-")==6) break;
			System.out.println("[����]���Ŀ� ���� �ʴ� �ֹε�Ϲ�ȣ�� �Է� �Ͽ����ϴ�.");
		}
		
		scanner.close();
		
		String separation=number.substring(7,8);
		
		String birthday="";
		if(separation.equals("1") || separation.equals("2")) {
			birthday+="19";
		} else if(separation.equals("3") || separation.equals("4")) {
			birthday+="20";
		}
		
		birthday+=number.substring(0, 2)+"�� ";
		birthday+=number.substring(2, 4)+"�� ";
		birthday+=number.substring(4, 6)+"�� ";
		
		String gender="";
		if(separation.equals("1") || separation.equals("3")) {
			gender="����";
		} else if(separation.equals("2") || separation.equals("4")) {
			gender="����";
		}
		
		System.out.println("[���]������� = "+birthday+", ���� = "+gender);
	}	
}









