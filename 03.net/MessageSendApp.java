package site.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 프로그램 
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		//DatagramSocket 클래스 : 다른 컴퓨터에 접속할 수 있는 기능을 제공하기 위한 클래스
		DatagramSocket socket=new DatagramSocket();
		
		//String.getBytes() : String 인스턴스의 문자열을 byte[] 배열로 변환하여 반환하는 메소드
		byte[] data=message.getBytes();
	
		//InetAddress 인스턴스 생성
		InetAddress address=InetAddress.getByName("192.168.14.31");
		
		//DatagramPacket 클래스 : 원하는 컴퓨터에게 값을 전달하기 위한 정보를 저장하기 위한 클래스
		// => DatagramPacket(byte[] data, int length, InetAddress address, int port) 생성자
		DatagramPacket packet=new DatagramPacket(data, data.length, address, 5000);
		
		//DatagramSocket.send(DatagramPacket packet) : 패킷에 저장된 정보를
		//이용하여 다른 컴퓨터에게 전달하는 메소드
		socket.send(packet);
		
		//DatagramSocket.close() : 소켓을 제거하는 메소드
		socket.close();
		
		System.out.println("[결과]메세지를 전달 하였습니다.");
	}
}





