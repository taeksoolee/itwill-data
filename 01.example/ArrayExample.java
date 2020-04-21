package example;

public class ArrayExample {
	public static void main(String[] args) {
		//����鿡 ���� ���̸� �����ϰ� �ִ� �迭 ����
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,69,51,39,33,11};
		
		//�迭�� ����� ������� ��� ���̸� ����Ͽ� ����ϼ���.
		//ex) ��� ���� = 36�� 
		int tot=0;
		for(int nai:age) {
			tot+=nai;
		}
		
		System.out.println("��� ���� = "+(tot/age.length)+"��");
		System.out.println("============================================");
		//�迭�� ����� ������� ���̸� ���ɺ��� �����Ͽ� �ο����� ����Ͽ� ����ϼ���.
		//ex) 10�� = 3��
		//    20�� = 4��
		//    ...
		//    60�� = 2��
		
		//���ɺ� �ο����� ���� �����ϱ� ���� �迭(����) ����
		//int cnt10=0,cnt20=0,cnt30=0,cnt40=0,cnt50=0,cnt60=0;

		//cnt[0]:10�� �ο���, cnt[1]:20�� �ο���,..., cnt[5]:60�� �ο���
		int[] cnt=new int[6];
		
		//���̿� ���� ���ɺ� �ο��� ���� ó��
		for(int nai:age) {
			/*
			if(nai>=10 && nai<20) cnt[0]++;
			else if(nai>=20 && nai<30) cnt[1]++;
			else if(nai>=30 && nai<40) cnt[2]++;
			else if(nai>=40 && nai<50) cnt[3]++;
			else if(nai>=50 && nai<60) cnt[4]++;
			else if(nai>=60 && nai<70) cnt[5]++;
			*/
			
			/*
			switch (nai/10) {
			case 1: cnt[0]++; break;
			case 2: cnt[1]++; break;
			case 3: cnt[2]++; break;
			case 4: cnt[3]++; break;
			case 5: cnt[4]++; break;
			case 6: cnt[5]++; break;
			}
			*/
			
			cnt[nai/10-1]++;
		}
		
		/*
		System.out.println("10�� = "+cnt[0]+"��");
		System.out.println("20�� = "+cnt[1]+"��");
		System.out.println("30�� = "+cnt[2]+"��");
		System.out.println("40�� = "+cnt[3]+"��");
		System.out.println("50�� = "+cnt[4]+"��");
		System.out.println("60�� = "+cnt[5]+"��");
		*/
		
		for(int i=0;i<cnt.length;i++) {
			System.out.println(((i+1)*10)+"�� = "+cnt[i]+"��");
		}
				
		System.out.println("============================================");
	}
}