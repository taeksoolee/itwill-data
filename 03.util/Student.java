package site.itwill.util;

//�ν��Ͻ��� �ʵ尪�� ���ϱ� ���ؼ��� Comparable<T> �������̽� ��ӹ޾� �ۼ�
// => Comparable<T> �������̽��� compareTo(T o) �޼ҵ带 �������̵� ����

//�л�����(�й�, �̸�)�� �����ϱ� ���� Ŭ���� - VO(Value Object) Ŭ����
public class Student implements Comparable<Student> {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[�й� = "+num+", �̸� = "+name+"]";
	}

	//this�� �ʵ尪�� �Ű������� �ʵ尪�� ����(-) �����Ͽ� �����(���, 0, ����)�� ��ȯ
	// => Collections.sort() �޼ҵ忡 ���� �ڵ� ȣ��Ǿ� ��ȯ������ ����
	// => ��ȯ���� ����� ��� List �ν��Ͻ��� ������Ʈ�� ���� ġȯ 
	@Override
	public int compareTo(Student o) {
		//return this.num-o.num;//�й�(��������)
		//return -(this.num-o.num);//�й�(��������)
		
		//return name.compareTo(o.name);//�̸�(��������)
		return -name.compareTo(o.name);//�̸�(��������)
	}
	
	
}	







