package basic;

public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			//continue : 반복문의 명령을  계속 실행하는 키워드
			// => continue 명령 아래에 존재하는 명령 실행 생략
			if(i==3) continue;
			System.out.println("i = "+i);
		}
		System.out.println("============================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//포함된 반복문 계속 실행 >> for(int j=1;j<=5;j++) 계속 실행
				if(j==3) continue;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//해당 라벨의 반복문 계속 실행 >> for(int i=1;i<=5;i++) 계속 실행
				// => break 기능와 유사
				if(j==3) continue loop;
				System.out.println("i = "+i+", j = "+j);
			}
		}
		System.out.println("============================================");
	}
}
