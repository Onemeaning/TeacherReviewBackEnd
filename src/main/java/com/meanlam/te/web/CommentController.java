package com.meanlam.te.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meanlam.te.entity.Comment;
import com.meanlam.te.service.CommentService;
import com.meanlam.te.util.BaiduNIP;

@RestController
@RequestMapping("/superadmin")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	/*
	 * 显示一组评论，根据老师的ID来选择显示那个老师的评论
	 */
	@RequestMapping(value = "/showComments", method = RequestMethod.GET)
	private Map<String, Object> showComments(String tId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Comment> listComments = commentService.showATeacherComments(tId);
		modelMap.put("commentList", listComments);//这个键（commentList）会在客户端直接获取
		return modelMap;
	}
	
	
	/*
	 * 用户添加一条评论
	 */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	private Map<String, Object> addComment(@RequestBody Comment comment)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		comment.setuType(BaiduNIP.sentimentAnalysis(comment.getuComments()));
		modelMap.put("success", commentService.addComment(comment));
		return modelMap;
	}
	
	
	/*
	 * 删除一条评论，根据用户的微信号来删除
	 */
	@RequestMapping(value = "/removecomment", method = RequestMethod.POST)
	private Map<String, Object> removeComment(@RequestBody Comment comment)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", commentService.deleteComment(comment));
		return modelMap;
	}
	
	/*
	 *映射老师标签（科研大佬、热心负责、为人师表）
	 */
	@RequestMapping(value = "/getTeacherTag", method = RequestMethod.GET)
	private Map<String, Object> getTeacherTag(String tId)
	{
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", commentService.getTeacherTag(tId));
		return modelMap;
	}
	
	
}
