package site.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP 서버에 접속하여 제공받은 날짜와 시간정보를 출력하는 클라이언트 프로그램
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket 인스턴스 생성
			// => 서버명(IP 주소)와 포트번호를 전달하여 서버 접속
			Socket socket=new Socket("192.168.14.31", 3000);
			
			//Socket.getInputStream() : Socket 인스턴스의 입력스트림을 반환하는 메소드
			InputStream in=socket.getInputStream();
			
			//입력스트림을 전달받아 객체 읽기가 가능한 스트림으로 확장
			ObjectInputStream stream=new ObjectInputStream(in);
			
			//서버에서 제공한 인스턴스를 반환받아 저장
			Date serverDate=(Date)stream.readObject();
			
			System.out.println("[결과]서버에서 제공된 날짜와 시간 = "
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(serverDate));
			
			//서버 접속 종료
			socket.close();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	} 
}





