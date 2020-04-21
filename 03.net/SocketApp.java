package site.itwill.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//Socket Ŭ���� : TCP ���α׷����� Ŭ���̾�Ʈ�� �����ϱ� ���� Ŭ����
// => ������ �����ϴ� ����� ���� - �����̸�(IP �ּ�)�� Port ��ȣ�� ����
public class SocketApp {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("www.daum.net", 80);
			
			//Socket.toString() : ���������� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
			//System.out.println("socket = "+socket.toString());
			System.out.println("socket = "+socket);
			
			//Socket.getInetAddress() : ���ӵ� ���� ��ǻ���� ��Ʈ��ũ ������ ��ȯ�ϴ� �޼ҵ�
			System.out.println("Remote IP Address = "
					+socket.getInetAddress().getHostAddress());
			
			//Socket.getPort() : ���ӵ� ���� ��ǻ�Ϳ� ��Ʈ��ũ ��Ʈ�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Remote Port Number = "+socket.getPort());
			
			//Socket.getLocalAddress() : ���� Ŭ���̾�Ʈ ��ǻ���� ��Ʈ��ũ ������ ��ȯ�ϴ� �޼ҵ�
			System.out.println("Local IP Address = "
					+socket.getLocalAddress().getHostAddress());

			//Socket.getLocalPort() : ���� Ŭ���̾�Ʈ ��ǻ���� ��Ʈ��ũ ��Ʈ�� ��ȯ�ϴ� �޼ҵ�
			System.out.println("Local Port Number = "+socket.getLocalPort());
			
			//Socket.close() : ������ �����ϴ� �޼ҵ� - ���� ����
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("[����]���� ��ǻ�͸� ã�� �� �����ϴ�.");
		} catch (IOException e) {
			//������ ���� ���°� �ƴ� ��� IOException �߻�
			System.out.println("[����]������ ������ �� �����ϴ�.");
		}
	}
}
