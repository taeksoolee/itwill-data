package site.itwill.util;

import java.util.Calendar;

public class CalendarApp {
	public static void main(String[] args) {
		//Calendar.getInstance() : �ý����� ���� ��¥�� �ð������� �����ϴ� Calendar �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
		Calendar now=Calendar.getInstance();
		
		//Calendar.toString() : Calendar �ν��Ͻ��� ��¥�� �ð������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Calendar �ν��Ͻ��� ����� ���������� ����� ��� ȣ�� ���� ����
		System.out.println("now = "+now);
		
		//��¥�� ���� ���
		String[] day={"��","��","ȭ","��","��","��","��"};
				
		//Calendar.get(int constantField) : Calendar �ν��Ͻ��� �����
		//��¥�� �ð����� �� ����ʵ忡 ���� ���� ��ȯ�ϴ� �޼ҵ�
		String printDate=now.get(Calendar.YEAR)+"�� "
				+(now.get(Calendar.MONTH)+1)+"�� "
				+now.get(Calendar.DATE)+"�� "
				+day[now.get(Calendar.DAY_OF_WEEK)-1]+"����";
				
		System.out.println("���� = "+printDate);
	}
}





