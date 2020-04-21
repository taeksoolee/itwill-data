package site.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataOutputStream 클래스 : 출력스트림을 전달받아 데이타 타입형태의 
//출력스트림을 생성하기 위한 클래스
// => 원하는 형태의 값을 출력스트림으로 전달하기 위한 기능 제공 
public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		DataOutputStream out=new DataOutputStream
				(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int value) : 정수값을 출력스트림으로 전달하는 메소드
		out.writeInt(100);
		
		//DataOutputStream.writeBoolean(boolean value) : 논리값을 출력스트림으로 전달하는 메소드
		out.writeBoolean(true);
		
		//DataOutputStream.writeUTF(String value) : 문자열을 출력스트림으로 전달하는 메소드
		out.writeUTF("홍길동");
		
		out.close();
		
		System.out.println("c:\\data\\data.txt 파일에 다양한 형태의 값들을 저장 하였습니다.");
	}
}






