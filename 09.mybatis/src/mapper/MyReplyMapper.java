package site.itwill.mapper;

import java.util.List;

import site.itwill.dto.MyReply;
import site.itwill.dto.MyReplyUser;

public interface MyReplyMapper {
	int insertReply(MyReply reply);
	List<MyReply> selectReplyList();
	List<MyReplyUser> selectReplyUserList();
	List<MyReply> selectCommentNoReplyList(int replyCommentNo);
}
