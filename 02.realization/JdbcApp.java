package realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		*/
		
		/*
		//시스템에 따른 클래스 변경시 프로그램 대부분 변경 
		// => 클래스들의 결합도 높아 유지보수의 효율성 낮다. 
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.erase();
		oracle.search();
		*/
		
		//인터페이스를 이용하여 클래스를 작성할 경우 시스템 변경에 따른
		//클래스 변경시 프로그램의 변경 약간 변경
		// => 클래스들의 결합도 낮춰 유지보수의 효율성 증가 
		//인터페이스로 참조변수를 생성하여 자식 인스턴스 저장
		// => 참조변수에 저장될 자식 인스턴스 변경하면 다른 클래스의 메소드 호출 
		//Jdbc jdbc=new JdbcMysql();
		Jdbc jdbc=new JdbcOracle();
		
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}



