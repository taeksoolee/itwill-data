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

//REST ����� �����ϴ� ��ûó�� �޼ҵ忡 ���� JSON �������� Ȯ���� ����
//Advanced REST Client ũ�Ҿ��� ��ġ�Ͽ� ��û�� ���� �׽�Ʈ ��� Ȯ�� 

//AJAX ��û�� ���� ȣ��Ǵ� ��ûó�� �޼ҵ��� method �Ӽ��� : ��û��� - RequestMethod(Enum)�� ����ʵ� 
// => GET(�˻�), POST(����), PUT(��ü ����), PATCH(�κ� ����), DELETE(����) ��
@Controller
//@RestController : ��� ��ûó�� �޼ҵ��� ��ȯ������ ����ǵ��� �����ϴ� ������̼�
// => ��ûó�� �޼ҵ忡�� @ResponseBody ������̼��� ������� �ʾƵ� �޼ҵ� ��ȯ������ ����ó��
// => Restful ����� �����ϴ� ��Ʈ�ѷ� Ŭ������ �ۼ��� ��� ���
//@RestController
public class BoardController {
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
	//REST_BOARD ���̺� ����� �Խñ� ����� �˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ� 
	// => �Խñ� ����� ����¡ ó���Ͽ� ����ǵ��� �ۼ�
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//System.out.println("pageNum = "+pageNum);
		
		//REST_BOARD ���̺� ����� �Խñ��� ������ ��ȯ�޾� ����
		int totalBoard=restBoardService.getRestBoardCount();
		
		int pageSize=5;//�������� ��µ� �Խñ��� ���� ����
		int blockSize=5;//������ ���� ��µ� �������� ���� ����
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		//Service Ŭ������ �޼ҵ带 ȣ���ϱ� ���� �Ű������� ���޵� Map ��ü ����
		Map<String, Object> pagerMap=new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		//��ûó�� �޼ҵ��� ��ȯ������ ���� Map ��ü ����
		// => �������� Map ��ü�� ��Ʈ��(Entry)�� �����Ͽ� ��ȯ - Entry >> JSON(JavaScript ��ü)
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager",pager);		
		
		return returnMap;
	}
	
	//�Խñ��� ���޹޾� REST_BOARD ���̺� �����ϰ� ����� ���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody
	//@RequestBody ������̼Ǹ� �̿��Ͽ� JSON ������ �Է°��� Java ��ü�� �ʵ�� ��ȯ�޾� ����
	public String restBoardAdd(@RequestBody RestBoard board) {
		//XSS ���ݿ� ���� ���� �±� ���� ���ڸ� ȸ�ǹ��ڷ� ����
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	
	//�Խñ� ��ȣ�� ���޹޾� REST_BOARD ���̺� ����� �ش� �Խñ��� 
	//�˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ�
	/*
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
	}
	*/
	
	//�Խñ� ��ȣ�� URL �ּҷ� ���޹޾� REST_BOARD ���̺� ����� �ش�  
	//�Խñ��� �˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ�
	// => ��û �ڿ��� URL �ּҿ� {������} �������� ǥ��
	// => @PathVariable ������̼��� �̿��Ͽ� URL �ּҷ� ���޵� ���� �Ű������� ����
	//��û �ڿ��� ������� �Ű��������� ������ �����ؾ߸� �Ͽ� �ٸ� ���
	//@PathVariable ������̼��� value �Ӽ������� ��û�ڿ��� ������ ���� ����
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
	
	//�Խñ��� ���޹޾� REST_BOARD ���̺� ����� �Խñ��� �����ϰ� �����  
	//���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
	// => ��û����� ���� ���� ��� method �Ӽ����� {} �ȿ� �����Ͽ� ����
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT, RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	//�Խñ� ��ȣ�� URL �ּҷ� ���޹޾� REST_BOARD ���̺� ����� �ش�  
	//�Խñ��� �����ϰ�	����� ���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoardRemove(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
}






