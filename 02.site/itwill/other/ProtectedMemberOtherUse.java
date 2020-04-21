package site.itwill.other;

import site.itwill.access.ProtectedMember;

public class ProtectedMemberOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		ProtectedMember member=new ProtectedMember();
		
		//member.num=100;
		//member.display();
	}
}
