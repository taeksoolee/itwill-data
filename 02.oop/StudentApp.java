package oop;

public class StudentApp {
	public static void main(String[] args) {
		/*
		Student student1=new Student("1000", "홍길동", 90, 96);
		Student student2=new Student("2000", "임꺽정", 94, 88);
		Student student3=new Student("3000", "전우치", 92, 80);
		Student student4=new Student("4000", "일지매", 76, 82);
		Student student5=new Student("5000", "장길산", 84, 86);
		
		//student1.calcTot();
		//student2.calcTot();
		//student3.calcTot();
		//student4.calcTot();
		//student5.calcTot();
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		*/
		
		//인스턴스를 저장할 수 있는 참조 요소들이 존재하는 배열 생성
		// => 배열 참조요소에는 null 자동 저장
		Student[] students=new Student[5];
		
		//참조요소에 인스턴스 생성하여 저장 - 인스턴스 배열
		students[0]=new Student("1000", "홍길동", 90, 96);
		students[1]=new Student("2000", "임꺽정", 94, 88);
		students[2]=new Student("3000", "전우치", 92, 80);
		students[3]=new Student("4000", "일지매", 76, 82);
		students[4]=new Student("5000", "장길산", 84, 86);
		
		//메소드 호출에 대한 일괄 처리
		/*
		for(int i=0;i<students.length;i++) {
			//students[i].calcTot();
			students[i].display();
		}
		*/
		
		//int total=0;
		
		for(Student student:students) {
			//student.calcTot();
			student.display();
			//total+=student.getTot();
			//정적메소드는 클래스를 이용하여 호출
			Student.setTotal(Student.getTotal()+student.getTot());
		}
		System.out.println("============================================");
		//System.out.println("총합계 = "+total);
		System.out.println("총합계 = "+Student.getTotal());
		System.out.println("============================================");
	}
}