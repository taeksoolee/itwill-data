package realization;

//DBMS에 연결하여 CRUD 기능을 제공하기 위한 클래스가 반드시 상속받아야 되는 인터페이스
// => 상속받은 클래스에 메소드 작성 규칙 제공
public interface Jdbc {
	void insert();
	void update();
	void delete();
	void select();
}