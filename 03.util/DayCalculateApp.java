package site.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램
//ex) 생년월일 입력[ex.2000-01-01] >> 2019-11-07
//    [결과]태어난지 1일 지났습니다.
// => 형식에 맞지 않은 생년월일이 입력될 경우 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
		
		//참조변수에 초기값으로 null 또는 인스턴스 저장
		Date birthday=null;
		System.out.print("생년월일 입력[ex.2000-01-01] >> ");
		try {
			birthday=sdf.parse(scanner.nextLine());
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞지 않는 생년월일을 입력 하였습니다.");
			System.exit(0);
		} finally {
			scanner.close();
		}
		
		//살아온 일수(현재 - 생일)를 계산하여 출력
		//long day=(new Date().getTime()-birthday.getTime())/(1000*60*60*24);
		long day=(System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24);
				
		System.out.println("[결과]태어난지 "+day+"일 지났습니다.");		
	}
}