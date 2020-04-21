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
	//Wrapper Ŭ���� ��� �⺻ �ڷ��� ��� ����
	List<MyHewon> selectStateHewonList(int state);
	String selectBeanHewonId(MyHewon hewon);
	//Map �ν����̽��� ���׸��� ��Ű String, �ʰ� Object�� ����
	String selectMapHewonId(Map<String, Object> map);
	//@Param : �߻�޼ҵ� �Ű������� ���޵� ���� SQL ������� �����ϱ� ���� ������̼�
	// => value �Ӽ������� SQL ��ɿ��� ����ϰ��� �ϴ� ������ ����
	// => �ٸ� �Ӽ��� �����Ƿ� value �Ӽ����� ���� ����
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








