package site.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import site.itwill.dto.MyMemberDTO;

//�������̽��� �̿��� ���� ���� - Mybatis Framework������ �ۼ� ����
//�߻�޼ҵ忡 ���� ������̼�(Mapper Annotation)�� �̿��Ͽ� SQL ��� ���
public interface MyMemberInterfaceMapper {
	//@Insert : INSERT ����� ����ϱ� ���� ������̼�
	//value �Ӽ� : SQL ����� �Ӽ��� ���� - �ٸ� �Ӽ��� ���� ��� �Ӽ����� ǥ�� ����
	@Insert(value = "insert into mymember values(#{id},#{name},#{phone},#{email})")
	int insertMember(MyMemberDTO member);
	
	//@Update : UPDATE ����� ����ϱ� ���� ������̼�
	@Update("update mymember set name=#{name}, phone=#{phone}, email=#{email} where id=#{id}")
	int updateMember(MyMemberDTO member);
	
	//@Delete : DELETE ����� ����ϱ� ���� ������̼�
	@Delete("delete from mymember where id=#{id}")
	int deleteMember(String id);
	
	//@Select : SELECT ����� ����ϱ� ���� ������̼�
	@Select("select * from mymember where id=#{id}")
	MyMemberDTO selectMember(String id);
	
	@Select("select * from mymember order by id")
	List<MyMemberDTO> selectAllMember();
}












