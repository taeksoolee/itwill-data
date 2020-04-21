package site.itwill.io;

import java.io.IOException;

//키보드 입력값을 원시데이타(1Byte)로 입력받아 모니터에 전달하는 프로그램
// => EOF(End Of File : 입력종료 - [Ctrl]+[Z])를 입력하면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");
		
		//키보드 입력값을 반환받아 저장하기 위한 변수
		int readByte;
		
		while(true) {
			//System.in : Java 프로그램 작성시 기본적으로 제공되는 키보드 입력스트림
			// => InputStream 클래스로 생성된 인스턴스
			//InputStream.read() : 입력스트림에서 원시데이타를 읽어 반환하는 메소드
			// => 입력스트림에 값이 존재하지 않을 경우 스레드 일시 중지
			// => 키보드를 눌러 스트림에 입력값을 전달후 엔터를 눌러 스레드 재실행
			//모든 입출력 클래스의 메소드에서는 IOException 발생 - 예외처리
			// => IOException : 입력스트림 또는 출력스트림에 문제가 있는 경우 발생되는 예외 
			readByte=System.in.read();
			
			//입력종료 관련 정보(Ctrl+Z : EOF >> -1)가 저장된 경우 반복문 종료
			if(readByte==-1) break;
			
			//System.out : Java 프로그램 작성시 기본적으로 제공되는 모니터 출력스트림
			// => PrintStream 클래스로 생성된 인스턴스
			// => PrintStream 클래스 : OutputStream 클래스를 상속받은 자식클래스
			//OutputStream.write(int b) : 원시데이타를 출력스트림으로 전달하는 메소드
			System.out.write(readByte);
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
}









