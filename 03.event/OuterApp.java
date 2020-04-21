package site.itwill.event;

import site.itwill.event.Outer.Inner;
import site.itwill.event.Outer.Nested;

public class OuterApp {
	public static void main(String[] args) {
		//내부클래스를 이용하여 인스턴스 생성 불가능
		//Inner inner=new Inner(100);
		
		Outer outer=new Outer(100);
		outer.outerDisplay();
		System.out.println("============================================");
		//외부클래스의 인스턴스를 이용하여 내부클래스로 인스턴스 생성 가능
		Inner inner=outer.new Inner(200);
		inner.innerDisplay();
		System.out.println("============================================");
		//정적클래스를 이용하여 인스턴스 생성 가능
		Nested nested=new Nested(300);
		nested.nestedDisplay();
		System.out.println("============================================");
	}
}







