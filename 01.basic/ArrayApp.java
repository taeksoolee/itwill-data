package basic;

public class ArrayApp {
	public static void main(String[] args) {
		//�迭�� �����Ͽ� �������� ����
		//�ڷ���[] ������ : 1���� �迭������ �����ϱ� ���� �������� ����
		//new �ڷ���[����] : ���ϴ� ������ ��(�ڷ���)�� �����ϴ� ��Ұ� ����� �迭 ����
		// => ������ �迭 ��Ҵ� �ڵ����� �ʱⰪ ����(����:0, ��:false, ����:null) 
		int[] num=new int[3];
		
		//���������� ����� �迭����(��ü) ���
		System.out.println("num = "+num);
		System.out.println("============================================");
		//���������� ����� �迭������ ÷��(Index)�� �̿��Ͽ� �迭 ��� ǥ��
		// => ÷�� : ��Ҹ� �����ϴ� ������ - 0���� 1�� �����Ǵ� ������
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("num[2] = "+num[2]);
		//�迭 ��Ҹ� �����ϴ� ÷�ڸ� �߸� ����� ��� ArrayIndexOutOfBoundsException �߻�
		//System.out.println("num[3] = "+num[3]);
		System.out.println("============================================");
		//��������.length : ���������� ����� �迭�� ���� ��� ������ ǥ���ϴ� �ʵ�
		System.out.println("�迭 ����� ���� = "+num.length);
		System.out.println("============================================");
		int index=0;
		//�迭 ����� ÷�ڴ� ���� �Ǵ� ��������� ǥ�� ����
		num[index]=10;
		num[index+1]=20;
		num[index+2]=30;
		
		//for ������ �̿��Ͽ� �迭�� ���� �ϰ� ó�� : ÷�� �̿�(�Է�, ó��, ���)
		for(int i=0;i<num.length;i++) {
			System.out.println("num["+i+"] = "+num[i]);
		}
		System.out.println("============================================");
		//�迭 ������ ��ҿ� �ʱⰪ �ο�
		//int[] su=new int[]{10,20,30,40,50};  
		int[] su={10,20,30,40,50};
		
		//for ������ �̿��Ͽ� �迭�� ���� �ϰ� ó�� : �ݺ������� �̿�(ó��, ���)
		for(int temp:su) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		System.out.println("============================================");
		int[] array={54,70,64,87,96,21,65,76,11,34,56,41,77,91};
		
		//�迭 ��Ұ��� ���� �հ踦 ����Ͽ� ���
		int tot=0;
		
		/*
		for(int i=0;i<array.length;i++) {
			tot+=array[i];
		}
		*/
		
		for(int number:array) {
			tot+=number;
		}
		
		System.out.println("�հ� = "+tot);
		System.out.println("============================================");
		//�迭 ��Ұ� �� 30~60 ������ ��Ұ��� ������ ����Ͽ� ���
		int cnt=0;
		
		/*
		for(int i=0;i<array.length;i++) {
			if(array[i]>=30 && array[i]<=60) cnt++;
		}
		*/
		
		for(int number:array) {
			if(number>=30 && number<=60) cnt++;
		}
		
		System.out.println("30~60 ������ ��� ���� = "+cnt);
		System.out.println("============================================");
	} 
}














