package site.itwill07.aop;

public class ExecutionTimeBean {
	public void run() {
		int count=0;
		for(int i=1;i<=2000000000;i++) {
			count++;
		}
		System.out.println("count = "+count);
	}
}
