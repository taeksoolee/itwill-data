package site.itwill.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//Ű����� �޼����� �Է¹޾� ������ �����Ͽ� �����ϴ� Ŭ���̾�Ʈ ���α׷� 
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//�⺻������ �����Ǵ� Ű���� �Է½�Ʈ���� ���ڿ��� �Է¹ޱ� ���� ��Ʈ������ Ȯ��
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//������ �����ϰ� ���� �޼����� Ű����� �Է��Ͽ� ����
		System.out.print("���� �޼��� �Է� >> ");
		String message=in.readLine();
		
		//���� ����
		Socket socket=new Socket("192.168.14.31", 4000);
		
		//������ ��½�Ʈ���� �����޾� ���ڿ��� ������ �� �ִ� ��Ʈ������ Ȯ��
		BufferedWriter out=new BufferedWriter
				(new OutputStreamWriter(socket.getOutputStream()));
		
		//��½�Ʈ���� �̿��Ͽ� �޼����� ������ ����
		out.write(message);
		out.flush();
				
		System.out.println("[���]������ �޼����� ���� �Ͽ����ϴ�.");
		socket.close();
	}
}






