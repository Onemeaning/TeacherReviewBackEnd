package com.meanlam.te.dao;
import java.util.List;
import com.meanlam.te.entity.ThumbsCountsResult;
import com.meanlam.te.entity.ThumbsUpCounts;


public interface ThumbsUpCountsDao {

	/**
	 *根据我们点赞人，和被点赞人ID，查找记录是否存在
	 * @param sourceId
	 * @return 一条信息
	 */
	ThumbsUpCounts findRecords(String sourceId,String destId);
	
	/**
	 * 根据被点赞人ID，查找记录条目，其实就是对应着点赞数
	 * @param destId
	 * @return 返回空则说明没人点赞，我们可以点赞；
	 */
	 List<ThumbsUpCounts> findRecordsCounts(String destId);
	
	/**
	 * 插入一条点赞记录，这个点赞记录是对于老师的，因为这条点赞记录没有，评论ID，和老师ID
	 * @param thumbsUpCounts
	 * @return
	 */
	int insertCounts(ThumbsUpCounts thumbsUpCounts);
	
	/**
	 * 根据源目ID删除一条记录
	 * @param sourceId
	 * @param destId
	 * @return
	 */
	int deleteThumbsUpCounts(String sourceId,String destId);
	
	
	/*--------------------------一下是对评论的点赞数操作的------------------------------------*/
	
	/**
	 * 根据老师的ID，查询每条评论，被点赞的数量
	 * @param teacherUniqueId
	 * @return
	 */
	List<ThumbsCountsResult> getDestIdWithCounts(String teacherUniqueId);
	
	/**
	 * 插入一条点赞记录，这个点赞记录是对于某条评论的，因为这条点赞记录需要添加评论ID，和老师ID
	 * @param thumbsUpCounts
	 * @return
	 */
	int insertCommentSupportCounts(ThumbsUpCounts thumbsUpCounts);
	
	/**
	 * 取消对某一条评论的点赞，需要这个评论的位移标识；
	 * 
	 */
	int deleteCommentSupportCounts(String sourceId,String commentId);
			
	/**
	 * 判断用户对某条评论是否点赞了
	 * @param sourceId
	 * @param teacherUniqueId
	 * @return
	 */	
	List<ThumbsCountsResult> queryCommentSupportCounts(String sourceId, String teacherUniqueId);
	
	
}
