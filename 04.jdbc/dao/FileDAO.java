package site.itwill.dao;

public class FileDAO implements DAO {
	@Override
	public void add() {
		System.out.println("### 파일의 정보를 저장하는 기능 ###");
	}
	
	@Override
	public void modify() {
		System.out.println("--- 파일의 정보를 변경하는 기능 ---");
	}
	
	@Override
	public void remove() {
		System.out.println("+++ 파일의 정보를 삭제하는 기능 +++");
	}
	
	@Override
	public void search() {
		System.out.println("*** 파일의 정보를 검색하는 기능 ***");
	}
}
