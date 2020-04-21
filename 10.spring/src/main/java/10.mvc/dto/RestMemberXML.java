package site.itwill10.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//JavaBean(DTO) 객체에 저장된 회원정보를 JAXB를 이용하여 XML 형식의 문자열로 자동 변환되도록 설정
// => JDK1.8 이하에서는 JDK 라이브러리에서 JAXB 기능 제공 
// => JDK9 이상에서는 Maven을 이용하여 JAXB 기능을 제공하는 라이브러리를 빌드하여 사용

//@XmlRootElement : XML의 Root 엘리먼트를 설정하는 어노테이션(필수)
// => name 속성 : Root 엘리먼트의 이름을 속성값으로 설정
// => name 속성이 생략된 경우 클래스명을 엘리먼트 이름으로 자동 설정
@XmlRootElement(name = "member")
//@XmlAccessorType : 자식 엘리먼트를 무엇으로 할 것인지를 설정하는 어노테이션(필수)
// => XmlAccessType Enum 자료형의 상수필드를 속성값으로 설정
// => XmlAccessType.FIELD : 클래스의 필드를 자식 엘리먼트로 표현 - 필드명 : 엘리먼트 이름, 필드값 : 엘리먼트 내용
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType : 자식 엘리먼트를 표현하는 방법을 설정하는 어노테이션(선택)
// => propOrder 속성 : 자식 엘리먼트 표현 순서를 설정
//@XmlType(propOrder = {"id", "address", "name"})
public class RestMemberXML {
	private String id;
	private String name;
	//@XmlElement : 자식 엘리먼트 이름을 설정하는 어노테이션(선택)
	// => @XmlElement 어노테이션을 선언하지 않은 경우 필드명이 자식 엘리먼트 이름으로 설정
	//@XmlElement(name = "addr")
	private String address;
	
	public RestMemberXML() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
