package site.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 범위의 중복되지 않는 정수난수 6개를 제공받아 오름차순 정렬하여 출력하는 프로그램 작성
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		Random random=new Random();
		
		while(true) {
			lottoSet.add(random.nextInt(45)+1);
			if(lottoSet.size()==6) break;
		}
		
		//Set.toArray(T[] a) : Set 인스턴스에 저장된 엘리먼트를 이용하여
		//배열로 변환하여 반환하는 메소드
		Integer[] lotto=lottoSet.toArray(new Integer[0]);
		
		//배열 요소값 정렬
		Arrays.sort(lotto);
		
		System.out.print("행운의 숫자 >> "+Arrays.toString(lotto));
	}
}








