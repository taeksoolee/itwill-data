package site.itwill.thread;

//��ǰ ������ ����� �����ϴ� Ŭ����
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
		//��ǰ�� �����Ͽ� �Ǹ��ڿ��� ����
		for(int i=1;i<=3;i++) {
			int qty=(int)(Math.random()*10)+1;//1~10 ������ ���� �߻�
			System.out.println("������ = "+qty+"���� ��ǰ�� ���� �Ͽ����ϴ�.");
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






