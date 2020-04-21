package enumerate;

public enum StringEnum {
	//생성자를 선언한 경우 상수필드 선언시 초기값을 전달해야만 상수필드 생성
	INSERT("Insert"), UPDATE("Update"), DELETE("Delete"), SELECT("Select");
	
	//상수필드의 자료형을 설정하기 위한 필드 선언
	// => private final 필드 선언
	// => 상수필드에 원하는 값을 저장하기 위해 생성자를 반드시 선언
	private final String value;
	
	//상수필드에 초기값을 전달하여 저장하기 위한 생성자 선언
	// => 생성자는 private 접근지정자로 은닉화 선언
	// => 매개변수에 값을 전달받아 상수필드에 초기값 저장
	private StringEnum(String value) {
		this.value=value;
	}

	//상수필드값을 확인하기 위한 Getter 메소드 선언
	public String getValue() {
		return value;
	}
}






