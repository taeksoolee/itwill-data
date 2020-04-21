package basic;

public class VariableApp {
	public static void main(String[] args) {
		//변수 선언
		int num;
		
		//변수에 값 저장 - 초기화
		num=100;
		
		//변수값 출력
		System.out.print("변경 전 변수값 = ");
		System.out.println(num);
		
		//변수에 값 저장 - 값 변경 >> 덮어씌우기(OverWrite)
		num=200;
		System.out.print("변경 후 변수값 = ");
		System.out.println(num);
		System.out.println("====================================");

		//변수 선언 및 초기화
		int su=300;

		//"출력대상"+변수값 or 변수값+"출력대상" >> 출력대상에 변수값 결합(문자열 변환)
		System.out.println("su = "+su);
		System.out.println("====================================");
		System.out.println("올해는 "+2+0+1+9+"년입니다.");
		System.out.println(2+0+1+9+"년은 돼지띠의 해입니다.");
		System.out.println(""+2+0+1+9+"년은 돼지띠의 해입니다.");
		System.out.println("====================================");
		//동일한 자료형의 변수는 나열하여 선언 가능
		int num1=10,num2=20;
		System.out.println("연산결과 = "+num1+num2);
		System.out.println("연산결과 = "+(num1+num2));
		System.out.println("연산결과 = "+num1*num2);
		System.out.println("연산결과 = "+(num1*num2));
		System.out.println("====================================");
		int kor=88, eng=90;
		//연산결과를 변수에 저장
		int tot=kor+eng;
		System.out.println("점수합계 = "+tot);		
		System.out.println("====================================");
		/*
		int number;
		//변수에 값이 저장되어 있지 않은 상태로 사용될 경우 에러 발생
		System.out.println("number = "+number);
		*/
		
		/*
		//변수에 저장 불가능한 값을 저장할 경우 에러 발생
		int number=10.0;
		System.out.println("number = "+number);
		*/
	}
}






