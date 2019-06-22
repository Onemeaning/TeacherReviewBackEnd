package com.meanlam.te.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.meanlam.te.dao.CommentDao;
import com.meanlam.te.dao.ThumbsUpCountsDao;
import com.meanlam.te.entity.Comment;
import com.meanlam.te.entity.CommentType;
import com.meanlam.te.service.CommentService;

@Service
public class CommentServiceImp implements CommentService{
	String[] evaluation = new String[] {"良师益友","温和可亲","为人师表","治学严谨","和蔼可亲","落落大方"};
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private  ThumbsUpCountsDao thumbsUpCountsDao;
	
	
	@Override
	public List<Comment> showATeacherComments(String tId) {
		if (tId != null)
		{
			return commentDao.quaryComment(tId);
		}
		else 
		{
			throw new RuntimeException("查询评论时老师的ID不能为空！:");
		}
		
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

	@Override
	public List<CommentType> getTeacherTag(String tId) {
		if (tId != null)
		{
			List<CommentType> list = commentDao.getCommentTypes(tId);
			for (CommentType commentType : list)
			{
				if (commentType.getuType().equals("0"))
				{
					commentType.setuType(evaluation[(int)(Math.random()*6)]);
				}
				else if (commentType.getuType().equals("1")) 
				{
					commentType.setuType("平易近人");
				}				
				else 
				{
					commentType.setuType("科研巨匠");
				}
			}
			return list;
		}
		else
		{
			throw new RuntimeException("为添加查询老师的ID");
		}
	}


	
	
}
