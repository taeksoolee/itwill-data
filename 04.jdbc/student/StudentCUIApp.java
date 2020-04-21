package site.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

//�л� ���� ���α׷� - �޴� ���ÿ� ���� �л����� ����,����,����,�˻� ��� ���� 
public class StudentCUIApp {
	private BufferedReader in;
	
	public StudentCUIApp() {
		in=new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu={"1.�л����� �߰�","2.�л����� ����","3.�л����� ����"
				,"4.�л��̸� �˻�","5.��ü�л� �˻�","6.���α׷� ����"};
		
		System.out.println("<<�л� ���� ���α׷�>>");
		
		while(true) {
			for(String item:menu) {
				System.out.println(item);
			}
			
			int choice;
			try {
				System.out.print("����[1~6] >> ");
				choice=Integer.parseInt(in.readLine());
				if(choice<1 || choice>6) throw new RuntimeException();
			} catch (Exception e) {
				System.out.println("[����]�޴��� �߸� ���� �Ͽ����ϴ�. �ٽ� ������ �ּ���.");
				System.out.println();
				continue;
			}
			
			if(choice==6) break;
			System.out.println();
			
			//�޴� ���ÿ� ���� ��� ���� �޼ҵ� ȣ��
			switch (choice) {
			case 1:	addStduent(); break;
			case 2:	modifyStudent(); break;
			case 3:	removeStudent(); break;
			case 4:	searchNameStudent(); break;
			case 5:	searchAllStudent(); break;
			}
			System.out.println();
		}
		System.out.println("[�޼���]�л� ���� ���α׷��� �����մϴ�.");
	}
	
	public static void main(String[] args) {
		new StudentCUIApp();
	}
	
