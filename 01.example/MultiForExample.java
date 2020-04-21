package example;

public class MultiForExample {
	public static void main(String[] args) {
		//¡Ú¡Ú¡Ú¡Ú¡Ú   i=1   º°=5
		//¡Ú¡Ú¡Ú¡Ú     i=2   º°=4
		//¡Ú¡Ú¡Ú       i=3   º°=3
		//¡Ú¡Ú         i=4   º°=2
		//¡Ú           i=5   º°=1
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=6-i;j++) {
				System.out.print("¡Ú");
			}
			System.out.println();
		} 

		System.out.println("============================================");

		//¡Ú¡Ú¡Ú¡Ú¡Ú   i=1  Èòº°=0  Èæº°=5
		//¡Ù¡Ú¡Ú¡Ú¡Ú   i=2  Èòº°=1  Èæº°=4
		//¡Ù¡Ù¡Ú¡Ú¡Ú   i=3  Èòº°=2  Èæº°=3
		//¡Ù¡Ù¡Ù¡Ú¡Ú   i=4  Èòº°=3  Èæº°=2
		//¡Ù¡Ù¡Ù¡Ù¡Ú   i=5  Èòº°=4  Èæº°=1
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print("¡Ù");
			}
			for(int j=1;j<=6-i;j++) {
				System.out.print("¡Ú");
			}
			System.out.println();
		}
		System.out.println("============================================");
		// 1 2 3 4 5 >> j 
		//¡Ú¡Ú¡Ú¡Ú¡Ú   i=1
		//¡Ù¡Ú¡Ú¡Ú¡Ú   i=2
		//¡Ù¡Ù¡Ú¡Ú¡Ú   i=3
		//¡Ù¡Ù¡Ù¡Ú¡Ú   i=4
		//¡Ù¡Ù¡Ù¡Ù¡Ú   i=5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i>j) {
					System.out.print("¡Ù");
				} else {
					System.out.print("¡Ú");
				}
			}
			System.out.println();
		}
		
		System.out.println("============================================");
		//        ¡Ú           i=1  °ø¹é(2)=4  º°=1
		//      ¡Ú¡Ú¡Ú         i=2  °ø¹é(2)=3  º°=3
		//    ¡Ú¡Ú¡Ú¡Ú¡Ú       i=3  °ø¹é(2)=2  º°=5
		//  ¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú     i=4  °ø¹é(2)=1  º°=7
		//¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú¡Ú   i=5  °ø¹é(2)=0  º°=9
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("  ");
			}
			for(int j=1;j<=i*2-1;j++) {
				System.out.print("¡Ú");
			}
			System.out.println();
		}

		System.out.println("============================================");
		// 1 2 3 4 5  >> j
		//¡Ú¡Ù¡Ù¡Ù¡Ú   i=1
		//¡Ù¡Ú¡Ù¡Ú¡Ù   i=2
		//¡Ù¡Ù¡Ú¡Ù¡Ù   i=3
		//¡Ù¡Ú¡Ù¡Ú¡Ù   i=4
		//¡Ú¡Ù¡Ù¡Ù¡Ú   i=5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j || i+j==6) {
					System.out.print("¡Ú");
				} else {
					System.out.print("¡Ù");
				}
			}
			System.out.println();
		}
		System.out.println("============================================");
	}
}