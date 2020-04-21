package site.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import site.itwill.dto.MyHewon;

public interface MyHewonInterfaceMapper {
	//@Results : �˻����� �÷����� Ŭ���� �ʵ忡 ������ �� �ִ� ������ �����ϴ� ������̼�
	// => XML Mapper ������ resultMap ������Ʈ�� ������ ����� ����
	// => value �Ӽ��� ���� ������ �Ӽ������� ����
	// => �ٸ� �߻�޼ҵ��� SQL ��ɿ� ���� �������� ���� �Ұ���
	@Results(value = {
		//@Result : �˻����� �÷����� Ŭ���� �ʵ忡 �����ϴ� ������̼�
		// => XML Mapper ������ id(result) ������Ʈ�� ������ ����� ����
		// => column �Ӽ��� property �Ӽ��� �̿��Ͽ� ���� ó��
		@Result(column = "hewon_id",property = "id")	
		,@Result(column = "hewon_name",property = "name")	
		,@Result(column = "hewon_phone",property = "phone")	
		,@Result(column = "hewon_email",property = "email")	
		,@Result(column = "hewon_state",property = "state")	
	})
	@Select("select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
	
	@Results(value = {
			@Result(column = "hewon_id",property = "id")	
			,@Result(column = "hewon_name",property = "name")	
			,@Result(column = "hewon_phone",property = "phone")	
			,@Result(column = "hewon_email",property = "email")	
			,@Result(column = "hewon_state",property = "state")	
	})
	@Select("select * from myhewon where hewon_name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);
	
	@Results(value = {
			@Result(column = "hewon_id",property = "id")	
			,@Result(column = "hewon_name",property = "name")	
			,@Result(column = "hewon_phone",property = "phone")	
			,@Result(column = "hewon_email",property = "email")	
			,@Result(column = "hewon_state",property = "state")	
	})
	//@SelectProvider : SELECT ����� ��ȯ�Ǵ� Ŭ������ �޼ҵ带 ȣ���Ͽ� SELECT ����� ����ϴ� ������̼�
	//type �Ӽ� : SELECT ����� ��ȯ�ϴ� �޼ҵ尡 ����� Ŭ����(Clazz)�� �Ӽ������� ����
	//method �Ӽ� : SELECT ����� ��ȯ�ϴ� �޼ҵ���� �Ӽ������� ����
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicHewonList")
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
}
