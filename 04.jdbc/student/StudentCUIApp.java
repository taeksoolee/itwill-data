package site.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

//ÇĞ»ı °ü¸® ÇÁ·Î±×·¥ - ¸Ş´º ¼±ÅÃ¿¡ µû¸¥ ÇĞ»ıÁ¤º¸ ÀúÀå,º¯°æ,»èÁ¦,°Ë»ö ±â´É ±¸Çö 
public class StudentCUIApp {
	private BufferedReader in;
	
	public StudentCUIApp() {
		in=new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu={"1.ÇĞ»ıÁ¤º¸ Ãß°¡","2.ÇĞ»ıÁ¤º¸ º¯°æ","3.ÇĞ»ıÁ¤º¸ »èÁ¦"
				,"4.ÇĞ»ıÀÌ¸§ °Ë»ö","5.ÀüÃ¼ÇĞ»ı °Ë»ö","6.ÇÁ·Î±×·¥ Á¾·á"};
		
		System.out.println("<<ÇĞ»ı °ü¸® ÇÁ·Î±×·¥>>");
		
		while(true) {
			for(String item:menu) {
				System.out.println(item);
			}
			
			int choice;
			try {
				System.out.print("¼±ÅÃ[1~6] >> ");
				choice=Integer.parseInt(in.readLine());
				if(choice<1 || choice>6) throw new RuntimeException();
			} catch (Exception e) {
				System.out.println("[¿¡·¯]¸Ş´º¸¦ Àß¸ø ¼±ÅÃ ÇÏ¿´½À´Ï´Ù. ´Ù½Ã ¼±ÅÃÇØ ÁÖ¼¼¿ä.");
				System.out.println();
				continue;
			}
			
			if(choice==6) break;
			System.out.println();
			
			//¸Ş´º ¼±ÅÃ¿¡ µû¸¥ ±â´É ±¸Çö ¸Ş¼Òµå È£Ãâ
			switch (choice) {
			case 1:	addStduent(); break;
			case 2:	modifyStudent(); break;
			case 3:	removeStudent(); break;
			case 4:	searchNameStudent(); break;
			case 5:	searchAllStudent(); break;
			}
			System.out.println();
		}
		System.out.println("[¸Ş¼¼Áö]ÇĞ»ı °ü¸® ÇÁ·Î±×·¥À» Á¾·áÇÕ´Ï´Ù.");
	}
	
	public static void main(String[] args) {
		new StudentCUIApp();
	}
	
