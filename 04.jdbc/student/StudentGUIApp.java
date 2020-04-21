package site.itwill.student; 

/********************************************************
ÆÄ    ÀÏ   ¸í : StudentGUIApp.java
±â         ´É : ÇĞ»ı °ü¸® ÇÁ·Î±×·¥
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
	 * »ı¼ºÀÚ Á¤ÀÇ
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("¡ß¡ß¡ß ÇĞ»ı °ü¸® ÇÁ·Î±×·¥ ¡ß¡ß¡ß");
		setSize(800, 400);

		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pno = new JPanel();
		pno.add(new JLabel("¹ø  È£"));
		pno.add(noTF = new JTextField(10));

		JPanel pname = new JPanel();
		pname.add(new JLabel("ÀÌ  ¸§"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("»ı  ÀÏ"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("Àü  È­"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("ÁÖ  ¼Ò"));
		paddress.add(addressTF = new JTextField(10));

		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(searchB = new JButton("°Ë  »ö"));
		searchB.addActionListener(this);

		bottom.add(addB = new JButton("Ãß  °¡"));
		addB.addActionListener(this);

		bottom.add(deleteB = new JButton("»è  Á¦"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("º¯  °æ"));
		updateB.addActionListener(this);

		bottom.add(cancelB = new JButton("Ãë  ¼Ò"));
		cancelB.addActionListener(this);

		Object[] title={"ÇĞ¹ø","ÀÌ¸§","ÀüÈ­¹øÈ£","ÁÖ¼Ò","»ı³â¿ùÀÏ"};
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
			if (c == addB) {//Ãß°¡ ¹öÆ°À» ´©¸¥ °æ¿ì
				if (cmd != ADD) {//ADD »óÅÂ°¡ ¾Æ´Ñ °æ¿ì
					setEnable(ADD);//ADD »óÅÂ·Î È°¼ºÈ­					
				} else {//ADD »óÅÂÀÎ °æ¿ì
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
			System.out.println("¿¹¿Ü ¹ß»ı : " + e);
		}		
	}
		
	//JTextField¿¡¼­ ÀÔ·ÂµÈ ÇĞ»ıÁ¤º¸¸¦ ¹İÈ¯¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â ¸Ş¼Òµå
	public void addStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();//ÀÔ·ÂÃĞÁ¡ ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		if(StudentDAO.getStudentDAO().selectNoStudent(no)!=null) {
			JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹øÀ» ÀÔ·Â ÇÏ¿´½À´Ï´Ù.");
			noTF.requestFocus();
			return;
		}
		
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[°¡-ÆR]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		//StudentDTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ¿© ÀÔ·Â°ªÀ¸·Î ÇÊµå°ª º¯°æ
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//STUDENT Å×ÀÌºí¿¡ ÀÔ·Â°ªÀ¸·Î ÇàÀ» ÀúÀåÇÏ°í °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
		// => StudnetDAO Å¬·¡½ºÀÇ insertStudent() ¸Ş¼Òµå È£Ãâ
		int rows=StudentDAO.getStudentDAO().insertStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ ÀúÀå ÇÏ¿´½À´Ï´Ù.");

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField¿¡¼­ ÀÔ·ÂµÈ ÇĞ»ıÁ¤º¸¸¦ ¹İÈ¯¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇĞ»ıÁ¤º¸¸¦ º¯°æÇÏ´Â ¸Ş¼Òµå
	public void modifyStudent() {
		int no=Integer.parseInt(noTF.getText());
		
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[°¡-ÆR]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		//StudentDTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ¿© ÀÔ·Â°ªÀ¸·Î ÇÊµå°ª º¯°æ
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» º¯°æÇÏ°í °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
		// => StudnetDAO Å¬·¡½ºÀÇ updateStudent() ¸Ş¼Òµå È£Ãâ
		int rows=StudentDAO.getStudentDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ º¯°æ ÇÏ¿´½À´Ï´Ù.");

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField¿¡¼­ ÀÔ·ÂµÈ ÇĞ¹øÀ» ¹İÈ¯ ¹Ş¾Æ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ STUDENT Å×ÀÌºí¿¡¼­ »èÁ¦ÇÏ´Â ¸Ş¼Òµå
	public void removeStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}

		int no=Integer.parseInt(noTemp);
		
		//STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» »èÁ¦ÇÏ°í °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
		// => StudnetDAO Å¬·¡½ºÀÇ deleteStudent() ¸Ş¼Òµå È£Ãâ
		int rows=StudentDAO.getStudentDAO().deleteStudent(no);
		
		if(rows>0) {
			JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ »èÁ¦ ÇÏ¿´½À´Ï´Ù.");
		} else {
			JOptionPane.showMessageDialog(this, "»èÁ¦ÇÏ°íÀÚ ÇÏ´Â ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
		}

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField¿¡¼­ ÀÔ·ÂµÈ ÇĞ¹øÀ» ¹İÈ¯ ¹Ş¾Æ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ STUDENT Å×ÀÌºí¿¡¼­
	//°Ë»öÇÏ¿© JTextField¿¡ Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	public void searchNoStudent() {
		String noTemp=noTF.getText();
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
				
		if(student==null) {
			JOptionPane.showMessageDialog(this, "º¯°æÇÏ°íÀÚ ÇÏ´Â ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
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
	
	//JTextField¿¡¼­ ÀÔ·ÂµÈ ÇĞ»ıÀÌ¸§À» ¹İÈ¯¹Ş¾Æ STUDENT Å×ÀÌºí¿¡  
	//ÀúÀåµÈ ÇØ´ç ÇĞ»ıÀÇ ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	public void searchNameStudent() {
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[°¡-ÆR]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
			nameTF.requestFocus();
			return;
		}
		
		//ÀÌ¸§À» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» °Ë»öÇÏ¿© °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
		// => StudnetDAO Å¬·¡½ºÀÇ selectNameStudent() ¸Ş¼Òµå È£Ãâ
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
			return;
		}

		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable¿¡ Ãâ·ÂµÈ ±âÁ¸ÀÇ ÇĞ»ıÁ¤º¸¸¦ ÇÑ Çà¾¿ Á¦°ÅÇÏ´Â ¹İº¹¹®
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		//¹İÈ¯¹ŞÀº ÇĞ»ıÁ¤º¸µéÀ» ÇÑ Çà¾¿ Ãâ·ÂÇÏ´Â ¹İº¹¹®
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
	
	//STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	public void displayAllStudent() {
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectAllStudent();
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//JTable¿¡ Ãâ·ÂµÈ ±âÁ¸ÀÇ ÇĞ»ıÁ¤º¸¸¦ ÇÑ Çà¾¿ Á¦°ÅÇÏ´Â ¹İº¹¹®
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		//¹İÈ¯¹ŞÀº ÇĞ»ıÁ¤º¸µéÀ» ÇÑ Çà¾¿ Ãâ·ÂÇÏ´Â ¹İº¹¹®
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






