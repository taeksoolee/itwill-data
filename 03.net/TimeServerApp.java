package site.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속 클라이언트에게 서버 컴퓨터의 날짜와 시간정보를 전달하는 서버 프로그램
// => NTP(Network Time Protocol) Server : 날짜와 시간정보를 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		try {
			//ServerSocket 인스턴스 생성 - 서버 실행
			// => 포트를 활성화하여 클라이언트의 접속 허용
			ntpServer=new ServerSocket(3000);
			System.out.println("[메세지]NTP Server Running...");
			
			//서버 프로그램은 클라이언트의 지속적인 접속을 허용하기 위해 무한루프 처리
			while(true) {
				//ServerSocket.accept() : 클라이언트의 접속을 기다리는 메소드
				// => 클라이언트 접속 전까지 스레드 일시 중지
				// => 클라이언트가 접속될 경우 클라이언트와 연결된 Socket 인스턴스 반환
				Socket socket=ntpServer.accept();
				
				/*
				//Socket.getOutputStream() : Socket 인스턴스의 출력스트림을 반환하는 메소드
				OutputStream out=socket.getOutputStream();
				
				//출력스트림을 전달받아 객체 전달이 가능한 스트림으로 확장
				ObjectOutputStream stream=new ObjectOutputStream(out);
				
				//클라이언트에게 전달할 인스턴스 생성
				Date date=new Date();
				
				//출력스트림을 이용하여 인스턴스 전달
				stream.writeObject(date);
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그 기록
				System.out.println("[로그]클라이언트("+socket.getInetAddress()
					.getHostAddress()+")에게 날짜와 시간정보를 제공 하였습니다.");
				
				//소켓 제거 - 클라이언트 접속 해제
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러]서버에 네트워크 문제가 발생 하였습니다.");
		}
	}
}
