package oop;

public class SingletonApp {
	public static void main(String[] args) {
		/*
		Singleton s1=new Singleton();
		System.out.println("s1 = "+s1);
		
		Singleton s2=new Singleton();
		System.out.println("s2 = "+s2);
		*/
		
		Singleton s1=Singleton.getInstance();
		System.out.println("s1 = "+s1);
		
		Singleton s2=Singleton.getInstance();
		System.out.println("s2 = "+s2);
		System.out.println("============================================");
		s1.display();
		s2.display();
		System.out.println("============================================");
		Singleton.getInstance().display();
		Singleton.getInstance().display();
		System.out.println("============================================");
	}
}





