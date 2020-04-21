package site.itwill.util;

import java.util.Calendar;

//현재 년월에 대한 달력을 출력하는 프로그램
public class CurrentCalendarApp {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();//2019-11-11
		
		//Calendar 인스턴스에 저장된 날짜와 시간정보 중 일을 1일로 변경
		//Calendar.set(int field, int value) : 원하는 필드값을 변경하는 메소드
		calendar.set(Calendar.DATE, 1);//2019-11-01
		
		//Calendar.set(int year, int month, int date) : 년월일 변경하는 메소드
		//calendar.set(2019, 11, 1);//2019-12-01
		
		//Calendar 인스턴스에 저장된 날짜에 대한 요일값을 반환받아 저장
		int week=calendar.get(Calendar.DAY_OF_WEEK);//1(일)~7(토)
		
		System.out.println("        "+calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월");
		System.out.println("============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");

		//1일에 대한 요일 전까지 공백 출력
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//1일부터 월에 대한 마지막 일까지 출력
		//Calendar.getActualMaximum(int field) : Calendar 인스턴스에 저장된
		//필드에 대한 사용 가능한 최대값을 반환하는 메소드 
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			if(i<10) {
				System.out.print("   "+i);
			} else {
				System.out.print("  "+i);
			}
			
			week++;
			
			if(week%7==1) {
				System.out.println();
			}
		}
	}
}








