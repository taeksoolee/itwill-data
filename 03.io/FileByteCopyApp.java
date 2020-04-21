package site.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일에 저장된 값을 원시데이타로 읽어 타겟파일에 전달하여 저장하는 프로그램
// => 모든 파일에 복사 기능 제공
public class FileByteCopyApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStream 클래스 : 입력스트림을 전달받아 대용량 입력스트림으로 생성하는 클래스
		BufferedInputStream in=null;
		//BufferedOutputStream 클래스 : 출력스트림을 전달받아 대용량 출력스트림으로 생성하는 클래스
		BufferedOutputStream out=null;
		try {
			//in=new BufferedInputStream(new FileInputStream("c:/data/setup.log"));
			in=new BufferedInputStream(new FileInputStream("c:/data/setup.exe"));
			
			//out=new BufferedOutputStream(new FileOutputStream("c:/data/setup_byte.log"));
			out=new BufferedOutputStream(new FileOutputStream("c:/data/setup_byte.exe"));
			
			int readByte;
			
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일이 존재하지 않습니다.");
		} finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
	}
}
