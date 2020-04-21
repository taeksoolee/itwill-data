package inheritance;

//학원 강사정보(강사번호, 강사이름, 강의과목)를 저장하기 위한 클래스
public class AcademyInstructor extends AcademyPerson {
	private String subject;
	
	public AcademyInstructor() {
		// TODO Auto-generated constructor stub
	}

	public AcademyInstructor(int number, String name, String subject) {
		super(number, name);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public void display() {
		System.out.println("강사번호 = "+getNumber());
		System.out.println("강사이름 = "+getName());
		System.out.println("강의과목 = "+subject);
	}
}
