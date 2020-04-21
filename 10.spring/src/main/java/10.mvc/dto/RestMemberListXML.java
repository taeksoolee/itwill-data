package site.itwill10.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ȸ�������� �����ϴ� List �ʵ尡 ����� Ŭ����
@XmlRootElement(name = "member_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestMemberListXML {
	//List �ʵ忡 ����� ��Ҹ� �ڽ� ������Ʈ�� ǥ��
	// => ����� ������ŭ �ڽ� ������Ʈ ����
	@XmlElement(name = "member")
	private List<RestMemberXML> restMemberList;
	
	public RestMemberListXML() {
		// TODO Auto-generated constructor stub
	}

	public List<RestMemberXML> getRestMemberList() {
		return restMemberList;
	}

	public void setRestMemberList(List<RestMemberXML> restMemberList) {
		this.restMemberList = restMemberList;
	}
}
