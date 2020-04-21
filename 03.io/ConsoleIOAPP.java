package site.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 출력하는 프로그램
public class ConsoleIOAPP {
	public static void main(String[] args) throws IOException {
		//스트림의 다단계 연결을 이용한 스트림 확장
		// => System.in : 키보드로 원시데이타를 입력받기 위해 제공되는 입력스트림
		// => new InputStreamReader(InputStream in) : InputStream 스트림을 전달받아
		//    인코딩데이타를 입력받을 수 있는 InputStreamReader 스트림으로 확장
		// => new BufferedReader(InputStreamReader in) : InputStreamReader 스트림을 전달받아
		//    대용량 데이타로 입력받을 수 있는 BufferedReader 스트림으로 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//PrintStream 클래스의 print() 또는 println() 메소드를 이용할 경우
		//모든 형태의 값을 전달해도 문자열로 변환하여 전달
		System.out.print("이름 입력 >> ");
		//BufferedReader.readLine() : 입력스트림에 존재하는 모든 인코딩
		//데이타(문자)를 문자열로 읽어 반환하는 메소드
		String name=in.readLine();	
		
		System.out.print("태어난 년도 입력 >> ");
		//입력값을 문자열로 반환받아 정수값로 변환하여 저장
		int year=Integer.parseInt(in.readLine());
		
		int age=Calendar.getInstance().get(Calendar.YEAR)-year+1;
		
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
	}
}
