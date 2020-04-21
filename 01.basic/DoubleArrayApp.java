package basic;

public class DoubleArrayApp {
	public static void main(String[] args) {
		int[][] num=new int[2][3];
		
		System.out.println("num = "+num);
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("============================================");
		System.out.println("num[0][0] = "+num[0][0]);
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);
		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("============================================");
		System.out.println("num.length = "+num.length);
		System.out.println("num[0].length = "+num[0].length);
		System.out.println("num[1].length = "+num[1].length);
		System.out.println("============================================");
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				System.out.println("num["+i+"]["+j+"] = "+num[i][j]);
			}
		}
		System.out.println("============================================");
		int[][] su={{10,20,30},{40,50,60}};
		
		for(int[] array:su) {
			for(int number:array) {
				System.out.print(number+"  ");
			}
			System.out.println();
		}
		System.out.println("============================================");
		/*
		//1���� �迭�� �������� �ʴ� 2���� �迭 ����
		int[][] temp=new int[3][];
		
		//1���� �迭�� �����Ƿ� 2���� �迭�� ��Ұ����� �ڵ����� null ����
		//System.out.println("temp[0] = "+temp[0]);
		//System.out.println("temp[1] = "+temp[1]);
		//System.out.println("temp[2] = "+temp[2]);
		
		//2���� �迭 ��ҿ� 1���� �迭�� �����Ͽ� �迭���� ����
		// => 1���� �迭�� ��� ������ �ٸ��� ���� ���� - �������̹迭
		temp[0]=new int[3];
		temp[1]=new int[2];
		temp[2]=new int[4];
		
		temp[0][0]=10;
		temp[0][1]=20;
		temp[0][2]=30;
		
		temp[1][0]=40;
		temp[1][1]=50;

		temp[2][0]=60;
		temp[2][1]=70;
		temp[2][2]=80;
		temp[2][3]=90;
		*/
		int[][] temp={{10,20,30},{40,50},{60,70,80,90}};
		
		for(int[] array:temp) {
			for(int number:array) {
				System.out.print(number+"  ");
			}
			System.out.println();
		}
		System.out.println("============================================");
		//�л��̸��� ����,����,���� ������ �Է¹޾� �л� ���� �հ�, ����
		//���� �հ�, ��ü ���� �հ踦 ����Ͽ� ����ϴ� ���α׷� �ۼ�
		//ex) ȫ�浿  80   90   100  240
		//    �Ӳ���  76   89   77   242
		//    ...
		//    ����  88   92   90   270
		//    ���հ�  392  380  370  1142
		String[] name={"ȫ�浿","�Ӳ���","����ġ","������","����","���հ�"};
		int[][] score={{80,90,100,0},{76,89,77,0},{78,99,87,0}
			,{98,99,100,0},{88,92,90,0},{0,0,0,0}};
	
		//�л� ���� �հ�, ���� ���� �հ�, ��ü ���� �հ� ���
		for(int i=0;i<score.length-1;i++) {
			for(int j=0;j<score[i].length-1;j++) {
				//score[i][j] : �л��� ���� ���� ������ ����� ���
				//score[i][score[i].length-1] : �л� ���� �հ谡 ����� ���
				score[i][score[i].length-1]+=score[i][j];
				//score[score.length-1][j] : ���� ���� �հ谡 ����� ���
				score[score.length-1][j]+=score[i][j];
				//score[score.length-1][score[i].length-1] : ��ü ���� �հ谡 ����� ���
				score[score.length-1][score[i].length-1]+=score[i][j];
			}
		}
		
		//�л��̸�, ����, ����, ���� ������ �л� ���� �հ�, ���� ���� 
		//�հ�, ��ü ���� �հ� ���
		for(int i=0;i<score.length;i++) {
			System.out.print(name[i]+"\t");
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("============================================");
	}
}
