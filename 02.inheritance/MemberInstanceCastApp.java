package inheritance;

//참조변수와 인스턴스와의 관계
public class MemberInstanceCastApp {
	public static void main(String[] args) {
		//부모클래스 참조변수=new 부모클래스();
		// => 부모 인스턴스를 생성하여 부모 인스턴스를 참조변수에 저장
		Member member1=new Member();
		
		//참조변수를 이용하여 부모 인스턴스 메소드 접근 가능
		member1.setId("aaa");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("============================================");
		//자식클래스 참조변수=new 자식클래스();
		// => 부모 인스턴스와 자식 인스턴스를 생성하여 자식 인스턴스를 참조변수에 저장
		MemberEvent member2=new MemberEvent();
		
		//참조변수를 이용하여 자식 인스턴스 메소드 접근 가능
		// => 자식 인스턴스에 메소드가 없는 경우 상속을 이용하여 부모 인스턴스 메소드 접근 가능
		member2.setId("bbb");
		member2.setName("임꺽정");
		member2.setEmail("bbb@itwill.site");
		
		member2.display();
		System.out.println("============================================");
		//자식클래스 참조변수=new 부모클래스();
		// => 에러 발생 : 부모 인스턴스를 생성하여 자식 참조변수에 저장 불가능
		// => 자식 인스턴스가 없으므로 자식 참조변수에 저장할 경우 에러 발생
		//MemberEvent member3=new Member();
		System.out.println("============================================");
		//부모클래스 참조변수=new 자식클래스();
		// => 부모 인스턴스와 자식 인스턴스를 생성하여 부모 인스턴스를 참조변수에 저장
		Member member4=new MemberEvent();
		
		//참조변수를 이용하여 부모 인스턴스 메소드 접근 가능
		// => 자식 인스턴스 메소드 접근 불가능
		member4.setId("ccc");
		member4.setName("전우치");
		
		//객체 형변환을 이용하면 참조변수를 이용하여 자식 인스턴스 메소드 접근 가능
		//명시적 객체 형변환(강제 형변환) : 참조변수의 자료형을 자식클래스로
		//일시적으로 변경하여 자식 인스턴스가 저장되도록 설정 - Cast 연산자 이용
		/*
		MemberEvent temp=(MemberEvent)member4;
		temp.setEmail("ccc@itwill.site");
		*/
		((MemberEvent)member4).setEmail("ccc@itwill.site");
		
		//묵시적 객체 형변환(자동 형변환) : 자식클래스에서 오버라이드 선언된
		//메소드는 부모클래스의 메소드 대신 자식클래스의 메소드가 호출되도록
		//자동으로 참조변수에 저장된 인스턴스가 일시적 자식 인스턴스로 변환
		member4.display();
		System.out.println("============================================");
	}
}









