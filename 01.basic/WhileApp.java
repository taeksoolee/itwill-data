package basic;

public class WhileApp {
	public static void main(String[] args) {
		//"Java Programming"�� ȭ�鿡 5�� ���
		int i=1;
		while(i<=5) {
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("===========================================");
		//1~100 ������ �������� �հ踦 ����Ͽ� ���
		int j=1,tot=0;
		do {
			tot+=j;
			j++;
		} while(j<=100);
		System.out.println("1~100 ������ �����հ� = "+tot);
		System.out.println("===========================================");
		//A4 ������ ������ ��� ���� ������ �� ��� �簢�� ����� 500�� 
		//�̻��� ����������� �� �� ���ƾ� �Ǵ��� ����Ͽ� ���
		//cnt : ���� Ƚ��, gae : �簢�� ����
		int cnt=0,gae=1;
		//�簢�� ����� 500�� �̻��� ��� �ݺ��� ����
		/*
		while(gae<500) {
			cnt++;
			gae*=2;
		}
		*/
		
		while(true) {//���ѷ���
			cnt++;
			gae*=2;
			if(gae>=500) break;
		}
		
		System.out.println(cnt+"�� ������ "+gae+"���� �簢���� ��������ϴ�.");
		System.out.println("===========================================");
		//1���� X ������ �������� �հ谡 300�̻� �Ƿ��� X�� ������ ��� ���
		//ex) 1~24 ������ �������� �հ� = 300
		/*
		int su=0,sum=0;//su : �������� ������, sum : �հ�
		while(sum<300) {
			su++;
			sum+=su;
		}
		*/
		
		int su=1,sum=0;
		while(true) {
			sum+=su;
			if(sum>=300) break;
			su++;
		}
		System.out.println("1~"+su+" ������ �������� �հ� = "+sum);
		System.out.println("===========================================");
	}
}