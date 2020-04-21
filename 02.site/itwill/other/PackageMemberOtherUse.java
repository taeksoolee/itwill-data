package site.itwill.other;

import site.itwill.access.PackageMember;

public class PackageMemberOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		PackageMember member=new PackageMember();
		
		//member.num=100;
		//member.display();
	}
}
