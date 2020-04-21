package site.itwill.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일에 저장된 값을 원시데이타로 읽어 모니터에 전달하여 출력하는 프로그램
public class FileByteLoadApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]c:\\data\\byte.txt 파일에 저장된 내용입니다.");
		
		//FileInputStream 클래스 : 파일 입력스트림을 생성하기 위한 클래스
		//FileInputStream(String fileName) : 파일경로를 전달받아 입력스트림을 만들어 주는 생성자
		// => 파일경로에 파일이 존재하지 않을 경우 FileNotFoundException 발생 - 예외처리
		FileInputStream in=null;
		try {
			in=new FileInputStream("c:/data/byte.txt");

			int readByte;
			
			while(true) {
				readByte=in.read();//파일에 저장된 값을 읽어 변수에 저장 - 읽기
				if(readByte==-1) break;
				System.out.write(readByte);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일에 존재하지 않습니다.");
		} finally {
			//if 구문을 이용하여 NullPointerException 발생 방지
			//FileInputStream.close() : 파일 입력스트림을 제거하는 메소드
			if(in!=null) in.close();
		}
	}
}





