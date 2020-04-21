package site.itwill.mapper;

import java.util.List;

import site.itwill.dto.MyComment1;
import site.itwill.dto.MyComment2;
import site.itwill.dto.MyComment3;
import site.itwill.dto.MyCommentReply;
import site.itwill.dto.MyCommentUser1;
import site.itwill.dto.MyCommentUser2;
import site.itwill.dto.MyCommentUserReplyUser;

public interface MyCommentMapper {
	int insertComment(MyComment1 comment);
	List<MyComment1> selectCommentList1();
	List<MyComment2> selectCommentList2();
	List<MyComment3> selectCommentList3();
	List<MyCommentUser1> selectCommentUserList1();
	List<MyCommentUser2> selectCommentUserList2();
	MyComment1 selectComment(int commentNo);
	MyCommentReply selectCommentReply(int commentNo);
	MyCommentUserReplyUser selectCommentUserReplyUser(int commentNo);
}







