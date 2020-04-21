package basic;

public class IfApp {
	public static void main(String[] args) {
		//int score=80;
		int score=50;
		
		//점수가 60점 이상인 경우 합격메세지 출력
		if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 합격입니다.");
		}
		
		//점수가 60점 미만인 경우 불합격메세지 출력
		if(score<60) {
			System.out.println("[결과]점수가 60점 미만이므로 불합격입니다.");
		}
		System.out.println("====================================");
		//점수가 60점 이상인 경우 합격메세지 출력하고 아닌 경우 불합격메세지 출력
		if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 합격입니다.");
		} else {
			System.out.println("[결과]점수가 60점 미만이므로 불합격입니다.");
		}
		System.out.println("====================================");
		//int num=9;
		int num=10;
		
		//변수에 저장된 정수값을 홀수와 짝수로 구분하여 출력
		if(num%2!=0) {
			System.out.println("[결과]"+num+" >> 홀수");
		} else {
			System.out.println("[결과]"+num+" >> 짝수");
		}
		System.out.println("====================================");
		//char mun='O';
		char mun='0';
		
		//변수에 저장된 문자값이 영문자인지 구분하여 출력
		if (mun>='A' && mun<='Z' || mun>='a' && mun<='z') {
			System.out.println("[결과]영문자가 맞습니다.");
		} else {
			System.out.println("[결과]영문자가 아닙니다.");
		}
		System.out.println("====================================");
		int jumsu=85;
		
		//변수에 저장된 정수값이 0~100 범위인지 구분하여 출력
		if(jumsu>=0 && jumsu<=100) {
			//System.out.println("[결과]정상적인 점수가 입력 되었습니다.");
			
			//점수에 따른 학점을 계산하여 출력
			//100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
			char grade;
			
			if(jumsu>=90) grade='A'; 
			else if(jumsu>=80) grade='B';
			else if(jumsu>=70) grade='C';
			else if(jumsu>=60) grade='D';
			else grade='F';//무조건 실행
			
			System.out.println("[결과]"+jumsu+"점 >> "+grade+"학점");
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 점수가 입력 되었습니다.");
		}
		System.out.println("====================================");

		int choice=1;
		
		//null : 존재하지 않는 객체를 표현하기 위한 키워드 
		//String name=null;
		//"" : 문자가 존재하지 않는 문자열(String 객체) >> NullString
		String name="";
		
		//문제)제어문에서 변수에 값을 저장하는 명령을 작성할 경우 초기화 에러 발생
		//해결법-1)무조건적인 명령 실행을 이용하여 변수값 저장
		//해결법-2)값을 저장하는 변수 선언시 초기값 설정
		// => 숫자형 : 0, 논리형 : false, 문자열 : "", 참조형 : null
		if(choice==1) {
			name="홍길동";
		} else if(choice==2) {
			name="임꺽정";
		} /* else {
			name="전우치";
		} */
	
		System.out.println("[결과]당신이 선택한 사람은 ["+name+"]입니다.");
		System.out.println("====================================");
	}
}










