package site.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//접속 클라이언트에서 보내온 메세지를 전달받아 출력하는 서버 프로그램
public class EchoServerApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket echoServer=new ServerSocket(4000);
		System.out.println("[메세지]Echo Server Running...");
		
		while(true) {
			Socket socket=echoServer.accept();
			
			//소켓의 입력스트림을 제공받아 문자열을 읽을 수 있는 스트림 확장
			BufferedReader in=new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			
			//클라이언트에서 보내온 메세지를 반환받아 출력
			System.out.println("["+socket.getInetAddress().getHostAddress()
				+"]님이 보내온 메세지 >> "+in.readLine());
			
			socket.close();		
		}
	}
}



