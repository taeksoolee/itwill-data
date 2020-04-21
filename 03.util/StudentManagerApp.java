package site.itwill.util;

import java.util.Collections;
import java.util.List;

public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//�л������� �����Ͽ� �����ü(�ݷ��� �ʵ�)�� ����
		manager.insertStudent(new Student(1000, "ȫ�浿"));
		manager.insertStudent(new Student(2000, "�Ӳ���"));
		manager.insertStudent(new Student(3000, "����ġ"));
		manager.insertStudent(new Student(4000, "������"));
		 
		boolean result=manager.insertStudent(new Student(5000, "����"));
		if(result) {
			System.out.println("[�޼���]�л������� ���������� ���� �Ͽ����ϴ�.");
		} else {
			System.out.println("[����]�̹� ���� �й��̹Ƿ� �л������� ������� �ʽ��ϴ�.");
		}
		System.out.println("============================================");
		//�����ü(�ݷ��� �ʵ�)�� ����� �л����� �� �й��� 2000�� �л������� �˻��Ͽ� ���
		Student findStudent=manager.selectStudent(2000);
		if(findStudent==null) {
			System.out.println("[�޼���]�ش� �й��� �л������� ã�� �� �����ϴ�.");
		} else {
			System.out.println(findStudent);
		}
		System.out.println("============================================");
		//�˻��� �л��� �̸��� [�Ӱ���]���� �����Ͽ� �����ü(�ݷ��� �ʵ�)�� ����� �л����� ����
		findStudent.setName("�Ӱ���");
		if(manager.updateStudent(findStudent)) {
			System.out.println("[�޼���]�л������� ���������� ���� �Ͽ����ϴ�.");
		} else {
			System.out.println("[����]������ �л������� ã�� �� �����ϴ�.");
		}
		System.out.println("============================================");
		//�����ü(�ݷ��� �ʵ�)�� ����� �л����� �� �й��� 4000�� �л����� ����
		if(manager.deleteStudent(4000)) {
			System.out.println("[�޼���]�л������� ���������� ���� �Ͽ����ϴ�.");
		} else {
			System.out.println("[����]������ �л������� ã�� �� �����ϴ�.");
		}
		System.out.println("============================================");
		//�����ü(�ݷ��� �ʵ�)�� ����� ��� �л������� ��ȯ�޾� ����
		List<Student> studentList=manager.selectAllStudent();
		for(Student student:studentList) {
			System.out.println(student);//toString() �޼ҵ� ȣ��
		}
		System.out.println("============================================");
		//�ټ��� �л������� ����� List �ν��Ͻ��� ������Ʈ ����
		Collections.sort(studentList);
		
		for(Student student:studentList) {
			System.out.println(student);
		}
		System.out.println("============================================");
	}
}