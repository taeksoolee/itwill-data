package basic;

public class ForApp {
	public static void main(String[] args) {
		//"Java Programming"�� ȭ�鿡 5�� ���
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("====================================");
		//"Java Programming"�� ȭ�鿡 5�� ���
		for(int i=1;i<=5;i++) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//"Java Programming"�� ȭ�鿡 5�� ���
		for(int i=5;i>=1;i--) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//"Java Programming"�� ȭ�鿡 5�� ���
		for(int i=2;i<=10;i+=2) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//1~10 ������ ���� �� Ȧ���� ȭ�鿡 ���
		for(int i=1;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("====================================");
		//1~100 ������ �������� �հ踦 ����Ͽ� ���
		//1+2+3+4+...+98+99+100 >> ?
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 ������ ���� �հ� = "+tot);
		System.out.println("====================================");
		//int begin=30,end=80;
		int begin=80,end=30;
		
		/*
		if(begin>end) {
			System.out.println("[����]���۰��� ������������ �۾ƾ� �˴ϴ�.");
			System.exit(0);
		}
		*/
		
		if(begin>end) {
			//�� ������ ����� �������� ���� �ٲپ� ���� - ġȯ �˰���(Swap Algorithm)
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		//�� ������ ����� ������ ������ �հ踦 ����Ͽ� ���
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		
		System.out.println(begin+"~"+end+" ������ ���� �հ� = "+sum);
		System.out.println("====================================");
		for(int i=1,j=5;i<=3;i++,j--) {
			System.out.println("i = "+i+", j = "+j);
		}
		System.out.println("====================================");
		int i=1;
		for(;i<=4;i++) {
			System.out.print(i+"  ");
		}
		//i=5
		for(;i>=1;i--) {
			System.out.print(i+"  ");
		}
		System.out.println();
		System.out.println("====================================");
		//���ѷ��� : ������� �ʴ� �ݺ���
		/*
		for(;;) {
			System.out.println("���� �ݺ��Ǿ� ����Ǵ� ���");
		}
		*/
		//System.out.println("====================================");
	}
}
