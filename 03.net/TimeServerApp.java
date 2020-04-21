package site.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//���� Ŭ���̾�Ʈ���� ���� ��ǻ���� ��¥�� �ð������� �����ϴ� ���� ���α׷�
// => NTP(Network Time Protocol) Server : ��¥�� �ð������� �����ϴ� ���� ��ǻ��
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		try {
			//ServerSocket �ν��Ͻ� ���� - ���� ����
			// => ��Ʈ�� Ȱ��ȭ�Ͽ� Ŭ���̾�Ʈ�� ���� ���
			ntpServer=new ServerSocket(3000);
			System.out.println("[�޼���]NTP Server Running...");
			
			//���� ���α׷��� Ŭ���̾�Ʈ�� �������� ������ ����ϱ� ���� ���ѷ��� ó��
			while(true) {
				//ServerSocket.accept() : Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ�
				// => Ŭ���̾�Ʈ ���� ������ ������ �Ͻ� ����
				// => Ŭ���̾�Ʈ�� ���ӵ� ��� Ŭ���̾�Ʈ�� ����� Socket �ν��Ͻ� ��ȯ
				Socket socket=ntpServer.accept();
				
				/*
				//Socket.getOutputStream() : Socket �ν��Ͻ��� ��½�Ʈ���� ��ȯ�ϴ� �޼ҵ�
				OutputStream out=socket.getOutputStream();
				
				//��½�Ʈ���� ���޹޾� ��ü ������ ������ ��Ʈ������ Ȯ��
				ObjectOutputStream stream=new ObjectOutputStream(out);
				
				//Ŭ���̾�Ʈ���� ������ �ν��Ͻ� ����
				Date date=new Date();
				
				//��½�Ʈ���� �̿��Ͽ� �ν��Ͻ� ����
				stream.writeObject(date);
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//�α� ���
				System.out.println("[�α�]Ŭ���̾�Ʈ("+socket.getInetAddress()
					.getHostAddress()+")���� ��¥�� �ð������� ���� �Ͽ����ϴ�.");
				
				//���� ���� - Ŭ���̾�Ʈ ���� ����
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[����]������ ��Ʈ��ũ ������ �߻� �Ͽ����ϴ�.");
		}
	}
}
