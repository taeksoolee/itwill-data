package basic;

//1~45 ������ �ߺ����� �ʴ� �������� 6���� �����޾� �������� �����Ͽ� ����ϴ� ���α׷� �ۼ�
// => ����(Sort) : ���� ���ʴ�� �����ϴ� ��� - �������� ����(Ascending Sort), �������� ����(Descending Sort)
public class LottoApp {
	public static void main(String[] args) {
		//6���� �������� �����ϴ� �迭 ���� 
		int[] lotto=new int[6];
		
		//1~45 ������ ���������� �����޾� �迭 ��ҿ� ����
		// => �迭 ��ҿ� ����Ǵ� �������� �ߺ����� ������ ����
		for(int i=0;i<lotto.length;i++) {
			//������ �߻��Ͽ� �迭 ��ҿ� ����
			// => ��ҿ� ����� ���� �������� ���Ͽ� �ߺ��� ��� ���� ��߻�
			while(true) {
				lotto[i]=(int)(Math.random()*100)%45+1;
				
				//�������� ���� �ߺ� ���������� �����ϱ� ���� ����
				// => false : ���ߺ�, true : �ߺ�
				boolean result=false;
				
				//���� ��ҿ� ����� �������� ���ʴ�� ��
				for(int j=0;j<i;j++) {
					//lotto[i] : ���� �߻��� �������� ����� ���
					//lotto[j] : ���� �������� ����� ���
					if(lotto[i]==lotto[j]) {//�������� �ߺ��� ���
						result=true;
						break;
					}
				}
				
				//�������� �ߺ����� ���� ��� while ���� ����
				if(!result) break;
			}//while ����
		}//for ����

		//�迭 ��Ҹ� �����Ͽ� ������ >> ���� ���� �˰���(Selection Sort Algorithm) �̿�
		for(int i=0;i<lotto.length-1;i++) {//�� ����� ÷�� : 0 ~ ������-1
			for(int j=i+1;j<lotto.length;j++) {//�Ǻ� ����� ÷�� : ��÷��+1 ~ ������
				//lotto[i] : �� ��� ǥ���� >> ���� ����
				//lotto[j] : �Ǻ� ��� ǥ����
				if(lotto[i] > lotto[j]) {//�������� ����
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		//�迭 ��Ұ� ���
		System.out.print("����� ���� >> ");
		for(int number:lotto) {
			System.out.print(number+"  ");
		}
		System.out.println();
	}
}





