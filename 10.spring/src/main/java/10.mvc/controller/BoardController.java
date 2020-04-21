package site.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import site.itwill10.dto.RestBoard;
import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;

//REST 기능을 제공하는 요청처리 메소드에 대한 JSON 응답결과를 확인을 위해
//Advanced REST Client 크롬앱을 설치하여 요청에 대한 테스트 결과 확인 

//AJAX 요청에 의해 호출되는 요청처리 메소드의 method 속성값 : 요청방식 - RequestMethod(Enum)의 상수필드 
// => GET(검색), POST(저장), PUT(전체 변경), PATCH(부분 변경), DELETE(삭제) 등
@Controller
//@RestController : 모든 요청처리 메소드의 반환값으로 응답되도록 설정하는 어노테이션
// => 요청처리 메소드에서 @ResponseBody 어노테이션을 사용하지 않아도 메소드 반환값으로 응답처리
// => Restful 기능을 제공하는 컨트롤러 클래스를 작성할 경우 사용
//@RestController
public class BoardController {
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
	//REST_BOARD 테이블에 저장된 게시글 목록을 검색하여 JSON 형태로 응답하는 요청처리 메소드 
	// => 게시글 목록을 페이징 처리하여 응답되도록 작성
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//System.out.println("pageNum = "+pageNum);
		
		//REST_BOARD 테이블에 저장된 게시글의 갯수를 반환받아 저장
		int totalBoard=restBoardService.getRestBoardCount();
		
		int pageSize=5;//페이지에 출력될 게시글의 갯수 저장
		int blockSize=5;//페이지 블럭에 출력될 페이지의 갯수 저장
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		//Service 클래스의 메소드를 호출하기 위해 매개변수에 전달될 Map 객체 생성
		Map<String, Object> pagerMap=new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		//요청처리 메소드의 반환값으로 사용될 Map 객체 생성
		// => 응답결과를 Map 객체의 엔트리(Entry)로 저장하여 반환 - Entry >> JSON(JavaScript 객체)
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager",pager);		
		
		return returnMap;
	}
	
	//게시글을 전달받아 REST_BOARD 테이블에 저장하고 결과를 문자열로 응답하는 요청처리 메소드
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody
	//@RequestBody 어노테이션를 이용하여 JSON 형태의 입력값을 Java 객체의 필드로 변환받아 저장
	public String restBoardAdd(@RequestBody RestBoard board) {
		//XSS 공격에 대한 방어로 태그 관련 문자를 회피문자로 변경
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	
	//게시글 번호를 전달받아 REST_BOARD 테이블에 저장된 해당 게시글을 
	//검색하여 JSON 형태로 응답하는 요청처리 메소드
	/*
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
	}
	*/
	
	//게시글 번호를 URL 주소로 전달받아 REST_BOARD 테이블에 저장된 해당  
	//게시글을 검색하여 JSON 형태로 응답하는 요청처리 메소드
	// => 요청 자원의 URL 주소에 {변수명} 형식으로 표현
	// => @PathVariable 어노테이션을 이용하여 URL 주소로 전달된 값을 매개변수에 저장
	//요청 자원의 변수명과 매개변수명을 같도록 선언해야만 하여 다를 경우
	//@PathVariable 어노테이션의 value 속성값으로 요청자원의 변수명 설정 가능
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
	
	//게시글을 전달받아 REST_BOARD 테이블에 저장된 게시글을 변경하고 결과를  
	//문자열로 응답하는 요청처리 메소드
	// => 요청방식이 여러 개인 경우 method 속성값을 {} 안에 나열하여 선언
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT, RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	//게시글 번호를 URL 주소로 전달받아 REST_BOARD 테이블에 저장된 해당  
	//게시글을 삭제하고	결과를 문자열로 응답하는 요청처리 메소드
	@RequestMapping(value = "/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoardRemove(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
}






