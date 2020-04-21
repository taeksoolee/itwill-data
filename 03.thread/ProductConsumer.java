package site.itwill.thread;

//제품 소비자 기능을 제공하는 클래스
public class ProductConsumer extends Thread {
	private ProductSeller seller;
	
	public ProductConsumer() {
		// TODO Auto-generated constructor stub
	}

	public ProductConsumer(ProductSeller seller) {
		super();
		this.seller = seller;
	}

	public ProductSeller getSeller() {
		return seller;
	}

	public void setSeller(ProductSeller seller) {
		this.seller = seller;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=3;i++) {
			int qty=seller.getQty();
			
			System.out.println("소비자 = "+qty+"개의 제품을 소비 하였습니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
