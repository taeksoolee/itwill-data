package basic;

public class ArrayApp {
	public static void main(String[] args) {
		//배열을 생성하여 참조변수 저장
		//자료형[] 변수명 : 1차원 배열정보를 저장하기 위한 참조변수 선언
		//new 자료형[갯수] : 원하는 갯수의 값(자료형)을 저장하는 요소가 선언된 배열 생성
		// => 생성된 배열 요소는 자동으로 초기값 저장(숫자:0, 논리:false, 참조:null) 
		int[] num=new int[3];
		
		//참조변수에 저장된 배열정보(객체) 출력
		System.out.println("num = "+num);
		System.out.println("============================================");
		//참조변수에 저장된 배열정보와 첨자(Index)를 이용하여 배열 요소 표현
		// => 첨자 : 요소를 구분하는 고유값 - 0부터 1씩 증가되는 정수값
		System.out.println("num[0] = "+num[0]);
		System.out.println("num[1] = "+num[1]);
		System.out.println("num[2] = "+num[2]);
		//배열 요소를 구분하는 첨자를 잘못 사용한 경우 ArrayIndexOutOfBoundsException 발생
		//System.out.println("num[3] = "+num[3]);
		System.out.println("============================================");
		//참조변수.length : 참조변수에 저장된 배열에 대한 요소 갯수를 표현하는 필드
		System.out.println("배열 요소의 갯수 = "+num.length);
		System.out.println("============================================");
		int index=0;
		//배열 요소의 첨자는 변수 또는 연산식으로 표현 가능
		num[index]=10;
		num[index+1]=20;
		num[index+2]=30;
		
		//for 구문을 이용하여 배열에 대한 일괄 처리 : 첨자 이용(입력, 처리, 출력)
		for(int i=0;i<num.length;i++) {
			System.out.println("num["+i+"] = "+num[i]);
		}
		System.out.println("============================================");
		//배열 생성시 요소에 초기값 부여
		//int[] su=new int[]{10,20,30,40,50};  
		int[] su={10,20,30,40,50};
		
		//for 구문을 이용하여 배열에 대한 일괄 처리 : 반복지시자 이용(처리, 출력)
		for(int temp:su) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		System.out.println("============================================");
		int[] array={54,70,64,87,96,21,65,76,11,34,56,41,77,91};
		
		//배열 요소값에 대한 합계를 계산하여 출력
		int tot=0;
		
		/*
		for(int i=0;i<array.length;i++) {
			tot+=array[i];
		}
		*/
		
		for(int number:array) {
			tot+=number;
		}
		
		System.out.println("합계 = "+tot);
		System.out.println("============================================");
		//배열 요소값 중 30~60 범위의 요소값의 갯수를 계산하여 출력
		int cnt=0;
		
		/*
		for(int i=0;i<array.length;i++) {
			if(array[i]>=30 && array[i]<=60) cnt++;
		}
		*/
		
		for(int number:array) {
			if(number>=30 && number<=60) cnt++;
		}
		
		System.out.println("30~60 범위의 요소 갯수 = "+cnt);
		System.out.println("============================================");
	} 
}














