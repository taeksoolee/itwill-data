package site.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

//ServerSocket Ŭ���� : TCP ���α׷����� ������ �����ϱ� ���� Ŭ���� 
// => Ŭ���̾�Ʈ�� ������ ��ٸ��� ��� ���� - Ư�� Port Ȱ��ȭ
//��Ʈ(Port) : ��Ʈ��ũ�� ���� ���� ������ �� �ִ� ������ ������
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=1000;i<=9000;i+=1000) {
			try {
				ServerSocket server=new ServerSocket(i);
				System.out.println(i+"�� ��Ʈ�� ��� �����մϴ�.");
				//ServerSocket.close() : ���� ��� �����ϴ� �޼ҵ�
				server.close();
			} catch (IOException e) {
				//�̹� �ٸ� ��Ʈ��ũ ���α׷����� ��Ʈ�� ����� ��� IOException �߻�
				System.out.println(i+"�� ��Ʈ�� �̹� ��� ���Դϴ�.");
			}
		}
	}
}



