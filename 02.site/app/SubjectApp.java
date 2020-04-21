package site.app;

import site.itwill.subject.JavaSubject;
//다른 패키지의 클래스를 쉽게 표현하기 위해 import 키워드를 이용하여 선언
// => 클래스명 입력 후 [Ctrl]+[Space]를 누르면 자동 import 설정
//[Ctrl]+[Shift]+[O] : import 추가 또는 제거 단축키 
import site.uniwill.subject.NetworkSubject;
//패키지가 다른 동일한 이름의 클래스는 import 설정 불가능
//import site.uniwill.subject.JavaSubject;

public class SubjectApp {
	public static void main(String[] args) {
		//다른 패키지의 클래스를 사용하고자 할 경우 패키지명을 포함하는 
		//클래스명으로 표현해야만 접근 가능
		site.itwill.subject.OracleSubject subject1=new site.itwill.subject.OracleSubject();
		subject1.display();
		
		//import 선언된 클래스는 패키지명을 생략하고 클래스명으로만 표현해도 접근 가능
		NetworkSubject subject2=new NetworkSubject();
		subject2.display();
		
		//같은 이름의 클래스가 다른 패키지에 선언된 경우 import 설정 주의
		JavaSubject subject3=new JavaSubject();
		subject3.display();
		
		//import 설정이 불가능한 경우 패키지명을 포함한 클래스명으로 표현
		site.uniwill.subject.JavaSubject subject4=new site.uniwill.subject.JavaSubject();
		subject4.display();
	}
}