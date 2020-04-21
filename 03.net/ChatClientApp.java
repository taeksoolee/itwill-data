package site.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//채팅 클라이언트 프로그램
// => 서버에서 보내온 메세지를 반환받아 컴퍼넌트에 출력 - 반복처리
// => 컴퍼넌트로 메세지를 입력하여 서버에 전달 - 이벤트 핸들러
public class ChatClientApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField field;//입력 컴퍼넌트
	private JTextArea area;//출력 컴퍼넌트
	
	//서버 접속 소켓정보를 저장하기 위한 필드
	private Socket socket;
	
	//서버에서 보내온 메세지를 받기 위한 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	//서버에 메세지를 보내기 위한 출력스트림을 저장하기 위한 필드
	private PrintWriter out;
	
	private String aliesName;//대화명 저장 필드
	
	public ChatClientApp(String title) {
		super(title);
		
		field=new JTextField();
		area=new JTextArea();
		
		JScrollPane pane=new JScrollPane(area);
		
		getContentPane().add(pane, BorderLayout.CENTER);
		getContentPane().add(field, BorderLayout.SOUTH);
		
		field.setFont(new Font("굴림", Font.BOLD, 20));
		area.setFont(new Font("굴림", Font.BOLD, 20));
		area.setFocusable(false);
		
		//입력 컴퍼넌트에서 이벤트가 발생된 경우 처리할 이벤트 핸들러 등록
		field.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400, 50, 400, 500);
		setVisible(true);
		
		try {
			socket=new Socket("192.168.14.31", 6000);//서버 접속
			
			//소켓의 입력스트림을 제공받아 문자열을 읽기 위한 스트림으로 확장
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

			//소켓의 출력스트림을 제공받아 문자열을 전달하기 위한 스트림으로 확장
			out=new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버에 접속할 수 없습니다."
					, "접속오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//대화명을 입력받아 저장
		while(true) {
			//입력 다이얼로그를 출력하여 대화명을 입력받아 저장
			aliesName=JOptionPane.showInputDialog(this, "대화명을 입력해 주세요."
				,"대화명 입력",JOptionPane.QUESTION_MESSAGE);
			if(aliesName!=null && !aliesName.equals("")) break;
			JOptionPane.showMessageDialog(this, "대화명을 반드시 입력해 주세요."
				, "입력오류", JOptionPane.ERROR_MESSAGE);
		}
		
		//입력된 대화명을 서버에 전달
		out.println(aliesName);
		
		//서버에서 보내온 메세지를 전달받아 컴퍼넌트에 출력 - 무한루프
		while(true) {
			try {
				area.append(in.readLine()+"\n");
				
				//JTextArea.setCaretPosition(int position) : JTextArea 
				//컴퍼넌트의 위치를 변경하는 메소드 
				area.setCaretPosition(area.getText().length());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "서버와의 연결이 끊어졌습니다."
					, "접속오류", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("채팅 프로그램");
	}

	//이벤트 핸들러 메소드 - 컴퍼넌트에서 입력된 메세지를 서버에 전달
	@Override
	public void actionPerformed(ActionEvent e) {
		//입력 컴퍼넌트의 문자열을 반환받아 저장
		String message=field.getText();
		
		if(!message.equals("")) {//메세지가 존재할 경우
			out.println(message);//서버에 메세지 전달
			field.setText("");//입력 컴퍼넌트 초기화
		}
	}
}






