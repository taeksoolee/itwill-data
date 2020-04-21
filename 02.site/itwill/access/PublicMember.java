package site.itwill.access;

//public : 모든 영역에서 접근 가능 - 클래스, 필드, 생성자, 메소드
// => 같은 패키지의 클래스에서 접근 가능
// => 다른 패키지의 클래스에서 접근 가능

//public 접근지정자를 클래스에 사용할 경우 다른 패키지에서 접근 가능한 클래스 선언
// => 소스파일에는 public 키워드가 붙은 클래스를 하나만 선언 가능
public class PublicMember {
	public int num;
	
	public void display() {
		System.out.println("num = "+num);
	}
}


