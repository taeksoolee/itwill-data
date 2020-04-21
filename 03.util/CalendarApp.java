package site.itwill.util;

import java.util.Calendar;

public class CalendarApp {
	public static void main(String[] args) {
		//Calendar.getInstance() : 시스템의 현재 날짜와 시간정보를 저장하는 Calendar 인스턴스를 반환하는 메소드 
		Calendar now=Calendar.getInstance();
		
		//Calendar.toString() : Calendar 인스턴스의 날짜와 시간정보를 문자열로 변환하여 반환하는 메소드
		// => Calendar 인스턴스가 저장된 참조변수를 출력할 경우 호출 생략 가능
		System.out.println("now = "+now);
		
		//날짜와 요일 출력
		String[] day={"일","월","화","수","목","금","토"};
				
		//Calendar.get(int constantField) : Calendar 인스턴스에 저장된
		//날짜와 시간정보 중 상수필드에 대한 값을 반환하는 메소드
		String printDate=now.get(Calendar.YEAR)+"년 "
				+(now.get(Calendar.MONTH)+1)+"월 "
				+now.get(Calendar.DATE)+"일 "
				+day[now.get(Calendar.DAY_OF_WEEK)-1]+"요일";
				
		System.out.println("현재 = "+printDate);
	}
}





