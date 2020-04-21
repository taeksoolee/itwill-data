package site.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드 입력값을 인코딩데이타로 읽어 파일에 전달하여 저장하는 프로그램
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");

		//키보드 입력스트림을 확장된 입력스트림으로 생성
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter 클래스 : 파일에 출력스트림을 생성하는 클래스
		// => FileWriter(String fileName) : 파일경로를 전달받아 출력스트림을 만들어 주는 생성자
		// => 파일경로에 파일이 존재하지 않을 경우 IOException 발생 - 예외처리
		// => 파일이 존재하지 않을 경우 파일을 자동으로 만들어 스트림 생성
		// => 파일이 존재 할 경우 기존 내용에 대신 새로운 내용으로 파일에 저장 - 덮어씌우기(OverWrite) 발생		
		//FileWriter out=new FileWriter("c:/data/char.txt");
		
		//FileWriter(String name, boolean append) : 매개변수에 true 값을
		//전달할 경우 기존 내용 뒤에 새로운 내용을 추가하여 파일에 저장 - 이어쓰기
		FileWriter out=new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);
			out.flush();
		}
		
		//FileWriter.close() : 파일 출력스트림을 제거하는 메소드
		out.close();
		
		System.out.println("[메세지]c:\\data\\char.txt 파일에 키보드 입력값이 저장 되었습니다.");
	}
}
