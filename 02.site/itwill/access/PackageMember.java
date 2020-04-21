package site.itwill.access;

//package : 접근지정자 관련 키워드를 사용하지 않을 경우 - 클래스, 필드, 생성자, 메소드
// => 같은 패키지의 클래스에서 접근 가능
// => 다른 패키지의 클래스에서 접근 불가능
public class PackageMember {
	int num;
	
	void display() {
		System.out.println("num = "+num);
	}
}
