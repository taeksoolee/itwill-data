package inheritance;

//������ �������(�����ȣ, ����̸�, ����)�� �����ϱ� ���� Ŭ����
// => Employee Ŭ������ ��ӹ޾� �ۼ�
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
	//�޿��� ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public int computeSalary() {
		return annualSalary/12;
	}
	*/
	
	//�޿��� ����Ͽ� ��ȯ�ϴ� �޼ҵ�� �θ�Ŭ������ �߻�޼ҵ带 �������̵� �����Ͽ� �ۼ�
	@Override
	public int computePay() {
		return annualSalary/12;
	}
	
}









