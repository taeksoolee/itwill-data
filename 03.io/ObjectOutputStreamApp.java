package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

//ObjectOutputStream 클래스 : 출력스트림을 전달받아 데이타 타입형태의 
//출력스트림을 생성하기 위한 클래스 
// => 객체(인스턴스)을 출력스트림으로 전달하기 위한 기능 제공 
public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream
				(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object o) : 객체(인스턴스)를 출력스트림을 전달하는 메소드
		//out.writeObject(new String("홍길동"));
		out.writeObject("홍길동");
		out.writeObject(new Date());
		out.writeObject(Arrays.asList("임꺽정","전우치","일지매","장길산"));
		
		out.close();
		
		System.out.println("c:\\data\\object.txt 파일에 객체들을 저장 하였습니다.");
	}
}










