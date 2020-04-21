package site.itwill.access;

public class PrivateMemberUse {
	public void run() {
		@SuppressWarnings("unused")
		PrivateMember member=new PrivateMember();
		
		//member.num=100;
		//member.display();
	}
}
