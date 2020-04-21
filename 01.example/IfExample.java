package example;

public class IfExample {
	public static void main(String[] args) {
		//문자변수에 저장된 문자값을 출력하세요.
		//단, 저장된 문자값이 알파벳 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun='x';
		
		//변수값에 소문자인 경우 대문자로 변환
		if(mun>='a' && mun<='z') mun-=32; 
		
		System.out.println("mun = "+mun);
		System.out.println("============================================");
		
		//정수변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num=345644;
		
		//변수값이 4의 배수인 경우
		if(num%4==0) {
			System.out.println("[결과]"+num+" >> 4의 배수가 맞습니다.");
		} else {
			System.out.println("[결과]"+num+" >> 4의 배수가 아닙니다.");
		}
		
		System.out.println("============================================");
		
		//올해가 평년인지 윤년인지를 구분하여 출력하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건들을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year=2019;
		
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println("[결과]"+year+"년은 윤년입니다.");
		} else {
			System.out.println("[결과]"+year+"년은 평년입니다.");
		}
		
		System.out.println("============================================");
		
		//이름이 "홍길동"인 학생의 시험성적은 국어 87점, 영어 93점, 수학 80점입니다.
		//학생의 시험성적에 대한 총점과 평균, 평균에 대한 학점을 계산하여 
		//이름, 총점, 평균, 학점을 출력하세요.
		// => 국어, 영어, 수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 종료 : System.exit(0);
		// => 평균에 대한 학점 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 2자리까지만 출력되도록 하고 나머지를 내림처리 하세요.
		String name="홍길동";
		int kor=87,eng=93,mat=80;
		
		//입력값에 대한 유효성 검사 >> Validation
		/*
		if((kor<0 || kor>100) || (eng<0 || eng>100) || (mat<0 || mat>100)) {
			System.out.println("[에러]0~100 범위를 벗어난 점수가 입력 되었습니다.");
			System.exit(0);//프로그램 강제 종료 메소드
		}
		*/
		//점수에 입력 유효성 검사 관련 상태정보를 저장하기 위한 변수 선언
		boolean status=false;
		
		if(kor<0 || kor>100) {
			System.out.println("[에러]0~100 범위를 벗어난 국어점수가 입력 되었습니다.");
			status=true;
		}
		
		if(eng<0 || eng>100) {
			System.out.println("[에러]0~100 범위를 벗어난 영어점수가 입력 되었습니다.");
			status=true;
		}
		
		if(mat<0 || mat>100) {
			System.out.println("[에러]0~100 범위를 벗어난 수학점수가 입력 되었습니다.");
			status=true;
		}
		
		//if 구문의 조건식 대신 boolean 변수 사용 가능 
		if(status) {
			System.exit(0);
		}
		
		int tot=kor+eng+mat;
		double avg=tot/3.0;
		String grade="";
		switch ((int)avg/10) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("이름 = "+name+", 총점 = "+tot+", 평균 = "
			+(int)(avg*100)/100.+", 학점 = "+grade);
		System.out.println("============================================");
	}
}







