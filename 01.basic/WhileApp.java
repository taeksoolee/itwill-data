package basic;

public class WhileApp {
	public static void main(String[] args) {
		//"Java Programming"를 화면에 5번 출력
		int i=1;
		while(i<=5) {
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("===========================================");
		//1~100 범위의 정수들의 합계를 계산하여 출력
		int j=1,tot=0;
		do {
			tot+=j;
			j++;
		} while(j<=100);
		System.out.println("1~100 범위의 정수합계 = "+tot);
		System.out.println("===========================================");
		//A4 용지를 반으로 계속 접어 펼쳤을 수 경우 사각형 모양이 500개 
		//이상이 만들어지려면 몇 번 접아야 되는지 계산하여 출력
		//cnt : 접는 횟수, gae : 사각형 갯수
		int cnt=0,gae=1;
		//사각형 모양이 500개 이상인 경우 반복문 종료
		/*
		while(gae<500) {
			cnt++;
			gae*=2;
		}
		*/
		
		while(true) {//무한루프
			cnt++;
			gae*=2;
			if(gae>=500) break;
		}
		
		System.out.println(cnt+"번 접으면 "+gae+"개의 사각형이 만들어집니다.");
		System.out.println("===========================================");
		//1부터 X 범위의 정수들의 합계가 300이상 되려면 X가 얼마인지 계산 출력
		//ex) 1~24 범위의 정수들의 합계 = 300
		/*
		int su=0,sum=0;//su : 더해지는 정수값, sum : 합계
		while(sum<300) {
			su++;
			sum+=su;
		}
		*/
		
		int su=1,sum=0;
		while(true) {
			sum+=su;
			if(sum>=300) break;
			su++;
		}
		System.out.println("1~"+su+" 범위의 정수들의 합계 = "+sum);
		System.out.println("===========================================");
	}
}