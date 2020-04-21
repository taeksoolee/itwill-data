package basic;

public class SwitchApp {
	public static void main(String[] args) {
		int choice=1;
		
		switch (choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("===================================");
		choice=2;
		
		switch (choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("===================================");
		choice=3;
		
		switch (choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("===================================");
		choice=4;
		
		switch (choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		default://무조건 실행	
			System.out.println("지구로 이동합니다.");
		}
		System.out.println("===================================");
		choice=1;
		
		switch (choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
			break;//switch 구문 종료
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;
		case 3:
			System.out.println("화성으로 이동합니다.");
			break;
		}
		System.out.println("===================================");
		int jumsu=85;
		
		if(jumsu>=0 && jumsu<=100) {
			//점수에 따른 학점을 계산하여 출력
			//100~90 : A, 89~80 : B, 79~70 : C, 69~60 : D, 59~0 : F
			char grade;
			
			switch (jumsu/10) {
			case 10:
			case 9: grade='A'; break;
			case 8: grade='B'; break;
			case 7: grade='C'; break;
			case 6: grade='D'; break;
			default: grade='F';
			}
			
			System.out.println("[결과]"+jumsu+"점 >> "+grade+"학점");
		} else {
			System.out.println("[에러]0~100 범위를 벗어난 점수가 입력 되었습니다.");
		}
		System.out.println("===================================");
		String kor="둘";
		String eng="";
		
		//JDK1.7 이상에서는 switch 구문을 이용하여 문자열 비교 가능
		switch (kor) {
		case "하나": eng="One";	break;
		case "둘": eng="Two";	break;
		case "셋": eng="Three";	break;
		}
		System.out.println("[결과]"+kor+" >> "+eng);
		System.out.println("===================================");
	}
}





