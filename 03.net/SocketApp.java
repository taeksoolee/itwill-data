package site.itwill.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket 클래스 : TCP 프로그램에서 클라이언트를 구현하기 위한 클래스
// => 서버에 접속하는 기능을 제공 - 서버이름(IP 주소)과 Port 번호로 접속
public class SocketApp {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("www.daum.net", 80);
			
			//Socket.toString() : 소켓정보를 문자열로 변환하여 반환하는 메소드
			//System.out.println("socket = "+socket.toString());
			System.out.println("socket = "+socket);
			
			//Socket.getInetAddress() : 접속된 서버 컴퓨터의 네트워크 정보를 반환하는 메소드
			System.out.println("Remote IP Address = "
					+socket.getInetAddress().getHostAddress());
			
			//Socket.getPort() : 접속된 서버 컴퓨터에 네트워크 포트를 반환하는 메소드
			System.out.println("Remote Port Number = "+socket.getPort());
			
			//Socket.getLocalAddress() : 접속 클라이언트 컴퓨터의 네트워크 정보를 반환하는 메소드
			System.out.println("Local IP Address = "
					+socket.getLocalAddress().getHostAddress());

			//Socket.getLocalPort() : 접속 클라이언트 컴퓨터의 네트워크 포트를 반환하는 메소드
			System.out.println("Local Port Number = "+socket.getLocalPort());
			
			//Socket.close() : 접속을 제거하는 메소드 - 접속 종료
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[에러]서버 컴퓨터를 찾을 수 없습니다.");
		} catch (IOException e) {
			//서버가 실행 상태가 아닌 경우 IOException 발생
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}
}
