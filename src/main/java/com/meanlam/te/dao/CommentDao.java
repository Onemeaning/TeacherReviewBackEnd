package com.meanlam.te.dao;

import java.util.List;

import com.meanlam.te.entity.Comment;

public interface CommentDao {
	List<Comment> quaryComment(String tId);

//	List<ReplyComment> quaryReplyCommentByWxid(int sourceId);//根据微信号查找别人回复的评论，肯定是一堆，用集合表示

	int insertComment(Comment comment);

	int deleteComment(Comment comment);

}
