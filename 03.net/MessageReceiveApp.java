package site.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//다른 컴퓨터에서 전달한 메세지를 제공받아 출력하는 UDP 프로그램
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket=new DatagramSocket(5000);
		
		//보내온 메세지를 저장하기 위한 byte[] 배열 선언
		byte[] data=new byte[256];
		
		//보내온 패킷을 저장하기 위한 DatagramPacket 인스턴스 생성
		DatagramPacket packet=new DatagramPacket(data, data.length);
		
		System.out.println("메세지 수신 중...");
		
		//DatagramSocket.receive(DatagramPacket packet) : 다른 컴퓨터에서
		//보내온 패킷을 DatagramPacket 인스턴스에 저장하기 위한 메소드
		// => 패킷을 받기 전까지 스레드 일시 중지
		socket.receive(packet);
		
		//byte[] 배열을 String 인스턴스로 변환하여 저장
		String message=new String(data);
		
		System.out.println("[결과]메세지 = "+message);
		
		socket.close();
	}
}