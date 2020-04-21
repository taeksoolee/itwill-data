package site.app;

import java.util.Date;
import java.util.Scanner;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 계산하여 출력하는 프로그램 작성하세요.
//ex) 이름 입력 >> 홍길동
//    태어난 년도 입력 >> 2000
//    [결과]홍길동님의 나이는 20살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		//키보드 입력값을 제공받기 위한 Scanner 인스턴스 생성
		Scanner scanner=new Scanner(System.in);
		
		//키보드로 이름과 태어난 년도를 입력받아 저장
		System.out.print("이름 입력 >> ");
		String name=scanner.nextLine();
		
		System.out.print("태어난 년도 입력 >> ");
		int birthYear=scanner.nextInt();
		
		//java.util.Date 클래스로 인스턴스 생성
		// => java.util.Date : 날짜와 시간정보를 저장하기 위한 클래스
		// => new Date() : 시스템(OS)의 현재 날짜와 시간정보를 저장한 Date 인스턴스 생성 
		Date now=new Date();
		
		//Date 인스턴스의 정보에서 현재 년도를 반환받아 저장
		//Date.getYear() : 1900년도부터 1년 단위 증가되는 정수값을 반환하는 메소드
		// => @Deprecated 어노테이션이 적용된 메소드
		//@Deprecated : 메소드를 호출하는 것을 권장하지 않도록 설정하는 어노테이션
		//@SuppressWarnings(String warning) : 매개변수에 전달되는 경고를 제거하는 어노테이션
		@SuppressWarnings("deprecation")
		int currentYear=now.getYear() + 1900;
		
		//나이를 계산하여 저장
		//int age=2019-birthYear+1;
		int age=currentYear-birthYear+1;
		
		//결과 출력
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		//Scanner 인스턴스 제거 - 입력장치 제거
		scanner.close();
	}
}
