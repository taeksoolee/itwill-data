package site.itwill.util;

import java.util.Collections;
import java.util.List;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//학생정보를 생성하여 저장매체(콜렉션 필드)에 저장
		manager.insertStudent(new Student(1000, "홍길동"));
		manager.insertStudent(new Student(2000, "임꺽정"));
		manager.insertStudent(new Student(3000, "전우치"));
		manager.insertStudent(new Student(4000, "일지매"));
		 
		boolean result=manager.insertStudent(new Student(5000, "장길산"));
		if(result) {
			System.out.println("[메세지]학생정보를 성공적으로 저장 하였습니다.");
		} else {
			System.out.println("[에러]이미 사용된 학번이므로 학생정보가 저장되지 않습니다.");
		}
		System.out.println("============================================");
		//저장매체(콜렉션 필드)에 저장된 학생정보 중 학번이 2000인 학생정보를 검색하여 출력
		Student findStudent=manager.selectStudent(2000);
		if(findStudent==null) {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		} else {
			System.out.println(findStudent);
		}
		System.out.println("============================================");
		//검색된 학생의 이름을 [임걱정]으로 변경하여 저장매체(콜렉션 필드)에 저장된 학생정보 변경
		findStudent.setName("임걱정");
		if(manager.updateStudent(findStudent)) {
			System.out.println("[메세지]학생정보를 성공적으로 변경 하였습니다.");
		} else {
			System.out.println("[에러]변경할 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("============================================");
		//저장매체(콜렉션 필드)에 저장된 학생정보 중 학번이 4000인 학생정보 삭제
		if(manager.deleteStudent(4000)) {
			System.out.println("[메세지]학생정보를 성공적으로 삭제 하였습니다.");
		} else {
			System.out.println("[에러]삭제할 학생정보를 찾을 수 없습니다.");
		}
		System.out.println("============================================");
		//저장매체(콜렉션 필드)에 저장된 모든 학생정보를 반환받아 저장
		List<Student> studentList=manager.selectAllStudent();
		for(Student student:studentList) {
			System.out.println(student);//toString() 메소드 호출
		}
		System.out.println("============================================");
		//다수의 학생정보가 저장된 List 인스턴스의 엘리먼트 정렬
		Collections.sort(studentList);
		
		for(Student student:studentList) {
			System.out.println(student);
		}
		System.out.println("============================================");
	}
}