package basic;

public class IfApp {
	public static void main(String[] args) {
		//int score=80;
		int score=50;
		
		//������ 60�� �̻��� ��� �հݸ޼��� ���
		if(score>=60) {
			System.out.println("[���]������ 60�� �̻��̹Ƿ� �հ��Դϴ�.");
		}
		
		//������ 60�� �̸��� ��� ���հݸ޼��� ���
		if(score<60) {
			System.out.println("[���]������ 60�� �̸��̹Ƿ� ���հ��Դϴ�.");
		}
		System.out.println("====================================");
		//������ 60�� �̻��� ��� �հݸ޼��� ����ϰ� �ƴ� ��� ���հݸ޼��� ���
		if(score>=60) {
			System.out.println("[���]������ 60�� �̻��̹Ƿ� �հ��Դϴ�.");
		} else {
			System.out.println("[���]������ 60�� �̸��̹Ƿ� ���հ��Դϴ�.");
		}
		System.out.println("====================================");
		//int num=9;
		int num=10;
		
		//������ ����� �������� Ȧ���� ¦���� �����Ͽ� ���
		if(num%2!=0) {
			System.out.println("[���]"+num+" >> Ȧ��");
		} else {
			System.out.println("[���]"+num+" >> ¦��");
		}
		System.out.println("====================================");
		//char mun='O';
		char mun='0';
		
		//������ ����� ���ڰ��� ���������� �����Ͽ� ���
		if (mun>='A' && mun<='Z' || mun>='a' && mun<='z') {
			System.out.println("[���]�����ڰ� �½��ϴ�.");
		} else {
			System.out.println("[���]�����ڰ� �ƴմϴ�.");
		}
		System.out.println("====================================");
		int jumsu=85;
		
		//������ ����� �������� 0~100 �������� �����Ͽ� ���
		if(jumsu>=0 && jumsu<=100) {
			//System.out.println("[���]�������� ������ �Է� �Ǿ����ϴ�.");
			
			//������ ���� ������ ����Ͽ� ���
			//100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
			char grade;
			
			if(jumsu>=90) grade='A'; 
			else if(jumsu>=80) grade='B';
			else if(jumsu>=70) grade='C';
			else if(jumsu>=60) grade='D';
			else grade='F';//������ ����
			
			System.out.println("[���]"+jumsu+"�� >> "+grade+"����");
		} else {
			System.out.println("[����]0~100 ������ ��� ������ �Է� �Ǿ����ϴ�.");
		}
		System.out.println("====================================");

		int choice=1;
		
		//null : �������� �ʴ� ��ü�� ǥ���ϱ� ���� Ű���� 
		//String name=null;
		//"" : ���ڰ� �������� �ʴ� ���ڿ�(String ��ü) >> NullString
		String name="";
		
		//����)������� ������ ���� �����ϴ� ����� �ۼ��� ��� �ʱ�ȭ ���� �߻�
		//�ذ��-1)���������� ��� ������ �̿��Ͽ� ������ ����
		//�ذ��-2)���� �����ϴ� ���� ����� �ʱⰪ ����
		// => ������ : 0, ���� : false, ���ڿ� : "", ������ : null
		if(choice==1) {
			name="ȫ�浿";
		} else if(choice==2) {
			name="�Ӳ���";
		} /* else {
			name="����ġ";
		} */
	
		System.out.println("[���]����� ������ ����� ["+name+"]�Դϴ�.");
		System.out.println("====================================");
	}
}










