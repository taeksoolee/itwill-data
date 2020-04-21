package basic;

//1~45 범위의 중복되지 않는 정수난수 6개를 제공받아 오름차순 정렬하여 출력하는 프로그램 작성
// => 정렬(Sort) : 값을 차례대로 나열하는 기능 - 오름차순 정렬(Ascending Sort), 내림차순 정렬(Descending Sort)
public class LottoApp {
	public static void main(String[] args) {
		//6개의 정수값을 저장하는 배열 선언 
		int[] lotto=new int[6];
		
		//1~45 범위의 정수난수를 제공받아 배열 요소에 저장
		// => 배열 요소에 저장되는 정수값은 중복값이 없도록 설정
		for(int i=0;i<lotto.length;i++) {
			//난수를 발생하여 배열 요소에 저장
			// => 요소에 저장된 기존 난수값을 비교하여 중복된 경우 난수 재발생
			while(true) {
				lotto[i]=(int)(Math.random()*100)%45+1;
				
				//난수값에 대한 중복 상태정보를 저장하기 위한 변수
				// => false : 미중복, true : 중복
				boolean result=false;
				
				//기존 요소에 저장된 난수값과 차례대로 비교
				for(int j=0;j<i;j++) {
					//lotto[i] : 새로 발생된 난수값이 저장된 요소
					//lotto[j] : 기존 난수값이 저장된 요소
					if(lotto[i]==lotto[j]) {//난수값이 중복된 경우
						result=true;
						break;
					}
				}
				
				//난수값이 중복되지 않은 경우 while 구문 종료
				if(!result) break;
			}//while 종료
		}//for 종료

		//배열 요소를 정렬하여 재저장 >> 선택 정렬 알고리즘(Selection Sort Algorithm) 이용
		for(int i=0;i<lotto.length-1;i++) {//비교 요소의 첨자 : 0 ~ 마지막-1
			for(int j=i+1;j<lotto.length;j++) {//피비교 요소의 첨자 : 비교첨자+1 ~ 마지막
				//lotto[i] : 비교 요소 표현식 >> 선택 정렬
				//lotto[j] : 피비교 요소 표현식
				if(lotto[i] > lotto[j]) {//오름차순 정렬
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//배열 요소값 출력
		System.out.print("행운의 숫자 >> ");
		for(int number:lotto) {
			System.out.print(number+"  ");
		}
		System.out.println();
	}
}





