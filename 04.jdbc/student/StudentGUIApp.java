package site.itwill.student; 

/********************************************************
��    ��   �� : StudentGUIApp.java
��         �� : �л� ���� ���α׷�
*********************************************************/
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentGUIApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField noTF, nameTF, phoneTF, addressTF, birthdayTF;
	JButton addB, deleteB, updateB, searchB, cancelB;
	
	JTable table;
	
	int cmd;
	/********************************************
	 * ������ ����
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("�ߡߡ� �л� ���� ���α׷� �ߡߡ�");
		setSize(800, 400);

		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pno = new JPanel();
		pno.add(new JLabel("��  ȣ"));
		pno.add(noTF = new JTextField(10));

		JPanel pname = new JPanel();
		pname.add(new JLabel("��  ��"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("��  ��"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("��  ȭ"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("��  ��"));
		paddress.add(addressTF = new JTextField(10));

		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(searchB = new JButton("��  ��"));
		searchB.addActionListener(this);

		bottom.add(addB = new JButton("��  ��"));
		addB.addActionListener(this);

		bottom.add(deleteB = new JButton("��  ��"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("��  ��"));
		updateB.addActionListener(this);

		bottom.add(cancelB = new JButton("��  ��"));
		cancelB.addActionListener(this);

		Object[] title={"�й�","�̸�","��ȭ��ȣ","�ּ�","�������"};
		table=new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		displayAllStudent();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}

	public void setEditable(int n) {
		switch (n) {
		case ADD:
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case DELETE:
			noTF.setEditable(true);
			break;
		case UPDATE:
			noTF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case SEARCH:
			nameTF.setEditable(true);
			break;
		case NONE:
			noTF.setEditable(false);
			nameTF.setEditable(false);
			phoneTF.setEditable(false);
			addressTF.setEditable(false);
			birthdayTF.setEditable(false);
		}
	}

	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;			
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;			
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}

	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {//�߰� ��ư�� ���� ���
				if (cmd != ADD) {//ADD ���°� �ƴ� ���
					setEnable(ADD);//ADD ���·� Ȱ��ȭ					
				} else {//ADD ������ ���
					addStudent();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {
					setEnable(DELETE);
				} else {
					removeStudent();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) {
					searchNoStudent();
				} else  {
					modifyStudent();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameStudent();
				}
			} else if (c == cancelB) {
				displayAllStudent();
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("���� �߻� : " + e);
		}		
	}
		
	//JTextField���� �Էµ� �л������� ��ȯ�޾� STUDENT ���̺� �����ϴ� �޼ҵ�
	public void addStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();//�Է����� �̵��ϴ� �޼ҵ�
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		if(StudentDAO.getStudentDAO().selectNoStudent(no)!=null) {
			JOptionPane.showMessageDialog(this, "�̹� ������� �й��� �Է� �Ͽ����ϴ�.");
			noTF.requestFocus();
			return;
		}
		
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[��-�R]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
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
		
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField���� �Էµ� �л������� ��ȯ�޾� STUDENT ���̺� ����� �л������� �����ϴ� �޼ҵ�
	public void modifyStudent() {
		int no=Integer.parseInt(noTF.getText());
		
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[��-�R]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		//StudentDTO �ν��Ͻ��� �����Ͽ� �Է°����� �ʵ尪 ����
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//STUDENT ���̺��� �������� �����ϰ� ����� ��ȯ�޾� ����
		// => StudnetDAO Ŭ������ updateStudent() �޼ҵ� ȣ��
		int rows=StudentDAO.getStudentDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField���� �Էµ� �й��� ��ȯ �޾� �ش� �й��� �л������� STUDENT ���̺��� �����ϴ� �޼ҵ�
	public void removeStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}

		int no=Integer.parseInt(noTemp);
		
		//STUDENT ���̺��� �������� �����ϰ� ����� ��ȯ�޾� ����
		// => StudnetDAO Ŭ������ deleteStudent() �޼ҵ� ȣ��
		int rows=StudentDAO.getStudentDAO().deleteStudent(no);
		
		if(rows>0) {
			JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
		} else {
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �л������� �������� �ʽ��ϴ�.");
		}

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField���� �Էµ� �й��� ��ȯ �޾� �ش� �й��� �л������� STUDENT ���̺���
	//�˻��Ͽ� JTextField�� ����ϴ� �޼ҵ�
	public void searchNoStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ� ���ڷ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
				
		if(student==null) {
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �л������� �������� �ʽ��ϴ�.");
			noTF.requestFocus();
			noTF.setText("");
			return;
		}
		
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
		
		setEnable(UPDATE_CHANGE);
	}
	
	//JTextField���� �Էµ� �л��̸��� ��ȯ�޾� STUDENT ���̺�  
	//����� �ش� �л��� �л������� �˻��Ͽ� ����ϴ� �޼ҵ�
	public void searchNameStudent() {
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[��-�R]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� 2~5 ������ �ѱ۸� �Է� �����մϴ�.");
			nameTF.requestFocus();
			return;
		}
		
		//�̸��� �����Ͽ� STUDENT ���̺��� �������� �˻��Ͽ� ����� ��ȯ�޾� ����
		// => StudnetDAO Ŭ������ selectNameStudent() �޼ҵ� ȣ��
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�˻��� �л������� �������� �ʽ��ϴ�.");
			return;
		}

		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable�� ��µ� ������ �л������� �� �྿ �����ϴ� �ݺ���
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		//��ȯ���� �л��������� �� �྿ ����ϴ� �ݺ���
		for(StudentDTO student:studentList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			model.addRow(rowData);
		}
		
		initDisplay();
	}
	
	//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ����ϴ� �޼ҵ�
	public void displayAllStudent() {
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectAllStudent();
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "����� �л������� �������� �ʽ��ϴ�.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable�� ��µ� ������ �л������� �� �྿ �����ϴ� �ݺ���
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		//��ȯ���� �л��������� �� �྿ ����ϴ� �ݺ���
		for(StudentDTO student:studentList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			model.addRow(rowData);
		}
	}
}






