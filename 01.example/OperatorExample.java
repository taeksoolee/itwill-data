package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678�ʸ� �Ͻú��� �������� ��ȯ�Ͽ� ����ϼ���.
		int cho=245678;
		System.out.print(cho+"�� >> ");
		
		int day=cho/(24*60*60);//24*60*60 >> 86400
		cho%=86400;//��(��)�� ������ �������� ����Ͽ� ����
		int hour=cho/3600;
		cho%=3600;
		int min=cho/60;
		int sec=cho%60;
		
		System.out.println(day+"�� "+hour+"�� "+min+"�� "+sec+"��");
		System.out.println("===================================");
		
		//�Ѵ��� ������ 1�� 5õ���� ����⸦ 20�� ������ ��� �����ؾߵ� �ݾ��� ����Ͽ� ����ϼ���.
		//��, 15�� �̻� ������ ��� 1��� 25% �������� �����Ͽ� ����ϼ���.
		int danga=150_000_000,gae=20;
		long money=(long)(gae>=15?danga*0.75:danga)*gae;
		System.out.println("���ұݾ� = "+money);
		System.out.println("===================================");
	}
}






