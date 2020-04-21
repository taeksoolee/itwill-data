package basic;

public class DoubleArrayApp {
	public static void main(String[] args) {
		int[][] num=new int[2][3];
		
		System.out.println("num = "+num);
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("============================================");
		System.out.println("num[0][0] = "+num[0][0]);
		System.out.println("num[0][1] = "+num[0][1]);
		System.out.println("num[0][2] = "+num[0][2]);
		System.out.println("num[1][0] = "+num[1][0]);
		System.out.println("num[1][1] = "+num[1][1]);
		System.out.println("num[1][2] = "+num[1][2]);
		System.out.println("============================================");
		System.out.println("num.length = "+num.length);
		System.out.println("num[0].length = "+num[0].length);
		System.out.println("num[1].length = "+num[1].length);
		System.out.println("============================================");
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<num[i].length;j++) {
				System.out.println("num["+i+"]["+j+"] = "+num[i][j]);
			}
		}
		System.out.println("============================================");
		int[][] su={{10,20,30},{40,50,60}};
		
		for(int[] array:su) {
			for(int number:array) {
				System.out.print(number+"  ");
			}
			System.out.println();
		}
		System.out.println("============================================");
		/*
		//1차원 배열이 존재하지 않는 2차원 배열 생성
		int[][] temp=new int[3][];
		
		//1차원 배열이 없으므로 2차원 배열의 요소값에는 자동으로 null 저장
		//System.out.println("temp[0] = "+temp[0]);
		//System.out.println("temp[1] = "+temp[1]);
		//System.out.println("temp[2] = "+temp[2]);
		
		//2차원 배열 요소에 1차원 배열을 생성하여 배열정보 저장
		// => 1차원 배열의 요소 갯수를 다르게 선언 가능 - 가변길이배열
		temp[0]=new int[3];
		temp[1]=new int[2];
		temp[2]=new int[4];
		
		temp[0][0]=10;
		temp[0][1]=20;
		temp[0][2]=30;
		
		temp[1][0]=40;
		temp[1][1]=50;

		temp[2][0]=60;
		temp[2][1]=70;
		temp[2][2]=80;
		temp[2][3]=90;
		*/
		int[][] temp={{10,20,30},{40,50},{60,70,80,90}};
		
		for(int[] array:temp) {
			for(int number:array) {
				System.out.print(number+"  ");
			}
			System.out.println();
		}
		System.out.println("============================================");
		//학생이름과 국어,영어,수학 점수를 입력받아 학생 점수 합계, 과목별
		//점수 합계, 전체 점수 합계를 계산하여 출력하는 프로그램 작성
		//ex) 홍길동  80   90   100  240
		//    임꺽정  76   89   77   242
		//    ...
		//    장길산  88   92   90   270
		//    총합계  392  380  370  1142
		String[] name={"홍길동","임꺽정","전우치","일지매","장길산","총합계"};
		int[][] score={{80,90,100,0},{76,89,77,0},{78,99,87,0}
			,{98,99,100,0},{88,92,90,0},{0,0,0,0}};
	
		//학생 점수 합계, 과목별 점수 합계, 전체 점수 합계 계산
		for(int i=0;i<score.length-1;i++) {
			for(int j=0;j<score[i].length-1;j++) {
				//score[i][j] : 학생의 개별 과목 점수가 저장된 요소
				//score[i][score[i].length-1] : 학생 점수 합계가 저장된 요소
				score[i][score[i].length-1]+=score[i][j];
				//score[score.length-1][j] : 과목별 점수 합계가 저장된 요소
				score[score.length-1][j]+=score[i][j];
				//score[score.length-1][score[i].length-1] : 전체 점수 합계가 저장된 요소
				score[score.length-1][score[i].length-1]+=score[i][j];
			}
		}
		
		//학생이름, 국어, 영어, 수학 점수와 학생 점수 합계, 과목별 점수 
		//합계, 전체 점수 합계 출력
		for(int i=0;i<score.length;i++) {
			System.out.print(name[i]+"\t");
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("============================================");
	}
}
