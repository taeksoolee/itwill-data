package oop;

public class Method {
	//�ĺ��� ����(Refactor >> Rename) : Ŀ�� ��ġ >> Alt+Shift+R >> ���� >> ����
	void displayOne() {
		System.out.println("Method Ŭ������ displayOne() �޼ҵ� ȣ��");
	}
	
	void displayTwo() {
		System.out.println("Method Ŭ������ displayTwo() �޼ҵ� ȣ��");
	}
	
	void printTotOne() {
		int tot=0;//��������(Local Variable)
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 ������ ���� �հ� = "+tot);
	}
	
	void printTotTwo(int num) {
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" ������ ���� �հ� = "+tot);
	}
	
	void printTotThree(int num1,int num2) {
		//�Ű������� ���޵� ���� ���� ��ȿ�� �˻�
		if(num1>num2) {//���������� ���� ���޵� ���
			System.out.println("[����]ù��° ���ް��� �ι�° ���ް����� �۾ƾ� �˴ϴ�.");
			return;//�޼ҵ� ����
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" ������ ���� �հ� = "+tot);
	}
	
	int returnTot(int num1,int num2) {
		if(num1>num2) {
			System.out.println("[����]ù��° ���ް��� �ι�° ���ް����� �۾ƾ� �˴ϴ�.");
			return 0;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		
		//return ����� �̿��Ͽ� ������� ��ȯ�ϸ� �޼ҵ� ����
		// => ��ȯ���� �ڷ��� �޼ҵ��� ��ȯ������ ����
		return tot;
	}
	
	//���޹��� �Ű��������� ¦���� ��� false, Ȧ���� ��� true ��ȯ�ϴ� �޼ҵ�  
	boolean isOdd(int num) {
		if(num%2==0) {
			return false;
		} else {
			return true;
		}
	}
	
	//��ü(�ν��Ͻ� - Instance)�� ���޹ް� ��ü�� ��ȯ�ϴ� �޼ҵ� 
	String getHello(String name) {
		return name+"�� �ȳ��ϼ���.";
	}
	
	//�迭(��ҵ鿡 ����� ��)�� ��ȯ�ϴ� �޼ҵ�
	int[] getArray() {
		int[] array={10,20,30,40,50};
		return array;
	}
	
	//�Ű������� ������ ���޹޾� �հ踦 ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => �Ű������� ������ŭ ���� ���޹޾� ó��
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//�Ű������� ������ ���޹޾� �հ踦 ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => �迭�� ��Ұ��� ������ ������� ���޹޾� ó��
	int sumTwo(int[] num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
	
	//�Ű������� ������ ���޹޾� �հ踦 ����Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => �Ű����� ���� ��ȣ(...)�� ����� ��� ���� 0�� �̻� �Է¹޾� �迭�� �����ϰ� ó�� 
	int sumThree(int... num) {
		int tot=0;
		for(int temp:num) {
			tot+=temp;
		}
		return tot;
	}
}













