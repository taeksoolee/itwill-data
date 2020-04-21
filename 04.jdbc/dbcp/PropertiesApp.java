package site.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties 파일(.properties) : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일
// => 프로그램을 변경하지 않고 Properties 파일을 변경하여 프로그램 실행 결과 변경 가능
// => 유지보수의 효율성 증가
// => Properties 파일에 의해 제공되는 값은 문자열(String)만 가능

//user.properties 파일을 읽어 저장값을 출력하는 프로그램
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//1.Properties 파일을 읽기 위한 입력스트림 생성
		
		//FileInputStream 클래스를 이용하여 입력스트림 생성
		// => FileInputStream 클래스를 이용할 경우 파일 경로에 대한 문제 발생
		//InputStream in=new FileInputStream("bin/site/itwill/dbcp/user.properties");
		
		//리플렉션 기능을 이용하여 입력스트림 생성
		// => 클래스.class - 클래스를 메모리에 저장(Clazz : Class 인스턴스)하여 사용하기 위한 방법
		//Class.getClassLoader() : ClassLoader 인스턴스를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String resource) : 리소스 파일을
		//읽기 위한 입력스트림을 생성하여 반환하는 메소드
		InputStream in=PropertiesApp.class.getClassLoader()
				.getResourceAsStream("site/itwill/dbcp/user.properties");
		
		//2.Properties 인스턴스 생성 - Properties 클래스는 Map 인터페이스를 상속받는 콜렉션 클래스
		Properties properties=new Properties();
		
		//3.Properties 파일의 정보를 읽어 Properties 인스턴스에 저장
		//Properties.load(InputStream in) : Properties 파일을 읽어 Properties 인스턴스에 저장하는 메소드 
		properties.load(in);
		
		//4.Properties 인스턴스에서 키(Key:String)를 이용하여 값(Value:String)을 반환받아 저장
		//Properties.get(String key) : 키에 대한 값을 반환하는 메소드
		// => 값을 Object 타입으로 반환하므로 객체 형변환하여 저장
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("user.properties 파일에 저장된 정보 >>");
		System.out.println("아이디 = "+id);
		System.out.println("비밀번호 = "+password);
		System.out.println("이름 = "+name);
	}
}










