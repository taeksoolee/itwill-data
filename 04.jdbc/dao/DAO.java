package site.itwill.dao;

//모든 DAO 클래스가 상속받아야 되는 인터페이스
// => 인터페이스를 상속받은 클래스는 추상메소드를 오버라이드 선언
// => 모든 DAO 클래스에 동일한 이름의 메소드 선언
public interface DAO {
	void add();
	void modify();
	void remove();
	void search();
}
