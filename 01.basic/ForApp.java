package basic;

public class ForApp {
	public static void main(String[] args) {
		//"Java Programming"를 화면에 5번 출력
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("====================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=1;i<=5;i++) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=5;i>=1;i--) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//"Java Programming"를 화면에 5번 출력
		for(int i=2;i<=10;i+=2) {
			System.out.println("Java Programming");
		}
		System.out.println("====================================");
		//1~10 범위의 정수 중 홀수만 화면에 출력
		for(int i=1;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("====================================");
		//1~100 범위의 정수들의 합계를 계산하여 출력
		//1+2+3+4+...+98+99+100 >> ?
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수 합계 = "+tot);
		System.out.println("====================================");
		//int begin=30,end=80;
		int begin=80,end=30;
		
		/*
		if(begin>end) {
			System.out.println("[에러]시작값이 마지막값보다 작아야 됩니다.");
			System.exit(0);
		}
		*/
		
		if(begin>end) {
			//두 변수에 저장된 정수값을 서로 바꾸어 저장 - 치환 알고리즘(Swap Algorithm)
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		//두 변수에 저장된 정수값 범위의 합계를 계산하여 출려
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		
		System.out.println(begin+"~"+end+" 범위의 정수 합계 = "+sum);
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
		//무한루프 : 종료되지 않는 반복문
		/*
		for(;;) {
			System.out.println("무한 반복되어 실행되는 명령");
		}
		*/
		//System.out.println("====================================");
	}
}
