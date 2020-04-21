package site.itwill.access;

//protected : 다른 패키지의 클래스는 상속을 이용하여 접근 - 필드, 생성자, 메소드
// => 같은 패키지의 클래스에서 접근 가능
// => 다른 패키지의 클래스에서 접근 불가능
public class ProtectedMember {
	protected int num;
	
	protected void display() {
		System.out.println("num = "+num);
	}
}
