package com.meanlam.te.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meanlam.te.entity.ThumbsCountsResult;
import com.meanlam.te.entity.ThumbsUpCounts;
import com.meanlam.te.service.ThumbsUpCountsService;

@RestController
@RequestMapping(value="/superadmin")
public class ThumbsUpCountsController {
	
	@Autowired
	private ThumbsUpCountsService thumbsUpCountsService;
	
	/*
	 * 查找是否点赞了，不为null就是点赞过了！
	 */
	@RequestMapping(value = "/isThumbsUp", method = RequestMethod.GET)
	private Map<String, Object> findRecords(String sourceId, String destId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		ThumbsUpCounts thumbsUpCounts = thumbsUpCountsService.findRecords(sourceId, destId);		
		modelMap.put("success", thumbsUpCounts);
		return modelMap;
	}
	
	
	/*
	 * 查找点赞数目有多少,0或者是一个数字
	 */
	@RequestMapping(value = "/findRecordsCounts", method = RequestMethod.GET)
	private Map<String, Object> findRecordsCounts(String destId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int thumbsUpCounts = thumbsUpCountsService.findRecordsCounts(destId);
		modelMap.put("success", thumbsUpCounts);
		return modelMap;
	}
	
	
	/*
	 * 一次点赞
	 */
	@RequestMapping(value = "/insertCounts", method = RequestMethod.POST)
	private Map<String, Object> insertCounts(@RequestBody ThumbsUpCounts thumbsUpCounts)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", thumbsUpCountsService.insertCounts(thumbsUpCounts));
		return modelMap;
	}
		
	/*
	 * 删除一条评论，根据用户的微信号来删除
	 */
	@RequestMapping(value = "/deleteThumbsUpCounts", method = RequestMethod.GET)//如果采用POST的方式，下面的参数应该为@@RequestBody ThumbsUpCounts thumbsUpCounts
	private Map<String, Object> deleteThumbsUpCounts(String sourceId, String destId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", thumbsUpCountsService.deleteThumbsUpCounts(sourceId, destId));
		return modelMap;
	}
	
	/*************************以下是操作对评论的点赞情况的*******************************************/
	
	/*
	 * 查找每条评论记录的点赞数目分别为多少
	 */
	@RequestMapping(value = "/getCommentIdWithCounts", method = RequestMethod.GET)
	private Map<String, Object> getCommentIdWithCounts(String teacherUniqueId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ThumbsCountsResult> listResult = new ArrayList<ThumbsCountsResult>();
		listResult = thumbsUpCountsService.getDestIdWithCounts(teacherUniqueId);
		Map<String, Integer> returnResult = new HashMap<String, Integer>();
		//如下处理方便前端找到相应的值遍历
		for (ThumbsCountsResult thumbsCountsResult : listResult)
		{
			returnResult.put(thumbsCountsResult.getCommentId(), thumbsCountsResult.getEveryCommentCounts());
		}		
		modelMap.put("success", returnResult);
		return modelMap;
	}
	
	/*
	 * 用于为某一条评论点赞
	 */
	@RequestMapping(value = "/insertCommentSupportCounts", method = RequestMethod.POST)
	private Map<String, Object> insertCommentSupportCounts(@RequestBody ThumbsUpCounts thumbsUpCounts)
	{
		System.out.println("收到点赞："+thumbsUpCounts);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", thumbsUpCountsService.insertCommentSupportCounts(thumbsUpCounts));
		return modelMap;
	}
	
	/*
	 * 删除一条评论的点赞情况，根据用户的微信号来删除
	 */
	@RequestMapping(value = "/deleteCommentSupportCounts", method = RequestMethod.GET)//如果采用POST的方式，下面的参数应该为@@RequestBody ThumbsUpCounts thumbsUpCounts
	private Map<String, Object> deleteCommentSupportCounts(String sourceId, String commentId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		System.out.println("删除点赞："+sourceId+":"+commentId);
		modelMap.put("success", thumbsUpCountsService.deleteCommentSupportCounts(sourceId, commentId));
		return modelMap;
	}
	
	/*
	 * 查找某个人对每条评论记录的点赞数目分别为多少。
	 * 如果数目大于0，则说明他已经点赞了，结果返回true，否则返回false，表示他没有点赞
	 * 
	 */
	@RequestMapping(value = "/isYourCommentSupported", method = RequestMethod.GET)
	private Map<String, Object> isYourCommentSupported(String sourceId, String teacherUniqueId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ThumbsCountsResult> listResult = new ArrayList<ThumbsCountsResult>();
		listResult = thumbsUpCountsService.queryCommentSupportCounts(sourceId, teacherUniqueId);
		Map<String, Boolean> returnResult = new HashMap<String, Boolean>();
		//如下处理方便前端找到相应的值遍历
		for (ThumbsCountsResult thumbsCountsResult : listResult)
		{
			returnResult.put(thumbsCountsResult.getCommentId(), (thumbsCountsResult.getEveryCommentCounts())>0?true:false);
		}		
		modelMap.put("success", returnResult);
		return modelMap;
	}

}
