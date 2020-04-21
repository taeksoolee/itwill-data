package inheritance;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member();
		
		member1.setId("aaa");
		member1.setName("È«±æµ¿");
		
		member1.display();
		System.out.println("============================================");
		Member member2=new Member("bbb", "ÀÓ²©Á¤");
		
		member2.display();
		System.out.println("============================================");
	}
}





