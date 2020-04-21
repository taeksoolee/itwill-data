package basic;

/*
작성자 : 홍길동
작성일자 : 2019년 10월 18일
작성목적 : 이클립스 연습 프로그램
*/

//어노테이션(Annotation) : API Documentation에서 특별한 설명을 제공하기 위한 기능
/** 
이클립스에서 작성된 첫번째 클래스 
@author H.G.D
@since JDK1.8
@version 1.0
*/
public class FirstApp { 
	/** JVM에 의해 가장 먼저 호출되는 특별한 메소드 */
	public static void main(String[] args) {
		/* 출력메소드 호출 */
		System.out.print("First Eclipse");
		//Java 명령
		System.out.println(" Application!!!");
	}
}
