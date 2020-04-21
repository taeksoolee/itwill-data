package oop;

//this : 메소드에 숨겨져 있는 매개변수 - 참조변수
// => 메소드를 호출한 인스턴스 정보를 자동으로 전달받아 저장
// => 메소드에서 인스턴스의 필드를 명확히 구분하기 위해 사용
// => this를 표현하지 않아도 기본적으로 this가 사용되어 표현

//this 키워드를 사용하는 경우
//1.메소드의 지역변수(매개변수)와 필드의 이름의 같은 경우 this를 사용하여 필드 표현
// => this를 사용하지 않으면 기본적으로 지역변수로 처리
//2.생성자에서 다른 생성자를 호출하여 초기화 작업을 하고자 할 경우 this 사용
// => 생성자 호출 명령 전에 다른 명령을 선언할 경우 에러 발생
//3.메소드에서 호출한 인스턴스를 표현하기 위해 사용 => 이벤트 처리, 다중 스레드 등

//회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스 - VO(Value Object) 클래스 
public class Member {
	//필드 선언 - 인스턴스 생성시 필드에 저장될 기본값 변경 가능
	private String id="NoId";//아이디
	private String name="NoName";//이름
	private String email="NoEmail";//이메일
	
	//생성자(Constructor)를 선언하지 않을 경우 내부적으로 기본 생성자가 제공
	
	//생성자 이름은 클래스명과 동일하게 선언하며 반환형 미선언
	// => 메소드 오버로드 기능에 의해 여러 개의 생성자 선언 가능
	
	//매개변수가 없는 생성자 선언 - 기본 생성자(Default Constructor) 
	// => 초기화 작업 미구현
	// => 선언하지 않을 경우 클래스의 상속성에 문제가 발생하므로 반드시 선언
	//기본 생성자 자동 완성 : [Ctrl]+[Space] >> Constructor 선택 >> 엔터(클릭)
	public Member() {
		//this 키워드를 이용해 다른 생성자 호출 
		//this("NoId", "NoName", "NoEmail");
	}
	
	//매개변수가 선언된 생성자 선언
	// => 인스턴스 생성시 필드에 원하는 값 저장 - 초기화 작업
	// => 매개변수에 전달되어 저장된 값을 이용하여 필드에 초기값 설정
	//생성자 자동 완성 : [Alt]+[Shift]+[S] >> [O] >> 필드 선택 >> Generator
	public Member(String id) {
		this.id = id;
		//this(id, "NoName", "NoEmail");
	}	

	public Member(String id, String name) {
		this.id=id;
		this.name=name;
		//this(id, name, "NoEmail");

	}

	public Member(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	//메소드 선언
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//필드값을 출력하는 메소드 >> 필드값 확인
	public void display() {
		//System.out.println("아이디 = "+this.id);
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
		System.out.println("이메일 = "+email);
	}
}




