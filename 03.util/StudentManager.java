package site.itwill.util;

import java.util.ArrayList;
import java.util.List;

//�л������� ����(����, ����, ����, �˻� - CRUD)�ϱ� ���� Ŭ���� 
// => BO(Business Object) Ŭ���� - Manager Ŭ����
public class StudentManager {
	//�ټ��� �л������� �����ϱ� ���� �ݷ��� �ʵ�
	// => Ŭ���� ���ο����� ����ϱ� ���� �ý��� �ʵ� 
	private List<Student> _studentList;//�����ü
	
	public StudentManager() {
		_studentList=new ArrayList<Student>();
	}
	
	//�й��� ���޹޾� �ش� �л������� ����� ������Ʈ�� ÷�ڸ� ��ȯ�ϴ� �޼ҵ�
	// => �ش� �й��� �л������� ���� ��� -1 ��ȯ
	// => Ŭ���� ���ο����� ���� �����ϵ��� ����ȭ ó��
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
	
	//�л������� ���޹޾� �ݷ��� �ʵ忡 ����(�߰�)�ϴ� �޼ҵ�
	// => ���޹��� �л������� �й��� �̹� �ݷ��� �ʵ忡 ����� ��� ������
	// => ���޹��� �л������� ������� ���� ��� false ��ȯ, ����� ��� true ��ȯ
	public boolean insertStudent(Student student) {
		if(getIndex(student.getNum())!=-1) {
			return false;
		}
		
		_studentList.add(student);
		return true;
	}
	
	//�л������� ���޹޾� �ݷ��� �ʵ忡 ����� �л������� �����ϴ� �޼ҵ�
	// => ���޹��� �л������� �й��� �ݷ��� �ʵ忡 ����Ǿ� ���� ���� ��� �̺���
	// => ���޹��� �л������� ������� ���� ��� false ��ȯ, ����� ��� true ��ȯ
	public boolean updateStudent(Student student) {
		int index=getIndex(student.getNum());
		
		if(index==-1) {
			return false;
		}
		
		_studentList.set(index, student);
		return true;
	}
	
	//�й��� ���޹޾� �ݷ��� �ʵ忡 ����� �л������� �����ϴ� �޼ҵ�
	// => ���޹��� �й��� �л������� �ݷ��� �ʵ忡 ����Ǿ� ���� ���� ��� �̻���
	// => ���޹��� �й��� �л������� �������� ���� ��� false ��ȯ, ������ ��� true ��ȯ
	public boolean deleteStudent(int num) {
		int index=getIndex(num);
		if(index==-1) {
			return false;
		}
		_studentList.remove(index);
		return true;
	}
	
	//�й��� ���޹޾� �ݷ��� �ʵ忡 ����� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޹��� �й��� �л������� �ݷ��� �ʵ忡 ����Ǿ� ���� ���� ��� null ��ȯ
	public Student selectStudent(int num) {
		int index=getIndex(num);
		if(index==-1) {
			return null;
		}
		return _studentList.get(index);
	}
	
	//�ݷ��� �ʵ忡 ����� ��� �л������� ��ȯ�ϴ� �޼ҵ�
	public List<Student> selectAllStudent() {
		return _studentList;
	}
}







