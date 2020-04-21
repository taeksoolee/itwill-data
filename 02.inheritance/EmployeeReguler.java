package inheritance;

//정규직 사원정보(사원번호, 사원이름, 연봉)를 저장하기 위한 클래스
// => Employee 클래스를 상속받아 작성
public class EmployeeReguler extends Employee {
	private int annualSalary;
	
	public EmployeeReguler() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeReguler(int empNo, String empName, int annualSalary) {
		super(empNo, empName);
		this.annualSalary = annualSalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	/*
	//급여를 계산하여 반환하는 메소드
	public int computeSalary() {
		return annualSalary/12;
	}
	*/
	
	//급여를 계산하여 반환하는 메소드는 부모클래스의 추상메소드를 오버라이드 선언하여 작성
	@Override
	public int computePay() {
		return annualSalary/12;
	}
	
}









