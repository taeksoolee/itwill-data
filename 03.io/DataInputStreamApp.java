package site.itwill.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//DataInputStream 클래스 : 입력스트림을 전달받아 데이타 타입형태의 
//입력스트림을 생성하기 위한 클래스
// => 입력스트림으로 전달된 값을 원하는 형태의 값으로 읽기 위한 기능 제공
public class DataInputStreamApp {
	public static void main(String[] args) throws IOException {
		DataInputStream in=new DataInputStream
				(new FileInputStream("c:/data/data.txt"));

		//값이 파일에 저장된 순서대로 반드시 읽어 반환받아 사용
		//DataInputStream.readInt() : 입력스트림의 값을 정수값으로 읽어 반환하는 메소드
		int value1=in.readInt();
		
		//DataInputStream.readBoolean() : 입력스트림의 값을 논리값으로 읽어 반환하는 메소드
		boolean value2=in.readBoolean();
		
		//DataInputStream.readUTF() : 입력스트림의 값을 문자열로 읽어 반환하는 메소드
		String value3=in.readUTF();
		
		System.out.println("정수값 = "+value1);
		System.out.println("논리값 = "+value2);
		System.out.println("문자열 = "+value3);
		
		in.close();
	}
}











