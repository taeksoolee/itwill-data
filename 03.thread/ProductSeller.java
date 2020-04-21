package site.itwill.thread;

//제품 판매자 기능을 제공하는 클래스
public class ProductSeller {
	private int qty;//제품수량
	private boolean empty;//재고상태
	
	public ProductSeller() {
		empty=true;
	}

	public synchronized int getQty() {
		while(empty) {
			try {
				//Object.wait() : notify() 메소드 호출 전까지 스레드에 Lock을 실행하는 메소드
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty=true;
		//Object.notify() : wait() 메소드에 의해 스레드에 구현된 Lock를 해제하는 메소드
		notify();
		return qty;
	}

	public synchronized void setQty(int qty) {
		while(!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty=false;
		this.qty = qty;
		notify();
	}
}
