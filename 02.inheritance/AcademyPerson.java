package inheritance;

//학원사람정보(번호, 이름)를 저장하기 위한 클래스
// => 학원 인적자원의 공통적인 속성과 기능을 정의하기 위한 클래스
// => 코드의 중복성을 최소화 하여 프로그램의 생산성 및 유지보수의 효율성 증가
// => 학원 인적자원 관련 클래스가 반드시 상속 받아야 되는 클래스
public class AcademyPerson {
	private int number;
	private String name;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("번호 = "+number);
		System.out.println("이름 = "+name);
	}
}






