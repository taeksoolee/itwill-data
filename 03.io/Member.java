package site.itwill.io;

import java.io.Serializable;

//ȸ������(���̵�, �̸�, �ּ�)�� �����ϱ� ���� Ŭ����
// => ��ü ������ ����� ó���Ǵ� Ŭ������ �ݵ�� ��ü����ȭ Ŭ������ ����
//��ü����ȭ(Object Serializable) : �ν��Ͻ��� byte �迭�� ��ȯ�Ͽ� ����
//�ϰų� ���޹ޱ� ���� ����� �����ϱ� ���� ���

//��ü����ȭ Ŭ������ �����ϴ� ���
//1. java.io.Serializable �������̽��� ��ӹ޾� �ۼ�
// => Ŭ������ ��� �ʵ尪�� byte �迭�� ��ȯ�ϴ� ��� ����
//2. java.io.Externalizable �������̽��� ��ӹ޾� �ۼ�
// => �߻�޼ҵ带 �������̵� �����Ͽ� Ŭ������ ���ϴ� �ʵ尪�� byte �迭�� ��ȯ�ϴ� ��� ����

//��ü����ȭ Ŭ������ Ŭ������ ������ �� �ִ� ������(serialVersionUID �ʵ尪)�� �ο�
// => ��Ŭ���������� serialVersionUID �ʵ尪�� �ڵ����� �����ϴ� ��� ����
public class Member implements Serializable {
	private static final long serialVersionUID = -8766870344312624296L;

	private String id;
	private String name;
	private String address;
  
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "���̵� = "+id+", �̸� = "+name+", �ּ� = "+address;
	}
}
