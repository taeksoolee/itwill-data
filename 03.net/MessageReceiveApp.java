package site.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//�ٸ� ��ǻ�Ϳ��� ������ �޼����� �����޾� ����ϴ� UDP ���α׷�
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket=new DatagramSocket(5000);
		
		//������ �޼����� �����ϱ� ���� byte[] �迭 ����
		byte[] data=new byte[256];
		
		//������ ��Ŷ�� �����ϱ� ���� DatagramPacket �ν��Ͻ� ����
		DatagramPacket packet=new DatagramPacket(data, data.length);
		
		System.out.println("�޼��� ���� ��...");
		
		//DatagramSocket.receive(DatagramPacket packet) : �ٸ� ��ǻ�Ϳ���
		//������ ��Ŷ�� DatagramPacket �ν��Ͻ��� �����ϱ� ���� �޼ҵ�
		// => ��Ŷ�� �ޱ� ������ ������ �Ͻ� ����
		socket.receive(packet);
		
		//byte[] �迭�� String �ν��Ͻ��� ��ȯ�Ͽ� ����
		String message=new String(data);
		
		System.out.println("[���]�޼��� = "+message);
		
		socket.close();
	}
}