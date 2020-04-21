package site.itwill.util;

import java.util.Calendar;

//���� ����� ���� �޷��� ����ϴ� ���α׷�
public class CurrentCalendarApp {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();//2019-11-11
		
		//Calendar �ν��Ͻ��� ����� ��¥�� �ð����� �� ���� 1�Ϸ� ����
		//Calendar.set(int field, int value) : ���ϴ� �ʵ尪�� �����ϴ� �޼ҵ�
		calendar.set(Calendar.DATE, 1);//2019-11-01
		
		//Calendar.set(int year, int month, int date) : ����� �����ϴ� �޼ҵ�
		//calendar.set(2019, 11, 1);//2019-12-01
		
		//Calendar �ν��Ͻ��� ����� ��¥�� ���� ���ϰ��� ��ȯ�޾� ����
		int week=calendar.get(Calendar.DAY_OF_WEEK);//1(��)~7(��)
		
		System.out.println("        "+calendar.get(Calendar.YEAR)+"�� "
				+(calendar.get(Calendar.MONTH)+1)+"��");
		System.out.println("============================");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");

		//1�Ͽ� ���� ���� ������ ���� ���
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//1�Ϻ��� ���� ���� ������ �ϱ��� ���
		//Calendar.getActualMaximum(int field) : Calendar �ν��Ͻ��� �����
		//�ʵ忡 ���� ��� ������ �ִ밪�� ��ȯ�ϴ� �޼ҵ� 
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			if(i<10) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;
			
			if(week%7==1) {
				System.out.println();
			}
		}
	}
}








