package com.meanlam.te.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meanlam.te.entity.Comment;
import com.meanlam.te.entity.CommentType;

public interface CommentDao {
	List<Comment> quaryComment(String tId);

//	List<ReplyComment> quaryReplyCommentByWxid(int sourceId);//根据微信号查找别人回复的评论，肯定是一堆，用集合表示

	int insertComment(Comment comment);

	int deleteComment(Comment comment);

	
	//更新id
	int updateCommnetId(@Param("newId") String tId, @Param("oldId")String oldteacherId);

	
	List<CommentType> getCommentTypes(String tId);
	

}
