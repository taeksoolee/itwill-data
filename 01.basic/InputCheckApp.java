package basic;

import java.util.Scanner;

//Ű����� ������ �Է¹޾� ������ ����Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
// => 100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
// => ������ 0~100 ������ �������� �Էµǵ��� �ۼ� >> ���������� ���� �Էµ� ��� ���Է�
public class InputCheckApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		/*
		int score=-1;//���������� ���� ����
		//�Է°��� ���������� ��� �ݺ� ó�� >> ��ȿ�� �˻�
		while(score<0 || score>100) {
			System.out.print("���� �Է�[0~100] >> ");
			score=scanner.nextInt();//1���̻� ����
			if(score<0 || score>100) {
				System.out.println("[����]0~100 ������ �������� �Է� �����մϴ�.");
			}
		}
		*/
		
		/*
		int score;
		do {
			System.out.print("���� �Է�[0~100] >> ");
			score=scanner.nextInt();//1���̻� ����
			if(score<0 || score>100) {
				System.out.println("[����]0~100 ������ �������� �Է� �����մϴ�.");
			}
		} while(score<0 || score>100);
		*/
		
		int score;
		while(true) {//���ѷ���
			System.out.print("���� �Է�[0~100] >> ");
			score=scanner.nextInt();//1���̻� ����
			//�������� �������� �Էµ� ��� �ݺ��� ����
			if(score>=0 && score<=100) break;
			//�Է°��� ���������� ��쿡 ���� ó��
			System.out.println("[����]0~100 ������ �������� �Է� �����մϴ�.");
		}
		
		String grade;
		switch (score/10) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		default: grade="F";
		}
		
		System.out.println("[���]"+score+"�� = "+grade+"����");
		
		scanner.close();
	}
}




