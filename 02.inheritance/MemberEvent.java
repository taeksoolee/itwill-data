package inheritance;

//�̺�Ʈ ���� ȸ������(���̵�, �̸�, �̸���)�� �����ϱ� ���� Ŭ����
// => ȸ�������� �����ϴ� Ŭ����(Member)�� ��ӹ޾� �ۼ�
//extends Ű���带 �̿��Ͽ� ���� Ŭ����(�θ�Ŭ����) ���
// => ����� �̿��Ͽ� �ڽ�Ŭ������ �θ�Ŭ������ �ʵ� �Ǵ� �޼ҵ� ���� ���� - ��Ӽ�
// => Java�� ���� ��Ӹ� ���� - ���� ��� �Ұ���
public class MemberEvent extends Member {
	/*
	//Member Ŭ������ ��ӹ޾� ����ϹǷ� ���� 
	private String id;
	private String name;
	*/
	private String email;
	
	//super : �ڽ�Ŭ������ �޼ҵ忡 �θ� �ν��Ͻ��� ���޹޾� �����ϱ� ���� ��������(Ű����)
	public MemberEvent() {
		//�ڽ�Ŭ������ �����ڿ��� �θ�Ŭ������ �����ڸ� ȣ���ϱ� ���� super ���
		// => �θ�Ŭ������ �⺻������ ȣ���ϴ� ��� ���� ����
		//super();
	}

	/*
	public MemberEvent(String id, String name, String email) {
		//super();
		//�޼��忡�� �ʵ�(�޼ҵ�)�� ���� �� ��� �ڽ�Ŭ�������� �˻��Ͽ�
		//�����ϰ� ���� ��쿡�� �θ�Ŭ�������� �˻��Ͽ� ����
		// => �θ�Ŭ������ �ʵ�(�޼ҵ�)�� private ���������ڷ� ����� ��� ���� �Ұ���
		//this.id=id;
		setId(id);
		setName(name);
		this.email = email;
	}
	*/
	
	//[Alt]+[Shift]+[S] >> [O] >> �θ� ������ ���� >> �ʵ� ���� >> Generate
	public MemberEvent(String id, String name, String email) {
		//super Ű���带 �̿��Ͽ� �θ�Ŭ������ ������ ȣ��
		// => �θ� �ν��Ͻ� �ʵ忡 ���ϴ� ���� �����Ͽ� �ʱ�ȭ ����
		// => ������ ȣ������ �ٸ� ����� ����Ǵ� ��� ���� �߻�
		super(id, name);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	public void display() {
		System.out.println("���̵� = "+getId());
		System.out.println("�̸� = "+getName());
		System.out.println("�̸��� = "+email);
	}
	*/
	
	//�޼ҵ� �������̵�(Override) : �θ�Ŭ������ �޼ҵ带 �缱���ϴ� ���
	// => �θ�Ŭ������ �޼ҵ� �Ӹ��θ� �����ϰ� �����Ͽ� �ۼ�
	// => �θ�Ŭ������ �޼ҵ�� �������� �ڽ�Ŭ������ �޼ҵ常 ȣ�� ����
	//�θ�Ŭ������ �޼ҵ�� >> [Ctrl]+[Space] >> Override �޼ҵ� ���� >> ����(Ŭ��)
	//@Override : �������̵� ���� �޼ҵ带 ǥ���ϱ� ���� ������̼�(Annotation)
	// => �������̵� ���� ��Ģ�� ��Ű�� ���� ��� ���� �߻�
	@Override
	public void display() {
		//�θ�Ŭ������ ������ �޼ҵ带 ���� ȣ��
		super.display();
		System.out.println("�̸��� = "+email);
	}
}





