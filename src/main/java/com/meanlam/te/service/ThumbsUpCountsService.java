package com.meanlam.te.service;

import java.util.List;

import com.meanlam.te.entity.ThumbsCountsResult;
import com.meanlam.te.entity.ThumbsUpCounts;

public interface ThumbsUpCountsService {
	
	/**
	 *根据我们点赞人，和被点赞人ID，查找记录
	 * @param sourceId
	 * @return 一条信息
	 */
	 ThumbsUpCounts findRecords(String sourceId,String destId);
	
	/**
	 * 根据被点赞人ID，查找记录条目，其实就是对应着点赞数
	 * @param destId
	 * @return 返回空则说明没人点赞，我们可以点赞；
	 */
	int findRecordsCounts(String destId);
	
	/**
	 * 插入一条点赞记录
	 * @param thumbsUpCounts
	 * @return
	 */
	boolean insertCounts(ThumbsUpCounts thumbsUpCounts);
	
	/**
	 * 根据源目ID删除一条记录
	 * @param sourceId
	 * @param destId
	 * @return
	 */
	boolean deleteThumbsUpCounts(String sourceId,String destId);
	
	
	/**
	 * 根据老师ID获取每一条记录的点赞数目，使用分组查询
	 * @param teacherUniqueId
	 * @return
	 */
	List<ThumbsCountsResult> getDestIdWithCounts(String teacherUniqueId);
	
	
	/**
	 * 给评论点赞，需要添加评论ID，和老师ID
	 * @param thumbsUpCounts
	 * @return
	 */
	boolean insertCommentSupportCounts(ThumbsUpCounts thumbsUpCounts);
	
	/**
	 * 取消对某一条评论的点赞，需要这个评论的位移标识,以及该评论的所属者；
	 * 
	 */
	boolean deleteCommentSupportCounts(String sourceId,String commentId);
			
	/**
	 * 判断用户对某条评论是否点赞了,根据被查询人的ID，以及老师的ID，唯一确定是在哪个老师下的评论，哪个人是否对哪条评论点赞了
	 * @param sourceId
	 * @param teacherUniqueId
	 * @return 返回结果是某个人在在某个老师下的评论上的每一条记录的点赞情况数目
	 */	
	List<ThumbsCountsResult> queryCommentSupportCounts(String sourceId, String teacherUniqueId);

}
