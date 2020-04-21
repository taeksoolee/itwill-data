package site.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//SimpleDateFormat : Date 인스턴스를 사용하기 위한 기능을 제공하는 클래스
public class SimpleDateFormatApp {
	public static void main(String[] args) {
		Date now=new Date();
		
		//SimpleDateFormat(String pattern) : 날짜와 시간정보에 대한 
		//패턴정보(패턴문자와 문자열)를 저장하는 인스턴스를 생성하는 생성자
		// => 패턴문자 : y(년) M(월) d(일) H(시) m(분) s(초) E(요일) 등 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
	
		//SimpleDateFormat.format(Date date) : Date 인스턴스에 저장된 날짜와 시간정보를 
		//SimpleDateFormat 인스턴스에 저장된 패턴정보로 변환하여 문자열로 반환하는 메소드
		String printDate=sdf.format(now);
		
		System.out.println("현재 = "+printDate);
		
		//SimpleDateFormat.applyPattern(String pattern) : SimpleDateFormat
		//인스턴스에 저장된 패턴정보를 변경하는 메소드
		sdf.applyPattern("yyyy-mm-dd HH:mm:ss");
		
		String want="2000-01-01 00:00:00";
		try {
			//SimpleDateFormat.parse(String str) : SimpleDateFormat 인스턴스에
			//저장된 패턴정보와 동일한 문자열을 전달받아 Date 인스턴스로 변환하여 반환하는 메소드
			// => 패턴정보와 문자열이 같지 않은 경우 ParseException 발생 
			Date wantDate = sdf.parse(want);
			System.out.println("wantDate = "+wantDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}





