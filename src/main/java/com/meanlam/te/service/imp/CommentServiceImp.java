package com.meanlam.te.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.meanlam.te.dao.CommentDao;
import com.meanlam.te.dao.ThumbsUpCountsDao;
import com.meanlam.te.entity.Comment;
import com.meanlam.te.service.CommentService;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private  ThumbsUpCountsDao thumbsUpCountsDao;
	
	
	@Override
	public List<Comment> showATeacherComments(String tId) {
		return commentDao.quaryComment(tId);
	}

	@Override
	@Transactional
	public boolean addComment(Comment comment) {
		if (comment.getuComments() != null && !"".equals(comment.getuComments()))
		{
			try
			{
				int effectNum = commentDao.insertComment(comment);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("评论失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("评论失败！:" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("评论信息不能为空！");
		}
	}

	@Override
	@Transactional
	public boolean deleteComment(Comment comment) {
		if (comment.getSourceId() !=null && comment.getuInsertTime()!=null)
		{
			try
			{
				int effectNum = commentDao.deleteComment(comment);
				String commentId = comment.getSourceId()+comment.getuInsertTime();
				thumbsUpCountsDao.deleteCommentRelativeSupports(commentId);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("删除评论失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("删除评论失败：" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("未指定删除那一条评论！！！");
		}
	}


	
	
}
