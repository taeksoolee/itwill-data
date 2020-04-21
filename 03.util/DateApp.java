package site.itwill.util;

import java.util.Date;

//Date : ��¥�� �ð������� �����ϱ� ���� Ŭ����
public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date() : �ý����� ���� ��¥�� �ð������� �����ϴ� �ν��Ͻ��� �����ϴ� ������
		Date now=new Date();
		
		//Date.toString() : Date �ν��Ͻ��� ��¥�� �ð������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Date �ν��Ͻ��� ����� ���������� ����� ��� ȣ�� ���� ����
		System.out.println("now = "+now.toString());
		
		//��¥�� ���� ���
		String[] day={"��","��","ȭ","��","��","��","��"};
		
		String printDate=(now.getYear()+1900)+"�� "+(now.getMonth()+1)
				+"�� "+now.getDate()+"�� "+day[now.getDay()]+"����";
		
		System.out.println("���� = "+printDate);
		
		//Date.getTime() : Date �ν��Ͻ��� ����� ��¥�� �ð������� Ÿ�ӽ������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� 
		long nowTime=now.getTime();
		System.out.println("nowTime = "+nowTime);
		
		Date wantDate=new Date(100, 0, 1);//2000�� 1�� 1��

		//System.out.println("wantDate = "+wantDate);
		long wantTime=wantDate.getTime();
		
		System.out.println("������(��) = "+((nowTime-wantTime)/1000));
	}
}
