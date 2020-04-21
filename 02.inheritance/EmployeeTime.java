package inheritance;

//�ð��� �������(�����ȣ, ����̸�, �ñ�, �ٹ��ð�)�� �����ϱ� ���� Ŭ����
// => Employee Ŭ������ ��ӹ޾� �ۼ�
public class EmployeeTime extends Employee {
	private int moneyPerHour;
	private int workedHour;
	
	public EmployeeTime() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeTime(int empNo, String empName, int moneyPerHour, int workedHour) {
		super(empNo, empName);
		this.moneyPerHour = moneyPerHour;
		this.workedHour = workedHour;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}

	public int getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}
	
	/*
	//�޿��� ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public int calcPay() {
		return moneyPerHour*workedHour;
	}
	*/
	
	@Override
	public int computePay() {
		return moneyPerHour*workedHour;
	}
}