	//[ÇĞ»ıÁ¤º¸ Ãß°¡] ¸Ş´º¸¦ ¼±ÅÃÇÑ °æ¿ì È£ÃâµÇ´Â ¸Ş¼Òµå
	// => Å°º¸µå·Î ÇĞ»ıÁ¤º¸¸¦ ÀÔ·Â¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀå ÈÄ °á°ú Ãâ·Â
	private void addStduent() {
		System.out.println("### ÇĞ»ıÁ¤º¸ Ãß°¡ ###");
		try {
			//Å°º¸µå·Î ÇĞ»ıÁ¤º¸¸¦ ÀÔ·Â¹Ş¾Æ ÀúÀå
			// => ÀÔ·Â°ª¿¡ ´ëÇÑ À¯È¿¼º °Ë»ç >> °ËÁõ ½ÇÆĞ½Ã ¸Ş¼¼Áö Ãâ·Â ÈÄ ÀçÀÔ·Â
			int no;
			while(true) {
				System.out.print("ÇĞ¹ø ÀÔ·Â >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				//String noReg="^[0-9]{4}$";
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				
				//ÀÔ·ÂµÈ ÇĞ¹øÀÌ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ °æ¿ì ÀçÀÔ·Â
				//ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» °Ë»öÇÏ¿© ¹İÈ¯¹Ş¾Æ ÀúÀå
				// => StudentDAO Å¬·¡½ºÀÇ selectNoStudent() ¸Ş¼Òµå È£Ãâ
				StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
				if(student!=null) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹øÀ» ÀÔ·Â ÇÏ¿´½À´Ï´Ù.");
					continue;
				}
				
				break;
			}
			
			String name;
			while(true) {
				System.out.print("ÀÌ¸§ ÀÔ·Â >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String nameReg="^[°¡-ÆR]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
					continue;
				}
				
				break;
			}
			
			String phone;
			while(true) {
				System.out.print("ÀüÈ­¹øÈ£ ÀÔ·Â >> ");
				phone=in.readLine();
				
				if(phone==null || phone.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(!Pattern.matches(phoneReg, phone)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				break;
			}
			
			String address;
			while(true) {
				System.out.print("ÁÖ¼Ò ÀÔ·Â >> ");
				address=in.readLine();
				
				if(address==null || address.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				break;
			}
			
			String birthday;
			while(true) {
				System.out.print("»ı³â¿ùÀÏ ÀÔ·Â >> ");
				birthday=in.readLine();
				
				if(birthday==null || birthday.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(!Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[ÀÔ·Â¿À·ù]»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				break;
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
			
			System.out.println("[Ã³¸®°á°ú]"+rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ ÀúÀå ÇÏ¿´½À´Ï´Ù.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[ÇĞ»ıÁ¤º¸ º¯°æ] ¸Ş´º¸¦ ¼±ÅÃÇÑ °æ¿ì È£ÃâµÇ´Â ¸Ş¼Òµå
	// => Å°º¸µå·Î ÇĞ¹øÀ» ÀÔ·Â¹Ş¾Æ STUDENT Å×ÀÌºíÀÇ ÀúÀåÇà¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ°í 
	//    º¯°æÇÏ°íÀÚ ÇÏ´Â ÇĞ»ıÁ¤º¸¸¦ ÀÔ·Â¹Ş¾Æ STUDENT Å×ÀÌºíÀÇ ÀúÀåÇà º¯°æ ÈÄ °á°ú Ãâ·Â
	// => ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê´Â °æ¿ì ¸Ş¼¼Áö Ãâ·Â ÈÄ ¸Ş¼Òµå Á¾·á
	private void modifyStudent() {
		System.out.println("### ÇĞ»ıÁ¤º¸ º¯°æ ###");
		try {
			int no;
			while(true) {
				System.out.print("ÇĞ¹ø ÀÔ·Â >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				break;
			}

			//ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» °Ë»öÇÏ¿© ¹İÈ¯¹Ş¾Æ ÀúÀå
			// => StudentDAO Å¬·¡½ºÀÇ selectNoStudent() ¸Ş¼Òµå È£Ãâ
			StudentDTO student=StudentDAO.getStudentDAO().selectNoStudent(no);
			if(student==null) {
				System.out.println("[Ã³¸®°á°ú]º¯°æÇÏ°íÀÚ ÇÏ´Â ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
				return;
			}
			
			//°Ë»öµÈ ÇĞ»ıÁ¤º¸ Ãâ·Â
			System.out.println("==========================================================");
			System.out.println("ÇĞ¹ø\tÀÌ¸§\tÀüÈ­¹øÈ£\tÁÖ¼Ò\t\t»ı³â¿ùÀÏ");
			System.out.println("==========================================================");
			System.out.println(student.getNo()+"\t"+student.getName()
				+"\t"+student.getPhone()+"\t"+student.getAddress()
				+"\t"+student.getBirthday());
			System.out.println("==========================================================");
			
			System.out.println("[¸Ş¼¼Áö]º¯°æ°ª ÀÔ·Â >> º¯°æÇÏÁö ¾ÊÀ» °æ¿ì ¿£ÅÍ¸¸ ÀÔ·Â");
			
			String name;
			while(true) {
				System.out.print("ÀÌ¸§ ÀÔ·Â >> ");
				name=in.readLine();
			
				String nameReg="^[°¡-ÆR]{2,5}$";
				if(name!=null && !name.equals("") && !Pattern.matches(nameReg, name)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
					continue;
				}
				
				break;
			}
			
			String phone;
			while(true) {
				System.out.print("ÀüÈ­¹øÈ£ ÀÔ·Â >> ");
				phone=in.readLine();
				
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(phone!=null && !phone.equals("") && !Pattern.matches(phoneReg, phone)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				break;
			}
			
			System.out.print("ÁÖ¼Ò ÀÔ·Â >> ");
			String address=in.readLine();
			
			String birthday;
			while(true) {
				System.out.print("»ı³â¿ùÀÏ ÀÔ·Â >> ");
				birthday=in.readLine();
				
				String birthdayReg="(18|19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(birthday!=null && !birthday.equals("") && !Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[ÀÔ·Â¿À·ù]»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				break;
			}
			
			//¹İÈ¯¹ŞÀº StudentDTO ÀÎ½ºÅÏ½º¸¦ º¯°æ°ªÀ¸·Î ÇÊµå°ª º¯°æ
			// => º¯°æ°ªÀ» ÀÔ·ÂÇÏÁö ¾ÊÀº °æ¿ì ÇÊµå°ª ¹Ìº¯°æ
			if(name!=null && !name.equals("")) student.setName(name);
			if(phone!=null && !phone.equals("")) student.setPhone(phone);
			if(address!=null && !address.equals("")) student.setAddress(address);
			if(birthday!=null && !birthday.equals("")) student.setBirthday(birthday);
			
			//STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» º¯°æÇÏ°í °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
			// => StudnetDAO Å¬·¡½ºÀÇ updateStudent() ¸Ş¼Òµå È£Ãâ
			int rows=StudentDAO.getStudentDAO().updateStudent(student);
			
			System.out.println("[Ã³¸®°á°ú]"+rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ º¯°æ ÇÏ¿´½À´Ï´Ù.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[ÇĞ»ıÁ¤º¸ »èÁ¦] ¸Ş´º¸¦ ¼±ÅÃÇÑ °æ¿ì È£ÃâµÇ´Â ¸Ş¼Òµå
	// => Å°º¸µå·Î ÇĞ¹øÀ» ÀÔ·Â¹Ş¾Æ STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» »èÁ¦ ÈÄ °á°ú Ãâ·Â
	// => ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê´Â °æ¿ì ¸Ş¼¼Áö Ãâ·Â ÈÄ ¸Ş¼Òµå Á¾·á
	private void removeStudent() {
		System.out.println("### ÇĞ»ıÁ¤º¸ »èÁ¦ ###");
		try {
			int no;
			while(true) {
				System.out.print("ÇĞ¹ø ÀÔ·Â >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String noReg="\\d{4}";
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÇĞ¹øÀº 4ÀÚ¸® ¼ıÀÚ·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				break;
			}

			//STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» »èÁ¦ÇÏ°í °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
			// => StudnetDAO Å¬·¡½ºÀÇ deleteStudent() ¸Ş¼Òµå È£Ãâ
			int rows=StudentDAO.getStudentDAO().deleteStudent(no);
			
			if(rows>0) {
				System.out.println("[Ã³¸®°á°ú]"+rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ »èÁ¦ ÇÏ¿´½À´Ï´Ù.");
			} else {
				System.out.println("[Ã³¸®°á°ú]»èÁ¦ÇÏ°íÀÚ ÇÏ´Â ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//[ÇĞ»ıÀÌ¸§ °Ë»ö] ¸Ş´º¸¦ ¼±ÅÃÇÑ °æ¿ì È£ÃâµÇ´Â ¸Ş¼Òµå
	// => °Ë»öµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê´Â °æ¿ì ¸Ş¼¼Áö Ãâ·Â ÈÄ ¸Ş¼Òµå Á¾·á
	private void searchNameStudent() {
		System.out.println("### ÇĞ»ıÁ¤º¸ ¸ñ·Ï ###");
		
		try {
			String name;
			while(true) {
				System.out.print("ÀÌ¸§ ÀÔ·Â >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
					continue;
				}
				
				String nameReg="^[°¡-ÆR]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[ÀÔ·Â¿À·ù]ÀÌ¸§Àº 2~5 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
					continue;
				}
				
				break;
			}
			
			//ÀÌ¸§À» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» °Ë»öÇÏ¿© °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
			// => StudnetDAO Å¬·¡½ºÀÇ selectNameStudent() ¸Ş¼Òµå È£Ãâ
			List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectNameStudent(name);
			
			if(studentList.isEmpty()) {
				System.out.println("[Ã³¸®°á°ú]°Ë»öµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
				return;
			}
			
			System.out.println("==========================================================");
			System.out.println("ÇĞ¹ø\tÀÌ¸§\tÀüÈ­¹øÈ£\tÁÖ¼Ò\t\t»ı³â¿ùÀÏ");
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
	
	//[ÀüÃ¼ÇĞ»ı °Ë»ö] ¸Ş´º¸¦ ¼±ÅÃÇÑ °æ¿ì È£ÃâµÇ´Â ¸Ş¼Òµå
	// => STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» ¸ğµÎ °Ë»ö ÈÄ °á°ú Ãâ·Â
	// => °Ë»öµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê´Â °æ¿ì ¸Ş¼¼Áö Ãâ·Â ÈÄ ¸Ş¼Òµå Á¾·á
	private void searchAllStudent() {
		System.out.println("### ÇĞ»ıÁ¤º¸ ¸ñ·Ï ###");
		
		//STUDENT Å×ÀÌºíÀÇ ÀúÀåÇàÀ» ¸ğµÎ °Ë»öÇÏ¿© °á°ú¸¦ ¹İÈ¯¹Ş¾Æ ÀúÀå
		// => StudnetDAO Å¬·¡½ºÀÇ selectAllStudent() ¸Ş¼Òµå È£Ãâ
		List<StudentDTO> studentList=StudentDAO.getStudentDAO().selectAllStudent();
		
		if(studentList.isEmpty()) {
			System.out.println("[Ã³¸®°á°ú]ÀúÀåµÈ ÇĞ»ıÁ¤º¸°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.");
			return;
		}
		
		System.out.println("==========================================================");
		System.out.println("ÇĞ¹ø\tÀÌ¸§\tÀüÈ­¹øÈ£\tÁÖ¼Ò\t\t»ı³â¿ùÀÏ");
		System.out.println("==========================================================");
		for(StudentDTO student:studentList) {
			System.out.println(student.getNo()+"\t"+student.getName()
				+"\t"+student.getPhone()+"\t"+student.getAddress()
				+"\t"+student.getBirthday());
		}
		System.out.println("==========================================================");
	}
}






