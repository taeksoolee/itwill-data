package basic;

public class OperatorApp {
	public static void main(String[] args) {
		System.out.println("10+20*3 = "+(10+20*3));
		System.out.println("(10+20)*3 = "+((10+20)*3));
		System.out.println("====================================");

		int a1=10;
		System.out.println("a1 = "+a1);
		System.out.println("-a1 = "+(-a1));
		
		System.out.println("20 > 10 = "+(20>10));
		System.out.println("!(20 > 10) = "+!(20>10));
		
		int a2=10,a3=10;
		++a2;//a2++;
		--a3;//a3--;
		System.out.println("a2 = "+a2+", a3 = "+a3);
		
		int a4=10,a5=10;
		System.out.println("a4 = "+a4+", a5 = "+a5);
		System.out.println("++a4 = "+(++a4)+", a5++ = "+(a5++));
		System.out.println("a4 = "+a4+", a5 = "+a5);
		System.out.println("====================================");
		
		int b1=20, b2=10;
		System.out.println(b1+" * "+b2+" = "+(b1*b2));
		System.out.println(b1+" / "+b2+" = "+(b1/b2));
		System.out.println(b1+" % "+b2+" = "+(b1%b2));
		System.out.println(b1+" + "+b2+" = "+(b1+b2));
		System.out.println(b1+" - "+b2+" = "+(b1-b2));
		System.out.println("====================================");
		System.out.println("20 > 10 = "+(20>10));
		System.out.println("20 < 10 = "+(20<10));
		System.out.println("20 == 10 = "+(20==10));
		System.out.println("20 != 10 = "+(20!=10));
		System.out.println("====================================");
		int c=20;
		System.out.println("c = "+c);
		System.out.println("c >= 10 && c <= 30 = "+(c>=10 && c<=30));
		System.out.println("c < 10  || c > 30 = "+(c<10 || c>30));
		System.out.println("====================================");
		//int d1=20,d2=10;
		int d1=10,d2=20;
		System.out.println("Å«°ª = "+(d1>d2?d1:d2));
		
		int d3=10;
		System.out.println(d3+" = "+(d3%2==0?"Â¦¼ö":"È¦¼ö"));
		System.out.println("====================================");
		int e=10;
		System.out.println("e = "+e);
		e+=5;
		System.out.println("e = "+e);
		System.out.println("====================================");
	}
}




