package site.itwill.util;

import java.util.Random;

//Random : ���� �߻� ���� ����� �����ϴ� Ŭ����
public class RandomApp {
	public static void main(String[] args) {
		//Random(int seed) : �õ尪�� �����Ͽ� Random �ν��Ͻ��� �����ϴ� ������
		// => Seed : �ұ�Ģ�� ������ �߻��ǵ��� �����ϴ� long Ÿ���� ������
		// => �õ尪�� System.currentTimeMillis() �޼ҵ带 ȣ���Ͽ� ��ȯ�޾� ���
		//System.currentTimeMillis() : �ý����� ���� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
		//Ÿ�ӽ�����(TimeStampe) : 1970�� 1�� 1���� �������� �ʴ� 1�� �����Ǵ� ������
		// => Java������ ms ������ 1�� �����Ǵ� long Ÿ���� ������
		//Random random=new Random(System.currentTimeMillis());
		
		//Random Ŭ������ �⺻ �����ڴ� �õ尪�� �ڵ����� �����Ͽ� �ν��Ͻ� ����
		// => ���������� System.currentTimeMillis() �޼ҵ��� ��ȯ���� ��� 
		Random random=new Random();
		
		for(int i=1;i<=5;i++) {
			//Random.nextInt(int bound) : 0 ~ bound-1 ������ ���������� �߻��Ͽ� ��ȯ�ϴ� �޼ҵ� 
			System.out.println(i+"��° ���� = "+random.nextInt(100));//0~99
		}
	}
}
