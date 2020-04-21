package site.itwill.other;

import site.itwill.access.PublicMember;

public class PublicMemberOtherUse {
	public void run() {
		PublicMember member=new PublicMember();
		
		member.num=100;
		member.display();
	}	
}
