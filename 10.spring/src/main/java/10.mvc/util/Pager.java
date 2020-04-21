package site.itwill10.util;

//����¡ ó�� ���� ������ �����ϱ� ���� Ŭ����
public class Pager {
	//�����ڸ� �̿��Ͽ� �Ű������� ���� ���޹޾� �ʱⰪ ����
	private int pageNum;//�˻� ������ ��ȣ
	private int totalBoard;//�˻� �Խñ��� ����
	private int pageSize;//�ϳ��� �������� ��µ� �Խñ��� ����
	private int blockSize;//�ϳ��� ������ ���� ��µ� �������� ����
	
	//�����ڷ� ���޹��� ���� �����Ͽ� ����� ����
	private int totalPage;//������ ����
	private int startRow;//���� �������� ��µ� �Խñ��� ���� ���ȣ
	private int endRow;//���� �������� ��µ� �Խñ��� ���� ���ȣ
	
	private int startPage;//���� ������ ���� ��µ� ���� ������ ��ȣ 
	private int endPage;//���� ������ ���� ��µ� ���� ������ ��ȣ
	private int prevPage;//���� ������ ���� ��µ� ���� ������ ��ȣ
	private int nextPage;//���� ������ ���� ��µ� ���� ������ ��ȣ
	
	public Pager(int pageNum, int totalBoard, int pageSize, int blockSize) {
		super();
		this.pageNum = pageNum;
		this.totalBoard = totalBoard;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPager();
	}
	
	private void calcPager() {
		totalPage=(int)Math.ceil((double)totalBoard/pageSize);
		if(pageNum<=0 || pageNum>totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
		endRow=pageNum*pageSize;
		if(endRow>totalBoard) {
			endRow=totalBoard;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}





