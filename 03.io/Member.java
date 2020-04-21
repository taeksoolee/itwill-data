package site.itwill.io;

import java.io.Serializable;

//회원정보(아이디, 이름, 주소)를 저장하기 위한 클래스
// => 객체 단위로 입출력 처리되는 클래스는 반드시 객체직렬화 클래스로 선언
//객체직렬화(Object Serializable) : 인스턴스를 byte 배열로 변환하여 전달
//하거나 전달받기 위한 기능을 제공하기 위한 방법

//객체직렬화 클래스로 선언하는 방법
//1. java.io.Serializable 인터페이스를 상속받아 작성
// => 클래스의 모든 필드값을 byte 배열로 변환하는 기능 제공
//2. java.io.Externalizable 인터페이스를 상속받아 작성
// => 추상메소드를 오버라이드 선언하여 클래스의 원하는 필드값만 byte 배열로 변환하는 기능 제공

//객체직렬화 클래스는 클래스를 구분할 수 있는 고유값(serialVersionUID 필드값)을 부여
// => 이클립스에서는 serialVersionUID 필드값을 자동으로 생성하는 기능 제공
public class Member implements Serializable {
	private static final long serialVersionUID = -8766870344312624296L;

	private String id;
	private String name;
	private String address;
  
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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
	
	@Override
	public String toString() {
		return "아이디 = "+id+", 이름 = "+name+", 주소 = "+address;
	}
}
