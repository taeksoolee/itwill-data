package site.itwill.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

//Provider 클래스 : SQL 명령을 반환하는 메소드가 선언된 클래스
// => 동적 SQL 기능을 Java 명령으로 구현
public class MyHewonProvider {
	public String selectDynamicHewonList(Map<String, Object> map) {
		//SQL 클래스 : SQL 명령 작성에 필요한 메소드를 제공하는 클래스
		// => 메소드를 호출하여 SQL 명령 작성 후 문자열로 변환하여 반환
		return new SQL() {{
			SELECT("*");
			FROM("myhewon");
			if(map.get("name")!=null && !map.get("name").equals("")) {
				WHERE("hewon_name=#{name}");
			}
			ORDER_BY("hewon_id");
		}}.toString();
	}
} 
