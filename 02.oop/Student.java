package oop;

//학생정보(학번, 이름, 국어, 영어, 총점)를 저장하기 위한 클래스
public class Student {
	//인스턴스 필드 - 인스턴스에 생성되는 필드
	private String num;
	private String name;
	private int kor,eng,tot;
	//정적필드는 클래스가 메모리에 로딩된 후 생성 
	// => 인스턴스에 상관없이 미리 하나만 생성된 후 모든 인스턴스 사용
	// => 기본값 변경을 이용하여 필드 초기값 설정
	private static int total;
	
	//생성자
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		//총점 계산 >> 메소드 호출
		//tot=kor+eng;
		calcTot();
	}

	//Getter & Setter 메소드
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}
	
	//정적메소드 : this 매개변수가 존재하지 않는 메소드
	// => 인스턴스 필드 접근 불가능 >> 인스턴스 메소드 호출 불가능
	// => 정적필드 접근 가능
	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		//정적필드는 클래스를 이용하여 접근하여 사용
		Student.total = total;
	}

	//Business 메소드
	private void calcTot() {//총점을 계산하는 메소드 >> 은닉화
		tot=kor+eng;
	}
	
	public void display() {
		System.out.println(name+"님의 성적 >> ");
		System.out.println("국어 = "+kor+", 영어 = "+eng+", 총점 = "+tot);
	}
	
}








