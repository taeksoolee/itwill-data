package example;

public class ForExample {
	public static void main(String[] args) {
		//���� �̸��� ȭ�鿡 7�� ����ϼ���.
		//ex) ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿
		for(int i=1;i<=7;i++) {
			System.out.print("ȫ�浿 ");
		}
		System.out.println();
		System.out.println("============================================");
		
		//1~10 ������ ���� �� ¦���� ȭ�鿡 ����ϼ���.
		//ex) 2    4    6    8    10
		/*
		for(int i=2;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		*/
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		System.out.println("============================================");
		
		//1~100 ������ �������� 3�� ��� �հ�� 5�� ��� �հ踦 ����Ͽ�
		//3�� ��� �հ迡�� 5�� ��� �հ踦 �� ����� ����Ͽ� ����ϼ���.
		//ex) ��� = 633
		int threeTot=0,fiveTot=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0) threeTot+=i;
			if(i%5==0) fiveTot+=i;
		}
		System.out.println("��� = "+(threeTot-fiveTot));

		System.out.println("============================================");
		
		//������ �� 7���� ȭ�鿡 ����ϼ���.
		//ex) 7 * 1 = 7
		//    7 * 2 = 14
		//    ...
		//    7 * 8 = 56
		//    7 * 9 = 63
		int dan=7;
		for(int i=1;i<=9;i++) {
			System.out.println(dan+" * "+i+" = "+(dan*i));
		}

		System.out.println("============================================");
		
		//5!�� ������� ����Ͽ� ����ϼ���.(5! = 5 * 4 * 3 * 2 * 1)
		//ex) 5! = 120
		int num=5, fac=1;
		for(int i=num;i>=1;i--) {
			fac*=i;
		}
		System.out.println(num+"! = "+fac);

		System.out.println("============================================");
		
		//�� ������ ����� ������ ������ �������� ȭ�鿡 ����ϼ���.
		//��, �� �ٿ� �������� 7���� ��µǵ��� �ۼ��ϼ���.
		//ex) 36    37    38    39    40    41    42
		//    43    44    45    46    47    48    49
		//    50    51    52    53    54    55    56
		//    57
		int begin=36,end=56;
		int cnt=0;//��� �������� ������ �����ϱ� ���� ����
		for(int i=begin;i<=end;i++) {
			System.out.print(i+"\t");
			cnt++;
			if(cnt%7==0) {
				System.out.println();
			}
		}
		if(cnt%7!=0) {
			System.out.println();
		}

		System.out.println("============================================");

	}
}