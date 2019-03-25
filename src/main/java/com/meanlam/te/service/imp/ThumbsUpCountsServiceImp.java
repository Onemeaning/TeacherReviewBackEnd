package com.meanlam.te.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meanlam.te.dao.ThumbsUpCountsDao;
import com.meanlam.te.entity.ThumbsCountsResult;
import com.meanlam.te.entity.ThumbsUpCounts;
import com.meanlam.te.service.ThumbsUpCountsService;

@Service
public class ThumbsUpCountsServiceImp implements ThumbsUpCountsService {
	
	@Autowired
	private ThumbsUpCountsDao thumbsUpCountsDao;

	@Override
	public ThumbsUpCounts findRecords(String sourceId, String destId) {
		ThumbsUpCounts thumbsUpCounts = thumbsUpCountsDao.findRecords(sourceId, destId);
		if (thumbsUpCounts!=null)
		{
			return thumbsUpCounts;
		}
		else {
			return null;
		}
		
	}

	@Override
	public int findRecordsCounts(String destId) {
		
		List<ThumbsUpCounts> thumbsUpCounts = new ArrayList<ThumbsUpCounts>();
		thumbsUpCounts = thumbsUpCountsDao.findRecordsCounts(destId);
		
		if (thumbsUpCounts!=null)
		{
			return thumbsUpCounts.size();
		}
		else
		{
			return 0;
		}
		
	}

	@Override
	@Transactional
	public boolean insertCounts(ThumbsUpCounts thumbsUpCounts) {
		if (thumbsUpCounts.getSourceId() != null && thumbsUpCounts.getDestId() != null)
		{
			try
			{
				int effectNum = thumbsUpCountsDao.insertCounts(thumbsUpCounts);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("点赞失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("点赞失败！:" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("源目地址没写");
		}
	}

	@Override
	@Transactional
	public boolean deleteThumbsUpCounts(String sourceId, String destId) {
		if (sourceId!=null && destId !=null)
		{
			try
			{
				int effectNum = thumbsUpCountsDao.deleteThumbsUpCounts(sourceId, destId);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("取消点赞失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("取消点赞失败：" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("未指定源目地址！！！");
		}
	}

	/*-----------------------以下是对评论的顶赞操作-------------------------------*/
	
	@Override
	public List<ThumbsCountsResult> getDestIdWithCounts(String teacherUniqueId) {
		
		return thumbsUpCountsDao.getDestIdWithCounts(teacherUniqueId);
	}

	@Override
	@Transactional
	public boolean insertCommentSupportCounts(ThumbsUpCounts thumbsUpCounts) {
		if (thumbsUpCounts.getSourceId() != null && thumbsUpCounts.getCommentId()!= null)
		{
			try
			{
				int effectNum = thumbsUpCountsDao.insertCommentSupportCounts(thumbsUpCounts);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("给评论点赞失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("给评论点点赞失败！:" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("给评论点源目地址没写");
		}
	}

	@Override
	@Transactional
	public boolean deleteCommentSupportCounts(String sourceId, String commentId) {
		if (sourceId!=null && commentId !=null)
		{
			try
			{
				int effectNum = thumbsUpCountsDao.deleteCommentSupportCounts(sourceId, commentId);
				if (effectNum > 0)
				{
					return true;
				} else
				{
					throw new RuntimeException("给评论取消点赞失败！");
				}
			} catch (Exception e)
			{
				throw new RuntimeException("给评论取消点赞失败：" + e.getMessage());
			}
		} else
		{
			throw new RuntimeException("未指定评论源目地址！！！");
		}
	}

	@Override
	public List<ThumbsCountsResult> queryCommentSupportCounts(String sourceId, String teacherUniqueId) {
		return thumbsUpCountsDao.queryCommentSupportCounts(sourceId, teacherUniqueId);
	}
	
	
	

}
