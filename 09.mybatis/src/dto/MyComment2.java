package site.itwill.dto;

import java.io.Serializable;

//테이블의 컬럼명과 상관 없는 필드명 작성 
// => 컬럼에 대한 별칭을 사용하거나 수동 매핑 처리를 하여 검색 컬럼값을 필드에 저장
public class MyComment2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private int no;
	private String id;
	private String content;
	private String date;
	
	public MyComment2() {
		// TODO Auto-generated constructor stub
	}

	public MyComment2(int no, String id, String content, String date) {
		super();
		this.no = no;
		this.id = id;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
