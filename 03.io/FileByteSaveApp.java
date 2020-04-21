package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드 입력값을 원시데이타로 읽어 파일에 전달하여 저장하는 프로그램
public class FileByteSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[종료:Ctrl+Z]");

		//FileOutputStream 클래스 : 파일 출력스트림을 생성하기 위한 클래스
		// => FileOutputStream(String fileName) : 파일경로를 전달받아 출력스트림을 만들어 주는 생성자
		// => 파일경로에 파일이 존재하지 않을 경우 FileNotFoundException 발생 - 예외처리
		// => FileNotFoundException 클래스는 IOException 클래스의 자식클래스
		// => 파일이 존재하지 않을 경우 파일을 자동으로 만들어 스트림 생성
		// => 파일이 존재 할 경우 기존 내용에 대신 새로운 내용으로 파일에 저장 - 덮어씌우기(OverWrite) 발생
		//FileOutputStream out=new FileOutputStream("c:/data/byte.txt");
		
		//FileOutputStream(String name, boolean append) : 매개변수에 true 값을
		//전달할 경우 기존 내용 뒤에 새로운 내용을 추가하여 파일에 저장 - 이어쓰기
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=System.in.read();
			if(readByte==-1) break;
			out.write(readByte);//파일 출력스트림에 값 전달 - 저장
		}
		
		//파일에는 입력스트림과 출력스트림을 하나씩만 생성 가능
		// => 파일에 생성된 스트림은 반드시 제거
		//FileOutputStream.close() : 파일 출력스트림 제거하는 메소드
		out.close();
		
		System.out.println("[메세지]c:\\data\\byte.txt 파일에 키보드 입력값이 저장 되었습니다.");
	}
}







