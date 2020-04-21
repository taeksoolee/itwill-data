package site.itwill.util;

import java.util.Date;

//Date : 날짜와 시간정보를 저장하기 위한 클래스
public class DateApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Date() : 시스템의 현재 날짜와 시간정보를 저장하는 인스턴스를 생성하는 생성자
		Date now=new Date();
		
		//Date.toString() : Date 인스턴스의 날짜와 시간정보를 문자열로 변환하여 반환하는 메소드
		// => Date 인스턴스가 저장된 참조변수를 출력할 경우 호출 생략 가능
		System.out.println("now = "+now.toString());
		
		//날짜와 요일 출력
		String[] day={"일","월","화","수","목","금","토"};
		
		String printDate=(now.getYear()+1900)+"년 "+(now.getMonth()+1)
				+"월 "+now.getDate()+"일 "+day[now.getDay()]+"요일";
		
		System.out.println("현재 = "+printDate);
		
		//Date.getTime() : Date 인스턴스에 저장된 날짜와 시간정보를 타임스템프로 변환하여 반환하는 메소드 
		long nowTime=now.getTime();
		System.out.println("nowTime = "+nowTime);
		
		Date wantDate=new Date(100, 0, 1);//2000년 1월 1일

		//System.out.println("wantDate = "+wantDate);
		long wantTime=wantDate.getTime();
		
		System.out.println("연산결과(초) = "+((nowTime-wantTime)/1000));
	}
}
