package com.meanlam.te.service;

import java.util.List;

import com.meanlam.te.entity.Comment;

public interface CommentService {

	List<Comment> showATeacherComments(String tId);

//	List<ReplyComment> quaryReplyCommentByWxid(int sourceId);//根据微信号查找别人回复的评论，肯定是一堆，用集合表示

	boolean addComment(Comment comment);

	boolean deleteComment(Comment comment);
}