	//[�л����� �߰�] �޴��� ������ ��� ȣ��Ǵ� �޼ҵ�
	// => Ű����� �л������� �Է¹޾� STUDENT ���̺� ���� �� ��� ���
	private void addStduent() {
		System.out.println("### �л����� �߰� ###");
		try {
			//Ű����� �л������� �Է¹޾� ����
			// => �Է°��� ���� ��ȿ�� �˻� >> ���� ���н� �޼��� ��� �� ���Է�
			int no;
			while(true) {
				System.out.print("�й� �Է� >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[�Է¿���]�й��� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				//String noReg="^[0-9]{4}$";
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[�Է¿���]�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				
				//�Էµ� �й��� STUDENT ���̺� ����� ��� ���Է�
				//�й��� �����Ͽ� STUDENT ���̺��� �������� �˻��Ͽ� ��ȯ�޾� ����
				// => StudentDAO Ŭ������ selectNoStudent() �޼ҵ� ȣ��
				StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
				if(student!=null) {
					System.out.println("[�Է¿���]�̹� ������� �й��� �Է� �Ͽ����ϴ�.");
					continue;
				}
				
				break;
			}
			
			String name;
			while(true) {
				System.out.print("�̸� �Է� >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[�Է¿���]�̸��� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String nameReg="^[��-�R]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[�Է¿���]�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
					continue;
				}
				
				break;
			}
			
			String phone;
			while(true) {
				System.out.print("��ȭ��ȣ �Է� >> ");
				phone=in.readLine();
				
				if(phone==null || phone.equals("")) {
					System.out.println("[�Է¿���]��ȭ��ȣ�� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(!Pattern.matches(phoneReg, phone)) {
					System.out.println("[�Է¿���]��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
					continue;
				}
				
				break;
			}
			
			String address;
			while(true) {
				System.out.print("�ּ� �Է� >> ");
				address=in.readLine();
				
				if(address==null || address.equals("")) {
					System.out.println("[�Է¿���]�ּҸ� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				break;
			}
			
			String birthday;
			while(true) {
				System.out.print("������� �Է� >> ");
				birthday=in.readLine();
				
				if(birthday==null || birthday.equals("")) {
					System.out.println("[�Է¿���]��������� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(!Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[�Է¿���]��������� ���Ŀ� �°� �Է��� �ּ���.");
					continue;
				}
				
				break;
			}
			
			//StudentDTO �ν��Ͻ��� �����Ͽ� �Է°����� �ʵ尪 ����
			StudentDTO student=new StudentDTO();
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);
			
			//STUDENT ���̺� �Է°����� ���� �����ϰ� ����� ��ȯ�޾� ����
			// => StudnetDAO Ŭ������ insertStudent() �޼ҵ� ȣ��
			int rows=StudentDAO.getStudentDAO().insertStudent(student);
			
			System.out.println("[ó�����]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[�л����� ����] �޴��� ������ ��� ȣ��Ǵ� �޼ҵ�
	// => Ű����� �й��� �Է¹޾� STUDENT ���̺��� �����ฦ �˻��Ͽ� ����ϰ� 
	//    �����ϰ��� �ϴ� �л������� �Է¹޾� STUDENT ���̺��� ������ ���� �� ��� ���
	// => �й��� �л������� �������� �ʴ� ��� �޼��� ��� �� �޼ҵ� ����
	private void modifyStudent() {
		System.out.println("### �л����� ���� ###");
		try {
			int no;
			while(true) {
				System.out.print("�й� �Է� >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[�Է¿���]�й��� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[�Է¿���]�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				break;
			}

			//�й��� �����Ͽ� STUDENT ���̺��� �������� �˻��Ͽ� ��ȯ�޾� ����
			// => StudentDAO Ŭ������ selectNoStudent() �޼ҵ� ȣ��
			StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
			if(student==null) {
				System.out.println("[ó�����]�����ϰ��� �ϴ� �л������� �������� �ʽ��ϴ�.");
				return;
			}
			
			//�˻��� �л����� ���
			System.out.println("==========================================================");
			System.out.println("�й�\t�̸�\t��ȭ��ȣ\t�ּ�\t\t�������");
			System.out.println("==========================================================");
			System.out.println(student.getNo()+"\t"+student.getName()
				+"\t"+student.getPhone()+"\t"+student.getAddress()
				+"\t"+student.getBirthday());
			System.out.println("==========================================================");
			
			System.out.println("[�޼���]���氪 �Է� >> �������� ���� ��� ���͸� �Է�");
			
			String name;
			while(true) {
				System.out.print("�̸� �Է� >> ");
				name=in.readLine();
			
				String nameReg="^[��-�R]{2,5}$";
				if(name!=null && !name.equals("") && !Pattern.matches(nameReg, name)) {
					System.out.println("[�Է¿���]�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
					continue;
				}
				
				break;
			}
			
			String phone;
			while(true) {
				System.out.print("��ȭ��ȣ �Է� >> ");
				phone=in.readLine();
				
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(phone!=null && !phone.equals("") && !Pattern.matches(phoneReg, phone)) {
					System.out.println("[�Է¿���]��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
					continue;
				}
				
				break;
			}
			
			System.out.print("�ּ� �Է� >> ");
			String address=in.readLine();
			
			String birthday;
			while(true) {
				System.out.print("������� �Է� >> ");
				birthday=in.readLine();
				
				String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(birthday!=null && !birthday.equals("") && !Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[�Է¿���]��������� ���Ŀ� �°� �Է��� �ּ���.");
					continue;
				}
				
				break;
			}
			
			//��ȯ���� StudentDTO �ν��Ͻ��� ���氪���� �ʵ尪 ����
			// => ���氪�� �Է����� ���� ��� �ʵ尪 �̺���
			if(name!=null && !name.equals("")) student.setName(name);
			if(phone!=null && !phone.equals("")) student.setPhone(phone);
			if(address!=null && !address.equals("")) student.setAddress(address);
			if(birthday!=null && !birthday.equals("")) student.setBirthday(birthday);
			
			//STUDENT ���̺��� �������� �����ϰ� ����� ��ȯ�޾� ����
			// => StudnetDAO Ŭ������ updateStudent() �޼ҵ� ȣ��
			int rows=StudentDAO.getStudentDAO().updateStudent(student);
			
			System.out.println("[ó�����]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[�л����� ����] �޴��� ������ ��� ȣ��Ǵ� �޼ҵ�
	// => Ű����� �й��� �Է¹޾� STUDENT ���̺��� �������� ���� �� ��� ���
	// => �й��� �л������� �������� �ʴ� ��� �޼��� ��� �� �޼ҵ� ����
	private void removeStudent() {
		System.out.println("### �л����� ���� ###");
		try {
			int no;
			while(true) {
				System.out.print("�й� �Է� >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[�Է¿���]�й��� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[�Է¿���]�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				break;
			}

			//STUDENT ���̺��� �������� �����ϰ� ����� ��ȯ�޾� ����
			// => StudnetDAO Ŭ������ deleteStudent() �޼ҵ� ȣ��
			int rows=StudentDAO.getStudentDAO().deleteStudent(no);
			
			if(rows>0) {
				System.out.println("[ó�����]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
			} else {
				System.out.println("[ó�����]�����ϰ��� �ϴ� �л������� �������� �ʽ��ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[�л��̸� �˻�] �޴��� ������ ��� ȣ��Ǵ� �޼ҵ�
	// => �˻��� �л������� �������� �ʴ� ��� �޼��� ��� �� �޼ҵ� ����
	private void searchNameStudent() {
		System.out.println("### �л����� ��� ###");
		
		try {
			String name;
			while(true) {
				System.out.print("�̸� �Է� >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[�Է¿���]�̸��� �ݵ�� �Է��� �ּ���.");
					continue;
				}
				
				String nameReg="^[��-�R]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[�Է¿���]�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
					continue;
				}
				
				break;
			}
			
			//�̸��� �����Ͽ� STUDENT ���̺��� �������� �˻��Ͽ� ����� ��ȯ�޾� ����
			// => StudnetDAO Ŭ������ selectNameStudent() �޼ҵ� ȣ��
			List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectNameStudent(name);
			
			if(studentList.isEmpty()) {
				System.out.println("[ó�����]�˻��� �л������� �������� �ʽ��ϴ�.");
				return;
			}
			
			System.out.println("==========================================================");
			System.out.println("�й�\t�̸�\t��ȭ��ȣ\t�ּ�\t\t�������");
			System.out.println("==========================================================");
			for(StudentDTO student:studentList) {
				System.out.println(student.getNo()+"\t"+student.getName()
					+"\t"+student.getPhone()+"\t"+student.getAddress()
					+"\t"+student.getBirthday());
			}
			System.out.println("==========================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[��ü�л� �˻�] �޴��� ������ ��� ȣ��Ǵ� �޼ҵ�
	// => STUDENT ���̺��� �������� ��� �˻� �� ��� ���
	// => �˻��� �л������� �������� �ʴ� ��� �޼��� ��� �� �޼ҵ� ����
	private void searchAllStudent() {
		System.out.println("### �л����� ��� ###");
		
		//STUDENT ���̺��� �������� ��� �˻��Ͽ� ����� ��ȯ�޾� ����
		// => StudnetDAO Ŭ������ selectAllStudent() �޼ҵ� ȣ��
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectAllStudent();
		
		if(studentList.isEmpty()) {
			System.out.println("[ó�����]����� �л������� �������� �ʽ��ϴ�.");
			return;
		}
		
		System.out.println("==========================================================");
		System.out.println("�й�\t�̸�\t��ȭ��ȣ\t�ּ�\t\t�������");
		System.out.println("==========================================================");
		for(StudentDTO student:studentList) {
			System.out.println(student.getNo()+"\t"+student.getName()
				+"\t"+student.getPhone()+"\t"+student.getAddress()
				+"\t"+student.getBirthday());
		}
		System.out.println("==========================================================");
	}
}






