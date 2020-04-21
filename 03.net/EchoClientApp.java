package site.itwill.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//키보드로 메세지를 입력받아 서버에 접속하여 전달하는 클라이언트 프로그램 
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//기본적으로 제공되는 키보드 입력스트림을 문자열을 입력받기 위한 스트림으로 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//서버에 전달하고 싶은 메세지를 키보드로 입력하여 저장
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		//서버 접속
		Socket socket=new Socket("192.168.14.31", 4000);
		
		//소켓의 출력스트림을 제공받아 문자열을 전달할 수 있는 스트림으로 확장
		BufferedWriter out=new BufferedWriter
				(new OutputStreamWriter(socket.getOutputStream()));
		
		//출력스트림을 이용하여 메세지를 서버에 전달
		out.write(message);
		out.flush();
				
		System.out.println("[결과]서버에 메세지를 전달 하였습니다.");
		socket.close();
	}
}






