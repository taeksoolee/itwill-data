package site.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

//채팅 서버 프로그램 => 다중스레드
// => 클라이언트에서 보내온 메세지를 얻어와 접속된 모든 클라이언트에게 전달하는 기능
// => 클라이언트와 연결된 소켓은 새로운 스레드를 이용하여 독립적으로 명령 실행  
public class ChatServerApp {
	//접속된 모든 클라이언트에 대한 정보를 저장하기 위한 콜렉션 필드
	private List<SocketThread> clientList;
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		try {
			chatServer=new ServerSocket(6000);
			System.out.println("[메세지]채팅 서버 동작 중...");
			
			clientList=new Vector<SocketThread>();
			
			while(true) {
				try {
					Socket client=chatServer.accept();
					
					System.out.println("[접속로그]"+client.getInetAddress()
						.getHostAddress()+"의 컴퓨터에서 접속 하였습니다.");
					
					//소켓정보를 저장하는 스레드 인스턴스 생성
					SocketThread st=new SocketThread(client);
					
					//콜렉션 필드에 스레드 인스턴스 추가
					clientList.add(st);
					
					//스레드 인스턴스를 이용하여 스레드 생성 - run() 메소드의 명령 실행
					st.start();
				} catch (IOException e) {
					System.out.println("[에러로그]클라이언트의 접속 관련 문제가 발생 하였습니다.");
				}
			}
			
		} catch (IOException e) {
			System.out.println("[에러]서버가 정상적으로 실행되지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		new ChatServerApp();
	}
	
	//현재 접속된 모든 클라이언트에게 메세지를 전달하기 위한 메소드
	public void sendMessage(String message) {
		for(SocketThread st:clientList) {
			//클라이언트와 연결된 소켓의 출력스트림으로 메세지를 전달
			st.out.println(message);
		}
	}
	
	//클라이언트와 연결된 소켓을 이용하여 입력과 출력 기능을 제공하기 위한 클래스
	// => 독립적으로 입력과 출력 기능을 제공하기 위해 스레드를 생성하여 동작되도록 구현
	public class SocketThread extends Thread {
		//클라이언트와 연결된 소켓정보를 저장하기 위한 필드
		private Socket socket;
		
		//클라이언트가 보내온 메세지를 받기 위한 입력스트림을 저장하기 위한 필드
		private BufferedReader in;
		
		//클라이언트에게 메세지를 보내기 위한 출력스트림을 저장하기 위한 필드
		private PrintWriter out;
		
		public SocketThread(Socket socket) {
			this.socket=socket;
		}
		
		@Override
		public void run() {
			//대화명을 저장하기 위한 변수 선언
			String aliasName="";
			try {
				//소켓의 입력스트림을 제공받아 문자열을 읽기 위한 스트림으로 확장
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//소켓의 출력스트림을 제공받아 문자열을 전달하기 위한 스트림으로 확장
				//PrintWriter(OutputStream out, boolean autoFlush) :  
				//boolean 매개변수에 true를 전달하면 자동으로 flush 기능 구현
				out=new PrintWriter(socket.getOutputStream(),true);
				
				//클라이언트에서 입력되어 전달된 대화명을 반환받아 저장
				// => 대화명을 입력받기 전까지 스레드 일시 중지
				aliasName=in.readLine();
				
				//현재 접속된 모든 클라이언트에게 입장메세지 전달
				sendMessage("["+aliasName+"]님이 입장 하였습니다.");
				
				//클라이언트에서 보내온 메세지를 반환받아 현재 접속된 모든 
				//클라이언트에게 전달 - 클라이언트의 접속 종료 전까지 반복
				// => 클라이언트가 메세지를 보내기 전까지 스레드 일시 중지
				// => 클라이언트가 접속을 종료한 경우 IOException 발생 
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch (IOException e) {
				//클라이언트가 접속을 종료한 경우 실행될 명령 작성
				// => 콜렉션 필드에서 현재 소켓 스레드를 제거
				// => 모든 접속 클라이언트에게 퇴장메세지를 전달
				clientList.remove(this);
				sendMessage("["+aliasName+"]님이 퇴장 하였습니다.");
				
				System.out.println("[해제로그]"+socket.getInetAddress()
					.getHostAddress()+"의 컴퓨터에서 접속을 해제 하였습니다.");
			}
		}
	}
}







