package basic;

public class SwitchApp {
	public static void main(String[] args) {
		int choice=1;
		
		switch (choice) {
		case 1:
			System.out.println("�������� �̵��մϴ�.");
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
		}
		System.out.println("===================================");
		choice=2;
		
		switch (choice) {
		case 1:
			System.out.println("�������� �̵��մϴ�.");
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
		}
		System.out.println("===================================");
		choice=3;
		
		switch (choice) {
		case 1:
			System.out.println("�������� �̵��մϴ�.");
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
		}
		System.out.println("===================================");
		choice=4;
		
		switch (choice) {
		case 1:
			System.out.println("�������� �̵��մϴ�.");
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
		default://������ ����	
			System.out.println("������ �̵��մϴ�.");
		}
		System.out.println("===================================");
		choice=1;
		
		switch (choice) {
		case 1:
			System.out.println("�������� �̵��մϴ�.");
			break;//switch ���� ����
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
			break;
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
			break;
		}
		System.out.println("===================================");
		int jumsu=85;
		
		if(jumsu>=0 && jumsu<=100) {
			//������ ���� ������ ����Ͽ� ���
			//100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
			char grade;
			
			switch (jumsu/10) {
			case 10:
			case 9: grade='A'; break;
			case 8: grade='B'; break;
			case 7: grade='C'; break;
			case 6: grade='D'; break;
			default: grade='F';
			}
			
			System.out.println("[���]"+jumsu+"�� >> "+grade+"����");
		} else {
			System.out.println("[����]0~100 ������ ��� ������ �Է� �Ǿ����ϴ�.");
		}
		System.out.println("===================================");
		String kor="��";
		String eng="";
		
		//JDK1.7 �̻󿡼��� switch ������ �̿��Ͽ� ���ڿ� �� ����
		switch (kor) {
		case "�ϳ�": eng="One";	break;
		case "��": eng="Two";	break;
		case "��": eng="Three";	break;
		}
		System.out.println("[���]"+kor+" >> "+eng);
		System.out.println("===================================");
	}
}





