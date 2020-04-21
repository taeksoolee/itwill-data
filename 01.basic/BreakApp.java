package basic;

public class BreakApp {
	public static void main(String[] args) {
		//조건식이 거짓인 경우 반복문 종료
		for(int i=1;i<=5;i++) {
			//break : 반복문을 종료하는 키워드
			if(i==3) break;
			System.out.println("i = "+i);
		}
		System.out.println("============================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//포함된 반복문 종료 >> for(int j=1;j<=5;j++) 종료
				if(j==3) break;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
		//반복문에 라벨(식별자)을 부여 가능 
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//해당 라벨의 반복문 종료 >> for(int i=1;i<=5;i++) 종료
				if(j==3) break loop;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
	}
}




