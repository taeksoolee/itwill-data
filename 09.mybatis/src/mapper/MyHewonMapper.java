package site.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import site.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	//List<MyHewon> selectStateHewonList(Integer state);
	//Wrapper 클래스 대신 기본 자료형 사용 가능
	List<MyHewon> selectStateHewonList(int state);
	String selectBeanHewonId(MyHewon hewon);
	//Map 인스페이스의 제네릭은 맵키 String, 맵값 Object로 설정
	String selectMapHewonId(Map<String, Object> map);
	//@Param : 추상메소드 매개변수에 전달된 값을 SQL 명령으로 제공하기 위한 어노테이션
	// => value 속성값으로 SQL 명령에서 사용하고자 하는 변수명 설정
	// => 다른 속성이 없으므로 value 속성명은 생략 가능
	String selectParamHewonId(@Param("name") String name, @Param("phone") String phone);
	int insertHewonMap(Map<String, Object> map);
	List<MyHewon> selectSearchHewonList(Map<String, Object> map);
	List<MyHewon> selectNameHewonList(String name);
	List<MyHewon> selectNameDynamicHewonList(Map<String, Object> map);
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
	int updateHewon(MyHewon hewon);
	int updateDynamicHewon(MyHewon hewon);
	List<MyHewon> selectDynamicMultiHewonList(List<String> list);
}








