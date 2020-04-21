package site.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

//ä�� ���� ���α׷� => ���߽�����
// => Ŭ���̾�Ʈ���� ������ �޼����� ���� ���ӵ� ��� Ŭ���̾�Ʈ���� �����ϴ� ���
// => Ŭ���̾�Ʈ�� ����� ������ ���ο� �����带 �̿��Ͽ� ���������� ��� ����  
public class ChatServerApp {
	//���ӵ� ��� Ŭ���̾�Ʈ�� ���� ������ �����ϱ� ���� �ݷ��� �ʵ�
	private List<SocketThread> clientList;
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		try {
			chatServer=new ServerSocket(6000);
			System.out.println("[�޼���]ä�� ���� ���� ��...");
			
			clientList=new Vector<SocketThread>();
			
			while(true) {
				try {
					Socket client=chatServer.accept();
					
					System.out.println("[���ӷα�]"+client.getInetAddress()
						.getHostAddress()+"�� ��ǻ�Ϳ��� ���� �Ͽ����ϴ�.");
					
					//���������� �����ϴ� ������ �ν��Ͻ� ����
					SocketThread st=new SocketThread(client);
					
					//�ݷ��� �ʵ忡 ������ �ν��Ͻ� �߰�
					clientList.add(st);
					
					//������ �ν��Ͻ��� �̿��Ͽ� ������ ���� - run() �޼ҵ��� ��� ����
					st.start();
				} catch (IOException e) {
					System.out.println("[�����α�]Ŭ���̾�Ʈ�� ���� ���� ������ �߻� �Ͽ����ϴ�.");
				}
			}
			
		} catch (IOException e) {
			System.out.println("[����]������ ���������� ������� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new ChatServerApp();
	}
	
	//���� ���ӵ� ��� Ŭ���̾�Ʈ���� �޼����� �����ϱ� ���� �޼ҵ�
	public void sendMessage(String message) {
		for(SocketThread st:clientList) {
			//Ŭ���̾�Ʈ�� ����� ������ ��½�Ʈ������ �޼����� ����
			st.out.println(message);
		}
	}
	
	//Ŭ���̾�Ʈ�� ����� ������ �̿��Ͽ� �Է°� ��� ����� �����ϱ� ���� Ŭ����
	// => ���������� �Է°� ��� ����� �����ϱ� ���� �����带 �����Ͽ� ���۵ǵ��� ����
	public class SocketThread extends Thread {
		//Ŭ���̾�Ʈ�� ����� ���������� �����ϱ� ���� �ʵ�
		private Socket socket;
		
		//Ŭ���̾�Ʈ�� ������ �޼����� �ޱ� ���� �Է½�Ʈ���� �����ϱ� ���� �ʵ�
		private BufferedReader in;
		
		//Ŭ���̾�Ʈ���� �޼����� ������ ���� ��½�Ʈ���� �����ϱ� ���� �ʵ�
		private PrintWriter out;
		
		public SocketThread(Socket socket) {
			this.socket=socket;
		}
		
		@Override
		public void run() {
			//��ȭ���� �����ϱ� ���� ���� ����
			String aliasName="";
			try {
				//������ �Է½�Ʈ���� �����޾� ���ڿ��� �б� ���� ��Ʈ������ Ȯ��
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//������ ��½�Ʈ���� �����޾� ���ڿ��� �����ϱ� ���� ��Ʈ������ Ȯ��
				//PrintWriter(OutputStream out, boolean autoFlush) :  
				//boolean �Ű������� true�� �����ϸ� �ڵ����� flush ��� ����
				out=new PrintWriter(socket.getOutputStream(),true);
				
				//Ŭ���̾�Ʈ���� �ԷµǾ� ���޵� ��ȭ���� ��ȯ�޾� ����
				// => ��ȭ���� �Է¹ޱ� ������ ������ �Ͻ� ����
				aliasName=in.readLine();
				
				//���� ���ӵ� ��� Ŭ���̾�Ʈ���� ����޼��� ����
				sendMessage("["+aliasName+"]���� ���� �Ͽ����ϴ�.");
				
				//Ŭ���̾�Ʈ���� ������ �޼����� ��ȯ�޾� ���� ���ӵ� ��� 
				//Ŭ���̾�Ʈ���� ���� - Ŭ���̾�Ʈ�� ���� ���� ������ �ݺ�
				// => Ŭ���̾�Ʈ�� �޼����� ������ ������ ������ �Ͻ� ����
				// => Ŭ���̾�Ʈ�� ������ ������ ��� IOException �߻� 
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch (IOException e) {
				//Ŭ���̾�Ʈ�� ������ ������ ��� ����� ��� �ۼ�
				// => �ݷ��� �ʵ忡�� ���� ���� �����带 ����
				// => ��� ���� Ŭ���̾�Ʈ���� ����޼����� ����
				clientList.remove(this);
				sendMessage("["+aliasName+"]���� ���� �Ͽ����ϴ�.");
				
				System.out.println("[�����α�]"+socket.getInetAddress()
					.getHostAddress()+"�� ��ǻ�Ϳ��� ������ ���� �Ͽ����ϴ�.");
			}
		}
	}
}







