package inheritance;

//����� �������(�����ȣ, ����̸�, ���޿�)�� �����ϱ� ���� Ŭ����
// => Employee Ŭ������ ��ӹ޾� �ۼ�
public class EmployeeContract extends Employee {
	private int contractPay;
	
	public EmployeeContract() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeContract(int empNo, String empName, int contractPay) {
		super(empNo, empName);
		this.contractPay = contractPay;
	}

	public int getContractPay() {
		return contractPay;
	}

	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}

	@Override
	public int computePay() {
		return contractPay;
	}
	
	/*
	//final �޼ҵ带 �������̵� ������ ��� ���� �߻�
	@Override
	public int computeIncentive() {
		return 100000000;
	}
	*/
}




