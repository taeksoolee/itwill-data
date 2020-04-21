package site.itwill.thread;

public class ProductSellerApp {
	public static void main(String[] args) {
		ProductSeller seller=new ProductSeller();
		
		new ProductProducer(seller).start();
		new ProductConsumer(seller).start();
	}
}
