package site.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//파일에 저장된 값을 인코딩데이타로 읽어 모니터에 전달하여 출력하는 프로그램
public class FileCharLoadApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]c:\\data\\char.txt 파일에 저장된 내용입니다.");
		
		//FileReader 클래스 : 파일 입력스트림을 생성하기 위한 클래스
		//FileReader(String fileName) : 파일경로를 전달받아 입력스트림을 만들어 주는 생성자
		// => 파일경로에 파일이 존재하지 않을 경우 FileNotFoundException 발생 - 예외처리
		FileReader in=null;
		try {
			in=new FileReader("c:/data/char.txt");
			
			//OutputStreamWriter out=new OutputStreamWriter(System.out);
			PrintWriter out=new PrintWriter(System.out);
			
			int readByte;
			
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일에 존재하지 않습니다.");
		} finally {
			//FileReader.close() : 파일 입력스트림을 제거하는 메소드
			if(in!=null) in.close();
		}
	}
}
