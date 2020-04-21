package site.itwill.util;

import java.util.ArrayList;
import java.util.List;

//학생정보를 관리(저장, 변경, 삭제, 검색 - CRUD)하기 위한 클래스 
// => BO(Business Object) 클래스 - Manager 클래스
public class StudentManager {
	//다수의 학생정보를 저장하기 위한 콜렉션 필드
	// => 클래스 내부에서만 사용하기 위한 시스템 필드 
	private List<Student> _studentList;//저장매체
	
	public StudentManager() {
		_studentList=new ArrayList<Student>();
	}
	
	//학번을 전달받아 해당 학생정보가 저장된 엘리먼트의 첨자를 반환하는 메소드
	// => 해당 학번의 학생정보가 없는 경우 -1 반환
	// => 클래스 내부에서만 접근 가능하도록 은닉화 처리
	private int getIndex(int num) {
		int index=-1;
		for(int i=0;i<_studentList.size();i++) {
			if(_studentList.get(i).getNum()==num) {
				index=i;
				break;
			}
		}
		return index;
	}
	
	//학생정보를 전달받아 콜렉션 필드에 저장(추가)하는 메소드
	// => 전달받은 학생정보의 학번이 이미 콜렉션 필드에 저장된 경우 미저장
	// => 전달받은 학생정보가 저장되지 않을 경우 false 반환, 저장될 경우 true 반환
	public boolean insertStudent(Student student) {
		if(getIndex(student.getNum())!=-1) {
			return false;
		}
		
		_studentList.add(student);
		return true;
	}
	
	//학생정보를 전달받아 콜렉션 필드에 저장된 학생정보를 변경하는 메소드
	// => 전달받은 학생정보의 학번이 콜렉션 필드에 저장되어 있지 않은 경우 미변경
	// => 전달받은 학생정보가 변경되지 않을 경우 false 반환, 변경될 경우 true 반환
	public boolean updateStudent(Student student) {
		int index=getIndex(student.getNum());
		
		if(index==-1) {
			return false;
		}
		
		_studentList.set(index, student);
		return true;
	}
	
	//학번을 전달받아 콜렉션 필드에 저장된 학생정보를 삭제하는 메소드
	// => 전달받은 학번의 학생정보가 콜렉션 필드에 저장되어 있지 않은 경우 미삭제
	// => 전달받은 학번의 학생정보가 삭제되지 않을 경우 false 반환, 삭제될 경우 true 반환
	public boolean deleteStudent(int num) {
		int index=getIndex(num);
		if(index==-1) {
			return false;
		}
		_studentList.remove(index);
		return true;
	}
	
	//학번을 전달받아 콜레션 필드에 저장된 학생정보를 검색하여 반환하는 메소드
	// => 전달받은 학번의 학생정보가 콜렉션 필드에 저장되어 있지 않은 경우 null 반환
	public Student selectStudent(int num) {
		int index=getIndex(num);
		if(index==-1) {
			return null;
		}
		return _studentList.get(index);
	}
	
	//콜렉션 필드에 저장된 모든 학생정보를 반환하는 메소드
	public List<Student> selectAllStudent() {
		return _studentList;
	}
}







