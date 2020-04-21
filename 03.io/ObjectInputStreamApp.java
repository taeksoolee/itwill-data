package site.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

//ObjectInputStream 클래스 : 입력스트림을 전달받아 데이타 타입형태의 
//입력스트림을 생성하기 위한 클래스
// => 입력스트림으로 전달된 값을 객체(인스턴스)로 읽기 위한 기능 제공
public class ObjectInputStreamApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream
				(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : 입력스트림에서 객체(인스턴스)를 읽어 반환하는 메소드
		// => Object 타입으로 객체(인스턴스)가 반환되므로 명시적 객체 형변환 사용
		// => 반환되는 객체(인스턴스)에 대한 클래스가 없을 경우 ClassNotFoundException 발생 - 예외처리
		String string=(String)in.readObject(); 
		Date date=(Date)in.readObject(); 
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)in.readObject();
		
		System.out.println("string = "+string);
		System.out.println("date = "+date);
		System.out.println("list = "+list);
		
		in.close();
	}
}