package site.itwill.controller;

//뷰(View) 관련 정보를 저장하기 위한 클래스
public class ActionForward {
	//응답 관련 정보를 저장하기 위한 필드
	// => false : 리다이렉트, true : 포워드 
	private boolean forward;
	//리다이렉트 요청(~.do) 또는 포워드 이동(~.jsp)과 관련된 URL 주소를 저장하기 위한 필드 
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
