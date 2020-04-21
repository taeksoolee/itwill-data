package site.itwill.thread;

//��ǰ �Һ��� ����� �����ϴ� Ŭ����
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
			
			System.out.println("�Һ��� = "+qty+"���� ��ǰ�� �Һ� �Ͽ����ϴ�.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
