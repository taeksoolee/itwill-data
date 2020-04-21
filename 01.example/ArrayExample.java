package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들에 대한 나이를 저장하고 있는 배열 생성
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,69,51,39,33,11};
		
		//배열에 저장된 사람들의 평균 나이를 계산하여 출력하세요.
		//ex) 평균 나이 = 36살 
		int tot=0;
		for(int nai:age) {
			tot+=nai;
		}
		
		System.out.println("평균 나이 = "+(tot/age.length)+"살");
		System.out.println("============================================");
		//배열의 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 2명
		
		//연령별 인원수를 누적 저장하기 위한 배열(변수) 선언
		//int cnt10=0,cnt20=0,cnt30=0,cnt40=0,cnt50=0,cnt60=0;

		//cnt[0]:10대 인원수, cnt[1]:20대 인원수,..., cnt[5]:60대 인원수
		int[] cnt=new int[6];
		
		//나이에 대한 연령별 인원수 누적 처리
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
		System.out.println("10대 = "+cnt[0]+"명");
		System.out.println("20대 = "+cnt[1]+"명");
		System.out.println("30대 = "+cnt[2]+"명");
		System.out.println("40대 = "+cnt[3]+"명");
		System.out.println("50대 = "+cnt[4]+"명");
		System.out.println("60대 = "+cnt[5]+"명");
		*/
		
		for(int i=0;i<cnt.length;i++) {
			System.out.println(((i+1)*10)+"대 = "+cnt[i]+"명");
		}
				
		System.out.println("============================================");
	}
}