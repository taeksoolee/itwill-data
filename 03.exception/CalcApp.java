package site.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수 2개를 입력받아 나눈 결과값를 출력하는 프로그램
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 >> ");
		//Scanner.nextInt() : 키보드로 입력된 정수값을 반환하는 메소드
		// => 입력값이 정수가 아닌 경우 InputMismatchException 발생
		int num1=scanner.nextInt();
		
		System.out.print("두번째 정수 입력 >> ");
		int num2=scanner.nextInt();
		
		//0으로 나눌 경우 ArithmeticException 발생
		System.out.println("[결과]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//인스턴스 생성 - 생성자의 명령 실행
			new CalcApp();
		} catch (InputMismatchException e) {
			System.out.println("[에러]정수값만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			//Exception : 모든 예외클래스의 부모클래스 - 모든 예외처리 가능
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
		*/
		
		try {
			new CalcApp();
		} catch (InputMismatchException | ArithmeticException e) {
			//JDK1.7 이상에서는 예외클래스를 | 연산자로 연결하여 작성 가능 
			System.out.println("[에러]형식에 맞게 값을 입력해 주세요.");
		} catch (Exception e) {
			//Exception : 모든 예외클래스의 부모클래스 - 모든 예외처리 가능
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생 되었습니다.");
		}
		
	}
}











