package site.itwill10.dto;

/*
이름    널?       유형           
----- -------- ------------ 
ID    NOT NULL VARCHAR2(20) 
NAME           VARCHAR2(20) 
POINT          NUMBER      
*/

//POINTUSER 테이블의 사용자 정보를 저장하기 위한 클래스 
public class PointUser {
	private String id;
	private String name;
	private int point;
	
	public PointUser() {
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
