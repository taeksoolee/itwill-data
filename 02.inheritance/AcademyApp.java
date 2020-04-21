package inheritance;

//학원 인적자원(학생, 강사, 직원) 관리 프로그램
public class AcademyApp {
	/*
	public static void processStudent(AcademyStudent student) {
		//학원학생정보를 전달받아 처리하는 메소드
	}
	
	public static void processInstructor(AcademyInstructor instructor) {
		//학원강사정보를 전달받아 처리하는 메소드
	}
	
	public static void processStaff(AcademyStaff staff) {
		//학원직원정보를 전달받아 처리하는 메소드
	}
	*/
	
	/*
	//메소드 오버로드 : 메소드명은 같으며 매개변수를 다르게 선언
	public static void process(AcademyStudent student) {
		//학원학생정보를 전달받아 처리하는 메소드
	}
	
	public static void process(AcademyInstructor instructor) {
		//학원강사정보를 전달받아 처리하는 메소드
	}
	
	public static void process(AcademyStaff staff) {
		//학원직원정보를 전달받아 처리하는 메소드
	}
	*/
	
	public static void process(AcademyPerson person) {
		//학원 인적자원정보(학생, 강사, 직원)를 전달받아 처리하는 메소드
	}
	
	public static void main(String[] args) {
		/*
		//학원학생정보를 저장하기 위한 배열 선언
		AcademyStudent[] students=new AcademyStudent[300];
		//학원강사정보를 저장하기 위한 배열 선언
		AcademyInstructor[] instructors=new AcademyInstructor[50];
		//학원직원정보를 저장하기 위한 배열 선언
		AcademyStaff[] staffs=new AcademyStaff[100];
		*/
		
		//학원 인적자원정보(학생, 강사, 직원)를 저장하기 위한 배열 선언
		AcademyPerson[] persons=new AcademyPerson[5];
		
		//부모 참조요소에 자식 인스턴스(부모 인스턴스)를 생성하여 저장
		persons[0]=new AcademyStudent(1000, "홍길동", "웹 개발자 과정");
		persons[1]=new AcademyInstructor(2000, "임꺽정", "JSP 과목");
		persons[2]=new AcademyStaff(3000, "전우치", "영업관리팀");
		persons[3]=new AcademyStudent(4000, "일지매", "웹 디자인 과정");
		persons[4]=new AcademyInstructor(5000, "장길산", "HTML 과목");
		
		for(AcademyPerson person:persons) {
			//명시적 객체 형변환을 위해 부모 참조변수에 저장 가능한 자식 인스턴스를 반드시 구분
			// => 상속 관계를 확인하기 위해 instanceof 연산자 이용
			//형식) 참조변수 instanceof 자식클래스
			// => 참조변수에 저장될 수 있는 자식클래스의 인스턴스인 경우 true 제공하는 연산자
			if(person instanceof AcademyStudent) {
				//명시적 객체 형변환을 이용하여 자식 인스턴스의 메소드 호출
				// => 명시적 객체 형변환을 잘못할 경우 ClassCaseException 발생
				System.out.println(((AcademyStudent)person).getCourse()+"의 학생정보 >> ");
			} else if(person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"의 강사정보 >> ");
			} else if(person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"의 직원정보 >> ");
			}
			
			//메소드 오버라이드 선언에 의해 묵시적 객체 형변환이 발생되어
			//부모 인스턴스의 메소드 대신 자식 인스턴스의 메소드 호출
			//묵시적 객체 형변환에 의해 참조변수에 저장될 자식 인스턴스에
			//따라 오버라이드 메소드 호출
			// => 메소드 오버라이드에 의한 다형성 구현
			person.display();
			System.out.println("========================================");
		}
		
		/*
		//같은 클래스의 정적 메소드는 클래스를 생략하여 호출 가능
		AcademyApp.processStudent(new AcademyStudent());
		processInstructor(new AcademyInstructor());
		processStaff(new AcademyStaff());
		//매개변수에 잘못된 값(인스턴스)를 전달할 경우 에러 발생
		processStudent(new AcademyInstructor());
		*/
		
		/*
		//전달된 값(인스턴스)에 따라 다른 메소드 호출 - 오버로드에 의한 다형성
		process(new AcademyStudent());
		process(new AcademyInstructor());
		process(new AcademyStaff());
		*/
		
		//매개변수(부모 참조변수)에 모든 자식 인스턴스(부모 인스턴스) 저장 가능
		process(new AcademyStudent());
		process(new AcademyInstructor());
		process(new AcademyStaff());
	}
}








