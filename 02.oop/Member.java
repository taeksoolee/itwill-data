package oop;

//this : �޼ҵ忡 ������ �ִ� �Ű����� - ��������
// => �޼ҵ带 ȣ���� �ν��Ͻ� ������ �ڵ����� ���޹޾� ����
// => �޼ҵ忡�� �ν��Ͻ��� �ʵ带 ��Ȯ�� �����ϱ� ���� ���
// => this�� ǥ������ �ʾƵ� �⺻������ this�� ���Ǿ� ǥ��

//this Ű���带 ����ϴ� ���
//1.�޼ҵ��� ��������(�Ű�����)�� �ʵ��� �̸��� ���� ��� this�� ����Ͽ� �ʵ� ǥ��
// => this�� ������� ������ �⺻������ ���������� ó��
//2.�����ڿ��� �ٸ� �����ڸ� ȣ���Ͽ� �ʱ�ȭ �۾��� �ϰ��� �� ��� this ���
// => ������ ȣ�� ��� ���� �ٸ� ����� ������ ��� ���� �߻�
//3.�޼ҵ忡�� ȣ���� �ν��Ͻ��� ǥ���ϱ� ���� ��� => �̺�Ʈ ó��, ���� ������ ��

//ȸ������(���̵�, �̸�, �̸���)�� �����ϱ� ���� Ŭ���� - VO(Value Object) Ŭ���� 
public class Member {
	//�ʵ� ���� - �ν��Ͻ� ������ �ʵ忡 ����� �⺻�� ���� ����
	private String id="NoId";//���̵�
	private String name="NoName";//�̸�
	private String email="NoEmail";//�̸���
	
	//������(Constructor)�� �������� ���� ��� ���������� �⺻ �����ڰ� ����
	
	//������ �̸��� Ŭ������� �����ϰ� �����ϸ� ��ȯ�� �̼���
	// => �޼ҵ� �����ε� ��ɿ� ���� ���� ���� ������ ���� ����
	
	//�Ű������� ���� ������ ���� - �⺻ ������(Default Constructor) 
	// => �ʱ�ȭ �۾� �̱���
	// => �������� ���� ��� Ŭ������ ��Ӽ��� ������ �߻��ϹǷ� �ݵ�� ����
	//�⺻ ������ �ڵ� �ϼ� : [Ctrl]+[Space] >> Constructor ���� >> ����(Ŭ��)
	public Member() {
		//this Ű���带 �̿��� �ٸ� ������ ȣ�� 
		//this("NoId", "NoName", "NoEmail");
	}
	
	//�Ű������� ����� ������ ����
	// => �ν��Ͻ� ������ �ʵ忡 ���ϴ� �� ���� - �ʱ�ȭ �۾�
	// => �Ű������� ���޵Ǿ� ����� ���� �̿��Ͽ� �ʵ忡 �ʱⰪ ����
	//������ �ڵ� �ϼ� : [Alt]+[Shift]+[S] >> [O] >> �ʵ� ���� >> Generator
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
	
	//�޼ҵ� ����
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
	
	//�ʵ尪�� ����ϴ� �޼ҵ� >> �ʵ尪 Ȯ��
	public void display() {
		//System.out.println("���̵� = "+this.id);
		System.out.println("���̵� = "+id);
		System.out.println("�̸� = "+name);
		System.out.println("�̸��� = "+email);
	}
}




