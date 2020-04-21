package site.itwill.thread;

//��ǰ �Ǹ��� ����� �����ϴ� Ŭ����
public class ProductSeller {
	private int qty;//��ǰ����
	private boolean empty;//������
	
	public ProductSeller() {
		empty=true;
	}

	public synchronized int getQty() {
		while(empty) {
			try {
				//Object.wait() : notify() �޼ҵ� ȣ�� ������ �����忡 Lock�� �����ϴ� �޼ҵ�
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		empty=true;
		//Object.notify() : wait() �޼ҵ忡 ���� �����忡 ������ Lock�� �����ϴ� �޼ҵ�
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
