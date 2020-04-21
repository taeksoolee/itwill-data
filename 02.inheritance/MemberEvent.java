package inheritance;

//이벤트 관련 회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하는 클래스(Member)를 상속받아 작성
//extends 키워드를 이용하여 기존 클래스(부모클래스) 상속
// => 상속을 이용하여 자식클래스는 부모클래스의 필드 또는 메소드 접근 가능 - 상속성
// => Java는 단일 상속만 가능 - 다중 상속 불가능
public class MemberEvent extends Member {
	/*
	//Member 클래스를 상속받아 사용하므로 생략 
	private String id;
	private String name;
	*/
	private String email;
	
	//super : 자식클래스의 메소드에 부모 인스턴스를 전달받아 저장하기 위한 참조변수(키워드)
	public MemberEvent() {
		//자식클래스의 생성자에서 부모클래스의 생성자를 호출하기 위해 super 사용
		// => 부모클래스의 기본생성자 호출하는 경우 생략 가능
		//super();
	}

	/*
	public MemberEvent(String id, String name, String email) {
		//super();
		//메서드에서 필드(메소드)에 접근 할 경우 자식클래스에서 검색하여
		//접근하고 없는 경우에는 부모클래스에서 검색하여 접근
		// => 부모클래스의 필드(메소드)가 private 접근지정자로 선언된 경우 접근 불가능
		//this.id=id;
		setId(id);
		setName(name);
		this.email = email;
	}
	*/
	
	//[Alt]+[Shift]+[S] >> [O] >> 부모 생성자 선택 >> 필드 선택 >> Generate
	public MemberEvent(String id, String name, String email) {
		//super 키워드를 이용하여 부모클래스의 생성자 호출
		// => 부모 인스턴스 필드에 원하는 값을 전달하여 초기화 설정
		// => 생성자 호출전에 다른 명령이 선언되는 경우 에러 발생
		super(id, name);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	public void display() {
		System.out.println("아이디 = "+getId());
		System.out.println("이름 = "+getName());
		System.out.println("이메일 = "+email);
	}
	*/
	
	//메소드 오버라이드(Override) : 부모클래스의 메소드를 재선언하는 기능
	// => 부모클래스의 메소드 머릿부를 동일하게 선언하여 작성
	// => 부모클래스의 메소드는 숨겨지고 자식클래스의 메소드만 호출 가능
	//부모클래스의 메소드명 >> [Ctrl]+[Space] >> Override 메소드 선택 >> 엔터(클릭)
	//@Override : 오버라이드 선언 메소드를 표현하기 위한 어노테이션(Annotation)
	// => 오버라이드 선언 규칙을 지키지 않을 경우 에러 발생
	@Override
	public void display() {
		//부모클래스의 숨겨진 메소드를 직접 호출
		super.display();
		System.out.println("이메일 = "+email);
	}
}





