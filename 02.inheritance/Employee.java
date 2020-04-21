package inheritance;

//사원정보(사원번호, 사원이름)를 저장하기 위한 클래스
// => 인스턴스 생성이 목적이 아닌 상속을 목적으로 작성된 클래스
// => 상속을 목적으로 작성된 클래스는 추상클래스로 선언하는 것을 권장
public abstract class Employee {
	private int empNo;
	private String empName;
	
	//상수필드(Constant Field) : 값 대신 사용하기 위한 필드 - 필드값 변경 불가
	// => 값 대신 의미있는 단어를 이용하여 표현하기 위해 사용
	// => 대문자로만 표현하며 단어와 단어의 구분은 _ 이용
	public static final double INCENTIVE_RATE=1.5;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	//급여를 계산하여 반환하는 메소드 - 메소드 작성규칙 제공(작업지시서)
	// => 자식클래스에서 반드시 메소드를 오버라이드 선언하도록 추상메소드로 선언
	// => 추상메소드가 하나라도 선언된 클래스는 반드시 추상클래스로 선언
	public abstract int computePay();
	
	//인센티브를 계산하여 반환하는 메소드
	// => 모든 사원들에게 급여의 150%로 계산하여 인센티브 지급
	//자식클래스에서 오버라이드 선언할 경우 반환되는 인센티브 변경 가능
	// => 자식클래스에서 오버라이드 선언하지 못하도록 final 메소드로 작성
	public final int computeIncentive() {
		//추상메소드를 호출하면 묵시적 객체 형변환에 의해 자식 인스턴스의 메소드 호출
		// => 부모클래스의 메소드에서 자식클래스의 메소드 호출
		//int incentive=(int)(computePay()*1.5);
		int incentive=(int)(computePay()*INCENTIVE_RATE);
		return incentive;
	}
}
