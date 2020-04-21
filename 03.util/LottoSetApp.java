package site.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 ������ �ߺ����� �ʴ� �������� 6���� �����޾� �������� �����Ͽ� ����ϴ� ���α׷� �ۼ�
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		Random random=new Random();
		
		while(true) {
			lottoSet.add(random.nextInt(45)+1);
			if(lottoSet.size()==6) break;
		}
		
		//Set.toArray(T[] a) : Set �ν��Ͻ��� ����� ������Ʈ�� �̿��Ͽ�
		//�迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//�迭 ��Ұ� ����
		Arrays.sort(lotto);
		
		System.out.print("����� ���� >> "+Arrays.toString(lotto));
	}
}








