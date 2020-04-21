package basic;

import java.util.Scanner;

public class ScannerApp {
	public static void main(String[] args) {
		//Scanner 클래스 : 입력장치(키보드, 파일 등)로 값을 입력받아 제공하는 메소드가 선언된 클래스
		//Scanner 객체 생성 >> 키보드로 값을 입력받기 위한 객체
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		//Scanner.nextLine() : 키보드 입력값을 문자열로 반환하는 메소드
		// => 키보드 입력값이 존재하지 않을 경우 스레드가 일시 중지
		// => 키보드로 값을 입력한 후 엔터를 입력해야만 스레드 재실행
		String name=scanner.nextLine();
		
		System.out.print("태어난 년도 입력 >> ");
		//Scanner.nextInt() : 키보드 입력값을 정수값으로 반환하는 메소드
		// => 키보드 입력값이 정수가 아닌 경우 예외(Exception) 발생
		int birthYear=scanner.nextInt();
		
		System.out.println("[결과]"+name+"님은 "+birthYear+"년에 태어났습니다.");
		
		//Scanner.close() : Scanner 객체 제거 메소드
		scanner.close();
	}
}
