package basic;

import java.util.Scanner;

//키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램을 작성하세요.
// => 100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
// => 점수는 0~100 범위의 정수값만 입력되도록 작성 >> 비정상적인 값이 입력된 경우 재입력
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		/*
		int score=-1;//비정상적인 값을 저장
		//입력값이 비정상적인 경우 반복 처리 >> 유효성 검사
		while(score<0 || score>100) {
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();//1번이상 실행
			if(score<0 || score>100) {
				System.out.println("[에러]0~100 범위의 정수값만 입력 가능합니다.");
			}
		}
		*/
		
		/*
		int score;
		do {
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();//1번이상 실행
			if(score<0 || score>100) {
				System.out.println("[에러]0~100 범위의 정수값만 입력 가능합니다.");
			}
		} while(score<0 || score>100);
		*/
		
		int score;
		while(true) {//무한루프
			System.out.print("점수 입력[0~100] >> ");
			score=scanner.nextInt();//1번이상 실행
			//정상적인 정수값이 입력된 경우 반복문 종료
			if(score>=0 && score<=100) break;
			//입력값이 미정상적인 경우에 대한 처리
			System.out.println("[에러]0~100 범위의 정수값만 입력 가능합니다.");
		}
		
		String grade;
		switch (score/10) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("[결과]"+score+"점 = "+grade+"학점");
		
		scanner.close();
	}
}




