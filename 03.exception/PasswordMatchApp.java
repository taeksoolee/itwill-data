package site.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 비밀번호와 비교하여 결과를 출력하는 프로그램
public class PasswordMatchApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		try {
			System.out.print("비밀번호 입력 >> ");
			int password=scanner.nextInt();
			
			/*
			if(password==1234) {
				System.out.println("[결과]입력한 비밀번호가 맞습니다.");
			} else {
				System.out.println("[결과]입력한 비밀번호가 다릅니다.");
			}
			*/
			
			if(password!=1234) {
				//throw 키워드 이용하여 인위적 예외 발생(예외 인스턴스 생성)
				// => 실행시 발생되는 예외가 아닌 경우 예외처리 하지 않을 경우 에러 발생
				throw new PasswordMissMatchException("[결과]입력한 비밀번호가 다릅니다.");
			}
			
			System.out.println("[결과]입력한 비밀번호가 맞습니다.");

		} catch (InputMismatchException e) {
			System.out.println("[에러]숫자만 입력 가능합니다.");
		} catch (PasswordMissMatchException e) {
			//실행시 발생되는 예외가 아닌 경우 예외처리 후 프로그램 종료 - finally 영역 필요
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}








