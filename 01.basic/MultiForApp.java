package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int cnt=0;//방법의 갯수를 저장하기 위한 변수
		for(int i=1;i<=3;i++) {//섬을 들어가는 방법
			for(int j=1;j<=4;j++) {//섬을 나가는 방법
				cnt++;
			}
		}
		System.out.println("이동 방법의 갯수 = "+cnt);
		System.out.println("===================================");
		//★★★★★★★
		//★★★★★★★
		//★★★★★★★
		//★★★★★★★
		for(int i=1;i<=4;i++) {//행(Row)
			for(int j=1;j<=7;j++) {//열(Column)
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("===================================");
		//2*1=2		3*1=3	4*1=4	5*1=5	6*1=6	7*1=7	8*1=8	9*1=9	
		//2*2=4		3*2=6	4*2=8	5*2=10	6*2=12	7*2=14	8*2=16	9*2=18	
		//2*3=6		3*3=9	4*3=12	5*3=15	6*3=18	7*3=21	8*3=24	9*3=27	
		//2*4=8		3*4=12	4*4=16	5*4=20	6*4=24	7*4=28	8*4=32	9*4=36	
		//2*5=10	3*5=15	4*5=20	5*5=25	6*5=30	7*5=35	8*5=40	9*5=45	
		//2*6=12	3*6=18	4*6=24	5*6=30	6*6=36	7*6=42	8*6=48	9*6=54	
		//2*7=14	3*7=21	4*7=28	5*7=35	6*7=42	7*7=49	8*7=56	9*7=63	
		//2*8=16	3*8=24	4*8=32	5*8=40	6*8=48	7*8=56	8*8=64	9*8=72	
		//2*9=18	3*9=27	4*9=36	5*9=45	6*9=54	7*9=63	8*9=72	9*9=81
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				//\t : Tab를 표현하는 Escape 문자
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println();
		}
		System.out.println("===================================");
		//★           i=1   별=1            
		//★★         i=2   별=2
		//★★★       i=3   별=3
		//★★★★     i=4   별=4
		//★★★★★   i=5   별=5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("===================================");
		//        ★   i=1  공백(2)=4  별=1            
		//      ★★   i=2  공백(2)=3  별=2
		//    ★★★   i=3  공백(2)=2  별=3
		//  ★★★★   i=4  공백(2)=1  별=4
		//★★★★★   i=5  공백(2)=0  별=5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("===================================");
		//☆☆☆☆★   i=5  흰별=4  흙별=1            
		//☆☆☆★★   i=4  흰별=3  흙별=2
		//☆☆★★★   i=3  흰별=2  흙별=3
		//☆★★★★   i=2  흰별=1  흙별=4
		//★★★★★   i=1  흰별=0  흙별=5
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i-1;j++) {
				System.out.print("☆");
			}
			for(int j=1;j<=6-i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("===================================");
		// 1 2 3 4 5  >> j 
		//☆☆☆☆★   i=1            
		//☆☆☆★★   i=2
		//☆☆★★★   i=3
		//☆★★★★   i=4
		//★★★★★   i=5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i+j<6) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		System.out.println("===================================");
	}
}








