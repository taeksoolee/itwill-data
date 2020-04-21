package site.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//회원정보를 파일에 저장하는 프로그램
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream
				(new FileOutputStream("c:/data/member.txt"));
		
		//writeObject() 메소드에서는 NotSerializableException 발생 가능
		//NotSerializableException : 객체직렬화 선언되지 않은 클래스의 
		//인스턴스를 출력스트림으로 전달할 때 발생되는 예외
		out.writeObject(new Member("aaa", "홍길동", "서울시 강남구"));
		out.writeObject(new Member("bbb", "임꺽정", "부천시 원미구"));
		out.writeObject(new Member("ccc", "전우치", "수원시 팔달구"));
		
		out.close();
		
		System.out.println("[메세지]파일에 회원정보를 성공적으로 저장 하였습니다.");
	}
}









