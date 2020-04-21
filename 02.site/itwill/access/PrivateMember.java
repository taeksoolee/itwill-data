package site.itwill.access;

//private : 클래스 내부에서만 접근 가능(은닉화) - 필드, 생성자, 메소드
// => 클래스 외부에서 접근 불가능
public class PrivateMember {
	private int num;
	
	@SuppressWarnings("unused")
	private void display() {
		System.out.println("num = "+num);
	}
}
