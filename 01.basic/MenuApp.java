package basic;

import java.util.Scanner;

//키보드로 메뉴 중 하나를 입력받아 선택메뉴에 대한 기능을 제공하는 프로그램을 작성하세요.
// => [프로그램 종료] 메뉴를 선택하기 전까지 사용자에게 원하는 기능을 계속 제공
// => 선택메뉴가 존재하지 않는 경우 에러메세지 출력 후 재입력
public class MenuApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			//메뉴 출력
			System.out.println("1.학생정보 입력");
			System.out.println("2.학생정보 변경");
			System.out.println("3.학생정보 삭제");
			System.out.println("4.학생정보 검색");
			System.out.println("5.프로그램 종료");

			//메뉴 선택
			System.out.print("메뉴 선택[1~5] >> ");
			int choice=scanner.nextInt();
			
			//입력값에 대한 유효성 검사
			if(choice<1 || choice>5) {
				System.out.println("[에러]선택한 메뉴는 존재하지 않습니다.\n");
				continue;
			}
			
			//[프로그램 종료] 메뉴 선택에 대한 처리 >> 반복문 종료
			if(choice==5) break;
			
			//선택 메뉴에 대한 처리
			switch (choice) {
			case 1:
				System.out.println("[처리결과]학생정보를 저장 하였습니다.");
				break;
			case 2:
				System.out.println("[처리결과]학생정보를 변경 하였습니다.");
				break;
			case 3:
				System.out.println("[처리결과]학생정보를 삭제 하였습니다.");
				break;
			case 4:
				System.out.println("[처리결과]학생정보를 검색 하였습니다.");
				break;
			}
			System.out.println();
		}
		
		System.out.println("[메세지]학생관리 프로그램을 종료합니다.");
		scanner.close();
	}
}
