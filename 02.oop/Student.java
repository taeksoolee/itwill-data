package oop;

//�л�����(�й�, �̸�, ����, ����, ����)�� �����ϱ� ���� Ŭ����
public class Student {
	//�ν��Ͻ� �ʵ� - �ν��Ͻ��� �����Ǵ� �ʵ�
	private String num;
	private String name;
	private int kor,eng,tot;
	//�����ʵ�� Ŭ������ �޸𸮿� �ε��� �� ���� 
	// => �ν��Ͻ��� ������� �̸� �ϳ��� ������ �� ��� �ν��Ͻ� ���
	// => �⺻�� ������ �̿��Ͽ� �ʵ� �ʱⰪ ����
	private static int total;
	
	//������
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		//���� ��� >> �޼ҵ� ȣ��
		//tot=kor+eng;
		calcTot();
	}

	//Getter & Setter �޼ҵ�
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
	//�����޼ҵ� : this �Ű������� �������� �ʴ� �޼ҵ�
	// => �ν��Ͻ� �ʵ� ���� �Ұ��� >> �ν��Ͻ� �޼ҵ� ȣ�� �Ұ���
	// => �����ʵ� ���� ����
	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		//�����ʵ�� Ŭ������ �̿��Ͽ� �����Ͽ� ���
		Student.total = total;
	}

	//Business �޼ҵ�
	private void calcTot() {//������ ����ϴ� �޼ҵ� >> ����ȭ
		tot=kor+eng;
	}
	
	public void display() {
		System.out.println(name+"���� ���� >> ");
		System.out.println("���� = "+kor+", ���� = "+eng+", ���� = "+tot);
	}
	
}








