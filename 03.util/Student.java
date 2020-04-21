package site.itwill.util;

//인스턴스의 필드값을 비교하기 위해서는 Comparable<T> 인터페이스 상속받아 작성
// => Comparable<T> 인터페이스의 compareTo(T o) 메소드를 오버라이드 선언

//학생정보(학번, 이름)를 저장하기 위한 클래스 - VO(Value Object) 클래스
public class Student implements Comparable<Student> {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[학번 = "+num+", 이름 = "+name+"]";
	}

	//this의 필드값과 매개변수의 필드값을 빼기(-) 연산하여 결과값(양수, 0, 음수)을 반환
	// => Collections.sort() 메소드에 의해 자동 호출되어 반환값으로 정렬
	// => 반환값이 양수인 경우 List 인스턴스의 엘리먼트를 서로 치환 
	@Override
	public int compareTo(Student o) {
		//return this.num-o.num;//학번(오름차순)
		//return -(this.num-o.num);//학번(내림차순)
		
		//return name.compareTo(o.name);//이름(오름차순)
		return -name.compareTo(o.name);//이름(내림차순)
	}
	
	
}	







