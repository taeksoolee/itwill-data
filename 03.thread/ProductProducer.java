package site.itwill.thread;

//제품 생산자 기능을 제공하는 클래스
public class ProductProducer extends Thread {
	private ProductSeller seller;
	
	public ProductProducer() {
		// TODO Auto-generated constructor stub
	}

	public ProductProducer(ProductSeller seller) {
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
		//제품을 생산하여 판매자에게 제공
		for(int i=1;i<=3;i++) {
			int qty=(int)(Math.random()*10)+1;//1~10 범위의 난수 발생
			System.out.println("생산자 = "+qty+"개의 제품을 생산 하였습니다.");
			seller.setQty(qty);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}






