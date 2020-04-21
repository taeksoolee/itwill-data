package site.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocket 클래스 : TCP 프로그램에서 서버를 구현하기 위한 클래스 
// => 클라이언트의 접속을 기다리는 기능 제공 - 특정 Port 활성화
//포트(Port) : 네트워크를 통해 값을 전달할 수 있는 논리적인 고유값
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=1000;i<=9000;i+=1000) {
			try {
				ServerSocket server=new ServerSocket(i);
				System.out.println(i+"번 포트는 사용 가능합니다.");
				//ServerSocket.close() : 서버 기능 제거하는 메소드
				server.close();
			} catch (IOException e) {
				//이미 다른 네트워크 프로그램에서 포트를 사용할 경우 IOException 발생
				System.out.println(i+"번 포트는 이미 사용 중입니다.");
			}
		}
	}
}



